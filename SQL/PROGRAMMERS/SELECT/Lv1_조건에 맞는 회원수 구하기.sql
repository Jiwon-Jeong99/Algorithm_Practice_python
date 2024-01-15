select count(*) as users 
from user_info
where substr(joined,1,4) = '2021' and age >= 20 and age <= 29;
