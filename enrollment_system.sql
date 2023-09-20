-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 20, 2023 at 06:18 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `enrollment system`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin info`
--

CREATE TABLE `admin info` (
  `id` int(30) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin info`
--

INSERT INTO `admin info` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin123');

-- --------------------------------------------------------

--
-- Table structure for table `student info`
--

CREATE TABLE `student info` (
  `id` int(11) NOT NULL,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `gender` varchar(30) NOT NULL,
  `age` varchar(30) NOT NULL,
  `yearlevel` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `Date Enroll` varchar(30) NOT NULL,
  `tuition` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student info`
--

INSERT INTO `student info` (`id`, `firstname`, `lastname`, `gender`, `age`, `yearlevel`, `username`, `password`, `Date Enroll`, `tuition`) VALUES
(17, '', '', 'Gender', '', 'Grade Level', '', '', 'April 2, 2017', 5382),
(18, '', '', 'Gender', '', 'Grade Level', '', '', 'February 1, 2022', 22382),
(21, 'Justin', 'Valdez', 'Male', '33', 'Grade 3', 'justinty', 'justinty3242', 'April 5, 2019', 17382),
(22, 'JOy', 'Domingo', 'Female', '23', 'Grade 3', 'faithjoy', 'joy1234', 'January 4, 2021', 22382),
(23, 'Justin', 'Valdez', 'Male', '22', 'Grade 5', 'Benz', 'Benz234', 'March 2, 2021', 22382),
(24, 'Justin', 'Maribel', 'Male', '22', 'Grade 2', 'Justin', 'jsutin234', 'February 3, 2020', 22382),
(25, 'Michelle', 'crit', 'Female', '22', 'Grade 1', 'mitch', 'narutokudasai', 'February 2, 2021', 22382),
(26, 'hanzo', 'benji', 'Male', '21', 'Grade 2', 'hanzo', 'hanzo435', 'February 2, 2020', 22382),
(27, 'John', 'Wolter', 'Male', '21', 'Grade 3', 'jake', '23242', 'March 3, 2022', 22382),
(28, 'James', 'Ladore', 'Male', '22', 'Grade 1', 'james', 'james32453', 'February 2, 2021', 22382),
(30, 'denden', 'buliag', 'Male', '22', 'Grade 4', 'den', 'den2342', 'February 1, 2021', 22382),
(31, 'Saint', 'Luo', 'Female', '22', 'Grade 5', 'say', 'sayy2342', 'February 2, 2022', 22382),
(32, 'Mile', 'Buliag', 'Male', '22', 'Grade 4', 'mile', 'tin234', 'February 4, 2018', 22382),
(33, 'Justin', 'Macarae', 'Male', '22', 'Grade 3', 'jsutin', 'naruto', 'January 4, 2021', 20382),
(34, 'Michelle', 'Balderama', 'Female', '22', 'Grade 6', 'mitch', 'narutokudasai', 'March 2, 2021', 9382),
(35, 'May', 'Ladesma', 'Female', '21', 'Grade 1', 'zyro', 'naruto', 'February 2, 2021', -4247),
(43, 'Hanze', 'yu', 'Male', '32', 'Grade 5', 'mitch', 'mitch234', 'February 2, 2021', 27881),
(44, 'John Micheal', 'Ladesma', 'Male', '21', 'Grade 6', 'John2x', 'micheal jackson', 'April 4, 2021', 28322),
(45, 'Michelle', 'Jester', 'Male', '22', 'Grade 3', 'Mitch', 'yolo234', 'February 3, 2020', 30382),
(46, 'Lanze', 'Danzo', 'Male', '34', 'Grade 6', 'Thinker', 'Achu453', 'March 6, 2017', 22322),
(47, 'john ford', 'buliag', 'Male', '21', 'Grade 6', 'johny', 'john342', 'January 7, 2020', 28322),
(48, 'James', 'buliag', 'Male', '21', 'Grade 1', 'james123', 'james123', 'January 1, 2020', 29753),
(49, 'Jake', 'Buliag', 'Male', '21', 'Grade 3', 'johnskie', '123', 'April 3, 2020', 30382);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin info`
--
ALTER TABLE `admin info`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student info`
--
ALTER TABLE `student info`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin info`
--
ALTER TABLE `admin info`
  MODIFY `id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `student info`
--
ALTER TABLE `student info`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
