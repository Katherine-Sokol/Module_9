package Task2_LinkedList;


public class MyLinkedListTests {

    public static void main(String[] args) {
//        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
//
//        for (int i = 0; i < 20; i ++) {
//            myLinkedList.add(i);
//        }

        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("abc");
        myLinkedList.add("vbn");
        myLinkedList.add("123");

        System.out.println(" MyLinkedList = " + myLinkedList);

        System.out.println("get(i) = " + myLinkedList.get(1));

        System.out.println(" MyLinkedList.size = " + myLinkedList.size());

        System.out.println("remove(i) = " + myLinkedList.remove(0));
        System.out.println("MyLinkedList after remove(i) = " + myLinkedList);
        System.out.println("MyLinkedList.size after remove(i) = " + myLinkedList.size());

        myLinkedList.clear();
        System.out.println("MyLinkedList after clear() = " + myLinkedList);
        System.out.println("MyLinkedList.size after clear() = " + myLinkedList.size());
    }
}
