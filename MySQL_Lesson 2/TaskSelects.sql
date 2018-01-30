/*Б. Написання SQL-запитів SELECT (GROUP BY, HAVING, статистика, підзапити (ANY, ALL, EXISTS), UNION, CASE ..)
Написати як мінімум по 5 запитів з кожного пункту*/

#4 (Використ підзапитів у конструкції WHERE з викор. IN, ANY, ALL)

#1. БД «Комп. фірма». Знайдіть виробників, що випускають ПК, але не ноутбуки (використати операцію IN). Вивести maker.
SELECT DISTINCT maker FROM product WHERE `type` = 'PC' AND maker NOT IN (SELECT maker FROM product WHERE `type` = 'Laptop');

#2. БД «Комп. фірма». Знайдіть виробників, що випускають ПК, але не ноутбуки (використати ключове слово ALL). Вивести maker.
SELECT DISTINCT maker FROM product WHERE `type` = 'PC' AND maker != ALL (SELECT maker FROM product WHERE `type` = 'Laptop');

#3. БД «Комп. фірма». Знайдіть виробників, що випускають ПК, але не ноутбуки (використати ключове слово ANY). Вивести maker.
SELECT DISTINCT maker FROM product WHERE `type` = 'PC' AND NOT maker = ANY (SELECT maker FROM product WHERE `type` = 'Laptop');

#4. БД «Комп. фірма». Знайдіть виробників, що випускають одночасно ПК та ноутбуки (використати операцію IN). Вивести maker.
SELECT DISTINCT maker FROM product WHERE `type` = 'PC' AND maker IN (SELECT maker FROM product WHERE `type` = 'Laptop');

#5. БД «Комп. фірма». Знайдіть виробників, що випускають одночасно ПК та ноутбуки (використати ключове слово ALL). Вивести maker.
SELECT DISTINCT maker FROM product WHERE `type` = 'PC' AND NOT maker != ALL (SELECT maker FROM product WHERE `type` = 'Laptop');

#6. БД «Комп. фірма». Знайдіть виробників, що випускають одночасно ПК та ноутбуки (використати ключове слово ANY). Вивести maker.
SELECT DISTINCT maker FROM product WHERE `type` = 'PC' AND maker = ANY (SELECT maker FROM product WHERE `type` = 'Laptop');

/*7. БД «Комп. фірма». Знайти тих виробників ПК, усі моделі ПК яких є у наявності в таблиці PC (використовувати вкладені
підзапити та оператори IN, ALL, ANY). Вивести maker.*/
SELECT DISTINCT maker FROM product WHERE model IN (SELECT model FROM pc);

SELECT DISTINCT maker FROM product WHERE model = ANY (SELECT model FROM pc);

SELECT DISTINCT maker FROM product WHERE NOT model != ALL(SELECT model FROM pc);


#5 (Використання підзапитів з лог. операцією EXISTS)

#1. БД «Комп. фірма». Знайти тих виробників ПК, усі моделі ПК яких є у наявності в таблиці PC (використовуючи операцію EXISTS). Вивести maker.
SELECT DISTINCT pr.maker FROM product pr WHERE EXISTS (SELECT * FROM pc WHERE pr.model = model);

#2. БД «Комп. фірма». Знайдіть виробників, які б випускали ПК зі швидкістю 750 МГц та вище. Виведіть: maker.
SELECT  pr.maker FROM product pr WHERE EXISTS (SELECT * FROM pc WHERE pr.model = model AND speed >= 750);

#3. БД «Комп. фірма». Знайдіть виробників, які б випускали одночасно ПК та ноутбуки зі швидкістю 750 МГц та вище. Виведіть: maker.
SELECT  pr.maker FROM product pr WHERE EXISTS ( SELECT * FROM pc WHERE pr.model = pc.model AND pc.speed >= 750)
AND EXISTS(SELECT * FROM laptop l WHERE pr.model = l.model AND l.speed >= 750); 
 
#4. БД «Комп. фірма». Знайдіть виробників принтерів, що випускають ПК з найвищою швидкістю процесора. Виведіть: maker.
SELECT pr.maker FROM product pr WHERE EXISTS(SELECT * FROM pc WHERE pr.model = pc.model AND pc.speed = ANY(SELECT max(speed) FROM pc));

