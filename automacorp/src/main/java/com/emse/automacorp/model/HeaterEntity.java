package com.emse.automacorp.model;

import jakarta.persistence.*;

@Entity
public class HeaterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private RoomEntity room; // Référence à la pièce

    @ManyToOne
    private SensorEntity sensor;

    public HeaterEntity() {
    }

    public void setRoom(RoomEntity room) {
        this.room = room;
    }

    public RoomEntity getRoom() {
        return room;
    }
    public HeaterEntity(String name, SensorEntity sensor, RoomEntity room) {
        this.name = name;
        this.sensor = sensor;
        this.room = room;
    }

}
