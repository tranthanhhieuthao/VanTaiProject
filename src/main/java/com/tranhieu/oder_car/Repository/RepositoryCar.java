package com.tranhieu.oder_car.Repository;

import com.tranhieu.oder_car.Model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface RepositoryCar extends JpaRepository<Car, Integer> {

    Page<Car> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM car c WHERE (:licensePlate IS NULL OR c.license_plate like %:licensePlate%)" +
            " AND (:placeReturn IS NULL OR c.place_return LIKE %:placeReturn%)" +
            " AND (:statusCar IS NULL OR c.status_car = :statusCar)", nativeQuery = true)
     Page<Car> searchCarByMutilCondition(@Param("licensePlate") String licensePlate,@Param("placeReturn") String placeReturn,@Param("statusCar") Boolean statusCar, Pageable pageable);
}
