package com.autobio.api.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String make;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private String color;
    @Column(nullable = false)
    private Integer year;
    @Column(nullable = false)
    private Integer mileage;
    @Column
    private String vin;

    public Vehicle() {}

    public void setId(Long id) {
        this.id = id;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }
    public void setVin(String vin) {
        this.vin = vin;
    }
    public Long getId() {
        return id;
    }
    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
    public String getColor() {
        return color;
    }
    public Integer getYear() {
        return year;
    }
    public Integer getMileage() {
        return mileage;
    }
    public String getVin() {
        return vin;
    }
}
