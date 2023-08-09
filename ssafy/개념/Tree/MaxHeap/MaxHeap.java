package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MaxHeap {
	private List<Integer> heap;
	
	public MaxHeap() {//MaxHeap의 arraylist 생성
		heap = new ArrayList<>();
	}
	
	//최대 힙에 새 원소 삽입
	public void push(int val) {
		heap.add(val);
		int idx = heap.size()-1; //인덱스니까 시작은 전체 heapSize-1
		
		//부모노드 < 새로넣는노드 일 때, 부모노드와 새로넣는노드 값의 위치를 바꾼다.
		//노드번호는 그대로
		while(idx>0 && heap.get((idx-1)/2) < heap.get(idx)) {
			swap((idx-1)/2, idx, heap.get((idx-1)/2), heap.get(idx));
			idx = (idx-1)/2; //부모노드로 인덱스로 다시 세팅
		}
	}
	
	//노드값 바꾸는 메서드
	public void swap(int to, int from, int a, int b) {
		int tmp=a;
		heap.set(to, b);
		heap.set(from, tmp);
	}
	
	//원소 삭제하기
	public int pop() {
		if(heap.isEmpty()) return 0;
		
		int delete = heap.get(0); //힙의 루트 노드 값을 가져온다.
		heap.set(0,  heap.get(heap.size()-1)); //루트 노드에 새로넣은노드값을 set한다.
		heap.remove(heap.size()-1); //새로넣은노드값을 삭제한다.
		
		int here=0; //루트 노드는 1부터 시작하지만, 큐에서 인덱스는 0부터 시작하므로 0으로 세팅
		while(true) {
			int left = here*2+1, right = here*2+2; //좌, 우 노드의 인덱스 초기화
			
			//기저조건1: 단말(리프)에 도달한 경우
			if(left>=heap.size()) break;
			
			//heap[here]이 루트노드에서 대소관계 비교하면서 내려갈 위치를 찾는다.
			int next= here;
			
			//here vs 왼쪽 자식 노드 비교
			if(heap.get(next) < heap.get(left)) { //왼쪽 자식 노드의 값이 더 클때
				next = left; //왼쪽 자식 노드 인덱스 할당
			}
			
			//위의 결과 vs 오른쪽 자식 노드 비교
			//오른쪽 자식 노드 값이 더 클때
			if(right < heap.size() && heap.get(next) < heap.get(right)) {
				next=right;
			}
			
			//기저조건2: 자식 노드 2개가 모두 자신과 같거나 이하일 때(더이상 next가 움직일 필요x)
			if(next==here) break;
			
			swap(here, next, heap.get(here), heap.get(next));
			here=next;
		}
		return delete;
	}
	
	public static void main(String[] args) {
		MaxHeap heap = new MaxHeap();
		Random random = new Random();
		
		for(int i=0; i<100; i++) {
			heap.push(random.nextInt(100));
		}
		
		System.out.println(heap);
		
		for(int i=0; i<100; i++) {
			System.out.println(heap.pop());
		}
	}
}
