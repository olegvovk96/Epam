USE storedpr_db;
SET SQL_SAFE_UPDATES = 0;

#ТРИГЕРИ

#1. Забезпечити цілісність значень для структури БД.

DROP TRIGGER check_table_employee_insert;
DELIMITER //
CREATE TRIGGER check_table_employee_insert
BEFORE INSERT
ON employee FOR EACH ROW
BEGIN
  IF NOT EXISTS (SELECT * FROM pharmacy ph WHERE ph.id = NEW.pharmacy_id)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "INSERT INTO заборонено";
  END IF;
  IF NOT EXISTS (SELECT * FROM post p WHERE p.post = NEW.post)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "INSERT INTO заборонено";
 END IF;
END //
DELIMITER ;



DROP TRIGGER check_table_employee_update;
DELIMITER //
CREATE TRIGGER check_table_employee_update
BEFORE UPDATE
ON employee FOR EACH ROW
BEGIN
  IF NOT EXISTS (SELECT * FROM pharmacy ph WHERE ph.id = NEW.pharmacy_id)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "UPDATE заборонено";
  END IF;
  IF NOT EXISTS (SELECT * FROM post p WHERE p.post = NEW.post)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "UPDATE заборонено";
 END IF;
END //
DELIMITER ;



DROP TRIGGER check_table_post_delete;
DELIMITER //
CREATE TRIGGER check_table_post_delete
BEFORE DELETE
ON post FOR EACH ROW
BEGIN
  IF EXISTS (SELECT * FROM employee e WHERE e.post = OLD.post)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "DELETE заборонено";
 END IF;
END //
DELIMITER ;



DROP TRIGGER check_table_pharmacy_delete;
DELIMITER //
CREATE TRIGGER check_table_pharmacy_delete
BEFORE DELETE
ON pharmacy FOR EACH ROW
BEGIN
  IF EXISTS (SELECT * FROM employee em WHERE em.pharmacy_id = OLD.id)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "DELETE заборонено";
  END IF;
  IF EXISTS (SELECT * FROM pharmacy_medicine pm WHERE pm.pharmacy_id = OLD.id)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "DELETE заборонено";
 END IF;
END //
DELIMITER ;



DROP TRIGGER check_table_pharmacy_insert;
DELIMITER //
CREATE TRIGGER check_table_pharmacy_insert
BEFORE INSERT
ON pharmacy FOR EACH ROW
BEGIN
  IF NOT EXISTS (SELECT * FROM street s WHERE s.street = NEW.street)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "INSERT INTO заборонено";
 END IF;
END //
DELIMITER ;


DROP TRIGGER check_table_pharmacy_update;
DELIMITER //
CREATE TRIGGER check_table_pharmacy_update
BEFORE UPDATE
ON pharmacy FOR EACH ROW
BEGIN
  IF NOT EXISTS (SELECT * FROM street s WHERE s.street = NEW.street)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "UPDATE заборонено";
 END IF;
END //
DELIMITER ;


DROP TRIGGER check_table_street_delete;
DELIMITER //
CREATE TRIGGER check_table_street_delete
BEFORE DELETE
ON street FOR EACH ROW
BEGIN
  IF EXISTS (SELECT * FROM pharmacy ph WHERE ph.street = OLD.street)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "DELETE заборонено";
 END IF;
END //
DELIMITER ;


DROP TRIGGER check_table_medicine_delete;
DELIMITER //
CREATE TRIGGER check_table_medicine_delete
BEFORE DELETE
ON medicine FOR EACH ROW
BEGIN
  IF EXISTS (SELECT * FROM medicine_zone mz WHERE mz.medicine_id = OLD.id)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "DELETE заборонено";
  END IF;
  IF EXISTS (SELECT * FROM pharmacy_medicine pm WHERE pm.pharmacy_id = OLD.id)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "DELETE заборонено";
 END IF;
END //
DELIMITER ;

