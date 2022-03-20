package com.adam.mobileshop.camera;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CameraRepo extends JpaRepository<Camera,Long> {
}
