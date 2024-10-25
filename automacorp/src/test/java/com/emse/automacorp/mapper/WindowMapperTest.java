package com.emse.automacorp.mapper;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class WindowMapperTest {

    @Test
    void shouldMapWindow() {
        // Arrange
        RoomEntity roomEntity = FakeEntityBuilder.createRoomEntity(1L, "Room1", FakeEntityBuilder.createBuildingEntity(1L, "Building1"));
        WindowEntity windowEntity = FakeEntityBuilder.createWindowEntity(101L, "Window1", roomEntity);

        // Act
        Window window = WindowMapper.of(windowEntity);

        // Assert
        Window expectedWindow = new Window(
                101L,
                "Window1",
                windowEntity.getSensor().getStatus(),
                roomEntity.getId()
        );
        Assertions.assertThat(window).usingRecursiveComparison().isEqualTo(expectedWindow);
    }
}

