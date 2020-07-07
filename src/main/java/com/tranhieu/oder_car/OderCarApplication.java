package com.tranhieu.oder_car;

import com.tranhieu.oder_car.Model.Users;
import com.tranhieu.oder_car.Repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class OderCarApplication {
//    public class OderCarApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(OderCarApplication.class, args);
    }


//    @Autowired
//    RepositoryUser userRepository;
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    public void run(String... args) throws Exception {
//        // Khi chương trình chạy
//        // Insert vào csdl một user.
//        Users user = new Users();
//        user.setNameUser("TranHieu");
//        user.setPassword(passwordEncoder.encode("123456"));
//        user.setEmail("tranhieu@gmail.com");
//        user.setPhoneNumber("0123456");
//        userRepository.save(user);
//        System.out.println(user);
//    }

}
