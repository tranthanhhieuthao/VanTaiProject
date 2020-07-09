package com.tranhieu.oder_car.Controller;

import com.tranhieu.oder_car.Model.Car;
import com.tranhieu.oder_car.Service.ServiceCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1")
public class ControllerCar {

    @Autowired
    private ServiceCar serviceCar;

    @GetMapping("/car")
    public ResponseEntity GetAllCar(@RequestParam Integer page, @RequestParam Integer limit) {
        return ResponseEntity.ok(serviceCar.getAllListCar(page,limit));
    }

    @GetMapping("/car/search")
    public ResponseEntity searchCar(@RequestParam String licensePlate, @RequestParam String placeReturn,@RequestParam String statusCar , @RequestParam Integer page, @RequestParam Integer limit) {
        return ResponseEntity.ok(serviceCar.searchCar(licensePlate,placeReturn,statusCar,page,limit));
    }

    @PostMapping("/car/update")
    public ResponseEntity createOrUpdateCar(@RequestBody Car car) {
        return ResponseEntity.ok(serviceCar.createOrUpdateCar(car));
    }

    @GetMapping("/car/{idCar}")
    public ResponseEntity detailCar(@PathVariable("idCar") Integer idCar) {
        return ResponseEntity.ok(serviceCar.detailCar(idCar));
    }

    @PostMapping("/car")
    public ResponseEntity deleteCar(@RequestBody Integer id) {
        return ResponseEntity.ok(serviceCar.deleteCar(id));
    }


}
