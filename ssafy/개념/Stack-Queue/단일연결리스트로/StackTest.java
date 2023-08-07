package practice;

public class StackTest {
	public static void main(String[] args) {
		IStack<String> stack = new LinkedListStack<String>();
		System.out.println(stack.size()+"//"+stack.isEmpty());
		stack.push("정지원");
		stack.push("아이리스");
		stack.push("싸피");
		stack.push("마우스");
		System.out.println(stack.peek());
		System.out.println(stack.size()+"//"+stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.size()+"//"+stack.isEmpty());
		System.out.println(stack.pop());
	}
}
