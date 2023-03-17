package by.shylau.rest.controller;

import by.shylau.rest.exception.NoSuchSensorException;
import by.shylau.rest.model.Sensor;
import by.shylau.rest.service.SensorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static by.shylau.rest.util.Constants.*;

@Slf4j
@RestController
@RequestMapping("/sensor")
public class SensorController {
    private final SensorService sensorService;

    @Autowired
    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping()
    public List<Sensor> showAllSensor() {
        log.info(SHOW_ALL_SENSOR);
        return sensorService.findAll();
    }

    @GetMapping("/{id}")
    public Sensor getSensorById(@PathVariable("id") int id) {
        log.info(CONTROLLER_GET_SENSOR_BY_ID, id);
        Sensor sensor = sensorService.getSensorById(id);
        if (sensor == null) {
            throw new NoSuchSensorException(CANT_FIND_BY_ID + id);
        }
        return sensor;
    }

    @GetMapping("/name/{name}")
    public List<Sensor> getSensorByName(@PathVariable String name) {
        log.info(GET_SENSOR_BY_NAME, name);
        List<Sensor> list = sensorService.findAllByName(name);
        if (list.isEmpty()) {
            throw new NoSuchSensorException(CANT_FIND_BY_NAME + name + "'");
        }
        return list;
    }

    @GetMapping("/greater/{value}")
    public List<Sensor> getSensorByValueGreaterThan(@PathVariable double value) {
        log.info(GET_SENSOR_BY_VALUE_GREATER_THAN, value);
        List<Sensor> list = sensorService.getSensorWhereValueGreaterThan(value);
        if (list.isEmpty()) {
            throw new NoSuchSensorException(CANT_FIND_BY_VALUE + value + "'");
        }
        return list;
    }

    @GetMapping("/less/{value}")
    public List<Sensor> getSensorByValueLessThan(@PathVariable double value) {
        log.info(GET_SENSOR_BY_VALUE_LESS_THAN, value);
        List<Sensor> list = sensorService.getSensorWhereValueLessThan(value);
        if (list.isEmpty()) {
            throw new NoSuchSensorException(CANT_FIND_BY_VALUE + value + "'");
        }
        return list;
    }

    @PostMapping()
    public String addSensor(@RequestBody @Valid Sensor sensor, BindingResult result) {
        log.info(ADD_SENSOR, sensor);

        String resp = "Sensor = " + sensor + " was ADD";

        if (result.hasErrors()) {
            resp = "incorrect fields in DB; incorrect field = " + result.getFieldError().getField()
                    + "; message = " + result.getFieldError().getDefaultMessage();
        } else {
            sensorService.save(sensor);
        }
        return resp;
    }

    @PutMapping()
    public String updateSensor(@RequestBody @Valid Sensor sensor, BindingResult result) {
        log.info(UPDATE_SENSOR, sensor);

        String resp = "Sensor = " + sensor + " was update";

        if (result.hasErrors()) {
            resp = "incorrect fields in DB; incorrect field = " + result.getFieldError().getField()
                    + "; message = " + result.getFieldError().getDefaultMessage();
        } else {
            sensorService.save(sensor);
        }
        return resp;
    }

    @DeleteMapping("/{id}")
    public String deleteSensor(@PathVariable("id") int id) {
        log.info(DELETE_SENSOR, id);

        Sensor sensor = sensorService.getSensorById(id);
        if (sensor == null) {
            throw new NoSuchSensorException(CANT_FIND_BY_ID + id);
        }
        sensorService.deleteById(id);
        return "Sensor with ID = " + id + " was DELETE";
    }

    @GetMapping("/rain")
    public Long getRainyDaysCount() {
        log.info(GET_RAINY_DAYS);
        return sensorService.findAll().stream().filter(Sensor::isRaining).count();
    }
}