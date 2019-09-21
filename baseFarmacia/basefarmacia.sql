-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-09-2019 a las 06:11:55
-- Versión del servidor: 10.1.36-MariaDB
-- Versión de PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `basefarmacia`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `almacen`
--

CREATE TABLE `almacen` (
  `COD_ALMACEN` int(11) NOT NULL,
  `NOM_ALMACEN` varchar(15) NOT NULL,
  `DIREC_ALMACEN` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `almacen`
--

INSERT INTO `almacen` (`COD_ALMACEN`, `NOM_ALMACEN`, `DIREC_ALMACEN`) VALUES
(1, 'INKAFARMA-CALLA', 'Jr Saenz Peña');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `COD_CATEGORIA` int(11) NOT NULL,
  `NOM_CATEGORIA` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`COD_CATEGORIA`, `NOM_CATEGORIA`) VALUES
(1, 'analgesicos'),
(2, 'higiene'),
(3, 'corporal'),
(4, 'bucodental'),
(5, 'facial');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `COD_CLIENTE` int(11) NOT NULL,
  `APELL_MATERNO_CLI` varchar(15) NOT NULL,
  `APELL_PATERNO_CLI` varchar(15) NOT NULL,
  `NOM_CLI` varchar(15) NOT NULL,
  `RUC_CLI` varchar(8) NOT NULL,
  `DNI_CLI` varchar(8) NOT NULL,
  `GENERO_CLI` varchar(1) NOT NULL,
  `DIR_CLI` varchar(30) NOT NULL,
  `CEL_CLI` varchar(9) NOT NULL,
  `COD_DISTRITO` int(11) DEFAULT NULL,
  `COD_USUARIO` int(11) DEFAULT NULL,
  `COD_SEDE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_pedido_compra_almacen`
--

CREATE TABLE `detalle_pedido_compra_almacen` (
  `COD_PEDIDO_COMPRA` int(11) DEFAULT NULL,
  `COD_ALMACEN` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_pedido_venta_sede`
--

CREATE TABLE `detalle_pedido_venta_sede` (
  `COD_PEDIDO_VENTA` int(11) DEFAULT NULL,
  `COD_SEDE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_producto_almacen`
--

CREATE TABLE `detalle_producto_almacen` (
  `COD_PRODUCTO` int(11) DEFAULT NULL,
  `COD_ALMACEN` int(11) DEFAULT NULL,
  `STOCK` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `distrito`
--

CREATE TABLE `distrito` (
  `COD_DISTRITO` int(11) NOT NULL,
  `NOM_DISTRITO` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `distrito`
--

INSERT INTO `distrito` (`COD_DISTRITO`, `NOM_DISTRITO`) VALUES
(1, 'Callao'),
(2, 'La Molina'),
(3, 'Cieneguilla'),
(4, 'La Victoria'),
(5, 'San Miguel'),
(6, 'Ate'),
(7, 'Breña'),
(8, 'Comas'),
(9, 'Barranco'),
(10, 'Chorrillos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `COD_EMPLEADO` int(11) NOT NULL,
  `APELL_PATERNO_EMP` varchar(15) NOT NULL,
  `APELL_MATERNO_EMP` varchar(15) NOT NULL,
  `NOMBRE_EMP` varchar(15) NOT NULL,
  `DIR_NAC_EMP` varchar(30) DEFAULT NULL,
  `FEC_NAC_EMP` date NOT NULL,
  `CELULAR_EMP` varchar(9) DEFAULT NULL,
  `FECHA_INGRESO` date NOT NULL,
  `COD_USUARIO` int(11) DEFAULT NULL,
  `COD_DISTRITO` int(11) DEFAULT NULL,
  `COD_SEDE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`COD_EMPLEADO`, `APELL_PATERNO_EMP`, `APELL_MATERNO_EMP`, `NOMBRE_EMP`, `DIR_NAC_EMP`, `FEC_NAC_EMP`, `CELULAR_EMP`, `FECHA_INGRESO`, `COD_USUARIO`, `COD_DISTRITO`, `COD_SEDE`) VALUES
