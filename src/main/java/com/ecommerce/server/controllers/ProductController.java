package com.ecommerce.server.controllers;

import com.ecommerce.server.dto.product.ProductDetailRequest;
import com.ecommerce.server.dto.request.product.ProductDetailResponse;
import com.ecommerce.server.entities.Product;
import com.ecommerce.server.exceptions.BusinessException;
import com.ecommerce.server.facade.ProductFacade;
import com.ecommerce.server.services.ProductService;
import com.ecommerce.server.utils.ExceptionUtils;
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

import static com.ecommerce.server.constant.ApiConstant.API_PATH;
import static com.ecommerce.server.constant.ApiConstant.PRODUCT_API;
import static com.ecommerce.server.constant.ErrorConstant.SYSTEM_ERROR;
import static com.ecommerce.server.constant.ErrorConstant.SYSTEM_ERROR_MESSAGE;

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

    @GetMapping("/{id}")
    public ResponseEntity<ProductDetailResponse> getProductById(@PathVariable UUID id){
        ProductDetailResponse productDtos = productService.getProductById(id);
        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }

    //   create Product
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDetailResponse productDto){
        Product product = productService.addProduct(productDto);
        return new ResponseEntity<>(product,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody ProductDetailResponse productDto, @PathVariable UUID id){
        Product product = productService.updateProduct(productDto, id);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }


}
