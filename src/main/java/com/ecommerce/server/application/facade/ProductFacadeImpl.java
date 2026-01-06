package com.ecommerce.server.application.facade;

import com.ecommerce.server.interfaces.models.product.ProductDetailRequest;
import com.ecommerce.server.interfaces.models.product.UploadProductResponse;
import com.ecommerce.server.interfaces.models.request.product.ProductDetailResponse;
import com.ecommerce.server.interfaces.models.request.product.UploadProductRequest;
import com.ecommerce.server.infrastructure.persistence.exceptions.BusinessException;
import com.ecommerce.server.application.services.ProductService;
import com.ecommerce.server.infrastructure.utils.ExceptionUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.ecommerce.server.infrastructure.persistence.constant.ErrorConstant.SYSTEM_ERROR;
import static com.ecommerce.server.infrastructure.persistence.constant.ErrorConstant.SYSTEM_ERROR_MESSAGE;


@RequiredArgsConstructor
public class ProductFacadeImpl implements ProductFacade{

    private final ProductService productService;

    @Override
    public ResponseEntity<ProductDetailResponse> getAllProducts(ProductDetailRequest request) {
        ProductDetailResponse response = productService.getAllProducts(request);
        if(response == null) {
            throw new BusinessException(request.getRequestId(), request.getRequestDateTime(), request.getChannel(),
                    ExceptionUtils.buildResultResponse(SYSTEM_ERROR, SYSTEM_ERROR_MESSAGE));
        }
        response.setRequestId(request.getRequestId());
        response.setRequestDateTime(request.getRequestDateTime());
        response.setChannel(request.getChannel());
        if(response.getData() == null) {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UploadProductResponse> uploadNewProduct(UploadProductRequest request) {
        UploadProductResponse response = productService.uploadProduct(request);
        if(response == null) {
            throw new BusinessException(request.getRequestId(), request.getRequestDateTime(), request.getChannel(),
                    ExceptionUtils.buildResultResponse(SYSTEM_ERROR, SYSTEM_ERROR_MESSAGE));
        }
        response.setRequestId(request.getRequestId());
        response.setRequestDateTime(request.getRequestDateTime());
        response.setChannel(request.getChannel());
        if(response.getData() == null) {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
