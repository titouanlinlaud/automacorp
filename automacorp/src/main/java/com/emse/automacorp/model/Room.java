package com.emse.automacorp.model;

import java.util.List;

public record Room(Long id, String name, List<Window> windows, Double targetTemperature) {
    // La pièce a un identifiant, un nom, et une liste de capteurs.

}