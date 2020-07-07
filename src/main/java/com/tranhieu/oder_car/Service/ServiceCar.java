package com.tranhieu.oder_car.Service;

import com.tranhieu.oder_car.DTO.DTODetailOrder;
import com.tranhieu.oder_car.Model.Car;
import com.tranhieu.oder_car.Model.Yield;
import com.tranhieu.oder_car.Repository.RepositoryCar;
import com.tranhieu.oder_car.Response.ResponseOderCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServiceCar {

    @Autowired
    private RepositoryCar repositoryCar;

    private Boolean checkNullPageAndlimit(Integer page, Integer limit) {
        if (page == null || limit == null) return true;
        return false;
    }

    public ResponseOderCar getAllListCar(Integer page, Integer limit) {
        if (checkNullPageAndlimit(page,limit)) {
            List<Car> listCar = repositoryCar.findAll();
            if (listCar.isEmpty()) return ResponseOderCar.failed("không tồn tại");
            return ResponseOderCar.isSuccess("SUCCESS", listCar);
        } else {
            Page<Car> listPageCar = repositoryCar.findAll(PageRequest.of(--page, limit));
            if (listPageCar.isEmpty()) return ResponseOderCar.failed("Không tồn tại");
            return ResponseOderCar.isSuccess("SUCCESS", listPageCar);
        }
    }

    public ResponseOderCar searchCar(String licensePlate, String placeReturn,Boolean statusCar, Integer page, Integer limit) {
            Page<Car> listCar = repositoryCar.searchCarByMutilCondition(licensePlate, placeReturn,statusCar, PageRequest.of(--page,limit));
        if (listCar.isEmpty()) return ResponseOderCar.failed("không tồn tại");
        return ResponseOderCar.isSuccess("SUCCESS", listCar);
    }

    public ResponseOderCar createOrUpdateCar(Car car) {
        repositoryCar.save(car);
        return ResponseOderCar.isSuccessSimple();
    }

    public ResponseOderCar detailCar(Integer id) {
        Car car = repositoryCar.findById(id).get();
        if (car == null) return ResponseOderCar.failed("Không tồn tại");
        return ResponseOderCar.isSuccess("SUCCES", car);
    }

    public ResponseOderCar deleteCar(Integer id) {
        Car car = repositoryCar.findById(id).get();
        if (car == null) return ResponseOderCar.failed("Không tồn tại");
        repositoryCar.delete(car);
        return ResponseOderCar.isSuccess("SUCCESS",car);
    }

    public ResponseOderCar getDetailOrder() {
        List<DTODetailOrder> dtoDetailOrder = repositoryCar.listDetailOrder();
        if (dtoDetailOrder.isEmpty()) return ResponseOderCar.failed("Không tồn tại");
        return ResponseOderCar.isSuccess("SUCCESS", dtoDetailOrder);
    }

}
