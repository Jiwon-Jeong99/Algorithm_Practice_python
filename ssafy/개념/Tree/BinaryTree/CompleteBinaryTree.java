package Tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

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
		nodes[++lastIndex] = data; //처음에는 1부터 투입
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
	
	//같은 레벨의 노드 별로 알고 싶을 때
	public void bfs2() {
		if(isEmpty()) return;
		//탐색순서를 관리할 대기열 자료구조 생성
		Queue<Integer> queue =  new ArrayDeque<Integer>();
		//탐색 시작의 대상부터 큐에 넣기
		queue.offer(1); //루트노드의 인덱스(1부터 시작)
		
		int breadth = 0; //너비 지칭 변수 - 너비를 이용해서 탐색
		while(!queue.isEmpty()) {//큐가 비어있지 않으면 대기열에 탐색을 기다리는 노드가 존재
			int size = queue.size();//큐 크기 파악
			
			while(--size>=0) {//큐가 빌때까지
				int current = queue.poll();
				System.out.println(nodes[current]+"\t");
				if(current*2<=lastIndex) queue.offer(current*2);
				if(current*2+1<=lastIndex) queue.offer(current*2+1);
			}
			System.out.println();
			System.out.println("======="+breadth+"너비탐색완료");
			breadth++;
		}
	}
	
	//동일 너비끼리 보여주는 메서드
	public void bfs3() {
		if(isEmpty()) return;
		//탐색순서를 관리할 대기열 자료구조 생성
		Queue<int[]> queue =  new ArrayDeque<int[]>();//int[] : {탐색노드의 인덱스, 너비}
		//탐색 시작의 대상부터 큐에 넣기
		queue.offer(new int[] {1,0}); //루트노드의 인덱스(1부터 시작) , 하나 옆으로 갈때마다 간선 하나 추가인데 시작이니까 0
		
		while(!queue.isEmpty()) {//큐가 비어있지 않으면 대기열에 탐색을 기다리는 노드가 존재
			int[] info = queue.poll();
			int current = info[0];//탐색 대상 큐에서 꺼내기
			//탐색대상 방문처리
			System.out.println(nodes[current]+"//"+info[1]);
			//현재 탐색대상을 통해 탐색해야할 새로운 대상을 큐에 넣기
			//왼쪽 자식만 있을 수 있고, 둘다 있을 수도 있다.
			if(current*2<=lastIndex) queue.offer(new int[] {current*2, info[1]+1}); //왼쪽 자식
			if(current*2+1<=lastIndex) queue.offer(new int[] {current*2+1, info[1]+1}); //오른쪽 자식
		}
	}
	
	//bfs는 하나의 큐에서 꺼내서 전체 탐색
	//dfs는 하나의 노드만 제어 -> 재귀로 모든 노드 제어
	//현재 노드를 전위순회로 탐색
	public void dfsByPreOrder(int current) {
		//탐색대상 방문처리
		System.out.print(nodes[current]);
		//현재 탐색대상을 통해 탐색해야할 새로운 대상을 재귀 호출로 탐색시키기
		//current*2 => 매개변수) 내용:다음탐색노드
		if(current*2<=lastIndex) dfsByPreOrder(current*2); //왼쪽 자식
		if(current*2+1<=lastIndex) dfsByPreOrder(current*2+1); //오른쪽 자식
	
		//bfs에서 while(!~) 후에 queue.poll 후에 노드처리하는 부분
		//자식 노드를 탐색할 수 있게 작업(queue에 넣게) -> 내용 : 다음 탐색노드 정보
	}
	//중위
	public void dfsByInOrder(int current) {
		//현재 탐색대상을 통해 탐색해야할 새로운 대상을 재귀 호출로 탐색시키기
		//current*2 => 매개변수) 내용:다음탐색노드
		if(current*2<=lastIndex) dfsByInOrder(current*2); //왼쪽 자식
		System.out.print(nodes[current]);
		if(current*2+1<=lastIndex) dfsByInOrder(current*2+1); //오른쪽 자식
	
		//bfs에서 while(!~) 후에 queue.poll 후에 노드처리하는 부분
		//자식 노드를 탐색할 수 있게 작업(queue에 넣게) -> 내용 : 다음 탐색노드 정보
	}
	//후위
	public void dfsByPostOrder(int current) {
		//현재 탐색대상을 통해 탐색해야할 새로운 대상을 재귀 호출로 탐색시키기
		//current*2 => 매개변수) 내용:다음탐색노드
		if(current*2<=lastIndex) dfsByInOrder(current*2); //왼쪽 자식
		if(current*2+1<=lastIndex) dfsByInOrder(current*2+1); //오른쪽 자식
		System.out.print(nodes[current]);
		//bfs에서 while(!~) 후에 queue.poll 후에 노드처리하는 부분
		//자식 노드를 탐색할 수 있게 작업(queue에 넣게) -> 내용 : 다음 탐색노드 정보
	}
	
	public void dfs() {
		if(isEmpty()) return;
		//탐색순서를 관리할 대기열 자료구조 생성
		Stack<Integer> stack =  new Stack<Integer>();
		//탐색 시작의 대상부터 큐에 넣기
		stack.push(1); //루트노드의 인덱스(1부터 시작)
		
		while(!stack.isEmpty()) {//큐가 비어있지 않으면 대기열에 탐색을 기다리는 노드가 존재
			int current = stack.pop();//탐색 대상 큐에서 꺼내기
			//탐색대상 방문처리
			System.out.print(nodes[current]);
			//현재 탐색대상을 통해 탐색해야할 새로운 대상을 큐에 넣기
			//왼쪽 자식만 있을 수 있고, 둘다 있을 수도 있다.
			
			//왜 스택은 오른쪽 먼저 넣나?
			//스택은 선입후출이기 때문에 
			//꺼낼때 왼-오 순으로 나와야 하니까 오-왼 순으로 넣는다.
			//전위순회
			if(current*2+1<=lastIndex) stack.push(current*2+1); //오른쪽 자식
			if(current*2<=lastIndex) stack.push(current*2); //왼쪽 자식	
		}
	}
}

