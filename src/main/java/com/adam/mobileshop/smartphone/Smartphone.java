package com.adam.mobileshop.smartphone;

import com.adam.mobileshop.brand.Brand;
import com.adam.mobileshop.camera.Camera;
import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Smartphone")
public class Smartphone implements Serializable {
    @Id
    @Column(name = "smartphone_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "brand_id")
//    private Brand brand;

   @Column(name="model_name")
    private String modelName;

    @ElementCollection
    @Column(name="other_names")
    private List<String> otherNames;

    @ElementCollection
    @Column(name="standards")
    private List<String> standards;

    @Column(name="weight")
    private float weight;

    @Column(name="display")
    private String display;

    @ElementCollection
    @Column(name="interlan_memory")
    private List<String> internalMemory;

    @Column(name="operatingSystem")
    private String operatingSystem;

    @Column(name="dual_sim")
    private Boolean dualSim;

    @Column(name="bluetooth")
    private boolean bluetooth;

//    @JoinColumn(name = "camera_id", nullable = false)
//    @OneToOne
//    private Camera camera;

    @Column(name="quantity")
    private int quantity;

    @Builder
    public Smartphone(long id, String modelName, List<String> otherNames, List<String> standards, float weight, String display, List<String> internalMemory, String operatingSystem, Boolean dualSim, boolean bluetooth, int quantity) {
        this.id = id;
        this.modelName = modelName;
        this.otherNames = otherNames;
        this.standards = standards;
        this.weight = weight;
        this.display = display;
        this.internalMemory = internalMemory;
        this.operatingSystem = operatingSystem;
        this.dualSim = dualSim;
        this.bluetooth = bluetooth;
        this.quantity = quantity;
    }


    public Smartphone() {

    }


    // public Brand getBrand() {
    //    return brand;
   // }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public void setBrand(Brand brand) {
//        this.brand = brand;
//    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public List<String> getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(List<String> otherNames) {
        this.otherNames = otherNames;
    }

    public List<String> getStandards() {
        return standards;
    }

    public void setStandards(List<String> standards) {
        this.standards = standards;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public List<String> getInternalMemory() {
        return internalMemory;
    }

    public void setInternalMemory(List<String> internalMemory) {
        this.internalMemory = internalMemory;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public Boolean getDualSim() {
        return dualSim;
    }

    public void setDualSim(Boolean dualSim) {
        this.dualSim = dualSim;
    }

    public boolean isBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

//    public Camera getCamera() {
//        return camera;
//    }
//
//    public void setCamera(Camera camera) {
//        this.camera = camera;
//    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
