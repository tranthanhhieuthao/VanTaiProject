package com.tranhieu.oder_car.Repository;

import com.tranhieu.oder_car.Model.Yield;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepositoryYield extends JpaRepository<Yield, Integer> {

    Page<Yield> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM yeild ye WHERE (:nameProduct IS NULL OR ye.name_product LIKE %:nameProduct%)" +
            " AND (:weight IS NULL OR ye.placeReturnProduct LIKE %:placeReturnProduct%)" +
            " AND (:statusYield IS NULL OR ye.status_oder LIKE %:statusOder%)", nativeQuery = true)
    Page<Yield> searchYeild(@Param("nameProduct") String nameProduct, @Param("placeReturnProduct") String placeReturnProduct, @Param("statusYield") String statusOder, Pageable pageable);

}
