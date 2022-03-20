package com.adam.mobileshop.camera;

import org.springframework.stereotype.Service;

@Service
public interface CameraService {
    void saveCamera(Camera camera);
    void deleteCameraById(long id);
    Camera findCameraById(long id);
}
