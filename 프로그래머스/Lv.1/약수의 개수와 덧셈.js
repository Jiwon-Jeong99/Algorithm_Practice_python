function solution(left, right) {
    var answer = 0;
    
    for (let i=left; i<right+1; i++){
        let count = 0;
        for(let j=1; j<i+1; j++){
            if(i%j==0){
                count += 1;
            }
        } 
        if(count % 2 ==0){
            answer += i;
        }
        else{
            answer -= i;
        }
    }
    
    return answer;
}