package com.emse.automacorp.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import jakarta.persistence.*;
import java.util.Set;



@Entity

public class RoomEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer floor;

    @Column(nullable = false)
    private String name;

    @Column
    private double target_temperature;

    @OneToOne(cascade = CascadeType.ALL)
    private SensorEntity current_temperature;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    List<WindowEntity> windows = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "building_id")
    private BuildingEntity building;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<HeaterEntity> heaters = new HashSet<>();

    public RoomEntity() {
    }

    public RoomEntity(String name, Integer floor, double target_temperature, SensorEntity current_temperature) {
        this.name = name;
        this.floor = floor;
        this.target_temperature = target_temperature;
        this.current_temperature = current_temperature;

    }
    public RoomEntity(String name, SensorEntity current_temperature, int floor) {
        this.name = name;
        this.current_temperature = current_temperature;
        this.floor = floor;
    }


    public Long getId() {
        return id;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SensorEntity getcurrent_temperature() {
        return current_temperature;
    }

    public void setcurrent_temperature(SensorEntity current_temperature) {
        this.current_temperature = current_temperature;
    }

    public Double gettarget_temperature() {
        return target_temperature;
    }

    public void settarget_temperature(Double target_temperature) {
        this.target_temperature = target_temperature;
    }

    public List<WindowEntity> getWindows() {
        return windows;
    }

    public void setWindows(List<WindowEntity> windows) {
        this.windows = windows;
    }

    public void addWindow(WindowEntity window) {
        this.windows.add(window);
        window.setRoom(this); // Set the bidirectional relationship
    }

    public void removeWindow(WindowEntity window) {
        this.windows.remove(window);
        window.setRoom(null); // Remove the association
    }
    public BuildingEntity getBuilding() {
        return building;
    }

    // Setter pour building
    public void setBuilding(BuildingEntity building) {
        this.building = building;
    }

    public void setHeaters(Set<HeaterEntity> heaters) {
        this.heaters = heaters;
    }

    public Set<HeaterEntity> getHeaters() {
        return heaters;
    }
}

