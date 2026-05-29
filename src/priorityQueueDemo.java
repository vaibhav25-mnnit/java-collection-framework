import java.util.PriorityQueue;

public class priorityQueueDemo {
    public static void runPriorityQueueDemo()
    {

        PriorityQueue<Integer> pq = new PriorityQueue<>();//Default behaviour is less is at top --> min head

        pq.offer(12);
        pq.offer(89);
        pq.offer(1);
        pq.offer(0);
        pq.offer(13);

        System.out.println(pq);

        System.out.println(pq.peek());
        System.out.println(pq);
        System.out.println(pq.poll());
        System.out.println(pq);

        System.out.println("-----------------------------------------");
        PriorityQueue<Integer> maxHeap= new PriorityQueue<>((a,b) -> Integer.compare(b,a));//This is a max heap converted using custom comparator

        maxHeap.offer(1);
        maxHeap.offer(3);
        maxHeap.offer(44);

        System.out.println(maxHeap);
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap);

    }
}
