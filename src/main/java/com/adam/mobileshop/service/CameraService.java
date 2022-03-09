package com.adam.mobileshop.service;

import com.adam.mobileshop.model.Camera;
import org.springframework.stereotype.Service;

@Service
public interface CameraService {
    void newCamera(Camera camera);
    void deleteCameraById(long id);
    Camera findCameraById(long id);
}
