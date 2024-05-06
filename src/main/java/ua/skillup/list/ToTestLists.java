package ua.skillup.list;

public class ToTestLists {
    public static void main(String[] args) {

        // Testing of the unidirectional non-cyclic
        CustomList List01 = new CustomList();
        List01.push(12);
        List01.push(14);
        List01.push(16);
        List01.push(18);

        System.out.println(List01);
        System.out.println("Deleted last element: " + List01.pop() + "\n");
        System.out.println(List01);
        List01.push(20);
        System.out.println(List01);

        System.out.println("Deleted first element: " + List01.shift());
        System.out.println(List01);

        List01.unshift(15);
        System.out.println("List with added first element 15: \n" + List01);

        List01.push(22);
        List01.push(23);
        List01.push(24);
        System.out.println("Added 22 and 23 to the end: \n" + List01);


        List01.insert(0, 0);
        System.out.println("00 is inserted on 00 position: \n" + List01);

        List01.insert(2, 2);
        System.out.println("02 is inserted on 02 position: \n" + List01);

        List01.pop();
        System.out.println("Removed last element: \n" + List01);

        CustomList List02 = new CustomList();
//        List02.pop();


        System.out.println("Index of incorrect object: " + List01.indexOf(150));
        System.out.println("Index of the correct object: " + List01.indexOf(20));

        System.out.println("Removed element: " + List01.remove(5));
        System.out.println("The List with removed element with index 5: \n" + List01);

        System.out.println("The 4th element is : " + List01.get(3));

        System.out.println("Index of 22: " + List01.indexOf(22));

        //Test cases from tests

        CustomList emptyList;
        CustomList list;
        list = new CustomList();
        list.push("A");
        list.push("B");
        list.push("C");
        list.push("D");
        System.out.println(list);
        System.out.println(list.indexOf("D"));



        // My Homework is the directional cyclic (25 % 4 + 1 = 2)


    }

}
