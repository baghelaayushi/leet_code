import java.util.ArrayList;
import java.util.LinkedList;

public class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if (newInterval.end < newInterval.start) {
            int temp1 = newInterval.end;
            newInterval.end = newInterval.start;
            newInterval.start = temp1;
        }
        ArrayList<Interval> temp = new ArrayList<>();

        if (intervals.size() == 0){
            temp.add(newInterval);
            return temp;}
        else {
            // adding the first element
            // if start for new interval is less than the first element change it
            int i = 0;
            if (intervals.get(0).start >= newInterval.start && intervals.get(0).end >= newInterval.start) {
                temp.add(newInterval);
            }
            else {
                if (intervals.get(0).start >= newInterval.start) {
                    intervals.get(0).start = newInterval.start;
                }

                // this function adds the given interval in apt position
                for (Interval interval : intervals) {
                    if (temp.size() == 0 || temp.get(temp.size() - 1).end < newInterval.start){
                        if(interval.start > newInterval.start) {
                            temp.add(newInterval);
                            break;
                        }
                        else
                            temp.add(interval);
                    }

                    else {
                        temp.get(temp.size() - 1).end = Math.max(temp.get(temp.size() - 1).end, newInterval.end);
                        temp.get(temp.size() - 1).start = Math.min(temp.get(temp.size() - 1).start, newInterval.start);
                        break;
                    }
                    i++;
                }
            }

            if (i == intervals.size())
                temp.add(newInterval);
            System.out.println(i);

            // now starting from a given position iterating over the array
            for (int j = i; j < intervals.size(); j++) {
                if (temp.size() == 0 || temp.get(temp.size() - 1).end < intervals.get(j).start)
                    temp.add(intervals.get(j));
                else {
                    temp.get(temp.size() - 1).end = Math.max(temp.get(temp.size() - 1).end, intervals.get(j).end);
                }

            }

            return temp;

        }
    }
    public static void main(String args[]){
       Interval obj = new Interval(1,3);
       Interval obj1 = new Interval(5,6);
       Interval obj2 = new Interval(8,10);
       Interval obj3 = new Interval(15,18);
       Interval add = new Interval(2,7);
       ArrayList<Interval> intervals = new ArrayList<>();
       intervals.add(obj);
       intervals.add(obj1);
       intervals.add(obj2);
       intervals.add(obj3);
       System.out.println(intervals.size());
       System.out.println(intervals.get(intervals.size()-1).start);
       ArrayList<Interval> output = insert(intervals,add);
       int size = output.size();
       for(int i=0; i<size;i++)
           System.out.println(output.get(i).start +","+output.get(i).end);
    }
}
