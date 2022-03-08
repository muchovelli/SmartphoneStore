package com.adam.mobileshop.repository;

import com.adam.mobileshop.model.Camera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CameraRepo extends JpaRepository<Camera,Long> {
}
