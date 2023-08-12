function solution(d, budget) {
    var count = 0;
    var sum=0;
    d.sort((a,b) => a-b);
    
    for(let i=0;i<d.length; i++){
        sum += d[i];
        
        if(sum <= budget){
            count++;
        }
        else{
            break
        }
    }
    return count;
}
    