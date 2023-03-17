package by.shylau.rest.util;

public class Constants {
    private Constants() {
    }

    //Exception
    public static final String CANT_FIND_BY_ID = "DB is dont have sensor with ID ";
    public static final String CANT_FIND_BY_NAME= "DB is dont have sensor with name '";
    public static final String CANT_FIND_BY_VALUE = "DB is dont have sensor with value '";


    //DB
    public static final String TABLE_NAME = "sensor";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_VALUE = "value";
    public static final String COLUMN_RAINING = "raining";
    public static final String COLUMN_TIME = "time";


    //Validation Value
    public static final String VALUE_MIN_MESSAGE = "минимум -100 градусов";
    public static final String VALUE_MAX_MESSAGE = "максимум 100 градусов";
    public static final int VALUE_MAX = 100;
    public static final int VALUE_MIN = -100;


    //Validation Value
    public static final int NAME_SIZE_MIN = 3;
    public static final int NAME_SIZE_MAX = 30;
    public static final String NAME_SIZE_MESSAGE = "Имя должно быть от 3 до 30 символов длиной";
    public static final String NAME_NOT_BLANK_MESSAGE = "Имя не должно быть пустым";


    //Logs Controller
    public static final String SHOW_ALL_SENSOR = "IN SensorController showAllSensor";
    public static final String CONTROLLER_GET_SENSOR_BY_ID = "IN SensorController getSensorById {}";
    public static final String DELETE_SENSOR = "IN SensorController deleteSensor {}";
    public static final String GET_SENSOR_BY_NAME = "IN SensorController getSensorByName {}";
    public static final String GET_RAINY_DAYS = "IN SensorController getRainyDays";
    public static final String ADD_SENSOR = "IN SensorController addSensor {}";
    public static final String UPDATE_SENSOR = "IN SensorController updateSensor {}";
    public static final String GET_SENSOR_BY_VALUE_GREATER_THAN = "IN SensorController getSenorByValueGreaterThan {}";
    public static final String GET_SENSOR_BY_VALUE_LESS_THAN = "IN SensorController getSenorByValueLessThan {}";


    //Logs SensorService
    public static final String FIND_ALL = "IN SensorService findAll";
    public static final String SAVE = "IN SensorService save {}";
    public static final String FIND_ALL_BY_NAME = "IN SensorService findAllByName {}";
    public static final String DELETE_BY_ID = "IN SensorService deleteById {}";
    public static final String SERVICE_GET_SENSOR_BY_ID = "IN SensorService getSensorById {}";
    public static final String SERVICE_GET_SENSOR_BY_VALUE_GREATER_THAN = "IN SensorService getSensorByValueGreaterThan {}";
    public static final String SERVICE_GET_SENSOR_BY_VALUE_LESS_THAN = "IN SensorService getSensorByValueLessThan {}";
}
