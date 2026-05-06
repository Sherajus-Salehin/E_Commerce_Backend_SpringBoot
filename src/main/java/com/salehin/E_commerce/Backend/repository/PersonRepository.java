package com.salehin.E_commerce.Backend.repository;

import com.salehin.E_commerce.Backend.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Integer> {
}
