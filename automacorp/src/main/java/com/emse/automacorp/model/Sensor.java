package com.emse.automacorp.model;

public record Sensor(Long id, String name, SensorType type, Double value) {
}