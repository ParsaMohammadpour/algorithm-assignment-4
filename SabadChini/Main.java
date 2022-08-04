import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Long> array;

    public static int number;

    public static long max = Long.MIN_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
        int end = 0;
        long current, pre = 0;
        array = new ArrayList<>();
        array.add((long) 0);
        for (int i = 0; i < number; i++) {
            current = scanner.nextLong();
            if ((i == 0) || (pre >= 0 && current >= 0) || (pre < 0 && current < 0)) {
                current += array.get(end);
                array.remove(end);
                array.add(current);
            } else {
                end++;
                array.add(current);
            }
            max = Long.max(max, array.get(end));
            pre = current;
        }
        if (array.get(array.size() - 1) <= 0) {
            array.remove(array.size() - 1);
            end--;
        }
        if (array.get(0) <= 0) {
            array.remove(0);
            end--;
        }
        if (end == 0) {
            System.out.println(max);
        } else if (end == 1) {
            System.out.println(Long.max(max, array.get(0) + array.get(1)));
        } else {
            findMaxBenefit();
            System.out.println(max);
        }
    }

    public static void findMaxBenefit() {
        long temp;
        for (int j = 0; j < array.size() - 2; j++) {
            if (array.get(j) < 0)
                continue;
            temp = array.get(j) + array.get(j + 1) + array.get(j + 2);
            if (Long.min(array.get(j), array.get(j + 2)) >= -array.get(j + 1)) {
                array.remove(j + 2);
                array.remove(j + 1);
                array.remove(j);
                array.add(j, temp);
                max = Long.max(max, temp);
                j--;
            }
        }
        if (array.size() == 1)
            return;
        for (int i = 0; i < array.size() - 1; i++) {
            if (array.get(i) < 0)
                continue;
            long[] tempLong = new long[array.size()];
            tempLong[i] = array.get(i);
            for (int j = i + 1; j < array.size(); j++) {
                tempLong[j] = tempLong[j - 1] + array.get(j);
                max = Long.max(tempLong[j], max);
            }
        }
    }
}