-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `derrapdb` DEFAULT CHARACTER SET utf8 ;
USE `derrapdb` ;

-- -----------------------------------------------------
-- Table `mydb`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `derrapdb`.`cliente` (
  `dni` VARCHAR(9) NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido1` VARCHAR(45) NULL,
  `apellido2` VARCHAR(45) NULL,
  `telefono` INT(9) NULL,
  `direccion` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `fecha_registro` DATE NULL,
  PRIMARY KEY (`dni`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `derrapdb`.`usuario` (
  `dni` VARCHAR(9) NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido1` VARCHAR(45) NULL,
  `apellido2` VARCHAR(45) NULL,
  `telefono` INT(9) NULL,
  `password` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `fecha_contratacion` DATE NULL,
  `rol` VARCHAR(45) NULL,
  PRIMARY KEY (`dni`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`vehiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `derrapdb`.`vehiculo` (
  `matricula` VARCHAR(20) NOT NULL,
  `marca` VARCHAR(45) NULL,
  `modelo` VARCHAR(45) NULL,
  `color` VARCHAR(15) NULL,
  `ano_fabr` INT(4) NULL,
  `tipo_vehiculo` VARCHAR(45) NULL,
  `km` DOUBLE NULL,
  `fecha_registro` DATE NULL,
  `cliente_dni` VARCHAR(9) NOT NULL,
  PRIMARY KEY (`matricula`),
  INDEX `fk_vehiculo_cliente_idx` (`cliente_dni` ASC) VISIBLE,
  CONSTRAINT `fk_vehiculo_cliente`
    FOREIGN KEY (`cliente_dni`)
    REFERENCES `derrapdb`.`cliente` (`dni`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `derrapdb`.`proveedor` (
  `id` VARCHAR(20) NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `telefono` INT(9) NULL,
  `email` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`almacen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `derrapdb`.`almacen` (
  `id` VARCHAR(15) NOT NULL,
  `stock` INT(40) NULL,
  `nombre_pieza` VARCHAR(45) NULL,
  `num_serie` INT(15) NULL,
  `precio_pieza` DOUBLE NULL,
  `marca` VARCHAR(45) NULL,
  `horas_trabajo` DOUBLE NULL,
  `almacencol` VARCHAR(45) NULL,
  `proveedor_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_almacen_proveedor1_idx` (`proveedor_id` ASC) VISIBLE,
  CONSTRAINT `fk_almacen_proveedor1`
    FOREIGN KEY (`proveedor_id`)
    REFERENCES `derrapdb`.`proveedor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`cita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `derrapdb`.`cita` (
  `id` VARCHAR(20) NOT NULL,
  `estado` VARCHAR(45) NULL,
  `fecha` DATE NULL,
  `hora` INT NULL,
  `vehiculo_matricula` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cita_vehiculo1_idx` (`vehiculo_matricula` ASC) VISIBLE,
  CONSTRAINT `fk_cita_vehiculo1`
    FOREIGN KEY (`vehiculo_matricula`)
    REFERENCES `derrapdb`.`vehiculo` (`matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`servicio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `derrapdb`.`servicio` (
  `id` VARCHAR(20) NOT NULL,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`orden_reparacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `derrapdb`.`orden_reparacion` (
  `id` VARCHAR(20) NOT NULL,
  `estado_repa` VARCHAR(45) NULL,
  `diagnostico` VARCHAR(45) NULL,
  `descrip_reparacion` VARCHAR(45) NULL,
  `fecha_ingreso` DATE NULL,
  `fecha_entrega` DATE NULL,
  `usuario_dni` VARCHAR(9) NOT NULL,
  `vehiculo_matricula` VARCHAR(20) NOT NULL,
  `asignacion` VARCHAR(2) NULL,
  `servicio_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_orden_reparacion_usuario1_idx` (`usuario_dni` ASC) VISIBLE,
  INDEX `fk_orden_reparacion_vehiculo1_idx` (`vehiculo_matricula` ASC) VISIBLE,
  INDEX `fk_orden_reparacion_servicio1_idx` (`servicio_id` ASC) VISIBLE,
  CONSTRAINT `fk_orden_reparacion_usuario1`
    FOREIGN KEY (`usuario_dni`)
    REFERENCES `derrapdb`.`usuario` (`dni`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orden_reparacion_vehiculo1`
    FOREIGN KEY (`vehiculo_matricula`)
    REFERENCES `derrapdb`.`vehiculo` (`matricula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orden_reparacion_servicio1`
    FOREIGN KEY (`servicio_id`)
    REFERENCES `derrapdb`.`servicio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`facturacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `derrapdb`.`facturacion` (
  `id` VARCHAR(20) NOT NULL,
  `precio_total` DOUBLE NULL,
  `fecha_emision` DATE NULL,
  `tipo_pago` VARCHAR(45) NULL,
  `orden_reparacion_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_facturacion_orden_reparacion1_idx` (`orden_reparacion_id` ASC) VISIBLE,
  CONSTRAINT `fk_facturacion_orden_reparacion1`
    FOREIGN KEY (`orden_reparacion_id`)
    REFERENCES `derrapdb`.`orden_reparacion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `derrapdb`.`pedido` (
  `id` VARCHAR(20) NOT NULL,
  `estado` VARCHAR(45) NULL,
  `total_pedido` INT NULL,
  `fecha_pedido` DATE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`repuesto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `derrapdb`.`repuesto` (
  `almacen_id` VARCHAR(15) NOT NULL,
  `orden_reparacion_id` VARCHAR(20) NOT NULL,
  `cantidad_utilizada` INT NULL,
  PRIMARY KEY (`almacen_id`, `orden_reparacion_id`),
  INDEX `fk_almacen_has_orden_reparacion_orden_reparacion1_idx` (`orden_reparacion_id` ASC) VISIBLE,
  INDEX `fk_almacen_has_orden_reparacion_almacen1_idx` (`almacen_id` ASC) VISIBLE,
  CONSTRAINT `fk_almacen_has_orden_reparacion_almacen1`
    FOREIGN KEY (`almacen_id`)
    REFERENCES `derrapdb`.`almacen` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_almacen_has_orden_reparacion_orden_reparacion1`
    FOREIGN KEY (`orden_reparacion_id`)
    REFERENCES `derrapdb`.`orden_reparacion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`solicitud`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `derrapdb`.`solicitud` (
  `orden_reparacion_id` VARCHAR(20) NOT NULL,
  `pedido_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`orden_reparacion_id`, `pedido_id`),
  INDEX `fk_orden_reparacion_has_pedido_pedido1_idx` (`pedido_id` ASC) VISIBLE,
  INDEX `fk_orden_reparacion_has_pedido_orden_reparacion1_idx` (`orden_reparacion_id` ASC) VISIBLE,
  CONSTRAINT `fk_orden_reparacion_has_pedido_orden_reparacion1`
    FOREIGN KEY (`orden_reparacion_id`)
    REFERENCES `derrapdb`.`orden_reparacion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orden_reparacion_has_pedido_pedido1`
    FOREIGN KEY (`pedido_id`)
    REFERENCES `derrapdb`.`pedido` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- I N S E R C I O N E S

-- Tabla cliente
INSERT INTO `derrapdb`.`cliente` (`dni`, `nombre`, `apellido1`, `apellido2`, `telefono`, `direccion`, `email`, `fecha_registro`) 
VALUES 
('12345678A', 'Juan', 'Pérez', 'García', 600123456, 'Calle Falsa 123', 'juan.perez@example.com', '2023-10-01'),
('87654321B', 'Ana', 'López', 'Martín', 700654321, 'Avenida Siempreviva 742', 'ana.lopez@example.com', '2023-09-15');

SELECT * FROM USUARIO;
-- Tabla usuario
INSERT INTO `derrapdb`.`usuario` (`dni`, `nombre`, `apellido1`, `apellido2`, `telefono`, `password`, `direccion`, `email`, `fecha_contratacion`, `rol`) 
VALUES
('23456789C', 'Carlos', 'Ruiz', 'Sánchez', 800567890, 'admin', 'Calle del Sol 5', 'carlos.ruiz@example.com', '2023-08-01', 'Administrador'),
('98765432D', 'María', 'Gómez', 'Fernández', 900876543, 'mecanico', 'Calle Luna 8', 'maria.gomez@example.com', '2023-07-20', 'Mecánico');

-- Tabla vehiculo
INSERT INTO `derrapdb`.`vehiculo` (`matricula`, `marca`, `modelo`, `color`, `ano_fabr`, `tipo_vehiculo`, `km`, `fecha_registro`, `cliente_dni`) 
VALUES 
('ABC123', 'Toyota', 'Corolla', 'Blanco', 2019, 'Sedán', 20000, '2023-10-02', '12345678A'),
('XYZ789', 'Honda', 'Civic', 'Negro', 2020, 'Sedán', 15000, '2023-09-18', '87654321B');

-- Tabla proveedor
INSERT INTO `derrapdb`.`proveedor` (`id`, `nombre`, `telefono`, `email`, `direccion`) 
VALUES 
('PROV1', 'Proveedores S.L.', 910123456, 'contacto@proveedores.com', 'Calle Mayor 10'),
('PROV2', 'Repuestos y Más', 920654321, 'info@repuestostore.com', 'Avenida Central 5');

-- Tabla almacen
INSERT INTO `derrapdb`.`almacen` (`id`, `stock`, `nombre_pieza`, `num_serie`, `precio_pieza`, `marca`, `horas_trabajo`, `almacencol`, `proveedor_id`) 
VALUES 
('ALM1', 50, 'Filtro de Aceite', 123456, 15.50, 'Mann', 0.5, 'A', 'PROV1'),
('ALM2', 30, 'Bujía', 654321, 5.75, 'Bosch', 0.2, 'B', 'PROV2');

-- Tabla cita
INSERT INTO `derrapdb`.`cita` (`id`, `estado`, `fecha`, `hora`, `vehiculo_matricula`) 
VALUES 
('CITA1', 'Pendiente', '2023-10-15', 10, 'ABC123'),
('CITA2', 'Confirmada', '2023-10-20', 12, 'XYZ789');

-- Tabla servicio
INSERT INTO `derrapdb`.`servicio` (`id`, `nombre`) 
VALUES 
('SERV1', 'Cambio de Aceite'),
('SERV2', 'Revisión General');

-- Tabla orden_reparacion
INSERT INTO `derrapdb`.`orden_reparacion` (`id`, `estado_repa`, `diagnostico`, `descrip_reparacion`, `fecha_ingreso`, `fecha_entrega`, `usuario_dni`, `vehiculo_matricula`, `asignacion`, `servicio_id`) 
VALUES 
('OR1', 'Iniciado', 'Fallo en motor', 'Reparación motor', '2023-10-01', '2023-10-10', '23456789C', 'ABC123', 'A1', 'SERV1'),
('OR2', 'Finalizado', 'Cambio de aceite', 'Cambio de filtro y aceite', '2023-09-15', '2023-09-20', '98765432D', 'XYZ789', 'B2', 'SERV2');

-- Tabla facturacion
INSERT INTO `derrapdb`.`facturacion` (`id`, `precio_total`, `fecha_emision`, `tipo_pago`, `orden_reparacion_id`) 
VALUES 
('FACT1', 200.50, '2023-10-11', 'Tarjeta de Crédito', 'OR1'),
('FACT2', 75.75, '2023-09-21', 'Efectivo', 'OR2');

-- Tabla pedido
INSERT INTO `derrapdb`.`pedido` (`id`, `estado`, `total_pedido`, `fecha_pedido`) 
VALUES 
('PED1', 'Pendiente', 150, '2023-10-01'),
('PED2', 'Entregado', 300, '2023-09-15');

-- Tabla repuesto
INSERT INTO `derrapdb`.`repuesto` (`almacen_id`, `orden_reparacion_id`, `cantidad_utilizada`) 
VALUES 
('ALM1', 'OR1', 2),
('ALM2', 'OR2', 4);

-- Tabla solicitud
INSERT INTO `derrapdb`.`solicitud` (`orden_reparacion_id`, `pedido_id`) 
VALUES 
('OR1', 'PED1'),
('OR2', 'PED2');