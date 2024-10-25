package com.emse.automacorp.web;



import com.emse.automacorp.dao.SensorDao;
import com.emse.automacorp.model.SensorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {

    @Autowired
    private SensorDao sensorDao;

    // GET: Récupérer la liste des capteurs
    @GetMapping
    public List<SensorEntity> findAll() {
        return sensorDao.findAll();
    }

    // GET: Récupérer un capteur particulier via son ID
    @GetMapping("/{id}")
    public ResponseEntity<SensorEntity> findById(@PathVariable Long id) {
        Optional<SensorEntity> sensor = sensorDao.findById(id);
        return sensor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST: Créer un nouveau capteur
    @PostMapping
    public ResponseEntity<SensorEntity> create(@RequestBody SensorEntity sensor) {
        if (sensor.getId() != null && sensorDao.existsById(sensor.getId())) {
            return ResponseEntity.badRequest().build();
        }
        SensorEntity savedSensor = sensorDao.save(sensor);
        return ResponseEntity.ok(savedSensor);
    }

    // PUT: Mettre à jour un capteur existant
    @PutMapping("/{id}")
    public ResponseEntity<SensorEntity> update(@PathVariable Long id, @RequestBody SensorEntity sensor) {
        if (!sensorDao.existsById(id)) {
            return ResponseEntity.badRequest().build();
        }
        sensor.setId(id);  // Assurez-vous que l'ID correspond
        SensorEntity updatedSensor = sensorDao.save(sensor);
        return ResponseEntity.ok(updatedSensor);
    }

    // DELETE: Supprimer un capteur via son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!sensorDao.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        sensorDao.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

