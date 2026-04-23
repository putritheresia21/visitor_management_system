-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 23 Apr 2026 pada 14.17
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `visitor_db`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `areas_visits`
--

CREATE TABLE `areas_visits` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `area_name` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data untuk tabel `areas_visits`
--

INSERT INTO `areas_visits` (`id`, `area_name`, `created_at`, `updated_at`) VALUES
(1, 'Lobby', '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(2, 'Meeting Room', '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(3, 'Office', '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(4, 'Cafeteria', '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(5, 'Parking Lot', '2026-04-23 00:50:07', '2026-04-23 00:50:07');

-- --------------------------------------------------------

--
-- Struktur dari tabel `departements`
--

CREATE TABLE `departements` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `departement_name` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data untuk tabel `departements`
--

INSERT INTO `departements` (`id`, `departement_name`, `created_at`, `updated_at`) VALUES
(1, 'IT', '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(2, 'HRD', '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(3, 'Finance', '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(4, 'Marketing', '2026-04-23 00:50:07', '2026-04-23 00:50:07');

-- --------------------------------------------------------

--
-- Struktur dari tabel `employees`
--

CREATE TABLE `employees` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `number_employee` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `departement_id` bigint(20) UNSIGNED NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data untuk tabel `employees`
--

INSERT INTO `employees` (`id`, `name`, `number_employee`, `phone`, `departement_id`, `created_at`, `updated_at`) VALUES
(1, 'Peter Parker', 'EMP001', '081234567890', 1, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(2, 'Steve Rogers', 'EMP002', '081234567891', 2, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(3, 'Tony Stark', 'EMP003', '081234567892', 3, '2026-04-23 00:50:07', '2026-04-23 00:50:07');

-- --------------------------------------------------------

--
-- Struktur dari tabel `identity_types`
--

CREATE TABLE `identity_types` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `identity_type` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data untuk tabel `identity_types`
--

INSERT INTO `identity_types` (`id`, `identity_type`, `created_at`, `updated_at`) VALUES
(1, 'KTP', '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(2, 'SIM', '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(3, 'Passport', '2026-04-23 00:50:07', '2026-04-23 00:50:07');

-- --------------------------------------------------------

--
-- Struktur dari tabel `migrations`
--

CREATE TABLE `migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `migration` varchar(255) NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data untuk tabel `migrations`
--

INSERT INTO `migrations` (`id`, `migration`, `batch`) VALUES
(1, '2019_12_14_000001_create_personal_access_tokens_table', 1),
(2, '2026_04_19_052057_create_departements_table', 1),
(3, '2026_04_19_054458_create_employees_table', 1),
(4, '2026_04_19_054955_create_areas_visits_table', 1),
(5, '2026_04_19_061952_create_identity_types_table', 1),
(6, '2026_04_19_062129_create_nationalities_table', 1),
(7, '2026_04_19_062219_create_visitors_table', 1),
(8, '2026_04_19_062603_create_visits_table', 1),
(9, '2026_04_23_114911_create_users_table', 2);

-- --------------------------------------------------------

--
-- Struktur dari tabel `nationalities`
--

CREATE TABLE `nationalities` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data untuk tabel `nationalities`
--

INSERT INTO `nationalities` (`id`, `name`, `created_at`, `updated_at`) VALUES
(1, 'Indonesian', '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(2, 'American', '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(3, 'Chinese', '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(4, 'Japanese', '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(5, 'Other', '2026-04-23 00:50:07', '2026-04-23 00:50:07');

-- --------------------------------------------------------

--
-- Struktur dari tabel `personal_access_tokens`
--

CREATE TABLE `personal_access_tokens` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `tokenable_type` varchar(255) NOT NULL,
  `tokenable_id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `token` varchar(64) NOT NULL,
  `abilities` text DEFAULT NULL,
  `last_used_at` timestamp NULL DEFAULT NULL,
  `expires_at` timestamp NULL DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE `users` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data untuk tabel `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`, `created_at`, `updated_at`) VALUES
(1, 'Admin', 'admin@gmail.com', '$2y$10$RQb45/5u0/4mViIhX9E72OgBXuX/PGk6CxEEGiwxter.3zfmydRm.', '2026-04-23 04:50:07', '2026-04-23 04:50:07');

-- --------------------------------------------------------

--
-- Struktur dari tabel `visitors`
--

CREATE TABLE `visitors` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `identity_number` varchar(255) NOT NULL,
  `identity_type_id` bigint(20) UNSIGNED NOT NULL,
  `nationality_id` bigint(20) UNSIGNED NOT NULL,
  `company` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data untuk tabel `visitors`
--

INSERT INTO `visitors` (`id`, `name`, `phone`, `email`, `identity_number`, `identity_type_id`, `nationality_id`, `company`, `photo`, `created_at`, `updated_at`) VALUES
(1, 'John Smith', '081234567890', 'john@starkindustries.com', '1234567890', 1, 1, 'Stark Industries', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(2, 'Jane Jansen', '081234567891', 'jane@wayneindustries.com', '0987654321', 2, 1, 'Wayne Industries', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(3, 'Bruce Wayne', '081234567892', 'bruce@wayneindustries.com', '1122334455', 2, 2, 'Wayne Industries', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(4, 'Charlie Brown', '081234567891', 'charlie@gmail.com', 'AB0987654321', 3, 1, 'Peanuts', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(5, 'Lucy van Pelt', '081234567890', 'lucy@gmail.com', 'AB1234567890', 3, 1, 'Peanuts', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(6, 'Fiona Blue', '081234567891', 'fiona@gmail.com', '098765432123', 1, 1, 'Cyburg', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(7, 'Gina Green', '081234567892', 'gina@gmail.com', '1122334454235', 2, 1, 'Cyburg', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(8, 'Harry Potter', '081234567890', 'harry@gmail.com', '091234567890', 3, 1, 'Hogwarts', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(9, 'Hermione Granger', '081234567891', 'hermione@gmail.com', '091234567891', 3, 1, 'Hogwarts', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(10, 'Ron Weasley', '081234567892', 'ron@gmail.com', '091234567892', 3, 1, 'Hogwarts', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(11, 'Albus Dumbledore', '081234567893', 'dumbledore@gmail.com', '091234567893', 3, 1, 'Hogwarts', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(12, 'Alda Hickle', '08+1-951-380-2003', 'shannon.jones@example.com', '0707145464', 3, 3, 'PT. DEF', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(13, 'Prof. Imelda Pfeffer Sr.', '08(817) 513-6722', 'gottlieb.elwyn@example.com', '8427170854', 2, 3, 'PT. DEF', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(14, 'Katelyn Jerde', '081-737-579-6616', 'kshlerin.irving@example.org', '4146895650', 3, 2, 'PT. XYZ', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(15, 'Mr. Jaylin Raynor', '08240.950.8041', 'aleuschke@example.org', '8309047804', 2, 3, 'PT. XYZ', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(16, 'Jeffry Becker', '081-478-557-4902', 'broderick.stroman@example.com', '0532259736', 2, 1, 'PT. ABC', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(17, 'Raoul Kris', '08+1-505-492-8985', 'orie90@example.org', '9847280230', 2, 1, 'PT. DEF', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(18, 'Mrs. Eleanore Heller', '08+14345330134', 'ilangosh@example.com', '9394228904', 2, 1, 'PT. DEF', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(19, 'Braxton Bergnaum', '08616.781.8724', 'carroll.garland@example.net', '4546776806', 3, 3, 'PT. ABC', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(20, 'Prof. Jaime Mertz', '08+1-507-245-5550', 'ybreitenberg@example.net', '3564065133', 3, 3, 'PT. ABC', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(21, 'Prof. Gianni Bradtke', '08435-424-5285', 'toni84@example.com', '8759271612', 1, 1, 'PT. XYZ', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(22, 'Russell Grant', '08+1-434-494-1064', 'lorine.hermiston@example.org', '2191371005', 1, 3, 'PT. GHI', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(23, 'Kariane Hansen', '08585-573-4415', 'erdman.shakira@example.org', '2850121347', 1, 3, 'PT. ABC', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(24, 'Mr. Lamont Schmeler Sr.', '081-331-920-2424', 'kling.astrid@example.net', '9002138305', 3, 3, 'PT. XYZ', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(25, 'Mrs. Emma Jones PhD', '08(509) 848-9488', 'jevon.collier@example.org', '5573954000', 3, 1, 'PT. DEF', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(26, 'Santa Connelly', '08+1 (551) 510-6531', 'zraynor@example.net', '0944578418', 3, 3, 'PT. XYZ', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(27, 'Lina Schneider', '08380-234-2597', 'pleffler@example.org', '9550681999', 1, 2, 'PT. XYZ', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(28, 'Roberta Mante', '08+1.501.557.6052', 'lkessler@example.org', '3968835267', 3, 1, 'PT. DEF', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(29, 'Prof. Lucious Cole', '081-848-241-2138', 'ola.beahan@example.net', '5143398377', 2, 1, 'PT. GHI', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(30, 'Dr. Elvis McGlynn', '08(904) 883-0220', 'ystokes@example.com', '9647942241', 1, 1, 'PT. XYZ', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(31, 'Marietta Bashirian', '08252.819.3270', 'wschamberger@example.net', '7838109097', 1, 3, 'PT. XYZ', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(32, 'Marianna Lesch', '081-628-267-7207', 'mraz.jedidiah@example.org', '9740604184', 2, 3, 'PT. GHI', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(33, 'Erich Feeney', '08+1.440.676.6308', 'nelle82@example.org', '6475062520', 1, 2, 'PT. GHI', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(34, 'Garfield Kulas', '08(531) 627-4480', 'twehner@example.net', '9914870218', 2, 1, 'PT. XYZ', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(35, 'Ardella Herman', '081-260-761-0888', 'cmraz@example.net', '0959090010', 3, 2, 'PT. XYZ', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(36, 'Mr. Aurelio Trantow PhD', '08+1-872-537-0452', 'altenwerth.floy@example.net', '3524926465', 1, 1, 'PT. DEF', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(37, 'Prof. Diego Jast', '08341-410-8136', 'vena17@example.net', '5761001067', 1, 2, 'PT. GHI', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(38, 'Ozella Rohan', '08985-233-3851', 'araceli.nader@example.org', '1371791706', 3, 2, 'PT. ABC', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(39, 'Ebba Boyle IV', '08(602) 654-9820', 'celestine.mertz@example.org', '9284866089', 3, 2, 'PT. XYZ', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(40, 'Katelyn VonRueden', '08(346) 628-8661', 'dolly.kling@example.org', '1009989003', 1, 2, 'PT. ABC', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(41, 'Elton Gerhold', '08+1.380.242.5996', 'vkautzer@example.com', '4305102661', 1, 3, 'PT. GHI', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(42, 'Cristian Jacobs', '08+1 (678) 885-0779', 'rosa26@example.net', '2020348554', 3, 2, 'PT. XYZ', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(43, 'Lilliana Rowe', '08+1.563.814.9361', 'tcorkery@example.com', '0161624453', 2, 1, 'PT. XYZ', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(44, 'Katelynn Gorczany I', '08+1 (804) 369-6596', 'kimberly05@example.net', '9503719052', 1, 1, 'PT. XYZ', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(45, 'Roberto Schamberger', '08603-766-4791', 'dangelo54@example.net', '2269417174', 2, 2, 'PT. XYZ', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(46, 'Mr. Lukas Jacobs', '08+1.757.943.8657', 'gerda19@example.net', '2530224847', 3, 1, 'PT. XYZ', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(47, 'Devyn Green', '08(910) 749-6983', 'emard.esmeralda@example.net', '1300413369', 1, 2, 'PT. DEF', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(48, 'Celia Streich PhD', '08432.859.1582', 'dhomenick@example.com', '9059024771', 1, 3, 'PT. ABC', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(49, 'Royal Rutherford', '08+15749292432', 'sonya.kreiger@example.com', '0428538334', 2, 2, 'PT. GHI', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(50, 'Glenda Deckow', '08463.682.3566', 'tromaguera@example.net', '6555133854', 1, 2, 'PT. XYZ', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(51, 'Leonard Toy', '08+1.770.797.6844', 'ivy.predovic@example.com', '0968189882', 3, 1, 'PT. DEF', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(52, 'Gretchen Hartmann', '08850.631.6654', 'hailie48@example.com', '0590301317', 3, 2, 'PT. XYZ', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(53, 'Dr. Pasquale Langosh DDS', '08352.822.2101', 'alta.hand@example.org', '2605922039', 2, 1, 'PT. XYZ', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(54, 'Miss Leola Schoen IV', '08+1.205.718.2181', 'daugherty.bernice@example.org', '0878938834', 1, 2, 'PT. DEF', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(55, 'Lilliana Quitzon', '08+1-985-285-3255', 'collins.abigale@example.org', '1877691899', 3, 2, 'PT. ABC', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(56, 'Anahi Reynolds', '08+1-202-360-4406', 'madilyn86@example.com', '0880849104', 1, 2, 'PT. GHI', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(57, 'Jefferey Sanford', '08(248) 791-4052', 'armstrong.claudia@example.org', '3810163057', 2, 2, 'PT. DEF', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(58, 'Fermin Hermiston', '08858-236-2017', 'marc.ruecker@example.com', '0814839857', 3, 3, 'PT. GHI', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(59, 'Ms. Nannie Barton MD', '08+1-951-473-6966', 'carley11@example.com', '3349249583', 1, 1, 'PT. DEF', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(60, 'Lorenz Abshire', '08+1 (863) 374-5837', 'amy.ritchie@example.net', '1131108523', 3, 1, 'PT. DEF', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07'),
(61, 'Margie Emard', '08+1.757.542.9677', 'michel.sawayn@example.org', '6604858770', 2, 2, 'PT. XYZ', NULL, '2026-04-23 00:50:07', '2026-04-23 00:50:07');

-- --------------------------------------------------------

--
-- Struktur dari tabel `visits`
--

CREATE TABLE `visits` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `purpose` varchar(255) NOT NULL,
  `visitor_id` bigint(20) UNSIGNED NOT NULL,
  `employee_id` bigint(20) UNSIGNED NOT NULL,
  `departement_id` bigint(20) UNSIGNED NOT NULL,
  `area_visit_id` bigint(20) UNSIGNED NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data untuk tabel `visits`
--

INSERT INTO `visits` (`id`, `purpose`, `visitor_id`, `employee_id`, `departement_id`, `area_visit_id`, `created_at`, `updated_at`) VALUES
(1, 'Discussion', 17, 2, 3, 1, '2026-04-21 15:45:24', '2026-04-21 15:45:24'),
(2, 'Meeting', 20, 2, 1, 2, '2026-04-18 14:10:04', '2026-04-18 14:10:04'),
(3, 'Meeting', 37, 1, 1, 2, '2026-04-07 12:59:58', '2026-04-07 12:59:58'),
(4, 'Conference', 14, 3, 1, 1, '2026-03-30 20:48:02', '2026-03-30 20:48:02'),
(5, 'Discussion', 39, 1, 1, 1, '2026-04-09 08:05:20', '2026-04-09 08:05:20'),
(6, 'Conference', 1, 3, 3, 1, '2026-04-11 19:20:36', '2026-04-11 19:20:36'),
(7, 'Presentation', 3, 3, 2, 2, '2026-04-01 12:49:17', '2026-04-01 12:49:17'),
(8, 'Conference', 14, 2, 1, 1, '2026-04-01 20:41:49', '2026-04-01 20:41:49'),
(9, 'Presentation', 14, 2, 1, 1, '2026-03-27 08:32:49', '2026-03-27 08:32:49'),
(10, 'Meeting', 40, 1, 1, 1, '2026-04-22 07:28:02', '2026-04-22 07:28:02'),
(11, 'Presentation', 8, 2, 3, 1, '2026-03-23 19:57:32', '2026-03-23 19:57:32'),
(12, 'Discussion', 50, 1, 3, 1, '2026-04-05 03:51:34', '2026-04-05 03:51:34'),
(13, 'Presentation', 50, 3, 2, 2, '2026-03-25 08:21:02', '2026-03-25 08:21:02'),
(14, 'Presentation', 21, 1, 2, 2, '2026-03-31 14:14:54', '2026-03-31 14:14:54'),
(15, 'Presentation', 45, 3, 3, 2, '2026-03-24 14:47:32', '2026-03-24 14:47:32'),
(16, 'Conference', 28, 1, 2, 2, '2026-03-30 11:59:44', '2026-03-30 11:59:44'),
(17, 'Meeting', 12, 3, 3, 2, '2026-04-12 15:11:24', '2026-04-12 15:11:24'),
(18, 'Conference', 28, 1, 3, 1, '2026-04-05 18:58:42', '2026-04-05 18:58:42'),
(19, 'Conference', 34, 1, 3, 1, '2026-04-18 13:42:40', '2026-04-18 13:42:40'),
(20, 'Conference', 2, 2, 1, 2, '2026-04-13 22:54:41', '2026-04-13 22:54:41'),
(21, 'Presentation', 31, 1, 3, 1, '2026-03-24 19:33:15', '2026-03-24 19:33:15'),
(22, 'Interview', 40, 2, 3, 1, '2026-03-29 03:05:51', '2026-03-29 03:05:51'),
(23, 'Presentation', 16, 1, 2, 2, '2026-03-24 06:00:56', '2026-03-24 06:00:56'),
(24, 'Presentation', 2, 2, 3, 2, '2026-04-12 06:56:04', '2026-04-12 06:56:04'),
(25, 'Discussion', 42, 1, 1, 1, '2026-04-10 12:08:34', '2026-04-10 12:08:34'),
(26, 'Conference', 45, 3, 3, 1, '2026-04-05 22:00:04', '2026-04-05 22:00:04'),
(27, 'Interview', 49, 3, 1, 2, '2026-03-28 12:59:18', '2026-03-28 12:59:18'),
(28, 'Interview', 3, 3, 1, 1, '2026-03-24 13:02:28', '2026-03-24 13:02:28'),
(29, 'Meeting', 3, 1, 2, 1, '2026-04-12 21:44:24', '2026-04-12 21:44:24'),
(30, 'Conference', 22, 1, 3, 2, '2026-04-01 13:06:31', '2026-04-01 13:06:31'),
(31, 'Meeting', 34, 2, 3, 1, '2026-04-21 18:28:01', '2026-04-21 18:28:01'),
(32, 'Meeting', 33, 2, 3, 2, '2026-04-21 01:35:03', '2026-04-21 01:35:03'),
(33, 'Presentation', 20, 3, 1, 2, '2026-04-22 12:31:32', '2026-04-22 12:31:32'),
(34, 'Interview', 33, 2, 3, 2, '2026-04-19 06:17:58', '2026-04-19 06:17:58'),
(35, 'Discussion', 10, 3, 2, 2, '2026-04-16 21:11:59', '2026-04-16 21:11:59'),
(36, 'Conference', 37, 1, 1, 1, '2026-04-19 09:04:19', '2026-04-19 09:04:19'),
(37, 'Meeting', 31, 2, 2, 2, '2026-04-22 11:38:12', '2026-04-22 11:38:12'),
(38, 'Interview', 36, 3, 1, 1, '2026-04-21 19:32:44', '2026-04-21 19:32:44'),
(39, 'Interview', 41, 2, 3, 1, '2026-04-17 20:30:02', '2026-04-17 20:30:02'),
(40, 'Discussion', 16, 3, 1, 1, '2026-04-21 17:51:43', '2026-04-21 17:51:43'),
(41, 'Interview', 39, 2, 1, 2, '2026-04-19 03:12:25', '2026-04-19 03:12:25'),
(42, 'Discussion', 6, 2, 1, 1, '2026-04-19 21:36:29', '2026-04-19 21:36:29'),
(43, 'Presentation', 9, 1, 3, 2, '2026-04-20 14:32:13', '2026-04-20 14:32:13'),
(44, 'Conference', 13, 3, 1, 1, '2026-04-18 17:19:10', '2026-04-18 17:19:10'),
(45, 'Interview', 35, 2, 3, 2, '2026-04-17 10:07:18', '2026-04-17 10:07:18'),
(46, 'Conference', 34, 3, 1, 1, '2026-04-20 00:47:55', '2026-04-20 00:47:55'),
(47, 'Discussion', 26, 1, 1, 1, '2026-04-19 17:33:38', '2026-04-19 17:33:38'),
(48, 'Interview', 28, 1, 1, 2, '2026-04-20 18:29:17', '2026-04-20 18:29:17'),
(49, 'Presentation', 38, 1, 1, 2, '2026-04-21 17:16:58', '2026-04-21 17:16:58'),
(50, 'Meeting', 31, 3, 1, 1, '2026-04-16 22:10:24', '2026-04-16 22:10:24'),
(51, 'Meeting', 10, 3, 2, 1, '2026-04-21 04:04:02', '2026-04-21 04:04:02'),
(52, 'Interview', 21, 3, 1, 1, '2026-04-20 16:39:42', '2026-04-20 16:39:42'),
(53, 'Presentation', 17, 1, 1, 1, '2026-04-21 08:45:40', '2026-04-21 08:45:40'),
(54, 'Meeting', 20, 3, 2, 2, '2026-04-20 13:54:28', '2026-04-20 13:54:28'),
(55, 'Discussion', 27, 1, 2, 1, '2026-04-20 08:24:30', '2026-04-20 08:24:30'),
(56, 'Conference', 18, 1, 2, 1, '2026-04-22 09:51:41', '2026-04-22 09:51:41'),
(57, 'Meeting', 49, 3, 2, 2, '2026-04-21 08:43:51', '2026-04-21 08:43:51'),
(58, 'Interview', 30, 1, 3, 2, '2026-04-22 23:10:28', '2026-04-22 23:10:28'),
(59, 'Interview', 22, 3, 2, 1, '2026-04-21 15:52:28', '2026-04-21 15:52:28'),
(60, 'Presentation', 8, 1, 3, 1, '2026-04-22 01:29:26', '2026-04-22 01:29:26'),
(61, 'Discussion', 14, 2, 1, 2, '2026-04-22 10:37:43', '2026-04-22 10:37:43'),
(62, 'Interview', 32, 3, 3, 1, '2026-04-23 00:47:25', '2026-04-23 00:47:25'),
(63, 'Meeting', 7, 3, 2, 1, '2026-04-22 16:55:41', '2026-04-22 16:55:41'),
(64, 'Interview', 17, 2, 3, 1, '2026-04-22 20:26:05', '2026-04-22 20:26:05'),
(65, 'Meeting', 44, 1, 2, 1, '2026-04-22 19:43:09', '2026-04-22 19:43:09');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `areas_visits`
--
ALTER TABLE `areas_visits`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `departements`
--
ALTER TABLE `departements`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `employees_number_employee_unique` (`number_employee`),
  ADD KEY `employees_departement_id_foreign` (`departement_id`);

--
-- Indeks untuk tabel `identity_types`
--
ALTER TABLE `identity_types`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `identity_types_identity_type_unique` (`identity_type`);

--
-- Indeks untuk tabel `migrations`
--
ALTER TABLE `migrations`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `nationalities`
--
ALTER TABLE `nationalities`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nationalities_name_unique` (`name`);

--
-- Indeks untuk tabel `personal_access_tokens`
--
ALTER TABLE `personal_access_tokens`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `personal_access_tokens_token_unique` (`token`),
  ADD KEY `personal_access_tokens_tokenable_type_tokenable_id_index` (`tokenable_type`,`tokenable_id`);

--
-- Indeks untuk tabel `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `users_email_unique` (`email`);

--
-- Indeks untuk tabel `visitors`
--
ALTER TABLE `visitors`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `visitors_identity_number_unique` (`identity_number`),
  ADD KEY `visitors_identity_type_id_foreign` (`identity_type_id`),
  ADD KEY `visitors_nationality_id_foreign` (`nationality_id`);

--
-- Indeks untuk tabel `visits`
--
ALTER TABLE `visits`
  ADD PRIMARY KEY (`id`),
  ADD KEY `visits_visitor_id_foreign` (`visitor_id`),
  ADD KEY `visits_employee_id_foreign` (`employee_id`),
  ADD KEY `visits_departement_id_foreign` (`departement_id`),
  ADD KEY `visits_area_visit_id_foreign` (`area_visit_id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `areas_visits`
--
ALTER TABLE `areas_visits`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `departements`
--
ALTER TABLE `departements`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `employees`
--
ALTER TABLE `employees`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `identity_types`
--
ALTER TABLE `identity_types`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT untuk tabel `nationalities`
--
ALTER TABLE `nationalities`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `personal_access_tokens`
--
ALTER TABLE `personal_access_tokens`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `visitors`
--
ALTER TABLE `visitors`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=62;

--
-- AUTO_INCREMENT untuk tabel `visits`
--
ALTER TABLE `visits`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=66;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `employees`
--
ALTER TABLE `employees`
  ADD CONSTRAINT `employees_departement_id_foreign` FOREIGN KEY (`departement_id`) REFERENCES `departements` (`id`);

--
-- Ketidakleluasaan untuk tabel `visitors`
--
ALTER TABLE `visitors`
  ADD CONSTRAINT `visitors_identity_type_id_foreign` FOREIGN KEY (`identity_type_id`) REFERENCES `identity_types` (`id`),
  ADD CONSTRAINT `visitors_nationality_id_foreign` FOREIGN KEY (`nationality_id`) REFERENCES `nationalities` (`id`);

--
-- Ketidakleluasaan untuk tabel `visits`
--
ALTER TABLE `visits`
  ADD CONSTRAINT `visits_area_visit_id_foreign` FOREIGN KEY (`area_visit_id`) REFERENCES `areas_visits` (`id`),
  ADD CONSTRAINT `visits_departement_id_foreign` FOREIGN KEY (`departement_id`) REFERENCES `departements` (`id`),
  ADD CONSTRAINT `visits_employee_id_foreign` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`),
  ADD CONSTRAINT `visits_visitor_id_foreign` FOREIGN KEY (`visitor_id`) REFERENCES `visitors` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
