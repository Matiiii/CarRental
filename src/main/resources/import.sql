
-- Agency
<<<<<<< HEAD
INSERT INTO `jstk`.`agency`(`id`,`name`,`street`,`city`,`postal_code`,`hause_number`,`country`,`updated`,`created`,`version`)VALUES('1', 'Stadion', 'Bułgarska', 'Poznań', '60-635', '12', 'Poland',null,'2018-08-16 13:10:18','1');
INSERT INTO `jstk`.`agency`(`id`,`name`,`street`,`city`,`postal_code`,`hause_number`,`country`,`updated`,`created`,`version`)VALUES('2', 'Zoo', 'Kabanosa', 'Wrocław', '45-658', '115', 'Poland',null,'2018-08-16 13:10:18','1');

INSERT INTO `jstk`.`agency`(`id`,`city`,`country`,`hause_number`,`name`,`postal_code`,`street`,`updated`,`created`,`version`)VALUES('3', 'Poznań' ,'Poland','12','Bulgarska','60-655','Koronna',null,'2018-08-16 13:10:18','1');

-- Car






INSERT INTO `jstk`.`car`(`id`,`brand`,`color`,`created`,`engine_cap`,`mileage`,`power`,`type`,`updated`,`version`,`agency_id`)VALUES( '1', 'BMW', 'czerwony', '2018-08-16 13:10:18', '2.5', '37300', '180', 'sedan', NULL, '1', '1');
INSERT INTO `jstk`.`car`(`id`,`brand`,`color`,`created`,`engine_cap`,`mileage`,`power`,`type`,`updated`,`version`,`agency_id`)VALUES('2', 'BMW', 'czerwony', '2018-08-16 13:10:18', '2.5', '37300', '180', 'sedan', NULL, '1', '1');
INSERT INTO `jstk`.`car`(`id`,`brand`,`color`,`created`,`engine_cap`,`mileage`,`power`,`type`,`updated`,`version`,`agency_id`)VALUES('3', 'BMW', 'czerwony', '2018-08-16 13:10:18', '3.5', '21000', '250', 'sedan', NULL, '1', '1');
INSERT INTO `jstk`.`car`(`id`,`brand`,`color`,`created`,`engine_cap`,`mileage`,`power`,`type`,`updated`,`version`,`agency_id`)VALUES('4', 'Mercedes', 'zielony', '2018-08-16 13:10:18', '4', '60200', '300', 'sedan', NULL, '1', '2');
INSERT INTO `jstk`.`car`(`id`,`brand`,`color`,`created`,`engine_cap`,`mileage`,`power`,`type`,`updated`,`version`,`agency_id`)VALUES('5', 'Ford', 'Czarny', '2018-08-16 13:10:18', '2.5', '20034', '320', 'kombi', NULL, '1', '1');

-- Customer

INSERT INTO `jstk`.`customer`(`id`,`name`,`surname`,`birthday`,`phone`,`street`,`city`,`postal_code`,`hause_number`,`country`,`credit_card`,`email`,`updated`,`created`,`version`)VALUES('1', 'Marcin', 'Nowak', '1990-08-01', '998777888', 'ul. Dolna', 'Poznań', '60-655', '17', 'Poland', '321461231412323323', 'qelussypynni-1890@yopmail.com',null,'2018-08-16 13:10:18','1');
INSERT INTO `jstk`.`customer`(`id`,`name`,`surname`,`birthday`,`phone`,`street`,`city`,`postal_code`,`hause_number`,`country`,`credit_card`,`email`,`updated`,`created`,`version`)VALUES('2', 'Kajtek', 'Suchopiety', '1990-08-01 01:10:01', '997997997', 'ul. Pieczarkowa', 'Poznań', '60-645', '120', 'Poland', '32323232454545', 'orzeszek@gmail.com',null,'2018-08-16 13:10:18','1');
INSERT INTO `jstk`.`customer`(`id`,`name`,`surname`,`birthday`,`phone`,`street`,`city`,`postal_code`,`hause_number`,`country`,`credit_card`,`email`,`updated`,`created`,`version`)VALUES('3', 'Adam', 'Małysz', '1986-10-04 01:10:01', '997997997', 'ul. Małysza', 'Wisła', '60-645', '1', 'Poland', '32323232454545', 'pony@gmail.com',null,'2018-08-16 13:10:18','1');
INSERT INTO `jstk`.`customer`(`id`,`name`,`surname`,`birthday`,`phone`,`street`,`city`,`postal_code`,`hause_number`,`country`,`credit_card`,`email`,`updated`,`created`,`version`)VALUES('4', 'Wojciech', 'Man', '1986-10-04 01:10:01', '997997997', 'ul. Małysza', 'Wisła', '60-645', '1', 'Poland', '32323232454545', 'pony@gmail.com',null,'2018-08-16 13:10:18','1');
=======
INSERT INTO `jstk`.`agency`(`id`,`name`,`street`,`city`,`postal_code`,`hause_number`,`country`)VALUES('1', 'Stadion', 'Bułgarska', 'Poznań', '60-635', '12', 'Poland');
INSERT INTO `jstk`.`agency`(`id`,`name`,`street`,`city`,`postal_code`,`hause_number`,`country`)VALUES('2', 'Zoo', 'Kabanosa', 'Wrocław', '45-658', '115', 'Poland');

