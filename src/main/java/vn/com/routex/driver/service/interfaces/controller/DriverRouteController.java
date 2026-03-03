package vn.com.routex.driver.service.interfaces.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.routex.driver.service.interfaces.models.driver.response.DriverRouteResponse;

import static vn.com.routex.driver.service.infrastructure.persistence.constant.ApiConstant.API_PATH;
import static vn.com.routex.driver.service.infrastructure.persistence.constant.ApiConstant.API_VERSION;
import static vn.com.routex.driver.service.infrastructure.persistence.constant.ApiConstant.DRIVER_PREFIX;

@RestController
@RequestMapping(API_PATH + API_VERSION + DRIVER_PREFIX)
public class DriverRouteController {

//    @PostMapping("/set-route")
//    public ResponseEntity<DriverRouteResponse>
}
