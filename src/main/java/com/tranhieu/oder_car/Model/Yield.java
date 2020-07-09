package com.tranhieu.oder_car.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "yield")
@AllArgsConstructor
@NoArgsConstructor
public class Yield {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Integer idProduct;
    @Column(name = "name_product")
    private String nameProduct;
    @Column(name = "weight")
    private int weight;
    @Column(name = "time_take_product")
    private Date TimeTakeProduct;
    @Column(name = "cost")
    private Integer cost;
    @Column(name = "place_return_product")
    private String placeReturnProduct;

    @Column(name = "status_oder")
    private String statusOder;

    @UpdateTimestamp
    @Column(name = "update_time_oder")
    private Date updateTimeOder;

    @ManyToOne
    @JoinColumn(name = "car_id",nullable = false)
    private Car car;

}
