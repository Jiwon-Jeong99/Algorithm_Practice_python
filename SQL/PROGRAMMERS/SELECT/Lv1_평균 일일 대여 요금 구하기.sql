SELECT round(avg(daily_fee),0) as AVERAGE_FEE
FROM car_rental_company_car
WHERE car_type = 'SUV';
