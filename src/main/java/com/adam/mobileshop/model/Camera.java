package com.adam.mobileshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Camera {

    @Id
    @Column(name = "camera_id", nullable = false)
    private long id;

    @Column(name="camera_type")
    private String cameraType;
    @Column(name="photo_matrix")
    private int photoMatrix;
    @Column(name="digital_zoom")
    private int digitalZoom;
    @Column(name="lossless_zoom")
    private int losslessZoom;
    @Column(name="flash")
    private boolean flash;
    @Column(name="resolution")
    private String resolution;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
