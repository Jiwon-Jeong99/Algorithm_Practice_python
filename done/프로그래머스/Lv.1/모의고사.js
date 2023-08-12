function solution(answers) {
    const one = [1,2,3,4,5];
    const two = [2,1,2,3,2,4,2,5];
    const three = [3,3,1,1,2,2,4,4,5,5];
    const result = [0,0,0];

    for(let i=0; i<answers.length; i++){
        if(answers[i] == one[i%5]){
            result[0]++;
        }
        if(answers[i] == two[i%8]){
            result[1]++;
        }
        if(answers[i] == three[i%10]){
            result[2]++;
        }
    }
        const maxValue = Math.max(...result);
        let index = 0;
        const answer = [];
        for(let k=0; k<3; k++){
            if(maxValue == result[k]){
                answer[index] = k+1;
                index++;

            }
        }
        return answer;
}