package Task3_Queue;


public class MyQueueTests {

    public static void main(String[] args) {
//        MyQueue<Integer> myQueue = new MyQueue<>();
//
//        for (int i = 0; i < 20; i ++) {
//            myQueue.add(i);
//        }

        MyQueue<String> myQueue = new MyQueue<>();
        myQueue.add("abc");
        myQueue.add("vbn");
        myQueue.add("123");

        System.out.println("MyQueue = " + myQueue);

        System.out.println("peek() = " + myQueue.peek());

        System.out.println("MyQueue.size = " + myQueue.size());

        System.out.println("poll() = " + myQueue.poll());
        System.out.println("MyQueue after first poll() = " + myQueue);
        System.out.println("MyQueue.size after first poll() = " + myQueue.size());

        System.out.println("poll() = " + myQueue.poll());
        System.out.println("MyQueue after second poll() = " + myQueue);
        System.out.println("MyQueue.size after second poll() = " + myQueue.size());

        myQueue.clear();
        System.out.println("MyQueue after clear() = " + myQueue);
        System.out.println("MyQueue.size after clear() = " + myQueue.size());
    }
}
