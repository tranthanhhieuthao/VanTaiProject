package com.tranhieu.oder_car.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "name_user",nullable = false,unique = true)
    private String nameUser;

    private String email;

    private String password;
    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",joinColumns = { @JoinColumn(name = "user_id")},
    inverseJoinColumns = { @JoinColumn(name = "role_id")})
    private Set<Roles> listRoles =  new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "users")
    private Set<Car> listCar = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    private Set<Yield> listYield = new HashSet<>();

}
