import java.util.ArrayDeque;
import java.util.Deque;

public class Matrix {

    private int[][] matrix;
    public int n;
    private int numberOfItems;
    private int[][][] getFrom;
    private Deque<int[]> queue;
    private int[] currentState;
    private int foundItems = 0;
    private int[] previousState;
    private int[] waiting;

    Matrix(int n) {
        this.n = n;
        matrix = new int[n][n];
        getFrom = new int[n][n][2];
        queue = new ArrayDeque<>();
        currentState = new int[]{0, 0};
        previousState = new int[]{0, 0};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                getFrom[i][j] = null;
            }
        }
        getFrom[0][0] = new int[]{-1, -1};
        waiting = new int[]{0, 0};
    }

    public void addNewRow(int[] row, int j) {
        if (j < n) {
            matrix[j] = row;
            return;
        } else if (j == n) {
            numberOfItems = row[0];
        }
    }

    public String printMatrix() {
        String res = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res.concat(matrix[i][j] + "\t");
                System.out.print(matrix[i][j] + "\t");
            }
            res.concat("\n");
            System.out.print("\n");
        }
        return res;
    }

    public int getIndexOf(int i, int j) {
        return i * n + j;
    }

    public int[] getCoordinatesFromIndex(int i) {
        return new int[]{(i / n), i % n};
    }

    public boolean canGoUp(int[] state) {
        char[] bin = Integer.toBinaryString(matrix[state[0]][state[1]]).toCharArray();
        return bin[bin.length - 1] != '1' && state[0] != 0;
    }

    public boolean canGoRight(int[] state) {
        char[] bin = Integer.toBinaryString(matrix[state[0]][state[1]]).toCharArray();
        if (bin.length < 2) return state[1] != n - 1;
        else return bin[bin.length - 2] != '1';
    }

    public boolean canGoDown(int[] state) {
        char[] bin = Integer.toBinaryString(matrix[state[0]][state[1]]).toCharArray();
        if (bin.length < 3) return state[0] != n - 1;
        else return bin[bin.length - 3] != '1';
    }

    public boolean canGoLeft(int[] state) {
        char[] bin = Integer.toBinaryString(matrix[state[0]][state[1]]).toCharArray();
        if (bin.length < 4) return state[1] != 0;
        else return bin[bin.length - 4] != '1';
    }


    public boolean hasItem(int[] state) {
        char[] bin = Integer.toBinaryString(matrix[state[0]][state[1]]).toCharArray();
        return bin.length == 5;
    }


    public void solve() {
        queue.offer(new int[]{0, 0});

        while (queue.size() != 0 || numberOfItems != foundItems || !isVisited(new int[]{n - 1, n - 1})) {
            currentState = queue.poll();
            //p("\nCurrentState: " + currentState[0] +", "+currentState[1]);
            if (canGoRight(currentState)) {
                if (!isVisited(new int[]{currentState[0], currentState[1] + 1})) {
                    getFrom[currentState[0]][currentState[1] + 1] = currentState;
                    queue.offer(new int[]{currentState[0], currentState[1] + 1});
                }

            }
            if (canGoDown(currentState)) {
                if (!isVisited(new int[]{currentState[0] + 1, currentState[1]})) {
                    getFrom[currentState[0] + 1][currentState[1]] = currentState;
                    queue.offer(new int[]{currentState[0] + 1, currentState[1]});
                }
                //p(currentState[0] +", "+currentState[1] +" can go down");
            }
            if (canGoUp(currentState)) {
                if (!isVisited(new int[]{currentState[0] - 1, currentState[1]})) {
                    getFrom[currentState[0] - 1][currentState[1]] = currentState;
                    queue.offer(new int[]{currentState[0] - 1, currentState[1]});
                }
            }
            if (canGoLeft(currentState)) {
                if (!isVisited(new int[]{currentState[0], currentState[1] - 1})) {
                    getFrom[currentState[0]][currentState[1] - 1] = currentState;
                    queue.offer(new int[]{currentState[0], currentState[1] - 1});
                }
            }
            if (hasItem(currentState)) {
                getPath(waiting, currentState);
                waiting = currentState;
                System.out.println("felvesz");
                //p("Új kincs");
                foundItems++;
            }

            //p("\ngetFrom[i][j] = ["+previousState[0] + ", "+ previousState[1] + "]" );
            previousState = currentState;
            //System.out.print("\nQueue:");
            //for (int[] a: queue) {
            //   System.out.print(" --> " + a[0] + ", " + a[1] + " ");
            //}
        }
//        p("Doen");
//        int[] b;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                b = getFrom[i][j];
//                if (b != null) System.out.print("[" + b[0] + "," + b[1] + "]\t");
//                else System.out.print("[null]\t");
//
//            }
//            p("");
//        }
        getPath(waiting, new int[]{n - 1, n - 1});
        System.out.print("\n");

        //p("Minden kincs megvan");


    }

    private void getPath(int[] start, int[] finish) {
        Deque<int[]> stack = new ArrayDeque<>();
        while (!sameState(start, finish)) {
            stack.push(finish);
            finish = getFrom[finish[0]][finish[1]];
        }
        int steps = stack.size();
        for (int i = 0; i < steps; i++) {
            start = stack.poll();
            System.out.println(start[0] + " " + start[1]);
        }
    }

    public void p(String str) {
        System.out.println(str);
    }

    public boolean sameState(int[] a, int[] b) {
        return (a[0] == b[0] && a[1] == b[1]) || (a[0] == -1 && a[1] == -1) || (b[0] == -1 && b[1] == -1);
    }

    public boolean isVisited(int[] a) {
        if (getFrom[a[0]][a[1]] == null) return false;
        return true;
    }


}
