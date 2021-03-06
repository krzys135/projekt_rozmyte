CREATE TABLE IF NOT EXISTS `tabela` (
  `Nazwa` varchar(42) DEFAULT NULL,
  `Pojemnosc_bagaznika` int(2) DEFAULT NULL,
  `Spalanie` decimal(3,1) DEFAULT NULL,
  `Ilosc_drzwi` int(3) DEFAULT NULL,
  `Cena` int(3) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

INSERT INTO `tabela` (`Nazwa`, `Pojemnosc_bagaznika`, `Spalanie`, `Ilosc_drzwi`, `Cena`) VALUES

('Mercedes E-Class',532,9.1,4,140624),
('Peugeot 208',285,5.8,3,46713),
('Volvo S80',480,11.8,4,79485),
('Mercedes SLK',225,7.1,2,60374),
('Nissan Micra',265,4.1,5,36101),
('Fiat Bravo',400,5.3,5,33708),
('Renault Laguna',450,7.6,5,39905),
('BMW 535i ',520,8.1,4,162634),
('Mercedes C-Class',475,9.4,4,90823),
('Ford Ka',224,5.3,3,21702),
('Ford Fiesta',295,5.8,5,36942),
('Mercedes A-Class',341,6.2,5,50187),
('Audi A1',270,5.9,3,50486),
('BMW 335i',480,7.9,4,151419),
('Nissan Patrol',303,11.8,5,45932),
('Ford Focus',363,5.9,5,44161),
('Ford Kuga',360,5,10.3,73810),
('Mitsubishi Colt',155,5.6,3,33112),
('Skoda Fabia',300,6.9,5,28075),
('Renault Clio',300,6.3,5,42502),
('Toyota Yaris',272,5.3,3,47000),
('Peugeot 107',139,4.6,3,17800),
('Seat Ibiza',284,6.2,3,52072),
('Volvo S40',404,8.5,4,46601),
('Land Rover Freelander',755,11.2,5,182000),
('Honda Jazz',335,5.4,5,60900),
('BMW Z4',180,9.4,2,170463),
('Citroen C1',130,4.6,3,33900),
('Ford Mondeo',486,6.4,5,43053),
('Citroen C3',300,5.9,5,32035),
('Subaru Forester',505,8.5,5,131200),
('Fiat Panda',225,5.2,5,31256),
('Land Rover Discovery',280,14.1,5,349470),
('Audi A3',380,5.8,5,118770),
('Hyundai Getz',254,5.5,3,22614),
('Mercedes CLK Cabrio',276,14.4,2,55705),
('BMW 740i',500,10,4,270234),
('Seat Altea',490,8.4,5,75990),
('Skoda Octavia',590,6.1,5,65981),
('Alfa Romeo Giulietta',350,5.2,5,76690),
('Fiat Sedici',270,6.5,5,40434),
('Mercedes CLK Coupe',435,12,2,58934),
('Mercedes SL-Class',364,7.5,2,337000),
('Volvo S60',380,7.9,4,103087),
('Hyundai Accent',390,6.4,4,52721),
('Nissan X-trail',603,9.6,5,91985),
('Mercedes S-Class',530,9.1,4,354445),
('Seat Leon',341,5.7,3,60536),
('Peugeot 807',830,5.9,5,23564),
('Subaru Impreza',301,10.5,5,124800),
('Ford C-Max',471,6.6,5,59783),
('Nissan Juke',251,6.9,5,56283),
('Toyota Avensis',509,6.9,4,105900),
('Mercedes CL 91-99',490,14.3,2,452743),
('Porsche Boxster',130,8.8,2,132000),
('Ford Galaxy',435,7.2,5,51209),
('Seat Toledo',550,5.8,5,39900),
('Fiat 500',185,6.5,3,38175),
('BMW 125i',360,6.6,3,98689),
('Opel Zafira',710,7.2,5,128300),
('Opel Astra',380,6.1,5,91000),
('Opel Corsa',285,5.5,3,48900),
('Opel Insignia',540,8.5,5,128797),
('Renault Kangoo',2650,8.6,3,29264),
('Alfa Romeo MiTo',270,5.6,3,31625),
('Ford B-Max',326,6.4,5,59000),
('Land Rover Range Rover',994,14.9,5,305000),
('Mazda 6',483,6,4,118000),
('Mazda CX-7',455,8.4,5,142000),
('Mercedes M-Class',690,6.5,5,261595),
('Audi A4',480,6.4,4,67515),
('Honda Civic',477,6.3,5,86400),
('Skoda Rapid',550,5.8,5,61350),
('Skoda Yeti',405,8,5,66479),
('Peugeot 308',420,5.8,5,37701),
('Volvo XC60',490,10.7,5,114604),
('Audi A6',530,7.7,4,162483),
('Volvo XC70',575,7,5,77984),
('Audi A8',510,9.4,4,261388),
('Volvo XC90',249,13.5,5,62271);