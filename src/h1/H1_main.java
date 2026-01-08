package h1;

public class H1_main {
    public static void main(String[] args) {
       Cell[] startMuster = {
        new Cell(1, 0), new Cell(1, 1), new Cell(1, 2)
    };

    // Erstelle ein 3x3 Gitter
    Grid grid = new Grid(startMuster, 3, 3);

    // Test: Erste Generation berechnen
    grid.computeNextGen();

    // Check: Die mittlere Spalte sollte nun leben, die Zeile tot sein
    Cell[][] array = grid.getGridArray();
    for (int r = 0; r < 3; r++) {
        for (int c = 0; c < 3; c++) {
            System.out.print(array[r][c].isAlive() ? "1 " : "0 ");
        }
        System.out.println();
    } 
    }
}
