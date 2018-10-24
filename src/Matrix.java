import java.util.ArrayList;

public class Matrix {

    private ArrayList<ArrayList<Integer>> rows;

    Matrix(){
        rows = new ArrayList<ArrayList<Integer>>();
    }

    public void addNewRow(ArrayList<Integer>row){
        System.out.println("Added: ");
        for (Integer i: row
                ) {
            System.out.print(i + "\t");
        }

        rows.add(row);
    }

    public void printMatrix(){
        System.out.println("Mátrix kiírása");
        for (ArrayList<Integer> row: rows) {
            for (int i: row) {
                System.out.print(i + "\t");
            }
            System.out.print("\n");
        }
    }
}