(1, 'Salinas', 'Lazaro', 'Jesus', 'Jr Lima', '1950-08-08', '989707601', '2019-02-25', 1, 1, 1),
(2, 'Alvarez', 'Gonzales', 'Roberto', 'Jr Molina', '1962-06-07', '966707655', '2019-02-25', 2, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido_compra`
--

CREATE TABLE `pedido_compra` (
  `COD_PEDIDO_COMPRA` int(11) NOT NULL,
  `FECHA_PEDIDO` date NOT NULL,
  `TOTAL` double NOT NULL,
  `COD_PROVEEDOR` int(11) DEFAULT NULL,
  `COD_SEDE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido_compra_producto`
--

CREATE TABLE `pedido_compra_producto` (
  `COD_PEDIDO_COMPRA` int(11) DEFAULT NULL,
  `COD_PRODUCTO` int(11) DEFAULT NULL,
  `CANTIDAD` double NOT NULL,
  `PRECIO_COMPRA` double NOT NULL,
  `IMPORTE` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido_venta`
--

CREATE TABLE `pedido_venta` (
  `COD_PEDIDO_VENTA` int(11) NOT NULL,
  `FECHA_PEDIDO` date NOT NULL,
  `DESCUENTO` double DEFAULT NULL,
  `SUBTOTAL` double DEFAULT NULL,
  `COD_CLIENTE` int(11) DEFAULT NULL,
  `COD_EMPLEADO` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido_venta_producto`
--

CREATE TABLE `pedido_venta_producto` (
  `COD_PEDIDO_VENTA` int(11) DEFAULT NULL,
  `COD_PRODUCTO` int(11) DEFAULT NULL,
  `CANTIDAD` double NOT NULL,
  `PRECIO_VENTA` double NOT NULL,
  `IMPORTE` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `COD_PRODUCTO` int(11) NOT NULL,
  `NOM_PRODUCTO` varchar(15) NOT NULL,
  `PRECIO_VENTA` double NOT NULL,
  `IGV` double NOT NULL,
  `COD_PROVEEDOR` int(11) DEFAULT NULL,
  `COD_CATEGORIA` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `COD_PROVEEDOR` int(11) NOT NULL,
  `NOM_PROVEEDOR` varchar(15) NOT NULL,
  `DIR_PROVEEDOR` varchar(30) NOT NULL,
  `CEL_PROVEEDOR` varchar(9) NOT NULL,
  `COD_DISTRITO` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sede`
--

CREATE TABLE `sede` (
  `COD_SEDE` int(11) NOT NULL,
  `NOM_SEDE` varchar(15) NOT NULL,
  `COD_DISTRITO` int(11) DEFAULT NULL,
  `COD_ALMACEN` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `sede`
--

INSERT INTO `sede` (`COD_SEDE`, `NOM_SEDE`, `COD_DISTRITO`, `COD_ALMACEN`) VALUES
(1, 'INKAFARMA-CALLA', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_usuario`
--

CREATE TABLE `tipo_usuario` (
  `COD_TIPO_USU` int(11) NOT NULL,
  `NOM_TIPO_USU` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipo_usuario`
--

INSERT INTO `tipo_usuario` (`COD_TIPO_USU`, `NOM_TIPO_USU`) VALUES
(1, 'Administrador'),
(2, 'Digitador'),
(3, 'Almacenero');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `COD_USUARIO` int(11) NOT NULL,
  `USUARIO` varchar(15) NOT NULL,
  `PASS` varchar(8) NOT NULL,
  `COD_TIPO_USU` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`COD_USUARIO`, `USUARIO`, `PASS`, `COD_TIPO_USU`) VALUES
(1, 'Yei', '123', 1),
(2, 'Usuario', 'contra', 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `almacen`
--
ALTER TABLE `almacen`
  ADD PRIMARY KEY (`COD_ALMACEN`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`COD_CATEGORIA`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`COD_CLIENTE`),
  ADD KEY `fk_cod_distrito4` (`COD_DISTRITO`),
  ADD KEY `fk_cod_usu2` (`COD_USUARIO`),
  ADD KEY `fk_cod_sede2` (`COD_SEDE`);

--
-- Indices de la tabla `detalle_pedido_compra_almacen`
--
ALTER TABLE `detalle_pedido_compra_almacen`
  ADD KEY `fk_pedido_compra2` (`COD_PEDIDO_COMPRA`),
  ADD KEY `fk_cod_almacen3` (`COD_ALMACEN`);

--
-- Indices de la tabla `detalle_pedido_venta_sede`
--
ALTER TABLE `detalle_pedido_venta_sede`
  ADD KEY `fk_cod_pedido_venta2` (`COD_PEDIDO_VENTA`),
  ADD KEY `fk_cod_sede3` (`COD_SEDE`);

--
-- Indices de la tabla `detalle_producto_almacen`
--
ALTER TABLE `detalle_producto_almacen`
  ADD KEY `fk_cod_producto3` (`COD_PRODUCTO`),
  ADD KEY `fk_cod_almacen2` (`COD_ALMACEN`);

--
-- Indices de la tabla `distrito`
--
ALTER TABLE `distrito`
  ADD PRIMARY KEY (`COD_DISTRITO`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`COD_EMPLEADO`),
  ADD KEY `fk_cod_usu1` (`COD_USUARIO`),
  ADD KEY `fk_cod_distrito3` (`COD_DISTRITO`),
  ADD KEY `fk_cod_sede1` (`COD_SEDE`);

--
-- Indices de la tabla `pedido_compra`
--
ALTER TABLE `pedido_compra`
  ADD PRIMARY KEY (`COD_PEDIDO_COMPRA`),
  ADD KEY `fk_cod_sede4` (`COD_SEDE`),
  ADD KEY `fk_cod_proveedor2` (`COD_PROVEEDOR`);

--
-- Indices de la tabla `pedido_compra_producto`
--
ALTER TABLE `pedido_compra_producto`
  ADD KEY `fk_pedido_compra1` (`COD_PEDIDO_COMPRA`),
  ADD KEY `fk_cod_producto4` (`COD_PRODUCTO`);

--
-- Indices de la tabla `pedido_venta`
--
ALTER TABLE `pedido_venta`
  ADD PRIMARY KEY (`COD_PEDIDO_VENTA`),
  ADD KEY `fk_cod_cliente` (`COD_CLIENTE`),
  ADD KEY `fk_cod_emp` (`COD_EMPLEADO`);

--
-- Indices de la tabla `pedido_venta_producto`
--
ALTER TABLE `pedido_venta_producto`
  ADD KEY `fk_cod_pedido_venta` (`COD_PEDIDO_VENTA`),
  ADD KEY `fk_cod_producto2` (`COD_PRODUCTO`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`COD_PRODUCTO`),
  ADD KEY `fk_cod_proveedor1` (`COD_PROVEEDOR`),
  ADD KEY `fk_cod_categoria1` (`COD_CATEGORIA`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`COD_PROVEEDOR`),
  ADD KEY `fk_cod_distrito2` (`COD_DISTRITO`);

--
-- Indices de la tabla `sede`
--
ALTER TABLE `sede`
  ADD PRIMARY KEY (`COD_SEDE`),
  ADD KEY `fk_cod_distrito` (`COD_DISTRITO`),
  ADD KEY `fk_cod_almacen` (`COD_ALMACEN`);

--
-- Indices de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  ADD PRIMARY KEY (`COD_TIPO_USU`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`COD_USUARIO`),
  ADD KEY `fk_cod_tipo_usu` (`COD_TIPO_USU`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `almacen`
--
ALTER TABLE `almacen`
  MODIFY `COD_ALMACEN` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `COD_CATEGORIA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `COD_CLIENTE` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `distrito`
--
ALTER TABLE `distrito`
  MODIFY `COD_DISTRITO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `COD_EMPLEADO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `pedido_compra`
--
ALTER TABLE `pedido_compra`
  MODIFY `COD_PEDIDO_COMPRA` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pedido_venta`
--
ALTER TABLE `pedido_venta`
  MODIFY `COD_PEDIDO_VENTA` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `COD_PRODUCTO` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `COD_PROVEEDOR` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `sede`
--
ALTER TABLE `sede`
  MODIFY `COD_SEDE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  MODIFY `COD_TIPO_USU` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `COD_USUARIO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `fk_cod_distrito4` FOREIGN KEY (`COD_DISTRITO`) REFERENCES `distrito` (`COD_DISTRITO`),
  ADD CONSTRAINT `fk_cod_sede2` FOREIGN KEY (`COD_SEDE`) REFERENCES `sede` (`COD_SEDE`),
  ADD CONSTRAINT `fk_cod_usu2` FOREIGN KEY (`COD_USUARIO`) REFERENCES `usuario` (`COD_USUARIO`);

--
-- Filtros para la tabla `detalle_pedido_compra_almacen`
--
ALTER TABLE `detalle_pedido_compra_almacen`
  ADD CONSTRAINT `fk_cod_almacen3` FOREIGN KEY (`COD_ALMACEN`) REFERENCES `almacen` (`COD_ALMACEN`),
  ADD CONSTRAINT `fk_pedido_compra2` FOREIGN KEY (`COD_PEDIDO_COMPRA`) REFERENCES `pedido_compra` (`COD_PEDIDO_COMPRA`);

--
-- Filtros para la tabla `detalle_pedido_venta_sede`
--
ALTER TABLE `detalle_pedido_venta_sede`
  ADD CONSTRAINT `fk_cod_pedido_venta2` FOREIGN KEY (`COD_PEDIDO_VENTA`) REFERENCES `pedido_venta` (`COD_PEDIDO_VENTA`),
  ADD CONSTRAINT `fk_cod_sede3` FOREIGN KEY (`COD_SEDE`) REFERENCES `sede` (`COD_SEDE`);

--
-- Filtros para la tabla `detalle_producto_almacen`
--
ALTER TABLE `detalle_producto_almacen`
  ADD CONSTRAINT `fk_cod_almacen2` FOREIGN KEY (`COD_ALMACEN`) REFERENCES `almacen` (`COD_ALMACEN`),
  ADD CONSTRAINT `fk_cod_producto3` FOREIGN KEY (`COD_PRODUCTO`) REFERENCES `producto` (`COD_PRODUCTO`);

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `fk_cod_distrito3` FOREIGN KEY (`COD_DISTRITO`) REFERENCES `distrito` (`COD_DISTRITO`),
  ADD CONSTRAINT `fk_cod_sede1` FOREIGN KEY (`COD_SEDE`) REFERENCES `sede` (`COD_SEDE`),
  ADD CONSTRAINT `fk_cod_usu1` FOREIGN KEY (`COD_USUARIO`) REFERENCES `usuario` (`COD_USUARIO`);

--
-- Filtros para la tabla `pedido_compra`
--
ALTER TABLE `pedido_compra`
  ADD CONSTRAINT `fk_cod_proveedor2` FOREIGN KEY (`COD_PROVEEDOR`) REFERENCES `proveedor` (`COD_PROVEEDOR`),
  ADD CONSTRAINT `fk_cod_sede4` FOREIGN KEY (`COD_SEDE`) REFERENCES `sede` (`COD_SEDE`);

--
-- Filtros para la tabla `pedido_compra_producto`
--
ALTER TABLE `pedido_compra_producto`
  ADD CONSTRAINT `fk_cod_producto4` FOREIGN KEY (`COD_PRODUCTO`) REFERENCES `producto` (`COD_PRODUCTO`),
  ADD CONSTRAINT `fk_pedido_compra1` FOREIGN KEY (`COD_PEDIDO_COMPRA`) REFERENCES `pedido_compra` (`COD_PEDIDO_COMPRA`);

--
-- Filtros para la tabla `pedido_venta`
--
ALTER TABLE `pedido_venta`
  ADD CONSTRAINT `fk_cod_cliente` FOREIGN KEY (`COD_CLIENTE`) REFERENCES `cliente` (`COD_CLIENTE`),
  ADD CONSTRAINT `fk_cod_emp` FOREIGN KEY (`COD_EMPLEADO`) REFERENCES `empleado` (`COD_EMPLEADO`);

--
-- Filtros para la tabla `pedido_venta_producto`
--
ALTER TABLE `pedido_venta_producto`
  ADD CONSTRAINT `fk_cod_pedido_venta` FOREIGN KEY (`COD_PEDIDO_VENTA`) REFERENCES `pedido_venta` (`COD_PEDIDO_VENTA`),
  ADD CONSTRAINT `fk_cod_producto2` FOREIGN KEY (`COD_PRODUCTO`) REFERENCES `producto` (`COD_PRODUCTO`);

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `fk_cod_categoria1` FOREIGN KEY (`COD_CATEGORIA`) REFERENCES `categoria` (`COD_CATEGORIA`),
  ADD CONSTRAINT `fk_cod_proveedor1` FOREIGN KEY (`COD_PROVEEDOR`) REFERENCES `proveedor` (`COD_PROVEEDOR`);

--
-- Filtros para la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD CONSTRAINT `fk_cod_distrito2` FOREIGN KEY (`COD_DISTRITO`) REFERENCES `distrito` (`COD_DISTRITO`);

--
-- Filtros para la tabla `sede`
--
ALTER TABLE `sede`
  ADD CONSTRAINT `fk_cod_almacen` FOREIGN KEY (`COD_ALMACEN`) REFERENCES `almacen` (`COD_ALMACEN`),
  ADD CONSTRAINT `fk_cod_distrito` FOREIGN KEY (`COD_DISTRITO`) REFERENCES `distrito` (`COD_DISTRITO`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_cod_tipo_usu` FOREIGN KEY (`COD_TIPO_USU`) REFERENCES `tipo_usuario` (`COD_TIPO_USU`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
