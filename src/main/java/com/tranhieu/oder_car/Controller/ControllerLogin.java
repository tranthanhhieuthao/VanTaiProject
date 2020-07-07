package com.tranhieu.oder_car.Controller;

import com.tranhieu.oder_car.ConfigJWT.JwtTokenProvider;
import com.tranhieu.oder_car.Model.CustomUserDetails;
import com.tranhieu.oder_car.Response.RequestLogin;
import com.tranhieu.oder_car.Response.ResponseLogin;
import com.tranhieu.oder_car.Response.ResponseOderCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class ControllerLogin {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity authenticateUser(@RequestBody RequestLogin requestLogin) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        requestLogin.getUserName(),
                        requestLogin.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.genarateToken((CustomUserDetails) authentication.getPrincipal());
        return ResponseEntity.ok(ResponseOderCar.isSuccess("SUCCESS", jwt));
    }
}
