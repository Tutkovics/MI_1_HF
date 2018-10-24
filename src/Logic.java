import java.util.ArrayDeque;
import java.util.Deque;

public class Logic {
    private Matrix matrix;
    private int[][][] getFrom;
    private Deque<int[]> queue = new ArrayDeque<>();
    private int[] currentState;

    Logic(Matrix m) {
        matrix = m;
        getFrom = new int[m.n][m.n][2];
        currentState = new int[]{0, 0};
    }

    public void solve() {

    }


}
