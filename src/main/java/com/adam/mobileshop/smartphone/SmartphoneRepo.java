package com.adam.mobileshop.smartphone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartphoneRepo extends JpaRepository<Smartphone, Long> {
}
