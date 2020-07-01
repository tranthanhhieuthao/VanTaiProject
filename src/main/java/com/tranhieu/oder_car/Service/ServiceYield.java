package com.tranhieu.oder_car.Service;

import com.tranhieu.oder_car.Model.Yield;
import com.tranhieu.oder_car.Repository.RepositoryYield;
import com.tranhieu.oder_car.Response.ResponseOderCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;


@Service
public class ServiceYield {

    @Autowired
    private RepositoryYield repositoryYield;

    private Boolean checkNullPageAndlimit(Integer page, Integer limit) {
        if (page == null || limit == null) return true;
        return false;
    }

    public ResponseOderCar getAllYeild(Integer page, Integer limit) {
        if (checkNullPageAndlimit(page,limit)) {
            List<Yield> listYield = repositoryYield.findAll();
            if (listYield.isEmpty()) return ResponseOderCar.failed("không tồn tại");
            return ResponseOderCar.isSuccess("SUCCESS", listYield);
        } else {
            Page<Yield> listYieldPage = repositoryYield.findAll(PageRequest.of(--page, limit));
            if (listYieldPage.isEmpty()) return ResponseOderCar.failed("Không tồn tại");
            return ResponseOderCar.isSuccess("SUCCESS", listYieldPage);
        }
    }

    public ResponseOderCar searchYeild(String nameProduct, String placeReturnProduct,Boolean statusYield, Integer page, Integer limit) {
        Page<Yield> listYield = repositoryYield.searchYeild(nameProduct, placeReturnProduct,statusYield, PageRequest.of(page,limit));
        if (listYield.isEmpty()) return ResponseOderCar.failed("Không tồn tại");
        return ResponseOderCar.isSuccess("SUCCESS", listYield);
    }

    public ResponseOderCar createOrUpdateYield(Yield yield) {
        repositoryYield.save(yield);
        return ResponseOderCar.isSuccessSimple();
    }

    public ResponseOderCar detailYield(Integer id) {
        Yield yield = repositoryYield.findById(id).get();
        if (yield == null) return ResponseOderCar.failed("Không tồn tại");
        return ResponseOderCar.failed("SUCCESS", yield);
    }

    public ResponseOderCar deleteYield(Integer id) {
        Yield yield = repositoryYield.findById(id).get();
        if (yield == null) return ResponseOderCar.failed("Không tồn tại");
        repositoryYield.delete(yield);
        return ResponseOderCar.isSuccess("SUCCESS", yield);
    }

}
