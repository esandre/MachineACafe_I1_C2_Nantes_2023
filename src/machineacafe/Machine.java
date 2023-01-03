package machineacafe;

public class Machine {
    private int _nombreCafésServis = 0;
    private double _argentEncaissé = 0;
    private boolean _eauDisponible = true;
    private int _stockGobelets;
    private int _stockCafé;
    private boolean _boutonSucreAppuyé = false;
    private int _stockSucre;

    public Machine(){
        _stockSucre = 1;
        _stockCafé = 1;
        _stockGobelets = 1;
    }

    private boolean PeutFaireUnCaféSimple(double somme){
        return somme >= 0.4 && _eauDisponible && _stockGobelets > 0 && _stockCafé > 0;
    }

    private boolean PeutFaireUnCaféSucré(double somme){
        return PeutFaireUnCaféSimple(somme) && _stockSucre > 0;
    }

    public void Insérer(double somme) {
        if(_boutonSucreAppuyé ? PeutFaireUnCaféSucré(somme) : PeutFaireUnCaféSimple(somme)){
            _argentEncaissé += somme;
            _nombreCafésServis ++;
            _stockGobelets--;
            _stockCafé--;

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

    public void RéapprovisionnerCafé() {
        _stockCafé++;
    }

    public void RéapprovisionnerGobelet() {
        _stockGobelets++;
    }

    public void RéapprovisionnerSucre() {
        _stockSucre ++;
    }
}
