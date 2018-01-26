USE labor_sql;
#1. (вибірка з одної таблиці з простою умовою)


#1.БД «Комп. фірма». Знайти виробників ноутбуків. Вивести: maker, type. Вихідні дані впорядкувати за зростанням за стовпцем maker.
SELECT maker, `type` FROM product ORDER BY maker;

/*2.БД «Комп. фірма». Знайти номер моделі, об’єм пам’яті та розміри екранів ноутбуків, ціна яких перевищує 1000 дол. 
Вивести: model, ram, screen, price. Вихідні дані впорядкувати за зростанням за стовпцем ram та за спаданням за стовпцем price.*/
SELECT model, ram, screen, price FROM laptop WHERE price > 1000;

#3.БД «Комп. фірма». Знайдіть усі записи таблиці Printer для кольорових принтерів. Вихідні дані впорядкувати за спаданням за стовпцем price.
SELECT * FROM printer WHERE color = 'y' ORDER BY price DESC;

/*4.БД «Комп. фірма». Знайдіть номер моделі, швидкість та розмір диску ПК, що мають CD-приводи зі швидкістю '12х' чи '24х' та
ціну меншу 600 дол. Вивести: model, speed, hd, cd, price. Вихідні дані впорядкувати за спаданням за стовпцем speed.*/
SELECT model, speed, hd, cd, price FROM pc WHERE cd IN('12x', '24x') AND price < 600 ORDER BY speed DESC;

/*5.БД «Кораблі». Перерахувати назви головних кораблів (з таблиці Ships). Вивести: name, class. Вихідні дані 
	впорядкувати за зростанням за стовпцем name.*/
SELECT `name`, class FROM ships WHERE `name` = class ORDER BY `name`;

/*6.БД «Комп. фірма». Отримати інформацію про комп’ютери, що мають частоту процесора не менше 500 МГц та ціну нижче 800
	дол. Вихідні дані впорядкувати за спаданням за стовпцем price.*/
SELECT model, speed, price FROM pc WHERE speed >= 500 AND price < 800 
UNION ALL
SELECT model, speed, price FROM laptop WHERE speed >= 500 AND price < 800 ORDER BY price DESC;

/*7.БД «Комп. фірма». Отримати інформацію про всі принтери, які не є матричними та коштують менше 300 дол. 
   Вихідні дані впорядкувати за спаданням за стовпцем type.*/
SELECT * FROM printer WHERE `type` != "Matrix" AND price < 300 ORDER BY `type` DESC;

/*8.БД «Комп. фірма». Знайти модель та частоту процесора комп’ютерів, що коштують від 400 до 600 дол. Вивести: model,
speed. Вихідні дані впорядкувати за зростанням за стовпцем hd.*/
SELECT model, speed FROM pc WHERE price BETWEEN 400 AND 600 ORDER BY hd;

/*9.БД «Комп. фірма». Знайти модель, частоту процесора та об’єм жорсткого диску для тих комп’ютерів, що комплектуються накопичувачами 
10 або 20 Мб та випускаються виробником 'A'. Вивести: model, speed, hd. Вихідні дані впорядкувати за зростанням за стовпцем speed.*/
SELECT model, speed, hd FROM pc WHERE hd IN(10, 20) AND model IN (SELECT model FROM product WHERE maker = 'A')
UNION ALL
SELECT model, speed, hd FROM laptop WHERE hd IN(10, 20) AND model IN (SELECT model FROM product WHERE maker = 'A') ORDER BY speed;

/*10.БД «Комп. фірма». Знайдіть номер моделі, швидкість та розмір жорсткого диску для усіх ноутбуків, екран яких не менше 12 дюймів. 
   Вивести: model, speed, hd, price. Вихідні дані впорядкувати за спаданням за стовпцем price.*/
SELECT model, speed, hd, price FROM laptop WHERE screen >= 12 ORDER BY price DESC;

/*11.БД «Комп. фірма». Знайдіть номер моделі, тип та ціну для усіх принтерів, вартість яких менше 300 дол. Вивести: model, type,
price. Вихідні дані впорядкувати за спаданням за стовпцем type.*/
SELECT model, `type`, price FROM printer WHERE price < 300 ORDER BY `type` DESC;

/*12.БД «Комп. фірма». Вивести моделі ноутбуків з кількістю RAM рівною 64 Мб. Вивести: model, ram, price. Вихідні дані
   впорядкувати за зростанням за стовпцем screen.*/
SELECT model, ram, price FROM laptop WHERE ram = 64 ORDER BY screen;

