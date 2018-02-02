CREATE DATABASE IF NOT EXISTS student_success;
USE student_success;

CREATE TABLE student(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	fname VARCHAR(20) NOT NULL,
    lname VARCHAR(25) NOT NULL,
    mname VARCHAR(25) NOT NULL,
    photo MEDIUMBLOB NULL DEFAULT NULL,
    autobiography MEDIUMBLOB NULL DEFAULT NULL,
    birth_date DATE NOT NULL,
    home_adress VARCHAR(50) NOT NULL,
    rating INT(3) NOT NULL,
    scholarship_size INT(4) NOT NULL,
    year_of_admission INT(4) NOT NULL,
    group_id INT NOT NULL,
    specialty_id INT NOT NULL
) ENGINE = InnoDB;


CREATE TABLE `group`(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(12) NOT NULL
) ENGINE = InnoDB;


CREATE TABLE faculty(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(30) NOT NULL
) ENGINE = InnoDB;


CREATE TABLE specialty(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    faculty_id INT NOT NULL
) ENGINE = InnoDB;


CREATE TABLE `subject`(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50)
) ENGINE = InnoDB;


CREATE TABLE teacher(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    fname VARCHAR(20)  NULL,
    lname VARCHAR(25)  NULL,
    mname VARCHAR(25)  NULL
) ENGINE = InnoDB;


CREATE TABLE subject_teacher(
	subject_id INT NOT NULL,
    teacher_id INT NOT NULL,
    PRIMARY KEY (subject_id, teacher_id)
) ENGINE = InnoDB;


CREATE TABLE `point`(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    semester INT(2) NOT NULL,
    module_1 INT(2) NULL,
    module_2 INT(2) NULL,
    100_point_scale INT(3) NOT NULL,
    5_point_scale INT(1) NOT NULL
) ENGINE = InnoDB;


CREATE TABLE student_subject_point(
	student_id INT NOT NULL,
    subject_id INT NOT NULL,
    point_id INT NOT NULL,
    PRIMARY KEY(student_id, subject_id, point_id)
) ENGINE = InnoDB;


ALTER TABLE subject_teacher
 ADD CONSTRAINT fk_subject_teacher_subject
    FOREIGN KEY (subject_id)
    REFERENCES `subject` (id),
 ADD CONSTRAINT fk_subject_teacher_teacher
    FOREIGN KEY (teacher_id)
    REFERENCES teacher (id);

ALTER TABLE specialty
 ADD CONSTRAINT fk_specialty_faculty
	FOREIGN KEY(faculty_id)
	REFERENCES faculty (id);
    
ALTER TABLE student
 ADD CONSTRAINT fk_student_group
	FOREIGN KEY(group_id)
    REFERENCES `group` (id),
 ADD CONSTRAINT fk_student_specialty
	FOREIGN KEY(specialty_id)
    REFERENCES specialty (id);
    
ALTER TABLE student_subject_point
 ADD CONSTRAINT fk_student_subject_point_student
	FOREIGN KEY(student_id)
    REFERENCES student (id),
 ADD CONSTRAINT fk_student_subject_point_subject
	FOREIGN KEY(subject_id)
    REFERENCES `subject` (id),
 ADD CONSTRAINT fk_student_subject_point_point
	FOREIGN KEY(point_id)
    REFERENCES `point` (id);

INSERT INTO faculty (`name`) VALUES ('Електроніки'), ('Фізичний'), ('Прикладна математика'), ('Біологічний'), ('Хімічний');

INSERT INTO specialty (`name`, faculty_id) 
VALUES ("Комп'ютерні науки", 1), ('Наноелектроніка', 1), ('Інформатика', 3), ('Системний аналіз', 3), ('Математика', 3);

INSERT INTO `group` (`name`) VALUES ('FEI-41'), ('FEI-42'), ('FEI-43'), ('FEI-44');

INSERT INTO student (fname, lname, mname, birth_date, home_adress, rating, scholarship_size, year_of_admission, group_id, specialty_id)
	VALUES
    ('Oleh', 'Vovk', 'Mykhailovych', '1996-12-08', 'Stryiska street', 6, 1280, 2014, 2, 1),
    ('Taras', 'Legan', 'A.', '1997-08-19', 'Chuprynky street', 22, 1280, 2014, 2, 1),
    ('Stetsyk', 'Ihor', 'B.', '1996-07-21', 'Naukova street', 20, 1280, 2014, 1, 2);

INSERT INTO `subject` (`name`) VALUES ('ТПР'), ('ТРСПО'), ('Управління ІТ проектами'), ('Проектування інформаціних ситем');

INSERT INTO teacher (fname, lname, mname) 
	VALUES
    ('Тарас', 'Ненчук', 'Миколаєвич'),
    ('Шувар', 'Роман', 'Ярославович'),
    ('Катеринчук', 'Іван', 'Миколаєвич');

INSERT INTO subject_teacher(subject_id, teacher_id) VALUES (1 , 3), (2 , 2), (3 ,1 ), (4 , 1);

INSERT INTO `point`(semester, module_1, module_2, 100_point_scale, 5_point_scale)
	VALUES 
    (7, 6, 8, 95, 5),
    (7, 25, 25, 96, 5),
    (6, 20, 18, 81, 4),
    (7, 20, 20, 78, 4);

INSERT INTO student_subject_point(student_id, subject_id, point_id) 
	VALUES
    (1, 1, 1),
    (2, 2, 2),
    (3, 3, 4);

