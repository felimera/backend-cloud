package com.project.appcustomer.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tbl_customers")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "El numero de documento no puede estar vacio.")
    @Size(min = 8, max = 8, message = "El tamaño del numero de identificacion es 8")
    @Column(name = "numero_id", unique = true, length = 8, nullable = false)
    private String numeroId;
    @NotEmpty(message = "El nombre no puede estar vacio.")
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @NotEmpty(message = "El apellido no puede estar vacio.")
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @NotEmpty(message = "El correo no puede estar vacio.")
    @Email(message = "El formato del correo electronico es incorrecto.")
    @Column(unique = true, nullable = false)
    private String email;
    @Column(name = "photo_url")
    private String photoUrl;
    @NotNull(message = "La region no puede ser vacio.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Region region;
    private String state;
}
