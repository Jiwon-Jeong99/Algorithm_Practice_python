-- null은 고려대상x
select count( distinct name)
from animal_ins
where name is not null;
