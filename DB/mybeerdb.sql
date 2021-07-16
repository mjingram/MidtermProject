-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mybeerdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mybeerdb` ;

-- -----------------------------------------------------
-- Schema mybeerdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mybeerdb` DEFAULT CHARACTER SET utf8 ;
USE `mybeerdb` ;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `enabled` TINYINT(100) NOT NULL,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `address` ;

CREATE TABLE IF NOT EXISTS `address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `zipcode` VARCHAR(12) NULL,
  `street` VARCHAR(200) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `account_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `account_info` ;

CREATE TABLE IF NOT EXISTS `account_info` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `address_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_user_address_idx` (`address_id` ASC),
  INDEX `fk_account_info_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_user_address`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_account_info_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `brewery`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `brewery` ;

CREATE TABLE IF NOT EXISTS `brewery` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `address_id` INT NOT NULL,
  `image_url` VARCHAR(2000) NULL,
  `logo_image_url` VARCHAR(2000) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_brewery_user_address1_idx` (`address_id` ASC),
  CONSTRAINT `fk_brewery_user_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `beer_style`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `beer_style` ;

CREATE TABLE IF NOT EXISTS `beer_style` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `beer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `beer` ;

CREATE TABLE IF NOT EXISTS `beer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `abv` DOUBLE NULL,
  `ibu` DOUBLE NULL,
  `name` VARCHAR(45) NULL,
  `ounces` DOUBLE NULL,
  `brewery_id` INT NULL,
  `beer_style_id` INT NULL,
  `image_url` VARCHAR(2000) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_beer_breweries1_idx` (`brewery_id` ASC),
  INDEX `fk_beer_beer_style1_idx` (`beer_style_id` ASC),
  CONSTRAINT `fk_beer_breweries1`
    FOREIGN KEY (`brewery_id`)
    REFERENCES `brewery` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_beer_beer_style1`
    FOREIGN KEY (`beer_style_id`)
    REFERENCES `beer_style` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `favorite_style`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `favorite_style` ;

CREATE TABLE IF NOT EXISTS `favorite_style` (
  `beer_style_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`beer_style_id`, `user_id`),
  INDEX `fk_beer_style_has_user_user1_idx` (`user_id` ASC),
  INDEX `fk_beer_style_has_user_beer_style1_idx` (`beer_style_id` ASC),
  CONSTRAINT `fk_beer_style_has_user_beer_style1`
    FOREIGN KEY (`beer_style_id`)
    REFERENCES `beer_style` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_beer_style_has_user_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `favorite_beer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `favorite_beer` ;

CREATE TABLE IF NOT EXISTS `favorite_beer` (
  `user_id` INT NOT NULL,
  `beer_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `beer_id`),
  INDEX `fk_user_has_beer_beer1_idx` (`beer_id` ASC),
  INDEX `fk_user_has_beer_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_beer_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_beer_beer1`
    FOREIGN KEY (`beer_id`)
    REFERENCES `beer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `favorite_brewery`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `favorite_brewery` ;

CREATE TABLE IF NOT EXISTS `favorite_brewery` (
  `user_id` INT NOT NULL,
  `brewery_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `brewery_id`),
  INDEX `fk_user_has_brewery_brewery1_idx` (`brewery_id` ASC),
  INDEX `fk_user_has_brewery_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_brewery_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_brewery_brewery1`
    FOREIGN KEY (`brewery_id`)
    REFERENCES `brewery` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `brewery_review`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `brewery_review` ;

CREATE TABLE IF NOT EXISTS `brewery_review` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `review_date` DATETIME NULL,
  `comment` TEXT NULL,
  `user_id` INT NOT NULL,
  `brewery_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_brewery_review_user1_idx` (`user_id` ASC),
  INDEX `fk_brewery_review_brewery1_idx` (`brewery_id` ASC),
  CONSTRAINT `fk_brewery_review_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_brewery_review_brewery1`
    FOREIGN KEY (`brewery_id`)
    REFERENCES `brewery` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `beer_review`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `beer_review` ;

CREATE TABLE IF NOT EXISTS `beer_review` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `review_date` DATETIME NULL,
  `comment` TEXT NULL,
  `user_id` INT NOT NULL,
  `beer_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_beer_review_user1_idx` (`user_id` ASC),
  INDEX `fk_beer_review_beer1_idx` (`beer_id` ASC),
  CONSTRAINT `fk_beer_review_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_beer_review_beer1`
    FOREIGN KEY (`beer_id`)
    REFERENCES `beer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS beeruser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'beeruser'@'localhost' IDENTIFIED BY 'beeruser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'beeruser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `mybeerdb`;
INSERT INTO `user` (`id`, `username`, `password`, `enabled`, `role`) VALUES (1, 'admin', 'admin90', 1, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `address`
-- -----------------------------------------------------
START TRANSACTION;
USE `mybeerdb`;
INSERT INTO `address` (`id`, `city`, `state`, `zipcode`, `street`) VALUES (1, 'Minneapolis', 'MN', '55111', '23rd Ave S');

COMMIT;


-- -----------------------------------------------------
-- Data for table `account_info`
-- -----------------------------------------------------
START TRANSACTION;
USE `mybeerdb`;
INSERT INTO `account_info` (`id`, `first_name`, `last_name`, `address_id`, `user_id`) VALUES (1, 'Paul', 'Noodle', 1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `brewery`
-- -----------------------------------------------------
START TRANSACTION;
USE `mybeerdb`;
INSERT INTO `brewery` (`id`, `name`, `address_id`, `image_url`, `logo_image_url`) VALUES (1, 'NorthGate Brewing', 1, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `beer_style`
-- -----------------------------------------------------
START TRANSACTION;
USE `mybeerdb`;
INSERT INTO `beer_style` (`id`, `name`) VALUES (1, 'India Pale Ale');

COMMIT;


-- -----------------------------------------------------
-- Data for table `beer`
-- -----------------------------------------------------
START TRANSACTION;
USE `mybeerdb`;
INSERT INTO `beer` (`id`, `abv`, `ibu`, `name`, `ounces`, `brewery_id`, `beer_style_id`, `image_url`) VALUES (1, 0.066, 0, 'Devil\'s Cup', 12.0, 1, 1, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `favorite_style`
-- -----------------------------------------------------
START TRANSACTION;
USE `mybeerdb`;
INSERT INTO `favorite_style` (`beer_style_id`, `user_id`) VALUES (1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `favorite_beer`
-- -----------------------------------------------------
START TRANSACTION;
USE `mybeerdb`;
INSERT INTO `favorite_beer` (`user_id`, `beer_id`) VALUES (1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `favorite_brewery`
-- -----------------------------------------------------
START TRANSACTION;
USE `mybeerdb`;
INSERT INTO `favorite_brewery` (`user_id`, `brewery_id`) VALUES (1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `brewery_review`
-- -----------------------------------------------------
START TRANSACTION;
USE `mybeerdb`;
INSERT INTO `brewery_review` (`id`, `review_date`, `comment`, `user_id`, `brewery_id`) VALUES (1, '2021-07-12', 'This is the bestest brewery eva!', 1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `beer_review`
-- -----------------------------------------------------
START TRANSACTION;
USE `mybeerdb`;
INSERT INTO `beer_review` (`id`, `review_date`, `comment`, `user_id`, `beer_id`) VALUES (1, '2020-07-13', 'Wow, this beer sucks', 1, 1);

COMMIT;