DROP TRIGGER check_table_zone_delete;
DELIMITER //
CREATE TRIGGER check_table_zone_delete
BEFORE DELETE
ON zone FOR EACH ROW
BEGIN
  IF EXISTS (SELECT * FROM medicine_zone mz WHERE mz.zone_id = OLD.id)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "DELETE заборонено";
 END IF;
END //
DELIMITER ;


DROP TRIGGER check_table_pharmacy_medicine_insert;
DELIMITER //
CREATE TRIGGER check_table_pharmacy_medicine_insert
BEFORE INSERT
ON pharmacy_medicine FOR EACH ROW
BEGIN
  IF NOT EXISTS (SELECT * FROM pharmacy ph WHERE ph.id = NEW.pharmacy_id)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "INSERT INTO заборонено";
  END IF;
  IF NOT EXISTS (SELECT * FROM medicine m WHERE m.id = NEW.medicine_id)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "INSERT INTO заборонено";
 END IF;
END //
DELIMITER ;


DROP TRIGGER check_table_pharmacy_medicine_update;
DELIMITER //
CREATE TRIGGER check_table_pharmacy_medicine_update
BEFORE UPDATE
ON pharmacy_medicine FOR EACH ROW
BEGIN
  IF NOT EXISTS (SELECT * FROM pharmacy ph WHERE ph.id = NEW.pharmacy_id)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "UPDATE заборонено";
  END IF;
  IF NOT EXISTS (SELECT * FROM medicine m WHERE m.id = NEW.medicine_id)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "UPDATE заборонено";
 END IF;
END //
DELIMITER ;

DROP TRIGGER check_table_medicine_zone_insert;
DELIMITER //
CREATE TRIGGER check_table_medicine_zone_insert
BEFORE INSERT
ON medicine_zone FOR EACH ROW
BEGIN
  IF NOT EXISTS (SELECT * FROM zone z WHERE z.id = NEW.zone_id)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "INSERT INTO заборонено";
  END IF;
  IF NOT EXISTS (SELECT * FROM medicine m WHERE m.id = NEW.medicine_id)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "INSERT INTO заборонено";
 END IF;
END //
DELIMITER ;


DROP TRIGGER check_table_medicine_zone_update;
DELIMITER //
CREATE TRIGGER check_table_medicine_zone_update
BEFORE UPDATE
ON medicine_zone FOR EACH ROW
BEGIN
  IF NOT EXISTS (SELECT * FROM zone z WHERE z.id = NEW.zone_id)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "INSERT INTO заборонено";
  END IF;
  IF NOT EXISTS (SELECT * FROM medicine m WHERE m.id = NEW.medicine_id)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "INSERT INTO заборонено";
 END IF;
END //
DELIMITER ;




#2. Співробітники→ Ідентифікаційний номер не може закінчувати двома нулями;
DELIMITER //
CREATE TRIGGER check_identity_number
BEFORE INSERT
ON employee FOR EACH ROW
BEGIN
	IF(new.identity_number RLIKE '00$')
	THEN SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'error identity_number != ...00 for INSERT';
	END IF;
END //
DELIMITER ;

INSERT INTO employee(surname, `name`, midle_name, identity_number, passport, experience, birthday, post, pharmacy_id)
VALUE ('Вовк', 'Наталя', 'Михайлівна', '1345349100', 'KН1111KС', 4.5, '1993-11-24', 'Фармацефт', 1);

DELIMITER //
CREATE TRIGGER update_identity_number
BEFORE UPDATE
ON employee FOR EACH ROW
BEGIN
	IF(new.identity_number RLIKE '00$')
	THEN SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'error identity_number != ...00 for UPDATE';
	END IF;
END //
DELIMITER ;

UPDATE employee SET identity_number = '1345349100' WHERE identity_number = '1277349155';

/*3. для Перелік лікарств→ Код міністерства забезпечити формат вводу:
2 довільні букви, окрім М і П + '-' + 3 цифри + '-' + 2цифри.*/

