import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) {
        try(BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer =new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] line =reader.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int question =Integer.parseInt(line[1]);
            long[][] matrix = new long[n + 1][n + 1];
            long temp;
            for (int i = 1; i < n + 1; i++) {
                temp = 0;
                line =reader.readLine().split(" ");
                for (int j = 1; j < n + 1; j++) {
                    temp += Long.parseLong(line[j - 1]);
                    if (i != 1) {
                        matrix[i][j] = temp + matrix[i - 1][j];
                    } else {
                        matrix[i][j] = temp;
                    }
                }
            }
            int minX, minY, maxX, maxY;
            for (int i = 0; i < question; i++) {
                line =reader.readLine().split(" ");
                minX = Integer.parseInt(line[0]);
                minY = Integer.parseInt(line[1]);
                maxX = Integer.parseInt(line[2]);
                maxY = Integer.parseInt(line[3]);
                writer.write(Long.toString(matrix[maxX][maxY] + matrix[minX - 1][minY - 1] - matrix[maxX][minY - 1] - matrix[minX - 1][maxY]) + "\n");
                writer.flush();
            }
        }catch (Exception e){e.printStackTrace();}
    }
}
