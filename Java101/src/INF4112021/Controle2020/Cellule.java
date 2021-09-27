package INF4112021.Controle2020;

public class Cellule {

}

// la définition d'une cellule
abstract class Def {
    abstract int eval(Grid g);
}
// une définition est de deux sortes possibles
class Cst extends Def {
    int c;
    int eval(Grid g) { return this.c; }
}
class Sum extends Def {
    Ref r1, r2;
    int eval(Grid g) { return this.r1.eval(g) + this.r2.eval(g); }
}
// une référence à une cellule de la grille
class Ref {
    int row, col;
    int eval(Grid g) { return g.grid[this.row][this.col].eval(g); }
}
// une cellule de la grille
class Cell {
    Def def; // la définition de cette cellule
    int value; // sa valeur, une fois calculée
    int eval(Grid g) {
        this.value = this.def.eval(g);
        return this.value;
    }
}
// l'ensemble des cellules
class Grid {
    int N;
    Cell[][] grid; // de taille NxN
}
