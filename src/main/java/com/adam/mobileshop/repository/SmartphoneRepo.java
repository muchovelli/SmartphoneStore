package com.adam.mobileshop.repository;

import com.adam.mobileshop.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartphoneRepo extends JpaRepository<Smartphone, Long> {
}
