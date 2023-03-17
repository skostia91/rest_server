package by.shylau.rest.service;

import by.shylau.rest.model.Sensor;
import by.shylau.rest.repository.SensorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static by.shylau.rest.util.Constants.*;

@Slf4j
@Service
public class SensorService {
    private final SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public List<Sensor> findAll() {
        log.info(FIND_ALL);
        return sensorRepository.findAll();
    }

    public void save(Sensor sensor) {
        log.info(SAVE, sensor);
        sensor.setDataTime(LocalDateTime.now());
        sensorRepository.save(sensor);
    }

    public List<Sensor> findAllByName(String name) {
        log.info(FIND_ALL_BY_NAME, name);
        return sensorRepository.findAllByName(name);
    }

    public void deleteById(int id) {
        log.info(DELETE_BY_ID, id);
        sensorRepository.deleteById(id);
    }

    public Sensor getSensorById(int id) {
        log.info(SERVICE_GET_SENSOR_BY_ID, id);

        Sensor sensor = null;
        Optional<Sensor> optional = sensorRepository.findById(id);
        if (optional.isPresent()) {
            sensor = optional.get();
        }
        return sensor;
    }

    public List<Sensor> getSensorWhereValueGreaterThan(double id) {
        log.info(SERVICE_GET_SENSOR_BY_VALUE_GREATER_THAN, id);
        return sensorRepository.findByValueGreaterThan(id);
    }

    public List<Sensor> getSensorWhereValueLessThan(double id) {
        log.info(SERVICE_GET_SENSOR_BY_VALUE_LESS_THAN, id);
        return sensorRepository.findByValueLessThan(id);
    }
}