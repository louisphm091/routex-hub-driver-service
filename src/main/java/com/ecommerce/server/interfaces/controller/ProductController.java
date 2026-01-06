package com.ecommerce.server.interfaces.controller;

import com.ecommerce.server.interfaces.models.product.ProductDetailRequest;
import com.ecommerce.server.interfaces.models.product.UploadProductResponse;
import com.ecommerce.server.interfaces.models.request.product.ProductDetailResponse;
import com.ecommerce.server.interfaces.models.request.product.UploadProductRequest;
import com.ecommerce.server.domain.product.Product;
import com.ecommerce.server.application.facade.ProductFacade;
import com.ecommerce.server.application.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.ecommerce.server.infrastructure.persistence.constant.ApiConstant.API_PATH;
import static com.ecommerce.server.infrastructure.persistence.constant.ApiConstant.PRODUCT_API;
import static com.ecommerce.server.infrastructure.persistence.constant.ApiConstant.UPLOAD_PRODUCT;

/**
 * @author Bao Pham
 * @created 31/03/2025
 * @project lv-shop-server
 **/

@RestController
@RequestMapping(API_PATH + PRODUCT_API)
@RequiredArgsConstructor
public class ProductController {

    private ProductFacade productFacade;
    private ProductService productService;

    @PostMapping()
    public ResponseEntity<ProductDetailResponse> getAllProducts(@RequestBody @Valid ProductDetailRequest request) {
        return productFacade.getAllProducts(request);
    }

    @PostMapping(UPLOAD_PRODUCT)
    public ResponseEntity<UploadProductResponse> uploadProduct(@RequestBody @Valid UploadProductRequest request) {
        return productFacade.uploadNewProduct(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDetailResponse> getProductById(@PathVariable UUID id){
        ProductDetailResponse productDtos = productService.getProductById(id);
        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody ProductDetailResponse productDto, @PathVariable UUID id){
        Product product = productService.updateProduct(productDto, id);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }


}
