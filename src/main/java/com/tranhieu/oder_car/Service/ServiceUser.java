package com.tranhieu.oder_car.Service;

import com.tranhieu.oder_car.Model.CustomUserDetails;
import com.tranhieu.oder_car.Model.Users;
import com.tranhieu.oder_car.Repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ServiceUser implements UserDetailsService {

    @Autowired
    private RepositoryUser repositoryUser;


    @Override
    public UserDetails loadUserByUsername(String name) {
        Users users = repositoryUser.findByNameUser(name);
        if (users == null) {
            throw new UsernameNotFoundException(name);
        }
        return new CustomUserDetails(users);
    }

    public UserDetails loadUserByIdUser(Long id) {
        Users users = repositoryUser.findByIdUser(id);
        if (users == null) {
            throw new UsernameNotFoundException("NotFound");
        }
        return new CustomUserDetails(users);
    }
}
