DROP DATABASE if EXISTS almacenes;
CREATE DATABASE almacenes;
USE almacenes;

DROP TABLE if EXISTS cajeros;
DROP TABLE if EXISTS maquinas_registradoras;
DROP TABLE if EXISTS venta;

CREATE TABLE cajeros(
codigo int AUTO_INCREMENT PRIMARY KEY,
nomapels varchar(255)
);

INSERT INTO cajeros(nomapels) VALUE ('cajero1');
INSERT INTO cajeros(nomapels) VALUE ('cajero2');
INSERT INTO cajeros(nomapels) VALUE ('cajero3');

DROP TABLE if EXISTS productos;
CREATE TABLE productos(
codigo int AUTO_INCREMENT PRIMARY KEY,
nombre varchar(100),
precio int
);

INSERT INTO productos(nombre,precio) VALUE ('producto1',100);
INSERT INTO productos(nombre,precio) VALUE ('producto2',200);
INSERT INTO productos(nombre,precio) VALUE ('producto3',300);


CREATE TABLE maquinas_registradoras(
codigo int auto_increment primary key,
piso int
);

INSERT INTO maquinas_registradoras(piso) VALUE (1);
INSERT INTO maquinas_registradoras(piso) VALUE (2);
INSERT INTO maquinas_registradoras(piso) VALUE (3);


CREATE TABLE venta(
id int AUTO_INCREMENT primary key,
cajero int,
maquina int,
producto int,
FOREIGN KEY (cajero) references cajeros(codigo) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (maquina) references maquinas_registradoras(codigo) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (producto) references productos(codigo) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO venta(cajero,maquina,producto) VALUE (1,1,1);
INSERT INTO venta(cajero,maquina,producto) VALUE (2,2,2);
INSERT INTO venta(cajero,maquina,producto) VALUE (3,3,3);