DROP TRIGGER check_insert_medicine_ministry_code;
DELIMITER //
CREATE TRIGGER check_insert_medicine_ministry_code
AFTER INSERT
ON medicine FOR EACH ROW
BEGIN
  IF NOT(new.ministry_code RLIKE '^[^МП][^МП]-[0-9][0-9][0-9]-[0-9][0-9]$' )
 THEN
 SIGNAL SQLSTATE '45000'
      SET MESSAGE_TEXT = "Ministry code format: 2 довільні букви, окрім М та П - 3 цифри - 2 цифри";
 END IF;
END //
DELIMITER ;

INSERT INTO medicine (`name`, ministry_code, recipe, narcotic, psychotropic) 
    VALUE ('Уралезан', 'МП-13-1341', 1, 0, 0); # Не спрацює


DROP TRIGGER check_update_medicine_ministry_code;
DELIMITER //
CREATE TRIGGER check_update_medicine_ministry_code
BEFORE UPDATE
ON medicine FOR EACH ROW
BEGIN
  IF NOT(new.ministry_code RLIKE '^[^МП][^МП]-[0-9][0-9][0-9]-[0-9][0-9]$' )
 THEN
 SIGNAL SQLSTATE '45000'
      SET MESSAGE_TEXT = "Ministry code format: 2 довільні букви, окрім М та П - 3 цифри - 2 цифри";
 END IF;
END //
DELIMITER ;

UPDATE medicine SET ministry_code = 'МП-13-1341' WHERE ministry_code = 'LD-432-34'; #Не спрацює



#4. Заборонити будь-яку модифікацію даних в таблиці Посада.

DROP TRIGGER check_update_post;
DELIMITER //
CREATE TRIGGER check_update_post
BEFORE UPDATE
ON post FOR EACH ROW
BEGIN
  IF EXISTS (SELECT * FROM employee emp WHERE emp.post != new.post)
 THEN
 SIGNAL SQLSTATE '45000'
      SET MESSAGE_TEXT = "UPDATE заборонено";
 END IF;
END //
DELIMITER ;

UPDATE post SET post = 'Юрист' WHERE post = 'Фармацефт'; # Не спрацює


DROP TRIGGER check_delete_post;
DELIMITER //
CREATE TRIGGER check_delete_post
BEFORE DELETE
ON post FOR EACH ROW
BEGIN
  IF EXISTS (SELECT * FROM employee emp WHERE emp.post = OLD.post)
 THEN
 SIGNAL SQLSTATE '45000'
      SET MESSAGE_TEXT = "DELETE заборонено";
 END IF;
END //
DELIMITER ;

DELETE FROM post WHERE post = 'Фармацефт'; # Не спрацює


#ЗБЕРЕЖУВАНІ ПРОЦЕДУРИ

#1. Забезпечити параметризовану вставку нових значень у таблицю Співробітники.
DROP PROCEDURE IF EXISTS insert_into_employee;
DELIMITER //
CREATE PROCEDURE insert_into_employee(
	IN lname VARCHAR(30),
    IN fname CHAR(30),
    IN mname VARCHAR(30),
    IN ind_number CHAR(10),
    IN pas CHAR(10),
    IN exp DECIMAL(10, 1),
    IN birt_hday DATE,
    IN postt VARCHAR(15),
    IN ph_id INT
)
BEGIN
	INSERT INTO employee(surname, `name`, midle_name, identity_number, passport, experience, birthday, post, pharmacy_id)
    VALUE(lname, fname, mname, ind_number, pas, exp, birt_hday, postt, ph_id);
END //
DELIMITER ;

CALL insert_into_employee('Кизлюк', 'Анастасія', 'Петрівна', '1277349155', 'KН2755KС', 3.5, '1992-03-04', 'Фармацефт', 1);


