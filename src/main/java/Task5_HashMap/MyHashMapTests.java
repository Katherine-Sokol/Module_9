package Task5_HashMap;


public class MyHashMapTests {

    public static void main(String[] args) {
        MyHashMap <String, Integer> myHashMap = new MyHashMap<>();

        myHashMap.put("Mark", 15);
        myHashMap.put("Cat", 20);
        myHashMap.put("Flex", 11);
        myHashMap.put("Star", 30);
        myHashMap.put("Amur", 5);
        myHashMap.put("Dog", 18);
        myHashMap.put("Face", 1);
        myHashMap.put("Smile", 100);
        myHashMap.put("House", 50);

        System.out.println("MyHashMap = " + myHashMap);
        System.out.println("MyHashMap.size = " + myHashMap.size());

        System.out.println("get(i) = " + myHashMap.get("Alex"));
        System.out.println("get(i) = " + myHashMap.get("Mark"));

        System.out.println("remove(i) = " + myHashMap.remove("Cat"));
        System.out.println("MyHashMap after remove(i) = " + myHashMap);
        System.out.println("MyHashMap.size after remove(i) = " + myHashMap.size());

        myHashMap.clear();
        System.out.println("MyHashMap after clear() = " + myHashMap);
        System.out.println("MyHashMap.size after clear = " +myHashMap.size());
    }
}
