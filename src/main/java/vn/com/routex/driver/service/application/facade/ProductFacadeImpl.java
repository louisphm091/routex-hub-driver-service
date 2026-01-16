package vn.com.routex.driver.service.application.facade;

import vn.com.routex.driver.service.interfaces.models.base.BaseRequest;
import vn.com.routex.driver.service.interfaces.models.product.request.ProductDetailRequest;
import vn.com.routex.driver.service.interfaces.models.product.request.UpdateProductRequest;
import vn.com.routex.driver.service.interfaces.models.product.response.UpdateProductResponse;
import vn.com.routex.driver.service.interfaces.models.product.response.UploadProductResponse;
import vn.com.routex.driver.service.interfaces.models.product.response.ProductDetailResponse;
import vn.com.routex.driver.service.interfaces.models.product.request.UploadProductRequest;
import vn.com.routex.driver.service.infrastructure.persistence.exceptions.BusinessException;
import vn.com.routex.driver.service.application.services.ProductService;
import vn.com.routex.driver.service.infrastructure.utils.ExceptionUtils;
import vn.com.routex.driver.service.interfaces.models.request.base.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static vn.com.routex.driver.service.infrastructure.persistence.constant.ErrorConstant.SYSTEM_ERROR;
import static vn.com.routex.driver.service.infrastructure.persistence.constant.ErrorConstant.SYSTEM_ERROR_MESSAGE;


@RequiredArgsConstructor
public class ProductFacadeImpl implements ProductFacade{

    private final ProductService productService;

    @Override
    public ResponseEntity<ProductDetailResponse> getAllProducts(ProductDetailRequest request) {
        ProductDetailResponse response = productService.getAllProducts(request);
        return new ResponseEntity<>(createResponse(request, response), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UploadProductResponse> uploadNewProduct(UploadProductRequest request) {
        UploadProductResponse response = productService.uploadProduct(request);
        return new ResponseEntity<>(createResponse(request, response), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductDetailResponse> getProductById(ProductDetailRequest request) {
        ProductDetailResponse response = productService.getProductById(request);
        return new ResponseEntity<>(createResponse(request, response), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UpdateProductResponse> updateProduct(UpdateProductRequest request) {
        UpdateProductResponse response = productService.updateProduct(request);
        return new ResponseEntity<>(createResponse(request, response), HttpStatus.OK);
    }


    private <R extends BaseResponse<?>> R createResponse(BaseRequest request, R response) {
        if(response == null) {
            throw new BusinessException(request.getRequestId(), request.getRequestDateTime(), request.getChannel(),
                    ExceptionUtils.buildResultResponse(SYSTEM_ERROR, SYSTEM_ERROR_MESSAGE));
        }

        response.setRequestId(request.getRequestId());
        response.setRequestDateTime(request.getRequestDateTime());
        response.setChannel(request.getChannel());
        if(response.getData() == null) {
            throw new BusinessException(request.getRequestId(), request.getRequestDateTime(), request.getChannel(),
                    ExceptionUtils.buildResultResponse(SYSTEM_ERROR, SYSTEM_ERROR_MESSAGE));
        };
        return response;
    }
}
