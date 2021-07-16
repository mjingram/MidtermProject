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
-- Table `user_address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_address` ;

CREATE TABLE IF NOT EXISTS `user_address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `zipcode` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `beer_reviews`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `beer_reviews` ;

CREATE TABLE IF NOT EXISTS `beer_reviews` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `beer_id` INT NULL,
  `comment` VARCHAR(500) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `brewery_reviews`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `brewery_reviews` ;

CREATE TABLE IF NOT EXISTS `brewery_reviews` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `brewery_id` INT NULL,
  `comment` VARCHAR(500) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `beer_profile`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `beer_profile` ;

CREATE TABLE IF NOT EXISTS `beer_profile` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `favorite_beers` VARCHAR(2000) NULL,
  `favorite_breweries` VARCHAR(2000) NULL,
  `favorite_beer_style` VARCHAR(45) NULL,
  `beer_reviews_id` INT NOT NULL,
  `brewery_reviews_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_beer_profile_beer_reviews1_idx` (`beer_reviews_id` ASC),
  INDEX `fk_beer_profile_brewery_reviews1_idx` (`brewery_reviews_id` ASC),
  CONSTRAINT `fk_beer_profile_beer_reviews1`
    FOREIGN KEY (`beer_reviews_id`)
    REFERENCES `beer_reviews` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_beer_profile_brewery_reviews1`
    FOREIGN KEY (`brewery_reviews_id`)
    REFERENCES `brewery_reviews` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `account_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `account_info` ;

CREATE TABLE IF NOT EXISTS `account_info` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `user_address_id` INT NOT NULL,
  `beer_profile_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_user_address_idx` (`user_address_id` ASC),
  INDEX `fk_user_beer_profile1_idx` (`beer_profile_id` ASC),
  CONSTRAINT `fk_user_user_address`
    FOREIGN KEY (`user_address_id`)
    REFERENCES `user_address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_beer_profile1`
    FOREIGN KEY (`beer_profile_id`)
    REFERENCES `beer_profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `account_info_id` INT NULL,
  `enabled` TINYINT(100) NOT NULL,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  INDEX `fk_account_info_user1_idx` (`account_info_id` ASC),
  CONSTRAINT `fk_account_info_user1`
    FOREIGN KEY (`account_info_id`)
    REFERENCES `account_info` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `breweries`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `breweries` ;

CREATE TABLE IF NOT EXISTS `breweries` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `beer_profile_id` INT NOT NULL,
  `beer_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_breweries_beer_profile1_idx` (`beer_profile_id` ASC),
  INDEX `fk_breweries_beer1_idx` (`beer_id` ASC),
  CONSTRAINT `fk_breweries_beer_profile1`
    FOREIGN KEY (`beer_profile_id`)
    REFERENCES `beer_profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_breweries_beer1`
    FOREIGN KEY (`beer_id`)
    REFERENCES `beer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
  `style` VARCHAR(45) NULL,
  `ounces` DOUBLE NULL,
  `brewery_id` INT NULL,
  `breweries_id` INT NOT NULL,
  `beer_profile_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_beer_breweries1_idx` (`breweries_id` ASC),
  INDEX `fk_beer_beer_profile1_idx` (`beer_profile_id` ASC),
  CONSTRAINT `fk_beer_breweries1`
    FOREIGN KEY (`breweries_id`)
    REFERENCES `breweries` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_beer_beer_profile1`
    FOREIGN KEY (`beer_profile_id`)
    REFERENCES `beer_profile` (`id`)
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
INSERT INTO `user` (`id`, `username`, `password`, `account_info_id`, `enabled`, `role`) VALUES (1, 'admin', 'admin90', NULL, 1, NULL);

COMMIT;

