import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

//        String input =  "10 9 7\n" +
//                "8 0 19\n" +
//                "12 4 2\n" +
//                "1";

//        String str ="12 3 9 21 5 1 5 3 9 7\n"+
//        "11 12 6 9 1 0 5 6 12 3\n"+
//        "8 5 7 10 10 10 9 5 5 2\n"+
//        "8 5 5 6 10 10 12 3 9 6\n"+
//        "12 3 9 7 12 6 9 6 12 3\n"+
//        "11 10 12 1 5 5 2 13 1 6\n"+
//        "10 12 3 14 9 3 12 3 12 3\n"+
//        "8 3 10 9 6 12 3 12 3 10\n"+
//        "8 0 6 12 3 11 12 5 0 2\n"+
//        "12 4 5 5 6 12 5 5 4 2\n"+
//        "1";

        /**
         * Not working
         */
/*
        String firstLine = new Scanner(System.in).nextLine();
//        String firstLine = new Scanner(input).nextLine();
        int countNumbersInLine = firstLine.length() - firstLine.replace(" ", "").length() + 1;

        Matrix matrix = new Matrix(countNumbersInLine);

//        Scanner sc = new Scanner(input).useDelimiter("[ \\s]");
        Scanner sc = new Scanner(System.in).useDelimiter("\\n");

//        Scanner sc = new Scanner(System.in);

        int j = 0;
        while (sc.hasNextLine()) {
            int i = 0;
            int[] row = new int[countNumbersInLine];

            for (int n = 0; n < countNumbersInLine; n++) {
                if (!sc.hasNext()) { 
                   // System.out.println("break");
                    break;
                }
                int szam = Integer.parseInt(sc.next());
                row[i] = szam;
                //System.out.println(szam + " -- ");
                i++;
            }
            matrix.addNewRow(row, j);
            j++;
        }

//        String asd = matrix.printMatrix();
*/

//        Scanner sc = new Scanner(str).useDelimiter("\n");
//        String[] input = sc.nextLine().split(" ");
//        int len = input.length;
//        int[] row = new int[len];
//        //int numberOfLine = 0;
//
//
//        Matrix matrix = new Matrix(len);//inputArray.length);
//
//        for(int l = 0; l < len-1; l++) {
//            for (int i= 0; i < len; i++){
//                    row[i] = Integer.parseInt(input[i]);
//            }
//
//            for(int k = 0; k< len; k++)System.out.print(row[k] + " ");
//            System.out.println(" ");
//
//            matrix.addNewRow(row,l);
//
//            input = sc.nextLine().split(" ");
//
//
//        }
//
////        int[] row2 = new int[len];
//
//        for (int i= 0; i < len; i++){
//            row[i] = Integer.parseInt(input[i]);
//        }
//
////        for(int k = 0; k< len; k++)System.out.print(row[k] + " ");
////        System.out.println(" ");
//
//;

        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        String[] input = sc.nextLine().split(" ");

        int len = input.length;
        Matrix matrix = new Matrix(len);

        for(int i = 0; i < len; i++){
            matrix.matrix[0][i] = Integer.parseInt(input[i]);
        }

        int[] row = new int[len];
        int i = 1;

        while(sc.hasNextLine()){

            if(i == len){
                row[0]=Integer.parseInt(sc.nextLine());
                matrix.addNewRow(row,len);
            } else {
                input = sc.nextLine().split(" ");
                for(int k = 0; k < len; k++){
                    row[k] = Integer.parseInt(input[k]);
                }
                matrix.addNewRow(row, i);
            }
            i++;
        }

        matrix.addNewRow(row,len-1);

 //       System.out.println("Last: " + input[0]);

        sc.close();
//        while(sc.hasNextLine()){
//            input = sc.nextLine().split(" ");
//            System.out.println(Arrays.asList(input));
//        }
//        sc.close();

        //System.out.println(matrix.printMatrix());


        matrix.solve();

    }
}
