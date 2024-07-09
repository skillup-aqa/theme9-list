package ua.skillup.list;

public class ToTestLists {
    // My Homework is the directional cyclic (25 % 4 + 1 = 2)
    public static void main(String[] args) {


        CustomList List01 = new CustomList();
        List01.push(12);
        List01.push(14);
        List01.push(16);
        List01.push(18);


        System.out.println(List01);
        System.out.println("Deleted first element: " + List01.shift());
        System.out.println(List01);
        System.out.println("Deleted end element: " + List01.pop());
        System.out.println(List01);

        CustomList List02 = new CustomList();
        List02.push(20);
        List02.push(21);
        List02.push(22);
        List02.push(23);
        List02.push(24);
        List02.push(25);
        System.out.println(List02.get(5));

        List02.unshift(19);
        System.out.println(List02);
        List02.insert(6, 55);
        System.out.println(List02);
        System.out.println(List02.indexOf(19));
        System.out.println("----------------");
        System.out.println(List02.remove(0));
        System.out.println(List02);
        System.out.println(List02.remove(0));
        System.out.println(List02.pop());
        System.out.println(List02.pop());
        System.out.println(List02.pop());
        System.out.println(List02);
        List02.insert(0, 5);
        System.out.println(List02);
        System.out.println(List02.pop());
        System.out.println(List02);

        CustomList List03 = new CustomList();
        List03.push(30);
        System.out.println(List03.pop());
    }

}
