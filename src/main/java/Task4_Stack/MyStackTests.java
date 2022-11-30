package Task4_Stack;

public class MyStackTests {

    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        for (int i = 0; i < 20; i ++) {
            myStack.push(i);
        }

//        MyStack<String> myStack = new MyStack<>();
//        myStack.push("abc");
//        myStack.push("vbn");
//        myStack.push("123");

        System.out.println("MyStack = " + myStack);

        System.out.println("peek() = " + myStack.peek());

        System.out.println("MyStack.size = " +myStack.size());

        System.out.println("pop() = " + myStack.pop());
        System.out.println("MyStack after first poll() = " + myStack);
        System.out.println("MyStack.size after first poll() = " + myStack.size());

        System.out.println("pop() = " + myStack.pop());
        System.out.println("MyStack after second poll() = " + myStack);
        System.out.println("MyStack.size after second poll() = " + myStack.size());

        System.out.println("remove(i) = " + myStack.remove(1));
        System.out.println("MyStack after remove(i) = " + myStack);
        System.out.println("MyStack.size after remove(i) = " + myStack.size());

        myStack.clear();
        System.out.println("MyStack after clear() = " + myStack);
        System.out.println("MyStack.size after clear() = " + myStack.size());
    }
}
