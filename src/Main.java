
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String input =  "10 9 7\n" +
                        "8 0 19\n" +
                        "12 4 2\n" +
                        "1";


        String firstLine = new Scanner(input).nextLine();
        int countNumbersInLine =firstLine.length() - firstLine.replace(" ", "").length() + 1;

        Matrix matrix = new Matrix(countNumbersInLine);

        Scanner sc = new Scanner(input).useDelimiter("[ \\s]");

        int j = 0;
        while(sc.hasNextLine()) {
            int i = 0;
            int[] row = new int[countNumbersInLine];

            for(int n = 0; n < countNumbersInLine ; n++) {
                if(!sc.hasNext()){
                    break;
                }
                int szam = Integer.parseInt(sc.next());
                row[i] = szam;
                System.out.println(szam + " -- ");
                i++;
            }
            matrix.addNewRow(row, j);
            j++;
        }

        matrix.printMatrix();
        matrix.solve();



        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        queue.offer(2);
        System.out.print(queue.poll());
        System.out.print(queue.poll());
        queue.offer(3);
        queue.offer(4);
        System.out.print(queue.poll());
        System.out.print(queue.poll());
        System.out.print(queue.poll());


    }
}
