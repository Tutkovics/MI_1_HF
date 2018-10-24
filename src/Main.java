import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String input =  "10 9 7\n" +
                        "8 0 19\n" +
                        "12 4 2\n" +
                        "1";

        int numberOfElements = 0;
        ArrayList<Integer> row = new ArrayList<>();
        Matrix matrix = new Matrix();

        Scanner sc = new Scanner(input);

        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            Scanner scanner = new Scanner(line).useDelimiter("[ \\s]");
            System.out.println("New line");

            row.clear();
            System.out.println("Scanner length: ");
            while(scanner.hasNext()){
                row.add(Integer.parseInt(scanner.next()));
            }

            matrix.addNewRow(row);

        }

        matrix.printMatrix();
    }
}
