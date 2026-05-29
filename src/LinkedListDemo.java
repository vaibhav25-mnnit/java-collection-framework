import java.util.*;

public class LinkedListDemo {

    public static void runLinkedListDemo()
    {
        //normal add
        List<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(33) ;
        list.add(234) ;
        System.out.println(list);


        List<Integer> list2 = new LinkedList<>();
        list2.add(1);
        list2.add(3);
        list2.add(5);
        System.out.println(list2);

        //add ALL --> add one list into another
        list.addAll(list2);
        System.out.println(list);
        System.out.println(list.size());

        //clear
        list2.clear();
        System.out.println(list2.size());

        //iterator --> it's a fancy way of traversing a collection, can be done on any collection

        Iterator<Integer> itr = list.iterator();
        while(itr.hasNext())
        {
            System.out.println("Element via iterator :"+ itr.next());
        }


        //methods specific to arrayList

        List<Integer> list3 = new LinkedList<>();
        list3.add(10);
        list3.add(20);
        list3.add(30);

        //1--> get --> get the element at given index
        System.out.println(list3.get(0));//10
        System.out.println(list3.get(2)); //30

        //2-> set --> set the given element at the index
        System.out.println("ArrayList before set : " + list3);
        list3.set(0,100);
        System.out.println("ArrayList after set: "+ list3);

        //3-->toArray --> converts any collection into array , return type is object array
        Object[] arr = list3.toArray();

        for(Object obj:arr)
        {
            System.out.println(obj);
        }

        //4-->contains --> checks weather the element is present in list or not , return type is boolean
        System.out.println("Contains " + list3.contains(20));
        System.out.println("Contains " + list3.contains(211));

        //5--> sort
        System.out.println("List one before sort:"+list);
        Collections.sort(list); //default asscending
        System.out.println("List one after sort: "+list);

        //sort with comparator
        Collections.sort(list,(a,b)-> Integer.compare(a,b)); //sorts asscending type
        System.out.println("List one after asscending sort: "+list);
        Collections.sort(list,(a,b)-> Integer.compare(b,a)); //sorts decending type
        System.out.println("List one after decending sort: "+list);


        //6--> clone (creates shallow copy) is not supported in case of linked list
//        ArrayList<Integer>  clonedList = (ArrayList<Integer>)list.clone();
//
//        System.out.println("Cloned list: "+clonedList+"\nOriginal List: "+list);
//        list.add(355);
//        System.out.println("Cloned list: "+clonedList+"\nOriginal List: "+list);


        //7 --> ensureCapacity --> It's not there for linked list
        List<Integer> list4 = new LinkedList<>();
//        list4.ensureCapacity(10);

        //8--> isEmpty() --> returns boolean if the list is empty or not

        System.out.println("List1 "+ list.isEmpty());
        System.out.println("List2 "+ list4.isEmpty());

        //9-->indexOf() --> returns the index of desired element, if not present returns -1
        System.out.println("Index of "+list.indexOf(355));


        LinkedList<Integer> list5 = new LinkedList<>();
        list5.addFirst(1);
        list5.addFirst(2);
        System.out.println(list5);

        list5.addLast(9);
        list5.addLast(8);
        System.out.println(list5);


        System.out.println(list5.getFirst());
        System.out.println(list5.getLast());

        System.out.println(list5.peek());
        System.out.println(list5);
        System.out.println(list5.poll());
        System.out.println(list5);
    }
}
