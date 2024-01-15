select 
    hour(datetime) as HOUR,
    count(hour(datetime)) as COUNT
from animal_outs
group by hour
having hour between 9 and 19
order by hour;
