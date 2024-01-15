-- 동물 이름 -> 2번 이상쓰인 이름
-- 해당 이름이 쓰인 횟수
-- 이름이 없는 동물은 집계 제외
-- 결과 이름순
select name, count(name) as count
from animal_ins
group by name
having count(name) is not null and count(name) >= 2
order by name;
