/**
약간 작업스케줄링 바이브?

문제
1. 작업 요청된 시점 ~ 작업 소요시간
2. 위의 것을 다 더한 것의 평균이 답
3. 작업을 수행하고 있지 않을 때는 먼저 요청이 들어온 작업부터 처리
(평균이 작아지려면, 전체 합계가 작아져야 함)
[작업이 요청되는 시점, 작업의 소요시간]

=> 평균이 가장 짧은 값을 return

aka - boj 1931 회의실배정
이거는 정렬로 lambda 형식, comparator로 정렬해서 최댓값 구하는 문제
arr[0]정렬 -> arr[1] 정렬

문풀
어떤것이 중헐까?
1) 작업이 요청되는 시간별로 정렬
2) 소요시간이 짧은 시간별로 정렬
3) 작업 도중 들어온 작업에서 가장 짧은 수행시간을 선택
-> 해당 시점에서의 우선순위대로 작업 진행

가장 이해하기 쉬운버전
1. 2개 우선순위큐(작업중인 큐, 대기중인 큐)
   대기큐 - 1) 작업이 요청되는 시간별로
   작업큐 - 2) 소요시간이 짧은 시간별로
*/

import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] jobs) {
        //대기큐 - 작업이 요청되는 시간별로 오름차순
        //Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        PriorityQueue<JobExec> waitQueue = new PriorityQueue<>((o1,o2) -> o1.start - o2.start);
            
        //작업큐 - 소요시간이 짧은 시간별로
        PriorityQueue<JobExec> workQueue = new PriorityQueue<>((o1,o2) -> o1.time - o2.time);
        
        int waitTime = 0; //작업대기시간
        int workTime = 0; //작업처리시간
        int waiting = 0; //대기중시간
        int done = 0; //완료된 작업수
        
        //배열순회하면서 대기큐에 추가
        for(int idx=0; idx<jobs.length; idx++){
            waitQueue.add(new JobExec(jobs[idx][0], jobs[idx][1]));
        }
        
        //작업을 전체 다 돌때까지 실행
        while(done < jobs.length){
            //현재 시간보다 이전에 시작된 작업들을 wait -> work 큐로 이동
            while(!waitQueue.isEmpty() && waitQueue.peek().start <= workTime){
               workQueue.offer(waitQueue.poll()); 
            }
            
            //만약 작업중인 큐가 없다면, 대기큐에서 가장 먼저 시작하는 작업이 시작
            if(workQueue.isEmpty()){
                waiting += waitQueue.peek().start - workTime;
                workTime = waitQueue.peek().start;
            }else{ //작업큐에서 소요시간이 가장 작은 작업 선택
                JobExec job = workQueue.poll();
                waitTime += workTime - job.start;
                workTime += job.time;
                // System.out.println(job.start+" "+job.time);
                done++;
            }
        }
        
        //평균계산
        int answer = (waitTime + workTime - waiting) / jobs.length;
        return answer;
    }
    
    //작업 class
    public class JobExec {
        int start, time;
        
        public JobExec(int start, int time){
            this.start = start;
            this.time = time;
        }
    }
}