INSERT INTO `jstk`.`agency`(`id`,`city`,`country`,`created`,`hause_number`,`name`,`postal_code`,`street`,`updated`,`version`)VALUES('3', 'Poznań' ,'Poland','','12','Bulgarska','60-655','Koronna','','');

-- Car

INSERT INTO `jstk`.`car`(`id`,`type`,`brand`,`color`,`power`,`mileage`,`agency_id`,`engine_cap`)VALUES( '1', 'sedan', 'BMW', 'czarny', '180', '34000', '1', '2.5');
INSERT INTO `jstk`.`car`(`id`,`type`,`brand`,`color`,`power`,`mileage`,`agency_id`,`engine_cap`)VALUES('2', 'sedan', 'BMW', 'czerwony', '180', '37300', '1', '2.5');
INSERT INTO `jstk`.`car`(`id`,`type`,`brand`,`color`,`power`,`mileage`,`agency_id`,`engine_cap`)VALUES('3', 'sedan', 'BMW', 'czerwony', '250', '21000', '1', '3.5');
INSERT INTO `jstk`.`car`(`id`,`type`,`brand`,`color`,`power`,`mileage`,`agency_id`,`engine_cap`)VALUES('4', 'sedan', 'Mercedes', 'zielony', '300', '60200', '2', '4.0');

-- Customer

INSERT INTO `jstk`.`customer`(`id`,`name`,`surname`,`birthday`,`phone`,`street`,`city`,`postal_code`,`hause_number`,`country`,`credit_card`,`email`)VALUES('1', 'Marcin', 'Nowak', '1990-08-01', '998777888', 'ul. Dolna', 'Poznań', '60-655', '17', 'Poland', '321461231412323323', 'qelussypynni-1890@yopmail.com');
INSERT INTO `jstk`.`customer`(`id`,`name`,`surname`,`birthday`,`phone`,`street`,`city`,`postal_code`,`hause_number`,`country`,`credit_card`,`email`)VALUES('2', 'Kajtek', 'Suchopiety', '1990-08-01 01:10:01', '997997997', 'ul. Pieczarkowa', 'Poznań', '60-645', '120', 'Poland', '32323232454545', 'orzeszek@gmail.com');
INSERT INTO `jstk`.`customer`(`id`,`name`,`surname`,`birthday`,`phone`,`street`,`city`,`postal_code`,`hause_number`,`country`,`credit_card`,`email`)VALUES('3', 'Adam', 'Małysz', '1986-10-04 01:10:01', '997997997', 'ul. Małysza', 'Wisła', '60-645', '1', 'Poland', '32323232454545', 'pony@gmail.com');
INSERT INTO `jstk`.`customer`(`id`,`name`,`surname`,`birthday`,`phone`,`street`,`city`,`postal_code`,`hause_number`,`country`,`credit_card`,`email`)
>>>>>>> 1cf9227fac64f7c55c790189c3bc7517cfd9d7af


-- employee

