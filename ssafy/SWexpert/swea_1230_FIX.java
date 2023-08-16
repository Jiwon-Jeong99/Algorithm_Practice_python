package java_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_1230_FIX {
	static BufferedReader br;
	static StringTokenizer st;
	
	static int size; //암호문 개수
	static ArrayList<String> origin; //원본 암호문
	static int saySize; //명령어 개수
	static String[] say; //암호문
	static ArrayList<String> result; //최종 변경된 리스트
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc=1; tc<=10; tc++) {
			size = Integer.parseInt(br.readLine().trim());
			String[] arr = br.readLine().trim().split(" ");
			origin = new ArrayList<>(Arrays.asList(arr)); //배열 -> arrayList
			saySize = Integer.parseInt(br.readLine().trim());
			say = br.readLine().trim().split(" ");
			
			System.out.print("#"+tc+" ");
			for(int finalIdx=0; finalIdx<10; finalIdx++) {
				System.out.print(origin.get(finalIdx)+" ");
			}
			System.out.println();
		}
	}
	static void hash() {
		int index=0; //say배열 순회용
		
		int idx=0; //암호문 수정용 인덱스
		int many=0; //몇개의 암호문 변경
		String str = ""; //변경하고싶은 암호문
		
		while(index<saySize) {
			if(say[index].equals("I")) {//삽입
				idx = Integer.parseInt(say[index+1]); //origin에 대입한 인덱스
				many = Integer.parseInt(say[index+2]);
				for(int n=0; n<many; n++) {
					str = say[index+3+n];
					origin.add(idx+n, str);
				}
				index += 2+many; //인덱스값 재세팅
			}else if(say[index].equals("D")) {//삭제
				idx = Integer.parseInt(say[index+1]);
				many = Integer.parseInt(say[index+2]);
				for(int n=0; n<many; n++) {
					origin.remove(idx);
				}
				index += 3;
			}else if(say[index].equals("A")) {//추가
				many = Integer.parseInt(say[index+1]);
				for(int n=0; n<many; n++) {
					origin.add(say[index+2+n]);
				}
				index += 1+many;
			}
		}
	}
}
