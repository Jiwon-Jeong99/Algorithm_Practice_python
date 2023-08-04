package exercise;
/**
 * swea_1218 괄호 짝짓기
 * @author 정지원
 *
 *1. 테스트케이스 입력받은만큼 반복
 *2.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1218 {
    static BufferedReader br;
    static StringBuilder sb;
    static int len; //문자열의 길이
    static String[] arr; //입력받은 bracket 담을 배열
    static String[] stack; //bracket이 짝이 맞는지 검증할 배열

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        int testCase = 10; //테스트케이스 입력받기
        for(int tc=1; tc<=testCase; tc++) { //테스트케이스만큼 반복
        	len = Integer.parseInt(br.readLine()); //문자열의 길이 입력받기
            String bracket = br.readLine(); //괄호들 입력받기
            arr = bracket.split(""); //괄호들 stack 배열에 넣기
            stack = new String[len]; //stack 초기화
            
            //arr 순회하며 bracket 살펴보기
            for(int idx=0; idx<len; idx++) {
            	stack[idx] = arr[idx]; //arr에서 첫번째 인덱스를 stack에도 넣어주는 메서드
            	
            	if(stack.length>1)
            }
            //if stack.length != 0 return 0
            //else return 1
        }
    }
    
    //pop : stack의 가장 상단 인덱스를 반환하고 삭제
    static String pop() {
        String lastIdx = stack[stack.length-1]; //stack 변경 전 마지막 인덱스값 저장
        String[] newStack = new String[stack.length-1]; //pop하고 난 뒤에 만들어질 배열 선언
        for(int idx=0; idx<stack.length-1; idx++) { //pop뒤에 만들어질 newStack 초기화
            newStack[idx] = stack[idx];
        }
        stack = newStack; // 주소값 재할당
        return lastIdx; //stack의 마지막 인덱스값 반환
    }
    
    //push : stack의 마지막에 값 추가
    static void push(String value) {
        String[] newStack = new String[stack.length+1];
        for(int idx=0; idx<stack.length+1; idx++) {
            if(idx == stack.length) newStack[idx] = value;
            else newStack[idx] = stack[idx];
        }
        stack = newStack;
    }
    
    //isEmpty : stack이 비었는지 체크
    static boolean isEmpty() {
        return (stack.length == 0) ? true : false;
    }
    
    //괄호의 짝이 맞았을 때, 두 괄호 모두 pop
    static void match() {
    	if
    }
}

//Stack 클래스
//class Stack {
//    static String[] arr;
//    static String[] stack; //괄호의 매칭을 담을 stack
//
//    Stack() {}
//    
//    Stack(String[] arr, String[] stack){ //매개변수 생성자
//        this.arr = arr;
//        this.stack = stack;
//    }
//
//    private String pop() {
//        String lastIdx = stack[stack.length-1]; //stack 변경 전 마지막 인덱스값 저장
//        String[] newStack = new String[stack.length-1]; //pop하고 난 뒤에 만들어질 배열 선언
//        for(int idx=0; idx<stack.length-1; idx++) { //pop뒤에 만들어질 newStack 초기화
//            newStack[idx] = stack[idx];
//        }
//        stack = newStack; // 주소값 재할당
//        return lastIdx; //stack의 마지막 인덱스값 반환
//    }
//    private void push(String value) {
//        String[] newStack = new String[stack.length+1];
//        for(int idx=0; idx<stack.length+1; idx++) {
//            if(idx == stack.length) newStack[idx] = value;
//            else newStack[idx] = stack[idx];
//        }
//        stack = newStack;
//    }
//
//    private boolean isEmpty() {
//        return (stack.length == 0) ? true : false;
//    }
//
//}
