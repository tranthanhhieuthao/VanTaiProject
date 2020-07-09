package com.tranhieu.oder_car.Repository;

import com.tranhieu.oder_car.DTO.DTODetailOrder;
import com.tranhieu.oder_car.Model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface RepositoryCar extends JpaRepository<Car, Integer> {

    Page<Car> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM car c WHERE (:licensePlate IS NULL OR c.license_plate like %:licensePlate%)" +
            " AND (:placeReturn IS NULL OR c.place_return LIKE %:placeReturn%)" +
            " AND (:statusCar IS NULL OR c.status_car LIKE %:statusCar%)", nativeQuery = true)
     Page<Car> searchCarByMutilCondition(@Param("licensePlate") String licensePlate,@Param("placeReturn") String placeReturn,@Param("statusCar") String statusCar, Pageable pageable);

    @Query(value = "SELECT new com.tranhieu.oder_car.DTO.DTODetailOrder(" +
            "us.nameUser, us.email, us.phoneNumber," +
            " c.licensePlate, c.grossTon, c.expectedReturnDate, c.placeReturn, c.statusCar," +
            " yi.nameProduct, yi.TimeTakeProduct, yi.cost, yi.placeReturnProduct, yi.statusOder) " +
            " FROM Users us INNER JOIN Car c ON us.idUser = c.users.idUser" +
            " INNER JOIN Yield yi ON c.idCar = yi.car.idCar")
    List<DTODetailOrder> listDetailOrder();
}