/*13.БД «Комп. фірма». Вивести моделі ПК з кількістю RAM більшою за 64 Мб. Вивести: model, ram, price. Вихідні дані
   впорядкувати за зростанням за стовпцем hd.*/
SELECT model, ram, price FROM pc WHERE ram > 64 ORDER BY hd;

/*14.БД «Комп. фірма». Вивести моделі ПК зі швидкістю процесора у межах від 500 до 750 МГц. Вивести: model, speed, price.
   Вихідні дані впорядкувати за спаданням за стовпцем hd.*/
SELECT model, speed, price FROM pc WHERE speed BETWEEN 500 AND 750 ORDER BY hd DESC;

/*15.БД «Фірма прий. вторсировини». Вивести інформацію про видачу грошей на суму понад 2000 грн. на пунктах прийому
   таблиці Outcome_o. Вихідні дані впорядкувати за спаданням за стовпцем date.*/
SELECT * FROM outcome_o WHERE `out` > 2000 ORDER BY `date` DESC;

/*16.БД «Фірма прий. вторсировини». Вивести інформацію про прийом грошей на суму у межах від 5 тис. до 10 тис. грн. на
   пунктах прийому таблиці Income_o. Вихідні дані впорядкувати за зростанням за стовпцем inc.*/
SELECT * FROM income_o WHERE inc BETWEEN 5000 AND 10000 ORDER BY inc;

/*17.БД «Фірма прий. вторсировини». Вивести інформацію про прийом грошей на пункті прийому №1 таблиці Income. Вихідні
   дані впорядкувати за зростанням за стовпцем inc.*/
SELECT * FROM income WHERE `point` = 1 ORDER BY inc;

/*18.БД «Фірма прий. вторсировини». Вивести інформацію про видачу грошей на пункті прийому №2 таблиці Outcome.
   Вихідні дані впорядкувати за зростанням за стовпцем out.*/
SELECT * FROM outcome WHERE `point` = 2 ORDER BY `out`;

#19.БД «Кораблі». Вивести інформацію про усі класи кораблів для країни 'Japan'. Вихідні дані впорядкувати за спаданням за стовпцем type.
SELECT * FROM classes WHERE country = "Japan" ORDER BY `type` DESC; 

/*20.БД «Кораблі». Знайти всі кораблі, що були спущені на воду у термін між 1920 та 1942 роками. Вивести: name, launched.
   Вихідні дані впорядкувати за спаданням за стовпцем launched.*/
SELECT `name`, launched FROM ships WHERE launched BETWEEN 1920 AND 1942 ORDER BY launched DESC;

/*21.БД «Кораблі». Вивести усі кораблі, що брали участь у битві 'Guadalcanal' та не були потопленими. Вивести: ship, battle,
   result. Вихідні дані впорядкувати за спаданям за стовпцем ship.*/
SELECT * FROM outcomes WHERE battle = "Guadalcanal" AND result != "sunk" ORDER BY ship DESC; 

#22.БД «Кораблі». Вивести усі потоплені кораблі. Вивести: ship, battle, result. Вихідні дані впорядкувати за спаданням за стовпцем ship.
SELECT * FROM outcomes WHERE result = "sunk" ORDER BY ship DESC;

/*23.БД «Кораблі». Вивести назви класів кораблів з водотоннажністю не меншою, аніж 40 тонн. 
   Вивести: class, displacement. Вихідні дані впорядкувати за зростанням за стовпцем type.*/
SELECT class, displacement FROM classes WHERE displacement >= 40000 ORDER BY `type`; 

/*24.БД «Аеропорт». Знайдіть номера усіх рейсів, що бувають у місті 'London'. Вивести: trip_no, town_from, town_to. Вихідні
     дані впорядкувати за зростанням за стовпцем time_out.*/
SELECT trip_no, town_from, town_to FROM trip WHERE town_from = "London" OR town_to = "London" ORDER BY time_out;

/*25.БД «Аеропорт». Знайдіть номера усіх рейсів, на яких курсує літак 'TU-134'. Вивести: trip_no, plane, town_from, town_to.
   Вихідні дані впорядкувати за спаданням за стовпцем time_out.*/
SELECT trip_no, plane, town_from, town_to FROM trip WHERE plane = "TU-134" ORDER BY time_out DESC;

/*26.БД «Аеропорт». Знайдіть номера усіх рейсів, на яких не курсує літак 'IL-86'. Вивести: trip_no, plane, town_from, town_to. Вихідні
   дані впорядкувати за зростанням за стовпцем plane.*/
