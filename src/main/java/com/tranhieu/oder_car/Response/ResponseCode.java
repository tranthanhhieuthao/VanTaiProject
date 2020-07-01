package com.tranhieu.oder_car.Response;

import org.omg.CORBA.PUBLIC_MEMBER;

public class ResponseCode {

    public interface ErrorCode {
        String ERROR_NOT_FOUND = "NOT_FOUND";
        String NOT_EXIT = "NOT_EXIT";
        String IS_USED = "IS_USED";
        String NOT_USED = "NOT_USED";
        String FAILED = "FAILED";
        String BAD_REQUEST = "BAD_REQUEST";
        String FILE_NOT_FOUND = "FILE_NOT_FOUND";
    }

    public interface successCode {
        String SUCCESS = "SUCCESS";
        String IS_EMPTY = "IS_EMPTY";
    }
}
