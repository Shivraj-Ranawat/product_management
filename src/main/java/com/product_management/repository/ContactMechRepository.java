package com.product_management.repository;

import com.product_management.model.ContactMech;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactMechRepository extends JpaRepository<ContactMech, Integer> {
}
