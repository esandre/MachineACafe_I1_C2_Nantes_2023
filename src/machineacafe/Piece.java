package machineacafe;

public class Piece {

    public static Piece UnCent = new Piece(0.01);
    public static Piece DeuxCents = new Piece(0.02);
    private final double valeur;

    private Piece(double valeur){
        this.valeur = valeur;
    }

    public static double Somme(Iterable<Piece> pieces){
        return 0;
    }
}
