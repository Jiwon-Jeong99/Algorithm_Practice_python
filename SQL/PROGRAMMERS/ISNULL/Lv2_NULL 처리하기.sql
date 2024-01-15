select
    ANIMAL_TYPE,
    ifnull(name, 'No name') as name,
    SEX_UPON_INTAKE
from animal_ins
order by animal_id;
