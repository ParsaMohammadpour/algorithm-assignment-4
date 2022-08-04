import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = (long) scanner.nextInt();
        long a = (long) scanner.nextInt();
        long b = (long) scanner.nextInt();
        PriorityQueue<Long> cordinates = new PriorityQueue<>(Long::compareTo);
        for (long i = 0; i < n; i++) {
            cordinates.add((long) scanner.nextInt());
        }
        System.out.println(findMax(cordinates, Long.min(a, b), Long.max(a, b)));
    }

    private static long findMax(PriorityQueue<Long> temp, long min, long max) {
        long price = min * temp.size();
        long pre = temp.poll(), current;
        long diff = max - min;
        ArrayList<ArrayList<Long>> cordinates = new ArrayList<>();
        cordinates.add(new ArrayList<>());
        cordinates.get(0).add(pre);
        int counter = 0;
        while (temp.size() > 0){
            current = temp.poll();
            if (current - pre > max)
                return -1;
            if (pre + min < current) {
                cordinates.add(new ArrayList<>());
                counter++;
            }
            cordinates.get(counter).add(current);
            pre = current;
        }
        if (cordinates.size() == 1)
            return price;
        if (cordinates.size() == 2)
            return (price + + diff + diff);
        pre = cordinates.get(0).get(cordinates.get(0).size() - 1);
        price +=diff;
        counter = 1;
        long help, special=0;
        while (counter < cordinates.size()){
            current = -1;
            price+=diff;
            help = cordinates.get(counter - 1).get(cordinates.get(counter - 1).size() - 1);
            for (int i = 0; i < cordinates.get(counter).size(); i++) {
                if (pre + max >= cordinates.get(counter).get(i))
                    current = cordinates.get(counter).get(i);
                if (help + max >= cordinates.get(counter).get(i))
                    special = cordinates.get(counter).get(i);
                else
                    break;
            }
            if (current == -1){
                price +=diff;
                pre = special;
            }else {
                pre = current;
            }
            counter ++;
        }
        return price;
    }
}