<<<<<<< HEAD
INSERT INTO `jstk`.`employee`(`id`,`name`,`surname`,`position`,`phone`,`agency_id`,`pesel`,`updated`,`created`,`version`)VALUES('1', 'Mariusz', 'Pudzianowski', 'Kierownik', '6854367', '1', '67060958937',null,'2018-08-16 13:10:18','1');
INSERT INTO `jstk`.`employee`(`id`,`name`,`surname`,`position`,`phone`,`agency_id`,`pesel`,`updated`,`created`,`version`)VALUES('2', 'Marzena', 'Dekiel', 'Sprzedawca', '105225295', '1', '66011537946',null,'2018-08-16 13:10:18','1');
INSERT INTO `jstk`.`employee`(`id`,`name`,`surname`,`position`,`phone`,`agency_id`,`pesel`,`updated`,`created`,`version`)VALUES('3', 'Monika', 'Szczygieł', 'Sprzedawc', '682832852', '1', '72080438277',null,'2018-08-16 13:10:18','1');
INSERT INTO `jstk`.`employee`(`id`,`name`,`surname`,`position`,`phone`,`agency_id`,`pesel`,`updated`,`created`,`version`)VALUES('4', 'Tomasz', 'Dzik', 'Księgowy', '682832856', '1', '88021132359',null,'2018-08-16 13:10:18','1');
=======
INSERT INTO `jstk`.`employee`(`id`,`name`,`surname`,`position`,`phone`,`agency_id`,`pesel`)VALUES('1', 'Mariusz', 'Pudzianowski', 'Kierownik', '6854367', '1', '67060958937');
INSERT INTO `jstk`.`employee`(`id`,`name`,`surname`,`position`,`phone`,`agency_id`,`pesel`)VALUES('2', 'Marzena', 'Dekiel', 'Sprzedawca', '105225295', '1', '66011537946');
INSERT INTO `jstk`.`employee`(`id`,`name`,`surname`,`position`,`phone`,`agency_id`,`pesel`)VALUES('3', 'Monika', 'Szczygieł', 'Sprzedawc', '682832852', '1', '72080438277');
INSERT INTO `jstk`.`employee`(`id`,`name`,`surname`,`position`,`phone`,`agency_id`,`pesel`VALUES('4', 'Tomasz', 'Dzik', 'Księgowy', '682832856', '1', '88021132359');
>>>>>>> 1cf9227fac64f7c55c790189c3bc7517cfd9d7af


-- rent 

<<<<<<< HEAD
INSERT INTO `jstk`.`rent`(`id`,`rental_start`,`rental_stop`,`rental_agency_start_id`,`rental_agency_stop_id`,`cost`,`customer_id`,`car_id`,`created`,`version`)VALUES('1', '2018-01-01 12:00:00', '2018-02-01 12:00:00', '1', '2', '3000.00', '1', '2','2018-08-16 13:10:18', '1');
INSERT INTO `jstk`.`rent`(`id`,`rental_start`,`rental_stop`,`rental_agency_start_id`,`rental_agency_stop_id`,`cost`,`customer_id`,`car_id`,`created`,`version`)VALUES('2', '2018-01-02 12:00:00', '2018-01-03 12:00:00', '1', '1', '200.00', '2', '1','2018-08-16 13:10:18', '1');
INSERT INTO `jstk`.`rent`(`id`,`rental_start`,`rental_stop`,`rental_agency_start_id`,`rental_agency_stop_id`,`cost`,`customer_id`,`car_id`,`created`,`version`)VALUES('3', '2018-02-03 12:00:00', '2018-02-10 12:00:00', '1', '1', '1500.00', '2', '2','2018-08-16 13:10:18', '1');
INSERT INTO `jstk`.`rent`(`id`,`rental_start`,`rental_stop`,`rental_agency_start_id`,`rental_agency_stop_id`,`cost`,`customer_id`,`car_id`,`created`,`version`)VALUES('4', '2018-01-14 12:00:00', '2018-01-20 12:00:00', '2', '2', '700.00', '1', '1','2018-08-16 13:10:18', '1');
INSERT INTO `jstk`.`rent`(`id`,`rental_start`,`rental_stop`,`rental_agency_start_id`,`rental_agency_stop_id`,`cost`,`customer_id`,`car_id`,`created`,`version`)VALUES('5', '2018-01-27 12:00:00', '2018-02-24 12:00:00', '2', '2', '4000.00', '2', '2','2018-08-16 13:10:18', '1');
INSERT INTO `jstk`.`rent`(`id`,`rental_start`,`rental_stop`,`rental_agency_start_id`,`rental_agency_stop_id`,`cost`,`customer_id`,`car_id`,`created`,`version`)VALUES('6', '2017-12-24 12:00:00', '2017-12-27 12:00:00', '3', '3', '6699.00', '1', '1','2018-08-16 13:10:18', '1');
INSERT INTO `jstk`.`rent`(`id`,`rental_start`,`rental_stop`,`rental_agency_start_id`,`rental_agency_stop_id`,`cost`,`customer_id`,`car_id`,`created`,`version`)VALUES('7', '2017-10-22 12:00:00', '2017-10-30 12:00:00', '1', '2', '800.00', '2', '2','2018-08-16 13:10:18', '1');
INSERT INTO `jstk`.`rent`(`id`,`rental_start`,`rental_stop`,`rental_agency_start_id`,`rental_agency_stop_id`,`cost`,`customer_id`,`car_id`,`created`,`version`)VALUES('8', '2017-10-22 12:00:00', '2017-11-22 12:00:00', '3', '1', '6000.00', '3', '3','2018-08-16 13:10:18', '1');
INSERT INTO `jstk`.`rent`(`id`,`rental_start`,`rental_stop`,`rental_agency_start_id`,`rental_agency_stop_id`,`cost`,`customer_id`,`car_id`,`created`,`version`)VALUES('9', '2017-10-02 12:00:00', '2017-10-12 12:00:00', '2', '3', '3000.00', '2', '4','2018-08-16 13:10:18', '1');
INSERT INTO `jstk`.`rent`(`id`,`rental_start`,`rental_stop`,`rental_agency_start_id`,`rental_agency_stop_id`,`cost`,`customer_id`,`car_id`,`created`,`version`)VALUES('10', '2017-12-02 12:00:00', '2017-12-22 12:00:00', '3', '1', '30.00', '3', '2','2018-08-16 13:10:18', '1');
=======
INSERT INTO `jstk`.`rent`(`id`,`rental_start`,`rental_stop`,`rental_agency_start_id`,`rental_agency_stop_id`,`cost`,`customer_id`,`car_id`)VALUES('1', '2018-01-01 12:00:00', '2018-02-01 12:00:00', '1', '2', '3000.00', '1', '2');
INSERT INTO `jstk`.`rent`(`id`,`rental_start`,`rental_stop`,`rental_agency_start_id`,`rental_agency_stop_id`,`cost`,`customer_id`,`car_id`)VALUES('2', '2018-01-02 12:00:00', '2018-01-03 12:00:00', '1', '1', '200.00', '2', '1');
INSERT INTO `jstk`.`rent`(`id`,`rental_start`,`rental_stop`,`rental_agency_start_id`,`rental_agency_stop_id`,`cost`,`customer_id`,`car_id`)VALUES('3', '2018-02-03 12:00:00', '2018-02-10 12:00:00', '1', '1', '1500.00', '3', '3');
INSERT INTO `jstk`.`rent`(`id`,`rental_start`,`rental_stop`,`rental_agency_start_id`,`rental_agency_stop_id`,`cost`,`customer_id`,`car_id`)VALUES('4', '2018-01-14 12:00:00', '2018-01-20 12:00:00', '2', '2', '700.00', '4', '4');
INSERT INTO `jstk`.`rent`(`id`,`rental_start`,`rental_stop`,`rental_agency_start_id`,`rental_agency_stop_id`,`cost`,`customer_id`,`car_id`)VALUES('5', '2018-01-27 12:00:00', '2018-02-24 12:00:00', '2', '4', '4000.00', '5', '5');
INSERT INTO `jstk`.`rent`(`id`,`rental_start`,`rental_stop`,`rental_agency_start_id`,`rental_agency_stop_id`,`cost`,`customer_id`,`car_id`)VALUES('6', '2017-12-24 12:00:00', '2017-12-27 12:00:00', '3', '3', '6699.00', '1', '1');
INSERT INTO `jstk`.`rent`(`id`,`rental_start`,`rental_stop`,`rental_agency_start_id`,`rental_agency_stop_id`,`cost`,`customer_id`,`car_id`)VALUES('7', '2017-10-22 12:00:00', '2017-10-30 12:00:00', '4', '4', '800.00', '2', '2');
INSERT INTO `jstk`.`rent`(`id`,`rental_start`,`rental_stop`,`rental_agency_start_id`,`rental_agency_stop_id`,`cost`,`customer_id`,`car_id`)VALUES('8', '2017-10-22 12:00:00', '2017-11-22 12:00:00', '5', '5', '6000.00', '8', '12');
INSERT INTO `jstk`.`rent`(`id`,`rental_start`,`rental_stop`,`rental_agency_start_id`,`rental_agency_stop_id`,`cost`,`customer_id`,`car_id`)VALUES('9', '2017-10-02 12:00:00', '2017-10-12 12:00:00', '4', '4', '3000.00', '7', '9');
INSERT INTO `jstk`.`rent`(`id`,`rental_start`,`rental_stop`,`rental_agency_start_id`,`rental_agency_stop_id`,`cost`,`customer_id`,`car_id`)VALUES('10', '2017-12-02 12:00:00', '2017-12-22 12:00:00', '5', '2', '30.00', '3', '8');
>>>>>>> 1cf9227fac64f7c55c790189c3bc7517cfd9d7af


-- car_employee

INSERT INTO `jstk`.`car_employee`(`car_id`,`employee_id`)VALUES('1', '2');
INSERT INTO `jstk`.`car_employee`(`car_id`,`employee_id`)VALUES('1', '3');
<<<<<<< HEAD
INSERT INTO `jstk`.`car_employee`(`car_id`,`employee_id`)VALUES('1', '1');
INSERT INTO `jstk`.`car_employee`(`car_id`,`employee_id`)VALUES('2', '2');
INSERT INTO `jstk`.`car_employee`(`car_id`,`employee_id`)VALUES('3', '1');
=======
INSERT INTO `jstk`.`car_employee`(`car_id`,`employee_id`)VALUES('1', '6');
INSERT INTO `jstk`.`car_employee`(`car_id`,`employee_id`)VALUES('2', '6');
INSERT INTO `jstk`.`car_employee`(`car_id`,`employee_id`)VALUES('2', '4');
>>>>>>> 1cf9227fac64f7c55c790189c3bc7517cfd9d7af




