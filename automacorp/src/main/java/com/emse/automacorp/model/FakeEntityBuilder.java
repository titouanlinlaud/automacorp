package com.emse.automacorp.model;
import java.util.ArrayList;
import java.util.Set;


public class FakeEntityBuilder {

    public static RoomEntity createRoomEntity(Long id, String name, BuildingEntity building) {
        // Sensor is recreated before each test
        RoomEntity entity = new RoomEntity(
                name,
                createSensorEntity(1L, "Temp", SensorType.TEMPERATURE, 23.2),
                1);

        entity.setBuilding(building);
        entity.settarget_temperature(26.4);
        entity.setWindows(new ArrayList<>(Set.of(
                createWindowEntity(id * 10 + 1L, "Window1" + name, entity),
                createWindowEntity(id * 10 + 2L, "Window2" + name, entity)
        )));
        entity.setHeaters(Set.of(
                createHeaterEntity(id * 10 + 1L, "Heater1" + name, entity),
                createHeaterEntity(id * 10 + 2L, "Heater2" + name, entity)
        ));
        return entity;
    }

    public static WindowEntity createWindowEntity(Long id, String name, RoomEntity roomEntity) {
        // Sensor is recreated before each test
        WindowEntity windowEntity = new WindowEntity(
                name,
                createSensorEntity(id * 10 + 1L, "Status" + id, SensorType.STATUS, 0.0),
                roomEntity
        );
        windowEntity.setId(id);
        return windowEntity;
    }

    public static HeaterEntity createHeaterEntity(Long id, String name, RoomEntity roomEntity) {
        // Sensor is recreated before each test
        HeaterEntity heaterEntity = new HeaterEntity(
                name,
                createSensorEntity(id * 10 + 1L, "Status" + id, SensorType.STATUS, 0.0),
                roomEntity
        );
        return heaterEntity;
    }

    public static SensorEntity createSensorEntity(Long id, String name, SensorType type, Double value) {
        // Sensor is recreated before each test
        SensorEntity sensorEntity = new SensorEntity(id, name,type,value);
        sensorEntity.setId(id);
        sensorEntity.setValue(value);
        return sensorEntity;
    }
    public static BuildingEntity createBuildingEntity(Long id, String name) {
        BuildingEntity buildingEntity = new BuildingEntity();
        buildingEntity.setId(id);
        buildingEntity.setName(name);
        buildingEntity.setRooms(Set.of(
                createRoomEntity(id * 10 + 1L, "Room1" + name, buildingEntity),
                createRoomEntity(id * 10 + 2L, "Room2" + name, buildingEntity)
        ));
        return buildingEntity;
    }
}

