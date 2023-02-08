// 다음 소스 코드를 완성하여 날짜와 시간을 출력하시오.
let year = '2019';
let month = '04';
let day = '26';
let hour = '11';
let minute = '34';
let second = '27';

// concat으로 문자열 합치는게 훨씬 더 빠름
// let result = year+'/'+month+'/'+day+' '+hour+':'+minute+':'+second;
let result = year.concat('/',month,'/',day,' ',hour,':',minute,':',second);

console.log(result);


