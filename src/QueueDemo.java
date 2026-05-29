import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo  {
    public  static void runQueueDemo() {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue);

        System.out.println("Polling "+queue.poll());

        System.out.println(queue);


        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(1);

    }
}
