package h1;

public class Cell {
    
    private int indexRow;
    private int indexCol;
    private boolean alive;
    private int numLivingNeighbors;
    private boolean isAliveNextGen;

    public Cell(int indexRow, int indexCol, boolean alive) {
        this.indexRow = indexRow;
        this.indexCol = indexCol;
        this.alive = alive;
    }

    public Cell(int indexRow, int indexCol) {
        this.indexRow = indexRow;
        this.indexCol = indexCol;
        this.alive = false; 
    }

    public int getIndexRow() {
        return indexRow;
    }

    public void setIndexRow(int indexRow) {
        this.indexRow = indexRow;
    }

    public int getIndexCol() {
        return indexCol;
    }

    public void setIndexCol(int indexCol) {
        this.indexCol = indexCol;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getNumLivingNeighbors() {
        return numLivingNeighbors;
    }

    public void setNumLivingNeighbors(int numLivingNeighbors) {
        this.numLivingNeighbors = numLivingNeighbors;
    } 

    public boolean isAliveNextGen() {
        return isAliveNextGen;
    }

    public void setAliveNextGen(boolean isAliveNextGen) {
        this.isAliveNextGen = isAliveNextGen;
    }


    public void countLivingNeighbors(Cell[][] gridArray) {
        int count = 0;

        int maxRow = gridArray.length;
        int maxCol = gridArray[0].length;

        for (int r = indexRow - 1; r <= indexRow + 1; r++) {
            for (int c = indexCol - 1; c <= indexCol + 1; c++) {
                if (r == indexRow && c == indexCol) {
                    continue;
                }
                if (r >= 0 && r < maxRow && c >= 0 && c < maxCol) {
                    if (gridArray[r][c].isAlive()) {
                        count++;
                    }
                }
            }
        }

        this.numLivingNeighbors = count;
        decideNextStatus();
    }

    private void decideNextStatus() {
        if (this.alive) {
            this.isAliveNextGen = (numLivingNeighbors == 2 || numLivingNeighbors == 3);
        } else {
            this.isAliveNextGen = (numLivingNeighbors == 3);
        }        
    }
}
