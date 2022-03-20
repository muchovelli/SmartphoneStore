package com.adam.mobileshop.camera;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CameraServiceImpl implements CameraService{
    @Autowired
    private CameraRepo cameraRepo;

    @Override
    public void saveCamera(Camera camera) {
        cameraRepo.save(camera);
    }

    @Override
    public void deleteCameraById(long id) {
        cameraRepo.deleteById(id);
    }

    @Override
    public Camera findCameraById(long id) {
        Optional<Camera> optional = cameraRepo.findById(id);
        return null;
    }
}
