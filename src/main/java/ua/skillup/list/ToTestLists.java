package ua.skillup.list;

public class ToTestLists {
    public static void main(String[] args) {

        // Testing of the unidirectional non-cyclic
        CustomList List01 = new CustomList();
        List01.push(12);
        List01.push(14);
        List01.push(16);

        System.out.println(List01);
        System.out.println("Deleted last element: " + List01.pop() + "\n");
        System.out.println(List01);
        List01.push(20);
        System.out.println(List01);

        System.out.println("Deleted first element: " + List01.shift());
        System.out.println(List01);

        List01.unshift(15);
        System.out.println("List with added first element 15: \n" + List01);

        List01.insert(1, 17);
        System.out.println("17 is inserted on 01 position: \n" + List01);

        System.out.println("Index of incorrect object: " + List01.indexOf(150));
        System.out.println("Index of the correct object: " + List01.indexOf(14));

        List01.remove(2);
        System.out.println("The List with removed element with index 2: \n" + List01);

        // My Homework is the unidirectional cyclic (25 % 4 + 1 = 2)


    }

}
