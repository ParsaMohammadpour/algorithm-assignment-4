import java.util.Scanner;

public class Main {

    public static long[] values;

    public static long[] valueZeroToIndex;

    public static int numberOfPast[];

    public static int number;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
        values = new long[number + 1];
        valueZeroToIndex = new long[number + 1];
        numberOfPast = new int[number + 1];
        for (int i = 1; i < number + 1; i++) {
            values[i] = scanner.nextLong();
        }
        findMax();
        System.out.println(valueZeroToIndex[number]);
        System.out.println(numberOfPast[number]);
        print(number);
    }

    public static void findMax() {
        valueZeroToIndex[0] = 0;
        valueZeroToIndex[1] = values[1];
        numberOfPast[1] = 1;
        if (number == 1)
            return;
        numberOfPast[2] = 1;
        if (values[1] >= values[2]) {
            valueZeroToIndex[2] = values[1];
        } else {
            valueZeroToIndex[2] = values[2];
        }
        for (int i = 3; i <= number; i++) {
            if (valueZeroToIndex[i - 1] == valueZeroToIndex[i - 2]) {
                valueZeroToIndex[i] = values[i] + valueZeroToIndex[i - 1];
                numberOfPast[i] =numberOfPast[i - 1] + 1;
            } else {
                long temp = values[i] + valueZeroToIndex[i - 2];
                if (temp > valueZeroToIndex[i - 1]) {
                    valueZeroToIndex[i] = temp;
                    numberOfPast[i] = numberOfPast[i - 2] + 1;
                } else {
                    valueZeroToIndex[i] = valueZeroToIndex[i - 1];
                    numberOfPast[i] = numberOfPast[i - 1];
                }
            }
        }
    }

    public static void print(int number){
        if (number >= 1){
            if (valueZeroToIndex[number] != valueZeroToIndex[number - 1]){
                print(number - 2);
                System.out.print(number + " ");
            }else {
                print(number - 1);
            }
        }
    }
}