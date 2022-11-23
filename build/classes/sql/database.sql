
CREATE DATABASE IF NOT EXISTS autosColombia;-- crea la BBDD

USE autosColombia;


CREATE TABLE usuarios(
    id INT NOT NULL AUTO_INCREMENT,
    numero_identificacion VARCHAR(120) NOT NULL,
    nombres VARCHAR(120) NOT NULL,
    apellidos VARCHAR(120) NOT NULL,
    direccion VARCHAR(255),
    telefono VARCHAR(255),
    PRIMARY KEY(id),
    UNIQUE(numero_identificacion),
    fk_vehiculos INT NOT NULL,
    fk_pagos INT NOT NULL,
    FOREIGN KEY(fk_vehiculos) REFERENCES vehiculos(id),
    FOREIGN KEY(fk_pagos) REFERENCES pagos(id) 
);

CREATE TABLE vehiculos(
    id INT NOT NULL AUTO_INCREMENT,
    placa VARCHAR(10) NOT NULL,
    descripcion VARCHAR(250),
    PRIMARY KEY(id)
);

CREATE TABLE pagos(
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(45) NOT NULL,
    descripcion VARCHAR(250),
    PRIMARY KEY(id),
    fecha_ingreso DATETIME DEFAULT NOW(),
    fecha_salida DATETIME DEFAULT NOW()
)