/*5. За Вашингтонським міжнародним договором від початку 1922 р. заборонялося будувати лінійні кораблі водотоннажністю
понад 35 тис. тонн. Вкажіть кораблі, що порушили цей договір (враховувати лише кораблі з відомим спуском на воду, тобто з
таблиці Ships). Виведіть: name, launched, displacement.*/
SELECT s.`name`, s.launched, c.displacement FROM ships s JOIN classes c ON c.class = s.class 
WHERE EXISTS (SELECT * FROM classes c WHERE c.class = s.class AND c.displacement > 35000);



#6 (Конкатенація стрічок чи мат. обчислення чи робота з датами)

#1. БД «Комп. фірма». Виведіть середню ціну ноутбуків з попереднім текстом 'середня ціна = '.
SELECT  avg(price) AS 'середня ціна = ' FROM pc;

#2. БД «Комп. фірма». Для таблиці PC вивести усю інформацію з коментарями у кожній комірці, наприклад, 'модель: 1121', 'ціна: 600,00' і т.д.
SELECT concat('code: ', `code`) `code`, concat('model: ', model) model, concat('speed: ', speed) speed, concat('ram: ', ram) ram, 
concat('hd: ', hd) hd, concat('cd: ', cd) cd, concat('price: ', price) price FROM pc;

#3. БД «Фірма прий. вторсировини». З таблиці Income виведіть дати у такому форматі: рік.число_місяця.день, наприклад, 2001.02.15 (без формату часу).
SELECT DATE_FORMAT(`date`, "%Y.%c.%d") `date` FROM income;

#4. БД «Кораблі». Для таблиці Outcomes виведіть дані, а заміть значень стовпця result, виведіть еквівалентні їм надписи українською мовою.
SELECT ship, battle, CASE result
WHEN 'sunk' THEN 'потоплений'
WHEN 'damaged' THEN 'пошкоджений'
WHEN 'OK' THEN 'цілий'
END AS result FROM outcomes;

/*5. БД «Аеропорт». Для таблиці Pass_in_trip значення стовпця place розбити на два стовпця з коментарями, наприклад, 
перший – 'ряд: 2' та другий – 'місце: a'.*/
SELECT concat('ряд: ', LEFT(place, 1)) AS ряд, concat('місце: ', RIGHT(place, 1)) AS місце FROM pass_in_trip;

/*6. БД «Аеропорт». Вивести дані для таблиці Trip з об’єднаними значеннями двох стовпців: town_from та town_to, з
додатковими коментарями типу: 'from Rostov to Paris'.*/
SELECT concat('from ', town_from, ' to ', town_to) town_from_town_to FROM trip;


#7 (Статистичні функції та робота з групами)

#1. БД «Комп. фірма». Знайдіть принтери, що мають найвищу ціну. Вивести: model, price.
SELECT model, max(price) AS max_price FROM printer;

#2. БД «Комп. фірма». Знайдіть ноутбуки, швидкість яких є меншою за швидкість будь-якого з ПК. Вивести: type, model, speed.
SELECT pr.`type`, l.model, l.speed FROM product pr RIGHT JOIN laptop l ON pr.model = l.model WHERE l.speed < ANY (SELECT min(speed) FROM pc);

#3. БД «Комп. фірма». Знайдіть виробників найдешевших кольорових принтерів. Вивести: maker, price.
SELECT pr.maker, min(prin.price) min_price_printer FROM product pr JOIN printer prin ON pr.model = prin.model WHERE prin.color = 'y';

/*4. БД «Комп. фірма». Знайдіть виробників, що випускають по крайній мірі дві різні моделі ПК. Вивести: maker, число
моделей. (Підказка: використовувати підзапити у якості обчислювальних стовпців та операцію групування)*/
SELECT DISTINCT maker FROM product WHERE maker IN (SELECT maker FROM product WHERE type='PC' GROUP BY maker HAVING COUNT(*) >= 2);

