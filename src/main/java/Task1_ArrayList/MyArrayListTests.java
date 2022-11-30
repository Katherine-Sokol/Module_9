package Task1_ArrayList;

public class MyArrayListTests {

    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();

        for (int i = 0; i < 20; i++) {
            myArrayList.add(i);
        }

//        MyArrayList <String> myArrayList = new MyArrayList<>();
//        myArrayList.add("abc");
//        myArrayList.add("vbn");
//        myArrayList.add("123");

        System.out.println("MyArrayList = " + myArrayList);

        System.out.println("get(i) = " + myArrayList.get(2));

        System.out.println("MyArrayList.size = " + myArrayList.size());

        System.out.println("remove(i) = " + myArrayList.remove(1));
        System.out.println("MyArrayList after remove(i) = " + myArrayList);
        System.out.println("MyArrayList.size after remove(i) = " + myArrayList.size());

        myArrayList.clear();
        System.out.println("MyArrayList after clear() = " + myArrayList);
        System.out.println("MyArrayList.size after clear() = " + myArrayList.size());
    }
}
