USE family_tree;

SELECT concat(fname, " ", lname) full_name, birth_date, death_date, birth_place, death_place, credit_card_number, gender_id, family_tree_id FROM family_tree;
SELECT concat(fname, " ", lname, ' народ. ',  day(birth_date), ' дня ', year(birth_date), ' р. від різдва Христового') personality_information  
                                                                          FROM family_companion;
SELECT (sin(min_cost) + cos(max_cost)) coefficient FROM heirloom;
