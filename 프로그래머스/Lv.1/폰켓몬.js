function solution(nums) {
    const thing = [...new Set(nums)]
    const new_thing = thing.length
    const new_nums = (nums.length)/2
    if (new_nums > new_thing){
        return new_thing
    }
    else{
        return new_nums
    }
    
}