package com.ecommerce.server.interfaces.controller;

import com.ecommerce.server.application.facade.ProductFacade;
import com.ecommerce.server.interfaces.models.product.request.ProductDetailRequest;
import com.ecommerce.server.interfaces.models.product.request.UpdateProductRequest;
import com.ecommerce.server.interfaces.models.product.request.UploadProductRequest;
import com.ecommerce.server.interfaces.models.product.response.ProductDetailResponse;
import com.ecommerce.server.interfaces.models.product.response.UpdateProductResponse;
import com.ecommerce.server.interfaces.models.product.response.UploadProductResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ecommerce.server.infrastructure.persistence.constant.ApiConstant.API_PATH;
import static com.ecommerce.server.infrastructure.persistence.constant.ApiConstant.GET_PRODUCT_DETAIL;
import static com.ecommerce.server.infrastructure.persistence.constant.ApiConstant.PRODUCT_API;
import static com.ecommerce.server.infrastructure.persistence.constant.ApiConstant.UPDATE_PRODUCT;
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

    @PostMapping()
    public ResponseEntity<ProductDetailResponse> getAllProducts(@RequestBody @Valid ProductDetailRequest request) {
        return productFacade.getAllProducts(request);
    }

    @PostMapping(UPLOAD_PRODUCT)
    public ResponseEntity<UploadProductResponse> uploadProduct(@RequestBody @Valid UploadProductRequest request) {
        return productFacade.uploadNewProduct(request);
    }

    @PostMapping(GET_PRODUCT_DETAIL)
    public ResponseEntity<ProductDetailResponse> getProductById(@RequestBody @Valid ProductDetailRequest request){
        return productFacade.getProductById(request);
    }

    @PutMapping(UPDATE_PRODUCT)
    public ResponseEntity<UpdateProductResponse> updateProduct(@RequestBody UpdateProductRequest request) {
        return productFacade.updateProduct(request);
    }


}
