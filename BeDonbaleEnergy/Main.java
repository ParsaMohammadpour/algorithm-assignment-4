import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        long sum = 0;
        PriorityQueue<Integer> charge = new PriorityQueue<>(Integer::compareTo);
        int temp;
        for (int i = 0; i < n; i++) {
            temp = scanner.nextInt();
            if (temp != 100)
                charge.add(temp);
        }
        if (charge.size() > 1) {
            int min = charge.poll();
            boolean isCompleted = false;
            outer:
            while (min >= x) {
                if (charge.size() == 0) {
                    isCompleted = true;
                    break;
                }
                temp = charge.poll();
                while (true) {
                    if (min < x) {
                        isCompleted = false;
                        break outer;
                    }
                    min -= x;
                    temp += y;
                    if (temp >= 100)
                        break;
                }
                if (charge.size() == 0) {
                    isCompleted = true;
                    break;
                }
            }
            if (isCompleted)
                System.out.println("YES");
            else
                System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
