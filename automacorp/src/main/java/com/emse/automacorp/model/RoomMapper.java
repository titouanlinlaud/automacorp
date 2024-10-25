package com.emse.automacorp.model;

import java.util.stream.Collectors;


public class RoomMapper {
    public static Room toRoom(RoomEntity roomEntity) {
        return new Room(
                roomEntity.getId(),
                roomEntity.getName(),
                roomEntity.getWindows().stream()
                        .map(WindowMapper::toWindow)  // Mapper chaque fenêtre
                        .collect(Collectors.toList()),
                roomEntity.gettarget_temperature()  // La température cible
        );
    }
}


