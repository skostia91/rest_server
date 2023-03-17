package by.shylau.rest.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.time.LocalDateTime;

import static by.shylau.rest.util.Constants.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = TABLE_NAME)
//@Table(name = "senso")
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID)
    private int id;

    @NotBlank(message = NAME_NOT_BLANK_MESSAGE)
    @Size(min = NAME_SIZE_MIN, max = NAME_SIZE_MAX, message = NAME_SIZE_MESSAGE)
    @Column(name = COLUMN_NAME)
    private String name;

    @Min(value = VALUE_MIN, message = VALUE_MIN_MESSAGE)
    @Max(value = VALUE_MAX, message = VALUE_MAX_MESSAGE)
    @Column(name = COLUMN_VALUE)
    private Double value;

    @NotNull
    @Column(name = COLUMN_RAINING)
    private boolean raining;

    @Column(name = COLUMN_TIME)
    private LocalDateTime dataTime;
}