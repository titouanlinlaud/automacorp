package com.emse.automacorp.model;

public record Window(Long id, String name, Sensor windowStatus, Long roomId) {
}