SELECT trip_no, plane, town_from, town_to FROM trip WHERE plane != "IL-86" ORDER BY plane;

/*27.БД «Аеропорт». Знайдіть номера усіх рейсів, що не бувають у місті 'Rostov'. Вивести: trip_no, town_from, town_to. Вихідні дані
   впорядкувати за зростанням за стовпцем plane.*/
SELECT trip_no, town_from, town_to FROM trip WHERE town_from != "Rostov" AND town_to != "Rostov" ORDER BY plane;



#2. (вибірка з одної таблиці з простою умовою)

#1.БД «Комп. фірма». Вивести усі моделі ПК, у номерах яких є хоча б дві одинички.
SELECT model FROM pc WHERE model LIKE "%1%1%";

#2.БД «Фірма прий. вторсировини». З таблиці Outcome вивести усю інформацію за березень місяць.
SELECT * FROM outcome WHERE `date` RLIKE '^20[0-9][0-9]-03-[0-9][0-9]';

#3.БД «Фірма прий. вторсировини». З таблиці Outcome_o вивести усю інформацію за 14 число будь-якого місяця.
SELECT * FROM outcome_o WHERE `date` RLIKE '^20[0-9][0-9]-[01][0-9]-14'; 

#4.БД «Кораблі». З таблиці Ships вивести назви кораблів, що починаються на 'W' та закінчуються літерою 'n'.
SELECT `name` FROM ships WHERE `name` LIKE "W%n";

#5.БД «Кораблі». З таблиці Ships вивести назви кораблів, що мають у своїй назві дві літери 'e'.
SELECT `name` FROM ships WHERE (LENGTH(`name`) - LENGTH(REPLACE(`name`,'e', ''))) = 2;

#6.БД «Кораблі». З таблиці Ships вивести назви кораблів та роки їх спуску на воду, назва яких не закінчується на літеру 'a'.
SELECT `name`, launched FROM ships WHERE `name` NOT LIKE "%a"; 

#7.БД «Кораблі». Вивести назви битв, які складаються з двох слів та друге слово не закінчується на літеру 'c'.
SELECT `name` FROM battles WHERE (LENGTH(`name`) - LENGTH(REPLACE(`name`,' ', ''))) = 1 AND substring_index(`name`, " ", -1) NOT LIKE "%c";

#8.БД «Аеропорт». З таблиці Trip вивести інформацію про рейси, що вилітають в інтервалі часу між 12 та 17 годинами включно.
SELECT * FROM trip WHERE time_out RLIKE '[1][2-6]:[0-5][0-9]:[0-5][0-9]' OR time_out RLIKE '^17:[0][0]:[0][0]';

#9.БД «Аеропорт». З таблиці Trip вивести інформацію про рейси, що прилітають в інтервалі часу між 17 та 23 годинами включно.
SELECT * FROM trip WHERE time_in  RLIKE '[1][7-9]:[0-5][0-9]:[0-5][0-9]' OR time_in  RLIKE '[2][0-3]:[0-5][0-9]:[0-5][0-9]' 
							OR time_in  RLIKE '^23:[0][0]:[0][0]';  
                            
#10.БД «Аеропорт». З таблиці Pass_in_trip вивести дати, коли були зайняті місця у першому ряду.						
SELECT `date` FROM pass_in_trip WHERE place LIKE "1%";

#11.БД «Аеропорт». З таблиці Pass_in_trip вивести дати, коли були зайняті місця 'c' у будь-якому ряді.
SELECT `date` FROM pass_in_trip WHERE place LIKE "%c";

#12.БД «Аеропорт». Вивести прізвища пасажирів (друге слово у стовпці name), що починаються на літеру 'С'.
SELECT substring_index(`name`, " ", -1) AS last_name FROM passenger WHERE substring_index(`name`, " ", -1) LIKE "C%";

#13.БД «Аеропорт». Вивести прізвища пасажирів (друге слово у стовпці name), що не починаються на літеру 'J'.
SELECT substring_index(`name`, " ", -1) AS last_name FROM passenger WHERE substring_index(`name`, " ", -1) NOT LIKE "J%";



#3. (Вибірка з 2х таблиць з простою умовою)

#1.БД «Комп. фірма». Вкажіть виробника для тих ПК, що мають жорсткий диск об’ємом не більше 8 Гбайт. Вивести: maker, type, speed, hd.
SELECT prod.maker, prod.`type`, p.speed, p.hd FROM pc p JOIN product prod ON p.model = prod.model WHERE p.hd <= 8;

