import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * MeetingRooms2
 */
public class MeetingRooms2 {


    public static void main(String[] args) {
        Interval in1 = new Interval(0,30);
        Interval in2 = new Interval(4, 9);
        Interval in3 = new Interval(5,15);
        Interval in4 = new Interval(10,16);

        Interval[] intervals = {in1,in2,in3,in4};

        MeetingRooms2 a = new MeetingRooms2();
        
        System.out.println(a.solve(intervals));

    }

    public int solve(Interval[] intervals){
        if(intervals == null || intervals.length == 0) return 0;
        //1. 소팅
        Arrays.sort(intervals, (Interval a, Interval b)->a.start-b.start);

        //2. minHeap
        Queue<Interval> heap = new PriorityQueue<>((Interval a, Interval b)->a.end-b.end);
        
        heap.offer(intervals[0]);
        for(int i=1;i<intervals.length;i++){

            if(heap.peek().end <= intervals[i].start){
                heap.poll();
            }
            heap.offer(intervals[i]);
        }

        return heap.size();

    }

    
    public void print(Interval[] intervals){
        for(int i=0; i<intervals.length; i++){
            Interval in = intervals[i];
            System.out.println(in.start+" "+in.end);
        }
    }
}