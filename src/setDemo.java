import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class setDemo {
    public static void runSetDemo()
    {
        Set<Integer> st = new HashSet<>();
        /*
            no duplicate elements and no order
            TC: O(1)
         */
        st.add(20);
        st.add(20);
        st.add(10);
        System.out.println(st);


        Set<Integer> st2 = new TreeSet<>();
        /*
            no duplicate ,but sorted order
            TC: O(log(n))
        */

        st2.add(20);
        st2.add(20);
        st2.add(20);
        st2.add(20);
        st2.add(20);
        st2.add(40);
        st2.add(10);
        st2.add(0);
        System.out.println(st2);
        //retainAll --> only stores the common elements of both sets in set1.


        Set<Integer> st3 = new LinkedHashSet<>();
        /*
            no duplicate ,but restores insertion order
            TC: O((n))
         */
        st3.add(4);
        st3.add(0);
        st3.add(3);
        st3.add(20);
        st3.add(20);
        st3.add(20);
        st3.add(20);
        st3.add(20);
        st3.add(10);
        st3.add(4);
        System.out.println(st3);


        HashSet<Student> st4 = new HashSet<>();
        st4.add(new Student(1,"Vaibhav"));
        st4.add(new Student(1,"Vaibhav"));
        st4.add(new Student(1,"Vaibhav"));
        st4.add(new Student(3,"Vaibhav"));
        System.out.println(st4);
    }
}
