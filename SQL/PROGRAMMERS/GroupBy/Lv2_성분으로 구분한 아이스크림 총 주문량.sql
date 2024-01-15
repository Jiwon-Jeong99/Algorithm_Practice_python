select 
    ii.ingredient_type,
    sum(fh.total_order) as total_order
from first_half as fh inner join icecream_info as ii
on fh.flavor = ii.flavor
group by ii.ingredient_type
order by total_order;
