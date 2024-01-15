select 
    warehouse_id,
    warehouse_name,
    address,
    (
        case
            when freezer_yn = 'Y' then 'Y'
            when freezer_yn is null then 'N'
            else 'N'
        end
    ) as freezer_yn
from food_warehouse
where address like '경기도%'
order by warehouse_id;
