package practice;
// 단일연결리스트로 스택 만들기
public class Node<T> {
	private T data;
	private Node<T> link; //기본적으로 null값이 들어감.
	
	public Node(T data, Node<T> link) {
		super();
		this.data = data;
		this.link = link;
	}

	public Node(T data) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getLink() {
		return link;
	}

	public void setLink(Node<T> link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", link=" + link + "]";
	}
}
