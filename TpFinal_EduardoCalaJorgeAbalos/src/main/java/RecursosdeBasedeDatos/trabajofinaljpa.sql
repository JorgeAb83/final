-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-11-2022 a las 05:06:43
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `trabajofinaljpa`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `ID` int(11) NOT NULL,
  `APELLIDO` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DNI` int(11) DEFAULT NULL,
  `FECHANACIMIENTO` date DEFAULT NULL,
  `NOMBRE` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `SUELDO` float DEFAULT NULL,
  `PROYECTO_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`ID`, `APELLIDO`, `DNI`, `FECHANACIMIENTO`, `NOMBRE`, `SUELDO`, `PROYECTO_ID`) VALUES
(1, 'Cala', 43940470, '2002-08-05', 'Eduardo', 300, 1),
(2, 'Cala', 47893567, '2000-05-07', 'Edgar', 200, 1),
(3, 'Cala', 1235267, '2005-03-06', 'Robinson', 300, 1),
(4, 'Gala', 24327728, '2000-05-03', 'Claudia', 300, 1),
(5, 'Gala', 654789467, '2007-04-04', 'Laura', 500, 2),
(6, 'Gala', 654735678, '2001-07-04', 'Samantha', 400, 2),
(7, 'Zapana', 543862678, '2002-03-06', 'Jimena', 300, 2),
(8, 'Zapana', 8745676, '2007-05-23', 'Nazarena', 200, 2),
(9, 'Zapana', 5437256, '2002-09-05', 'Selene', 700, 3),
(10, 'Herrera', 5438367, '2000-04-02', 'Angel', 200, 3),
(11, 'Herrera', 12376256, '2001-05-12', 'Mauricio', 700, 3),
(12, 'Gruz', 6732783, '2000-05-10', 'Hector', 100, 3),
(13, 'Cruz', 9836256, '2005-07-23', 'Brian', 100, 4),
(14, 'Cruz', 3472625, '2001-09-04', 'Jonatan', 200, 4),
(15, 'Cruz', 43297267, '2002-06-05', 'Nico', 400, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyectos`
--

CREATE TABLE `proyectos` (
  `ID` int(11) NOT NULL,
  `FECHAPREOYECTO` date DEFAULT NULL,
  `MONTO` float DEFAULT NULL,
  `NOMBRE` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `NUMLEJAGO` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `proyectos`
--

INSERT INTO `proyectos` (`ID`, `FECHAPREOYECTO`, `MONTO`, `NOMBRE`, `NUMLEJAGO`) VALUES
(1, '2000-05-04', 5000, 'Proyecto1', 234),
(2, '2015-04-23', 4000, 'Proyecto2', 123),
(3, '2010-06-06', 3000, 'Proyecto3', 567),
(4, '2000-07-06', 2000, 'Proyecto4', 978);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sequence`
--

CREATE TABLE `sequence` (
  `SEQ_NAME` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `sequence`
--

INSERT INTO `sequence` (`SEQ_NAME`, `SEQ_COUNT`) VALUES
('SEQ_GEN', '150');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_EMPLEADO_PROYECTO_ID` (`PROYECTO_ID`);

--
-- Indices de la tabla `proyectos`
--
ALTER TABLE `proyectos`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `sequence`
--
ALTER TABLE `sequence`
  ADD PRIMARY KEY (`SEQ_NAME`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `FK_EMPLEADO_PROYECTO_ID` FOREIGN KEY (`PROYECTO_ID`) REFERENCES `proyectos` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
