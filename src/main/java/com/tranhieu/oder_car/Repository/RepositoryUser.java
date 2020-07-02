package com.tranhieu.oder_car.Repository;

import com.tranhieu.oder_car.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUser extends JpaRepository<Users, Integer> {

    Users findByNameUser (String name);
    Users findByIdUser (Long id);
}
