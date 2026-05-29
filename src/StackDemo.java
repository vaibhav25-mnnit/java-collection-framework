import java.util.Stack;

public class StackDemo {

    public static void runStackDemo()
    {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);

        stack.pop();
        stack.pop();
        System.out.println(stack);


        System.out.println("Peak element in stack: "+stack.peek());


        System.out.println("Find in stack: "+ stack.search(1));
        System.out.println("Find in stack: "+ stack.search(5));
    }
}
