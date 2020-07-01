package com.tranhieu.oder_car.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseOderCar {

    private String message;
    private Object data;

    public static ResponseOderCar isSuccess(String message, Object data) {
        return new ResponseOderCar(message, data);
    }

    public static ResponseOderCar isSuccessSimple() {
        return new ResponseOderCar(ResponseCode.successCode.SUCCESS, "");
    }

    public static ResponseOderCar isFailSimple(Object data) {
        return new ResponseOderCar(ResponseCode.ErrorCode.FAILED, data);
    }

    public static ResponseOderCar failed(String message) {
        return new ResponseOderCar(message, null);
    }

    public static ResponseOderCar failed(String message, Object data) {
        return  new ResponseOderCar(message, data);
    }
}
