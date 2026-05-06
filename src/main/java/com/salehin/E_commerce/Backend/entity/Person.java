package com.salehin.E_commerce.Backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "people")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String firstName;
    private String lastName;
    private String lock; //email
    private String key;
}
