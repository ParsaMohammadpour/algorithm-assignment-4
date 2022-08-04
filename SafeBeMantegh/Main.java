import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = scanner.nextInt();
        PriorityQueue<Integer> time = new PriorityQueue<>(Integer::compareTo);
        for (int i = 0; i < people; i++) {
            time.add(scanner.nextInt());
        }
        long sum = 0;
        double average = 0.0;
        long current;
        for (int i = 0; i < people; i++) {
            current = time.poll();
            sum += current;
            average += ((double) sum);
        }
        if (people != 0)
            average /= ((double) people);
        System.out.printf("%.2f", average);
    }
}