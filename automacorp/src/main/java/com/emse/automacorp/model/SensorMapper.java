package com.emse.automacorp.model;

import java.util.List;
import java.util.stream.Collectors;

public class SensorMapper {
    public static Sensor toSensor(SensorEntity sensorEntity) {
        return new Sensor(
                sensorEntity.getId(),
                sensorEntity.getName(),
                sensorEntity.getSensorType(),
                sensorEntity.getValue()
        );
    }
    public static Sensor toRecord(SensorEntity entity) {
        if (entity == null) {
            return null; // Handle null case if necessary
        }
        return new Sensor(entity.getId(), entity.getName(), entity.getSensorType(), entity.getValue());
    }
    public static List<Sensor> toRecordList(List<SensorEntity> entities) {
        return entities.stream()
                .map(SensorMapper::toRecord)
                .collect(Collectors.toList());
    }
    public static SensorEntity toEntity(Sensor sensor) {
        if (sensor == null) {
            return null; // Handle null case if necessary
        }
        SensorEntity entity = new SensorEntity(sensor.id(),sensor.name(), sensor.type(), sensor.value());
        entity.setId(sensor.id()); // Set the ID if you want to preserve it
        return entity;
    }
}
