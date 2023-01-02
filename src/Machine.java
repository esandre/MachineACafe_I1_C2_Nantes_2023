public class Machine {
    private int _nombreCafésServis = 0;
    private double _argentEncaissé = 0;

    public void Insérer(double somme) {
        if(somme == 0.4){
            _argentEncaissé += 0.4;
            _nombreCafésServis ++;
        }
    }

    public int GetNombreCafésServis() {
        return _nombreCafésServis;
    }

    public double GetArgentEncaissé() {
        return _argentEncaissé;
    }
}
