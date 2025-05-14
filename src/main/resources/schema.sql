CREATE TABLE IF NOT EXISTS app_user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fName VARCHAR(255),
    lName VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(255),
    entryDate DATE,
    guide VARCHAR(255),
    trip VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS trips (
    id INT PRIMARY KEY AUTO_INCREMENT,
    imageUrl VARCHAR(255),
    durationAndPrice VARCHAR(255),
    title VARCHAR(255),
    location VARCHAR(255),
    area VARCHAR(255),
    tripType VARCHAR(255),
    difficulty INT,
    highlights TEXT
);


CREATE TABLE IF NOT EXISTS guides (
    id BIGINT PRIMARY KEY,
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    role VARCHAR(255),
    imageUrl VARCHAR(255),
    bio TEXT,
    specialty VARCHAR(255),
    yearsExperience INT,
    favoriteTrail VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS destinations (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    subtitle VARCHAR(255),
    imageUrl VARCHAR(255),
    linkUrl VARCHAR(255),
    tripCount INT
);

CREATE TABLE IF NOT EXISTS adventures (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    imageUrl VARCHAR(255),
    linkUrl VARCHAR(255),
    tripCount INT
);

--Assignment 3 Implementation
CREATE TABLE sec_user (
  userId            BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  email             VARCHAR(75) NOT NULL UNIQUE,
  encryptedPassword VARCHAR(128) NOT NULL,
  enabled           BIT NOT NULL 
);

CREATE TABLE sec_role(
  roleId   BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  roleName VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE user_role
(
  id     BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  userId BIGINT NOT NULL,
  roleId BIGINT NOT NULL
);

ALTER TABLE user_role
  ADD CONSTRAINT user_role_uk UNIQUE (userId, roleId);

ALTER TABLE user_role
  ADD CONSTRAINT user_role_fk1 FOREIGN KEY (userId)
  REFERENCES sec_user (userId);
 
ALTER TABLE user_role
  ADD CONSTRAINT user_role_fk2 FOREIGN KEY (roleId)
  REFERENCES sec_role (roleId);