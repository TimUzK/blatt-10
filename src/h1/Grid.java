package h1;

public class Grid {

    private Cell[][] gridArray;

    public Grid(Cell[] cells, int gridRows, int gridCols) {
        this.gridArray = new Cell[gridRows][gridCols];

        for (int r = 0; r < gridRows; r++) {
            for (int c = 0; c < gridCols; c++) {
                gridArray[r][c] = new Cell(r, c);
            }
        }

        if (cells != null) {
            for (Cell startCell : cells) {
                int r = startCell.getIndexRow();
                int c = startCell.getIndexCol();

                if (r >= 0 && r < gridRows && c >= 0 && c < gridCols) {
                    gridArray[r][c].setAlive(true);
                }
            }
        }

        for (int r = 0; r < gridArray.length; r++) {
            for (int c = 0; c < gridArray[0].length; c++) {
                gridArray[r][c].countLivingNeighbors(gridArray);
            }
        }
    }

    public Cell[][] getGridArray() {
        return gridArray;
    }

    public void setGridArray(Cell[][] gridArray) {
        this.gridArray = gridArray;
    }

    public void computeNextGen() {
        int rows = gridArray.length;
        int cols = gridArray[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                gridArray[r][c].setAlive(
                        gridArray[r][c].isAliveNextGen()
                );
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                gridArray[r][c].countLivingNeighbors(gridArray);
            }
        }
    }

    public void computeGeneration(int n) {
        for (int i = 0; i < n; i++) {
            computeNextGen();
        }
    }
}