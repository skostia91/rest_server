package by.shylau.rest.repository;

import by.shylau.rest.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer> {
    List<Sensor> findByValueGreaterThan(double value);
    List<Sensor> findByValueLessThan(double value);
    List<Sensor> findAllByName(String name);
}
