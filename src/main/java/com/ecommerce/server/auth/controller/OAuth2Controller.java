package com.ecommerce.server.auth.controller;

import jakarta.servlet.http.HttpServletResponse;
import com.ecommerce.server.auth.config.JWTTokenHelper;
import com.ecommerce.server.auth.entities.User;
import com.ecommerce.server.auth.services.OAuth2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.io.IOException;

/**
 * @created 08/04/2025
 * @project e-commerce application
 * @author Bao Pham
 *
**/


@RestController
@CrossOrigin(origins = "http://13.239.40.146:5173")
@RequestMapping("/oauth2")
public class OAuth2Controller {

    @Autowired
    OAuth2Service oAuth2Service;

    @Autowired
    private JWTTokenHelper jwtTokenHelper;

    @GetMapping("/success")
    public void callbackOAuth2(@AuthenticationPrincipal OAuth2User oAuth2User, HttpServletResponse response) throws IOException {

        String userName = oAuth2User.getAttribute("email");
        User user= oAuth2Service.getUser(userName);
        if(null == user){
            user = oAuth2Service.createUser(oAuth2User,"google");
        }

        String token = jwtTokenHelper.generateToken(user.getUsername());
        response.sendRedirect("http://13.239.40.146:5173/oauth2/callback?token="+token);

    }
}