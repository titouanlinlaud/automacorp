package com.emse.automacorp.model;

public class WindowMapper {
    public static Window toWindow(WindowEntity windowEntity) {
        return new Window(
                windowEntity.getId(),
                windowEntity.getName(),
                SensorMapper.toSensor(windowEntity.getWindowStatus()),  // Mapper le capteur de la fenêtre
                windowEntity.getRoom().getId()  // L'ID de la pièce associée
        );
    }
}

