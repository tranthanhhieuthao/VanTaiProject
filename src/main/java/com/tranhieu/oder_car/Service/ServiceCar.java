package com.tranhieu.oder_car.Service;

import com.tranhieu.oder_car.DTO.DTODetailOrder;
import com.tranhieu.oder_car.Model.Car;
import com.tranhieu.oder_car.Model.Yield;
import com.tranhieu.oder_car.Repository.RepositoryCar;
import com.tranhieu.oder_car.Repository.RepositoryYield;
import com.tranhieu.oder_car.Response.ResponseOderCar;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
@Slf4j
public class ServiceCar {

    @Autowired
    private RepositoryCar repositoryCar;

    @Autowired
    private RepositoryYield repositoryYield;

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

    public ResponseOderCar searchCar(String licensePlate, String placeReturn,String statusCar, Integer page, Integer limit) {
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

//    @Scheduled(fixedDelay = 5000,initialDelay = 10000)
    @Scheduled(cron = "0 0/30 22-23 * * *")
    public void DeleteCarAdreadlyDone() {
        log.info("Bắt đầu lên lịch quét");
        List<Yield> yields = repositoryYield.findAll();
        for(Yield yield : yields) {
            if (yield.getCar().getStatusCar().equalsIgnoreCase("DONE")) {
                Car car = yield.getCar();
                car.setStatusCar("NONE");
                repositoryCar.save(car);
                yield.setStatusOder("DONE");
                repositoryYield.save(yield);
//                repositoryYield.delete(yield);
                log.info("Đã xóa kiện hàng ,Chuyển đổi thành xe trống" + new Date());
            }
        }
        log.info("lịch quét kết thúc!!!");
    }
}
