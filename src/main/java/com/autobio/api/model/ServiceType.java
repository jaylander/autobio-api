package com.autobio.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "service_types")
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private Integer defaultIntervalMiles;

    @Column
    private Integer defaultIntervalMonths;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    public ServiceType() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDefaultIntervalMiles() {
        return defaultIntervalMiles;
    }

    public void setDefaultIntervalMiles(Integer defaultIntervalMiles) {
        this.defaultIntervalMiles = defaultIntervalMiles;
    }

    public Integer getDefaultIntervalMonths() {
        return defaultIntervalMonths;
    }

    public void setDefaultIntervalMonths(Integer defaultIntervalMonths) {
        this.defaultIntervalMonths = defaultIntervalMonths;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

