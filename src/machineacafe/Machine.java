package machineacafe;

public class Machine {
    private int _nombreCafésServis = 0;
    private double _argentEncaissé = 0;
    private boolean _eauDisponible = true;
    private int _nombreGobelets;
    private int _caféEnStock;
    private boolean _boutonSucreAppuyé = false;
    private int _stockSucre;

    public Machine(int nombreGobeletsInitial, int dosesCaféInitiales, int stockSucreInitial) {
        _nombreGobelets = nombreGobeletsInitial;
        _caféEnStock = dosesCaféInitiales;
        _stockSucre = stockSucreInitial;
    }

    private boolean PeutFaireUnCaféSimple(double somme){
        return somme >= 0.4 && _eauDisponible && _nombreGobelets > 0 && _caféEnStock > 0;
    }

    private boolean PeutFaireUnCaféSucré(double somme){
        return PeutFaireUnCaféSimple(somme) && _stockSucre > 0;
    }

    public void Insérer(double somme) {
        if(_boutonSucreAppuyé ? PeutFaireUnCaféSucré(somme) : PeutFaireUnCaféSimple(somme)){
            _argentEncaissé += somme;
            _nombreCafésServis ++;
            _nombreGobelets --;
            _caféEnStock --;

            if(_boutonSucreAppuyé){
                _stockSucre --;
            }
        }

        _boutonSucreAppuyé = false;
    }

    public int GetNombreCafésServis() {
        return _nombreCafésServis;
    }
    public double GetArgentEncaissé() {
        return _argentEncaissé;
    }
    public int GetStockSucre() { return _stockSucre; }

    public void CouperEau() {
        _eauDisponible = false;
    }
    public void SucrerCafé() { _boutonSucreAppuyé = true; }
}