/*2. Забезпечити реалізацію зв’язку М:М між таблицями Перелік
лікарств та Зона впливу, тобто вставити в стикувальну таблицю
відповідну стрічку, при цьому відповідні стрічки мають існувати в
основних таблицях.*/
DELIMITER //
CREATE PROCEDURE alter_table_medicine_zone()
BEGIN
	IF EXISTS( SELECT NULL
		   FROM INFORMATION_SCHEMA.COLUMNS
           WHERE table_name = 'medicine_zone'
             AND table_schema = 'storedpr_db'
             AND column_name = 'medicine_id') 
	AND EXISTS( SELECT NULL
		   FROM INFORMATION_SCHEMA.COLUMNS
           WHERE table_name = 'medicine_zone'
             AND table_schema = 'storedpr_db'
             AND column_name = 'zone_id')
	AND EXISTS( SELECT NULL
		   FROM INFORMATION_SCHEMA.COLUMNS
           WHERE table_name = 'medicine'
             AND table_schema = 'storedpr_db'
             AND column_name = 'id')
	AND EXISTS( SELECT NULL
		   FROM INFORMATION_SCHEMA.COLUMNS
           WHERE table_name = 'zone'
             AND table_schema = 'storedpr_db'
             AND column_name = 'id')            THEN
	ALTER TABLE medicine_zone 
      ADD CONSTRAINT fk_medicine_zone_medicine
      FOREIGN KEY(medicine_id)
      REFERENCES medicine (id),
      ADD CONSTRAINT fk_medicine_zone_zone
      FOREIGN KEY(zone_id)
      REFERENCES zone (id);
      END IF;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS alter_table_medicine_zone;
ALTER TABLE medicine_zone DROP foreign key fk_medicine_zone_medicine;
ALTER TABLE medicine_zone DROP foreign key fk_medicine_zone_zone;

CALL alter_table_medicine_zone();


/*3. Використовуючи курсор, забезпечити динамічне створення таблиць
з іменами Співробітників у поточній БД, з випадковою кількістю
стовпців (від 1 до 9). Імена та тип стовпців довільні.*/
DROP PROCEDURE IF EXISTS create_table_cursor;
DELIMITER //
CREATE PROCEDURE create_table_cursor()
BEGIN
	DECLARE done int DEFAULT false;
	DECLARE fname char(30);
	DECLARE eml_cursor CURSOR FOR SELECT `name` FROM employee;
	DECLARE CONTINUE HANDLER
	FOR NOT FOUND SET done = true;
	OPEN eml_cursor;
	myLoop: LOOP
		FETCH eml_cursor INTO fname;
		IF done=true THEN LEAVE myLoop;
		END IF;
		SET @temp_query = CONCAT('CREATE TABLE ', fname, '(p1 INT PRIMARY KEY, p2 VARCHAR(10) NOT NULL, p3 VARCHAR(5) NULL);');
		PREPARE myquery FROM @temp_query;
		EXECUTE myquery;
		DEALLOCATE PREPARE myquery;
	END LOOP;
	CLOSE eml_cursor;
END //
DELIMITER ;

CALL create_table_cursor();


#КОРИСТУВАЦЬКІ ФУНКЦІЇ

/*1. Для таблиці Співробітники написати функцію яка буде шукати MIN
стовпця Трудовий стаж . Потім зробити вибірку даних (SELECT),
використовуючи дану функцію. */
DROP function IF EXISTS min_value;
DELIMITER //
CREATE FUNCTION min_value()
	RETURNS DECIMAL(10,1)
BEGIN
	RETURN (SELECT min(experience) FROM employee);
END //
DELIMITER ;

SELECT min_value() experience;



/*2. Написати функцію, яка витягує за ключем між таблицями
Співробітники та Аптечна установа об’єднане значення полів Назва та
№будинку. Потім зробити вибірку усіх даних (SELECT) з таблиці
Співробітники, використовуючи дану функцію.*/
DROP function IF EXISTS concat_name_house_number;
DELIMITER //
CREATE FUNCTION concat_name_house_number(value1 INT)
	RETURNS VARCHAR(50)
BEGIN
	RETURN (SELECT concat(eml.`name`, ' ', ph.building_number)  
    FROM employee eml JOIN pharmacy ph ON eml.pharmacy_id = ph.id WHERE eml.id = value1) ;
END //
DELIMITER ;

SELECT concat_name_house_number(id) FROM employee;


