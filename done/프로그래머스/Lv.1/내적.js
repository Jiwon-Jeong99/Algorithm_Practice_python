function solution(a, b) {
    var result = 0;
    for(let i=0; i<a.length; i++){
        result += a[i] * b[i];
    }
    return result;
}