/*5. БД «Комп. фірма». Знайдіть середній розмір жорсткого диску ПК (одне значення на всіх) тих виробників, які також
випускають і принтери. Вивести: середній розмір жорсткого диску.*/
SELECT AVG(hd) AS 'середній розмір жорсткого диску' FROM pc WHERE model IN (SELECT model FROM product WHERE `type` = 'PC' 
AND maker IN (SELECT maker FROM product WHERE `type` = 'Printer'));



#8 (Підзапити у якості обчислювальних стовпців)

/*1. БД «Комп. фірма». Для таблиці Product отримати підсумковий набір у вигляді таблиці зі стовпцями maker, pc, laptop та printer,
в якій для кожного виробника необхідно вказати кількість продукції, що ним випускається, тобто наявну загальну
кількість продукції у таблицях, відповідно, PC, Laptop та Printer. (Підказка: використовувати підзапити у якості
обчислювальних стовпців)*/
SELECT pr.maker, count(p.model) pc, count(lap.model) laptop, count(prin.model) printer FROM product pr
	LEFT JOIN pc p ON pr.model= p.model 
    LEFT JOIN laptop lap ON pr.model = lap.model 
    LEFT JOIN printer prin ON pr.model = prin.model
	GROUP BY maker;

/*2. БД «Комп. фірма». Для кожного виробника знайдіть середній розмір екрану для ноутбуків, що ним випускається. Вивести:
maker, середній розмір екрану. (Підказка: використовувати підзапити у якості обчислювальних стовпців)*/
SELECT pr.maker, avg_screen AS 'середній розмір екрану' FROM (SELECT pr.maker, AVG(l.screen) avg_screen 
FROM product pr JOIN laptop l ON l.model = pr.model GROUP BY pr.maker) pr;


/*3. БД «Комп. фірма». Знайдіть максимальну ціну ПК, що випускаються кожним виробником. Вивести: maker,
максимальна ціна. (Підказка: використовувати підзапити у якості обчислювальних стовпців)*/
SELECT pr.maker, max_price AS 'максимальна ціна' FROM (SELECT pr.maker, max(price) AS max_price FROM product pr JOIN pc p ON p.model = pr.model GROUP BY pr.maker) pr;


/*4. БД «Комп. фірма». Знайдіть мінімальну ціну ПК, що випускаються кожним виробником. Вивести: maker,
максимальна ціна. (Підказка: використовувати підзапити у якості обчислювальних стовпців)*/
SELECT pr.maker, min_price AS 'мінімальна ціна' FROM (SELECT pr.maker, min(price) AS min_price FROM product pr JOIN pc p ON p.model = pr.model GROUP BY pr.maker) pr;

/*5. БД «Комп. фірма». Для кожного значення швидкості ПК, що перевищує 600 МГц, визначіть середню ціну ПК з такою ж
швидкістю. Вивести: speed, середня ціна. (Підказка: використовувати підзапити у якості обчислювальних стовпців)*/
SELECT p.speed, avg_price AS 'середня ціна'FROM (SELECT speed, AVG(price) AS avg_price FROM pc WHERE speed > 600 GROUP BY speed) p;


#9 (Оператор CASE)

/*1. БД «Комп. фірма». Для таблиці Product отримати підсумковий набір у вигляді таблиці зі стовпцями maker, pc, в якій для
кожного виробника необхідно вказати, чи виробляє він ('yes'), чи ні ('no') відповідний тип продукції. У першому випадку
('yes') додатково вказати поруч у круглих дужках загальну кількість наявної (тобто, що знаходиться у таблиці PC)
продукції, наприклад, 'yes(2)'. (Підказка: використовувати підзапити у якості обчислювальних стовпців та оператор CASE)*/

SELECT result.maker,
CASE WHEN pc AND result.maker NOT IN (SELECT maker FROM product WHERE `type` = 'PC') THEN 'no' ELSE concat('yes(', pc, ')') END pc
FROM (SELECT maker, count(p.model) pc FROM product pr LEFT JOIN pc p ON pr.model = p.model GROUP BY maker) result;


