package com.ecommerce.server.facade;

import com.ecommerce.server.dto.product.ProductDetailRequest;
import com.ecommerce.server.dto.request.product.ProductDetailResponse;
import com.ecommerce.server.exceptions.BusinessException;
import com.ecommerce.server.services.ProductService;
import com.ecommerce.server.utils.ExceptionUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.ecommerce.server.constant.ErrorConstant.SYSTEM_ERROR;
import static com.ecommerce.server.constant.ErrorConstant.SYSTEM_ERROR_MESSAGE;


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
}
