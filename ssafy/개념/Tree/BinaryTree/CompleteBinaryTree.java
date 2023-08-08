package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class CompleteBinaryTree<T> {
	private Object[] nodes;
	private int lastIndex; //채워진 마지막 노드의 인덱스
	private final int SIZE; //최대 노드의 개수
	
	public CompleteBinaryTree(int size) {
		this.SIZE = size;
		nodes = new Object[size+1];
	}
	
	public boolean isEmpty() {
		return lastIndex == 0; //1부터 사용할거니까 아무것도 저장되지 않은 상태
	}
	public boolean isFull() {
		return lastIndex == SIZE;
	}
	public boolean add(T data) {//데이터 받아오기
		if(isFull()) return false;
		nodes[++lastIndex] = data;
		return true;
	}
	
	public void bfs() {
		if(isEmpty()) return;
		//탐색순서를 관리할 대기열 자료구조 생성
		Queue<Integer> queue =  new ArrayDeque<Integer>();
		//탐색 시작의 대상부터 큐에 넣기
		queue.offer(1); //루트노드의 인덱스(1부터 시작)
		
		while(!queue.isEmpty()) {//큐가 비어있지 않으면 대기열에 탐색을 기다리는 노드가 존재
			int current = queue.poll();//탐색 대상 큐에서 꺼내기
			//탐색대상 방문처리
			System.out.println(nodes[current]);
			//현재 탐색대상을 통해 탐색해야할 새로운 대상을 큐에 넣기
			//왼쪽 자식만 있을 수 있고, 둘다 있을 수도 있다.
			if(current*2<=lastIndex) queue.offer(current*2); //왼쪽 자식
			if(current*2+1<=lastIndex) queue.offer(current*2+1); //오른쪽 자식
		}
	}
	
}
