package machineacafe;

import net.bank.interop.ModulePrelevementAutomatique;

public class Machine {
    private int _nombreCafésServis = 0;
    private double _argentEncaissé = 0;
    private Ressource _eau;
    private final RessourceStockée _gobelets;
    private final RessourceStockée _café;
    private final RessourceStockée _sucre;
    private boolean _boutonSucreAppuyé = false;

    private ModulePrelevementAutomatique _modulePrelevementAutomatique = null;

    public Machine(){
        _gobelets = new RessourceStockée(1);
        _café = new RessourceStockée(1);
        _sucre = new RessourceStockée(1);
        _eau = new RessourceInfinie(true);
    }

    public Machine(ModulePrelevementAutomatique module){
        this();
        _modulePrelevementAutomatique = module;
    }

    private boolean PeutFaireUnCaféSimple(double somme){
        return somme >= 0.4 && _eau.EstPrésente() && _gobelets.EstPrésente() && _café.EstPrésente();
    }

    private boolean PeutFaireUnCaféSucré(double somme){
        return PeutFaireUnCaféSimple(somme) && _sucre.EstPrésente();
    }

    public void Insérer(double somme) {
        if(_boutonSucreAppuyé ? PeutFaireUnCaféSucré(somme) : PeutFaireUnCaféSimple(somme)){
            _argentEncaissé += somme;
            _nombreCafésServis ++;
            _gobelets.Consommer();
            _café.Consommer();

            if(_boutonSucreAppuyé){
                _sucre.Consommer();
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
    public int GetStockSucre() { return _sucre.GetStock(); }

    public void CouperEau() {
        _eau = new RessourceInfinie(false);
    }
    public void SucrerCafé() { _boutonSucreAppuyé = true; }

    public void RéapprovisionnerCafé() {
        _café.Réapprovisionner();
    }

    public void RéapprovisionnerGobelet() {
        _gobelets.Réapprovisionner();
    }

    public void RéapprovisionnerSucre() {
        _sucre.Réapprovisionner();
    }

    public void PayerEnCB() {
        var somme = 0.40;
        var paiementRéussi = _modulePrelevementAutomatique.Prelever(somme);
        if (paiementRéussi) this.Insérer(somme);
    }
}
