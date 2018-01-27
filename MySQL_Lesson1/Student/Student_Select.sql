USE student;

SELECT concat(id_student_ticket, '-', date_of_admission) student FROM student;
SELECT concat(lname, ' ', fname, ' ', mname) full_name_student FROM student;
SELECT (year(date_of_admission) - year(birth_date)) years_old FROM student;
