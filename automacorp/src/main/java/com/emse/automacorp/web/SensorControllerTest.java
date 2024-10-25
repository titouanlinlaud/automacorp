package com.emse.automacorp.web;

import com.emse.automacorp.dao.SensorDao;
import com.emse.automacorp.model.SensorEntity;
import com.emse.automacorp.model.Sensor;
import com.emse.automacorp.model.SensorMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Sensors")
@RestController
@RequestMapping("/api/sensors")
public class SensorControllerTest {

    private final SensorDao sensorDao;

    @Autowired
    public SensorControllerTest(SensorDao sensorDao) {
        this.sensorDao = sensorDao;
    }

    @ApiOperation(value = "Retrieve a list of sensors")
    @GetMapping
    public List<Sensor> findAll() {
        return SensorMapper.toRecordList(sensorDao.findAll());
    }

    @ApiOperation(value = "Retrieve a sensor by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Sensor> findById(@PathVariable Long id) {
        return sensorDao.findById(id)
                .map(sensorEntity -> ResponseEntity.ok(SensorMapper.toRecord(sensorEntity)))
                .orElse(ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Create a new sensor")
    @PostMapping
    public ResponseEntity<Sensor> create(@RequestBody Sensor sensor) {
        SensorEntity sensorEntity = SensorMapper.toEntity(sensor);
        sensorDao.save(sensorEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(SensorMapper.toRecord(sensorEntity));
    }

    @ApiOperation(value = "Update an existing sensor")
    @PutMapping("/{id}")
    public ResponseEntity<Sensor> update(@PathVariable Long id, @RequestBody Sensor sensor) {
        if (!sensorDao.existsById(id)) {
            return ResponseEntity.badRequest().build();
        }

        SensorEntity sensorEntity = SensorMapper.toEntity(sensor);
        sensorEntity.setId(id); // Set the ID to ensure the correct entity is updated
        sensorDao.save(sensorEntity);
        return ResponseEntity.ok(SensorMapper.toRecord(sensorEntity));
    }

    @ApiOperation(value = "Delete a sensor by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!sensorDao.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        sensorDao.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
