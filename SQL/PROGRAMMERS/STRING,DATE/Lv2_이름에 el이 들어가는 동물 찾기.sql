select animal_id, name
from animal_ins
where name like '%el%' and animal_type = 'Dog'
order by name;