#2.БД «Комп. фірма». Знайдіть виробників ПК з процесором не менше 600 МГц. Вивести: maker.
SELECT maker FROM product WHERE model IN (SELECT model FROM pc WHERE speed >= 600); 

#3.БД «Комп. фірма». Знайдіть виробників ноутбуків з процесором не вище 500 МГц. Вивести: maker.
SELECT maker FROM product WHERE model IN (SELECT model FROM laptop WHERE speed <= 500);

/*4.БД «Комп. фірма». Знайдіть пари моделей ноутбуків, що мають однакові об’єми жорстких дисків та RAM (таблиця Laptop). 
У результаті кожна пара виводиться лише один раз. Порядок виведення: модель з більшим номером, модель з меншим номером, об’єм диску та RAM.*/
SELECT DISTINCT l_1.model model, l_2.model model, l_1.hd, l_1.ram FROM laptop l_1, laptop l_2 
		WHERE l_1.hd = l_2.hd AND l_1.ram = l_2.ram AND l_1.model > l_2.model;

/*5.БД «Кораблі». Знайдіть країни, що мали класи як звичайних бойових кораблів 'bb', так і класи крейсерів 'bc'. Вивести:
  country, типи з класом 'bb', типи з класом 'bc'.*/
SELECT classes.country, count(DISTINCT classes.`type`) bb_bc FROM classes LEFT JOIN ships ON ships.class = classes.class 
		WHERE classes.`type`='bb' OR classes.`type`='bc' 
        GROUP BY classes.country
        HAVING bb_bc = 2;
        
#6.БД «Комп. фірма». Знайдіть номер моделі та виробника ПК, яка має ціну менше за 600 дол. Вивести: model, maker.
SELECT model, maker FROM product WHERE model IN (SELECT model FROM pc WHERE price < 600);

#7.БД «Комп. фірма». Знайдіть номер моделі та виробника прінтера, яка має ціну вищу за 300 дол. Вивести: model, maker.
SELECT model, maker FROM product WHERE model IN (SELECT model FROM printer WHERE price > 300);

#8.БД «Комп. фірма». Виведіть виробника, номер моделі та ціну кожного комп’ютера, що є у БД. Вивести: maker, model, price.
SELECT pr.maker, pr.model, p.price pc_price, lap.price laptop_price FROM product pr LEFT JOIN pc p ON pr.model = p.model
									LEFT JOIN laptop lap ON pr.model = lap.model WHERE pr.`type` =  "PC" OR pr.`type` =  "Laptop";
                                    
#9.БД «Комп. фірма». Виведіть усі можливі моделі ПК, їх виробників та ціну (якщо вона вказана). Вивести: maker, model, price.                                    
SELECT pr.maker, pr.model, p.price FROM product pr LEFT JOIN pc p ON pr.model = p.model WHERE pr.`type` = "PC";	

/*10. БД «Комп. фірма». Виведіть виробника, тип, модель та частоту процесора для ноутбуків, частота процесорів яких перевищує
    600 МГц. Вивести: maker, type, model, speed.*/	
SELECT pr.maker, pr.`type`, pr.model, lap.speed FROM product pr RIGHT JOIN laptop lap ON pr.model = lap.model WHERE lap.speed > 600;

#11.БД «Кораблі». Для кораблів таблиці Ships вивести їх водотоннажність.
SELECT ships.`name`, classes.displacement FROM ships LEFT JOIN classes ON ships.class = classes.class;

#12.БД «Кораблі». Для кораблів, що вціліли у битвах, вивести назви та дати битв, у яких вони брали участь. 											 
SELECT outcomes.ship, battles.`name` battle, battles.`date` FROM outcomes LEFT JOIN battles ON outcomes.battle = battles.`name` 
									                                 WHERE outcomes.result = "OK";
                                                                     
#13.БД «Кораблі». Для кораблів таблиці Ships вивести країни, яким вони належать.                                                                     
SELECT ships.`name`, classes.country FROM ships LEFT JOIN classes ON ships.class = classes.class;	
	
#14.БД «Аеропорт». Для рейсових літаків 'Boeing' вказати назви компаній, яким вони належать.				
SELECT DISTINCT company.`name`, trip.plane FROM trip JOIN company ON trip.ID_comp = company.ID_comp WHERE trip.plane = "Boeing";	

#15.БД «Аеропорт». Для пасажирів таблиці Passenger вивести дати, коли вони користувалися послугами авіаліній.
SELECT passenger.`name`, pass_in_trip.`date` FROM passenger JOIN pass_in_trip ON passenger.ID_psg = pass_in_trip.ID_psg; 			

							
