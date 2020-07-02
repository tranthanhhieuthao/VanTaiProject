package com.tranhieu.oder_car.Controller;

import com.tranhieu.oder_car.ConfigJWT.JwtTokenProvider;
import com.tranhieu.oder_car.Model.CustomUserDetails;
import com.tranhieu.oder_car.Response.RequestLogin;
import com.tranhieu.oder_car.Response.ResponseLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ControllerLogin {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseLogin authenticateUser(@Validated @RequestBody RequestLogin requestLogin) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        requestLogin.getUserName(),
                        requestLogin.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.genarateToken((CustomUserDetails) authentication.getPrincipal());
        return new ResponseLogin(jwt);
    }
}
