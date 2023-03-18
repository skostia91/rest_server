# rest_server

Описание:
REST API
Состоит из двух частей сенсор отправляет данные на сервер. Сервер обрабатывает эти данные и записывает в БД.

Технологии: Java 11, Spring Boot, MVC, Data, MySQL Workbench, REST, Postman, Lombok, Validation

## Запуск программы:
1. Запуск rest приложения.
2. Запуск client приложения.
Client передаёт 500 запросов с данными о погоде сенсора(название сенсора, температуру, идёт ли дождь) которые записываются в БД("sensor"). 

##Функционал:
1. посмотреть все измерения погоды
Get
http://localhost:3333/rest/sensor

2. посмотреть измерения по id
Get
http://localhost:3333/rest/sensor/id

3. посмотреть измерения по name
Get
http://localhost:3333/rest/sensor/name/{name}

4. посмотреть измерения которые больше чем заданная величина
Get
http://localhost:3333/rest/sensor/greater/{value}

5. посмотреть измерения которые меньше чем заданная величина
Get
http://localhost:3333/rest/sensor/less/{value}

6. показать количество дождливых дней
Get
http://localhost:3333/rest/sensor/rain

7. добавление измерения и сохранение его в БД
Post
http://localhost:3333/rest/sensor

8. изменение измерения
Put
http://localhost:3333/rest/sensor

9. удаление измерения по id
Delete
http://localhost:3333/rest/sensor/{id}
