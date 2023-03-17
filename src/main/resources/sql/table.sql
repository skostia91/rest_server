CREATE TABLE `my_db`.`sensor` (
                                  `id` INT NOT NULL AUTO_INCREMENT,
                                  `name` VARCHAR(45) NOT NULL,
                                  `value` DECIMAL(6) NOT NULL,
                                  `raining` TINYINT(4) NOT NULL,
                                  `time` TIMESTAMP(6) NOT NULL,
                                  PRIMARY KEY (`id`));