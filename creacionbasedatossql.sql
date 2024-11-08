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
  `estado_proveedor` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`almacen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `derrapdb`.`almacen` (
  `id` VARCHAR(15) NOT NULL,
  `nombre_pieza` VARCHAR(45) NULL,
  `num_serie` INT(15) NULL,
  `precio_pieza` DOUBLE NULL,
  `marca` VARCHAR(45) NULL,
  `proveedor_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_almacen_proveedor1_idx` (`proveedor_id` ASC) VISIBLE,
  CONSTRAINT `fk_almacen_proveedor1`
    FOREIGN KEY (`proveedor_id`)
    REFERENCES `mydb`.`proveedor` (`id`)
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
-- Table `mydb`.`orden_reparacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `derrapdb`.`orden_reparacion` (
  `id` VARCHAR(20) NOT NULL,
  `estado_reparacion` VARCHAR(45) NULL,
  `descrip_reparacion` VARCHAR(45) NULL,
  `fecha_ingreso` DATE NULL,
  `usuario_dni` VARCHAR(9) NOT NULL,
  `vehiculo_matricula` VARCHAR(20) NOT NULL,
  `tipo_servicio` VARCHAR(45) NULL,
  `estado_orden` VARCHAR(45) NULL,
  `horas_trabajo` DOUBLE NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_orden_reparacion_usuario1_idx` (`usuario_dni` ASC) VISIBLE,
  INDEX `fk_orden_reparacion_vehiculo1_idx` (`vehiculo_matricula` ASC) VISIBLE,
  CONSTRAINT `fk_orden_reparacion_usuario1`
    FOREIGN KEY (`usuario_dni`)
    REFERENCES `derrapdb`.`usuario` (`dni`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orden_reparacion_vehiculo1`
    FOREIGN KEY (`vehiculo_matricula`)
    REFERENCES `derrapdb`.`vehiculo` (`matricula`)
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
  `pieza` VARCHAR(45) NULL,
  `num_piezas` INT NULL,
  `proveedor_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_pedido_proveedor1_idx` (`proveedor_id` ASC) VISIBLE,
  CONSTRAINT `fk_pedido_proveedor1`
    FOREIGN KEY (`proveedor_id`)
    REFERENCES `derrapdb`.`proveedor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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

-- Insert into cliente
INSERT INTO cliente (`dni`, `nombre`, `apellido1`, `apellido2`, `telefono`, `direccion`, `email`, `fecha_registro`) VALUES 
('123456789', 'Armando', 'Garcia', 'Gomez', 123456789, 'Calle Falsa 123', 'agg0072@alu.medac.es', '2024-01-01'),
('987654321', 'Maria', 'Lopez', 'Martinez', 987654321, 'Avenida Siempre Viva 456', 'mjgt344523@alu.medac.es', '2024-02-01');

-- Insert into usuario
INSERT INTO usuario (`dni`, `nombre`, `apellido1`, `apellido2`, `telefono`, `password`, `direccion`, `email`, `fecha_contratacion`, `rol`) VALUES 
('123456789', 'Juan', 'Perez', 'Gomez', 123456789, 'admin', 'Calle Falsa 123', 'juan@example.com', '2024-01-01', 'administrador'),
('987654321', 'Maria', 'Lopez', 'Martinez', 987654321, 'mecanico', 'Avenida Siempre Viva 456', 'maria@example.com', '2024-02-01', 'mecanico');

-- Insert into vehiculo
INSERT INTO vehiculo (`matricula`, `marca`, `modelo`, `color`, `ano_fabr`, `tipo_vehiculo`, `km`, `fecha_registro`, `cliente_dni`) VALUES 
('ABC123', 'Toyota', 'Corolla', 'Rojo', 2020, 'Sedan', 15000, '2024-01-01', '123456789'),
('XYZ987', 'Ford', 'Focus', 'Azul', 2019, 'Hatchback', 20000, '2024-02-01', '987654321');

-- Insert into proveedor
INSERT INTO proveedor (`id`, `nombre`, `telefono`, `email`, `direccion`, `estado_proveedor`) VALUES 
('prov001', 'Proveedor Uno', 123456789, 'proveedor1@example.com', 'Calle de los Proveedores 123', 'Activo'),
('prov002', 'Proveedor Dos', 987654321, 'proveedor2@example.com', 'Avenida de los Proveedores 456', 'Inactivo');

-- Insert into almacen
INSERT INTO almacen (`id`, `nombre_pieza`, `num_serie`, `precio_pieza`, `marca`, `proveedor_id`) VALUES 
('alm001', 'Filtro de Aceite', 10001, 15.50, 'Bosch', 'prov001'),
('alm002', 'Bujía', 10002, 8.75, 'NGK', 'prov002');

-- Insert into cita
INSERT INTO cita (`id`, `estado`, `fecha`, `hora`, `vehiculo_matricula`) VALUES 
('cita001', 'Programada', '2024-01-15', 10, 'ABC123'),
('cita002', 'Completada', '2024-02-20', 15, 'XYZ987');

-- Insert into orden_reparacion
INSERT INTO orden_reparacion (`id`, `estado_reparacion`, `descrip_reparacion`, `fecha_ingreso`, `usuario_dni`, `vehiculo_matricula`, `tipo_servicio`, `estado_orden`, `horas_trabajo`) VALUES 
('ord001', 'En Proceso', 'Cambio de aceite', '2024-01-15', '123456789', 'ABC123', 'Mantenimiento', 'Pendiente', 2.5),
('ord002', 'Completada', 'Cambio de bujías', '2024-02-20', '987654321', 'XYZ987', 'Reparación', 'Finalizada', 1.0);

-- Insert into facturacion
INSERT INTO facturacion (`id`, `precio_total`, `fecha_emision`, `tipo_pago`, `orden_reparacion_id`) VALUES 
('fact001', 150.00, '2024-01-16', 'Tarjeta', 'ord001'),
('fact002', 80.00, '2024-02-21', 'Efectivo', 'ord002');

-- Insert into pedido
INSERT INTO pedido (`id`, `estado`, `total_pedido`, `fecha_pedido`, `pieza`, `num_piezas`, `proveedor_id`) VALUES 
('ped001', 'Pendiente', 30, '2024-01-10', 'Filtro de Aceite', 2, 'prov001'),
('ped002', 'Recibido', 17.50, '2024-02-10', 'Bujía', 2, 'prov002');

-- Insert into repuesto
INSERT INTO repuesto (`almacen_id`, `orden_reparacion_id`, `cantidad_utilizada`) VALUES 
('alm001', 'ord001', 1),
('alm002', 'ord002', 4);

-- Insert into solicitud
INSERT INTO solicitud (`orden_reparacion_id`, `pedido_id`) VALUES 
('ord001', 'ped001'),
('ord002', 'ped002');
