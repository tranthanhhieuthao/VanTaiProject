package com.tranhieu.oder_car.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DTODetailOrder {

    private String nameUser;
    private String email;
    private String phoneNumber;
    private String licensePlate;
    private int grossTon;
    private Date expectedReturnDate;
    private String placeReturn;
    private String statusCar;
    private String nameProduct;
    private Date TimeTakeProduct;
    private Integer cost;
    private String placeReturnProduct;
    private Boolean statusOder;

//    public DTODetailOrder(String nameUser, String email,String phoneNumber,String licensePlate,
//                          int grossTon,
//                          Date expectedReturnDate, String placeReturn, String statusCar, String nameProduct,Date TimeTakeProduct
//                          ,Integer cost, String placeReturnProduct, Boolean statusOder) {
//        this.nameUser = nameUser;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//        this.licensePlate = licensePlate;
//        this.grossTon = grossTon;
//        this.expectedReturnDate = expectedReturnDate;
//        this.placeReturn = placeReturn;
//        this.statusCar = statusCar;
//        this.nameProduct = nameProduct;
//        this.TimeTakeProduct = TimeTakeProduct;
//        this.cost = cost;
//        this.placeReturnProduct = placeReturnProduct;
//        this.statusOder = statusOder;
//    }

}