/*3. БД «Кораблі». Визначити назви усіх кораблів з таблиці Ships, які задовольняють, у крайньому випадку, комбінації будь-яких
чотирьох критеріїв з наступного списку: numGuns=8, bore=15, displacement=32000, type='bb', country='USA', launched=1915,
class='Kongo'. Вивести: name, numGuns, bore, displacement, type, country, launched, class. (Підказка: використати для
перевірки умов оператор CASE)*/
SELECT amount.`name`, amount.numGuns, amount.bore, amount.displacement,  amount.`type`, amount.country, amount.launched, amount.class
FROM (SELECT s.`name`, c.numGuns, c.bore, c.displacement, c.`type`, c.country, s.launched, s.class, 
CASE WHEN (c.numGuns = 8) THEN (1) else (0) end n1, 
CASE WHEN (c.bore = 15) THEN (1) else (0) end n2, 
CASE WHEN (c.displacement = 32000) THEN (1) else (0) end n3, 
CASE WHEN (c.`type` = 'bb') THEN (1) else (0) end n4, 
CASE WHEN (c.country = 'USA') THEN (1) else (0) end n5, 
CASE WHEN (s.launched = 1915) THEN (1) else (0) end n6, 
CASE WHEN (s.class = 'Kon') THEN (1) else (0) end n7  
FROM ships s, classes c WHERE s.class=c.class) amount WHERE (amount.n1+amount.n2+amount.n3+amount.n4+amount.n5+amount.n6+amount.n7) >= 4; 


#10 (Об’єднання UNION)

/*1. БД «Комп. фірма». Знайдіть номера моделей та ціни усіх продуктів (будь-якого типу), що випущені виробником 'B'.
Вивести: maker, model, type, price. (Підказка: використовувати оператор UNION)*/

SELECT pr.maker, pr.model, pr.`type`, p.price 
FROM product pr JOIN pc p ON pr.model = p.model WHERE pr.maker = 'B' 
UNION ALL
SELECT pr.maker, pr.model, pr.`type`, l.price 
FROM product pr JOIN laptop l ON pr.model = l.model WHERE pr.maker='B' 
UNION ALL
SELECT pr.maker, pr.model, pr.`type`, prin.price 
FROM product pr JOIN printer prin ON pr.model = prin.model WHERE pr.maker='B';


/*2. БД «Комп. фірма». Для кожної моделі продукції з усієї БД виведіть її найвищу ціну. Вивести: type, model, максимальна
ціна. (Підказка: використовувати оператор UNION)*/

SELECT DISTINCT pr.`type`, p.model, max(p.price) max_price
FROM product pr JOIN pc p ON p.model = pr.model  group by pr.model
UNION ALL
SELECT DISTINCT pr.`type`, l.model, max(l.price) max_price
FROM product pr JOIN laptop l ON pr.model = l.model group by pr.model
UNION ALL
SELECT DISTINCT pr.`type`, prin.model, max(prin.price) max_price
FROM product pr JOIN printer prin ON pr.model = prin.model group by pr.model;


/*3. БД «Комп. фірма». Знайдіть середню ціну ПК та ноутбуків, що
випущені виробником 'A'. Вивести: одна загальна середня ціна. (Підказка: використовувати оператор UNION)*/

SELECT AVG(p.price) AS 'одна загальна середня ціна'
FROM (SELECT price FROM product pr JOIN pc p ON pr.model = p.model WHERE pr.maker = 'A' 
UNION ALL 
SELECT price FROM product pr JOIN laptop l ON pr.model = l.model WHERE pr.maker='A') p; 


/*4. БД «Кораблі». Перерахуйте назви головних кораблів, що є наявними у БД (врахувати також і кораблі з таблиці
Outcomes). Вивести: назва корабля, class. (Підказка: використовувати оператор UNION та операцію EXISTS) */

SELECT `name`, class FROM ships WHERE class = `name`
UNION ALL
SELECT o.ship, c.class FROM classes c, outcomes o WHERE c.class = o.ship; 


/*5. БД «Кораблі». Знайдіть класи, у яких входить лише один корабель з усієї БД (врахувати також кораблі у таблиці
Outcomes, яких немає у таблиці Ships). Вивести: class. (Підказка: використовувати оператор UNION та операцію EXISTS)*/

SELECT class FROM ships GROUP BY class HAVING COUNT(`name`) = 1
UNION ALL
SELECT class FROM classes c, outcomes o WHERE c.class = o.ship AND NOT EXISTS (SELECT * FROM ships s WHERE o.ship = s.class);

