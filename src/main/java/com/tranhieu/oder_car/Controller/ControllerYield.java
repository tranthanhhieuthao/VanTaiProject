package com.tranhieu.oder_car.Controller;

import com.tranhieu.oder_car.Model.Yield;
import com.tranhieu.oder_car.Service.ServiceYield;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1")
public class ControllerYield {

    @Autowired
    private ServiceYield serviceYield;

    @GetMapping("/yield")
    public ResponseEntity getAllListYield(Integer page, Integer limit) {
        return ResponseEntity.ok(serviceYield.getAllYeild(page,limit));
    }

    @GetMapping("/yield/search")
    public ResponseEntity searchYield(@RequestParam String nameProduct,@RequestParam String placeReturnProduct,@RequestParam Boolean statusOder, Integer page, Integer limit) {
        return ResponseEntity.ok(serviceYield.searchYeild(nameProduct, placeReturnProduct,statusOder, page, limit));
    }

    @PostMapping("/yield/update")
    public ResponseEntity createOrUpdate(Yield yield) {
        return ResponseEntity.ok(serviceYield.createOrUpdateYield(yield));
    }

    @GetMapping("/yield/{idYield}")
    public ResponseEntity detailYield(@PathVariable("idYield") Integer idYield) {
        return ResponseEntity.ok(serviceYield.detailYield(idYield));
    }

    @PostMapping("/yield")
    public ResponseEntity deleteYield(@RequestBody Integer id) {
        return ResponseEntity.ok(serviceYield.deleteYield(id));
    }


}
