package com.tranhieu.oder_car.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "car")
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_car")
    private Integer idCar;
    @Column(name = "license_plate")
    private String licensePlate;
    @Column(name = "type_car")
    private String typeCar;
    @Column(name = "gross_ton")
    private int grossTon;

    @Column(name = "expect_return_date")
    private Date expectedReturnDate;

    @Column(name = "place_return")
    private String placeReturn;

    @Column(name = "status_car")
    private String statusCar;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
    @JsonIgnore
    private Set<Yield> listYield = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;
}
