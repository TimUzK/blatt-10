package h2;

public class Spielstein {

    private int currentRow;
    private int currentCol;
    private Spielbrett brett;

    public Spielstein(Spielbrett brett, int indexRow, int indexCol) {
        this.currentRow = indexRow;
        this.currentCol = indexCol;
        this.brett = brett;
    }

    public int getCurrentRow() {
        return currentRow;
    }
    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }
    public int getCurrentCol() {
        return currentCol;
    }
    public void setCurrentCol(int currentCol) {
        this.currentCol = currentCol;
    }
    public Spielbrett getBrett() {
        return brett;
    }
    public void setBrett(Spielbrett brett) {
        this.brett = brett;
    }

    private boolean movesOut() {
        Feld aktuellesFeld = brett.getBrett()[currentRow][currentCol];
        char dir = aktuellesFeld.getDirection();

        if (dir == 'U' && currentRow == 0) return true;
        if (dir == 'R' && currentCol == brett.getDim() - 1) return true;
        if (dir == 'L' && currentCol == 0) return true;
        if (dir == 'D' && currentRow == brett.getDim() - 1) return true;

        return false;
    }
    
    public void go(int n){
        if (n <= 0) {
            return;
        }

        Feld aktuellesFeld = brett.getBrett()[currentRow][currentCol];


        if (aktuellesFeld.isBoese() || movesOut()) {
            return;
        }

        char dir = aktuellesFeld.getDirection();
        if (dir == 'U') this.currentRow -= 1;
        else if (dir == 'R') this.currentCol += 1;
        else if (dir == 'L') this.currentCol -= 1;
        else if (dir == 'D') this.currentRow += 1;

        go(n-1);
    }
}
