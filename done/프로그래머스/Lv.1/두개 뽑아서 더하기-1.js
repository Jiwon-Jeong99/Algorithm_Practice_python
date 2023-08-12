
function solution(numbers) {
    var answer = [];
    for ( let i = 0; i < numbers.length; i++) {
      for ( let j = i + 1; j < numbers.length; j++) {
        let sum = numbers[i] + numbers[j];
        //sum이 answer 리스트에 없으면 push
        if( answer.indexOf(sum) == -1) {
          answer.push(sum);
        }
      }
    }
    answer.sort ((a,b) => a-b);
    return answer;
}