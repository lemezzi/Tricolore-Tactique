import java.util.Vector;

public class Player {
    private String name;
    private Vector<Integer> pieces;
    private static final int[][] WINNING_COMBINATIONS = {
        {1, 2, 3}, {4, 5, 6}, {7, 8, 9}, // Rows
        {1, 4, 7}, {2, 5, 8}, {3, 6, 9}, // Columns
        {1, 5, 9}, {7, 5, 3}             // Diagonals
    };
    public Player(String name) {
        this.name = name;
        this.pieces = new Vector<Integer>() ;
    }
    public Player() {
        this.name="Player";
        this.pieces = new Vector<Integer>();
    }
    public void addPiecePhase1(int targetButton){
        if (this.pieces.size() <=2)
            this.pieces.add(targetButton);
    }
    public void addPiecesPhase2(int target,int oldRoundedButton)
    {
        if (this.pieces.contains(oldRoundedButton)) {
            this.pieces.removeElement(oldRoundedButton);
        }
        this.pieces.add(target);
    }
    public String getName() {
        return name;
    }
    public Vector<Integer> getPieces() {
        return pieces;
    }
    public boolean hasPlayerWon() {
        Vector<Integer> pieces = this.getPieces();

        // Check if any of the winning combinations is a subset of the player's pieces
        for (int[] combination : WINNING_COMBINATIONS) {
            boolean hasWon = true;
            for (int cell : combination) {
                if (!pieces.contains(cell)) {
                    hasWon = false;
                    break;
                }
            }
            if (hasWon) {
                return true;
            }
        }
        return false;
    }
}
