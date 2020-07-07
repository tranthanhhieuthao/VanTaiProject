package com.tranhieu.oder_car.Controller;

import com.tranhieu.oder_car.Service.ServiceCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("api/v1")
public class ControllerDetaiOrder {

    @Autowired
    ServiceCar serviceCar;

    @GetMapping("/listOrder")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity getListDetail() {
        return  ResponseEntity.ok(serviceCar.getDetailOrder());
    }

}
