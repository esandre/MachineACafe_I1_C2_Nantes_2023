import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MachineACafeTest {
    @Test
    @DisplayName("QUAND on met 40cts ALORS un café coule ET l'argent est encaissé")
    public void Test_Cafe_Coule(){
        // ETANT DONNE une machine
        Machine machine = new Machine();
        int nombreCaféInitiaux = machine.GetNombreCafésServis();
        double argentEncaisséInitial = machine.GetArgentEncaissé();
        double sommeInsérée = 0.40;

        // QUAND on met 40cts
        machine.Insérer(sommeInsérée);

        // ALORS un café coule
        int nombreCafésFinaux = machine.GetNombreCafésServis();
        assertEquals(nombreCaféInitiaux + 1, nombreCafésFinaux);

        // ET l'argent est encaissé
        double argentEncaisséFinal = machine.GetArgentEncaissé();
        assertEquals(argentEncaisséInitial + sommeInsérée, argentEncaisséFinal);
    }

    @Test
    @DisplayName("QUAND on met moins de 40cts ALORS aucun café ne coule ET l'argent est rendu")
    public void Test_Pas_Assez_Argent(){
        // ETANT DONNE une machine
        Machine machine = new Machine();
        int nombreCaféInitiaux = machine.GetNombreCafésServis();
        double argentEncaisséInitial = machine.GetArgentEncaissé();
        double sommeInsuffisante = 0.39;

        // QUAND on met moins de 40cts
        machine.Insérer(sommeInsuffisante);

        // ALORS aucun café ne coule
        int nombreCafésFinaux = machine.GetNombreCafésServis();
        assertEquals(nombreCaféInitiaux, nombreCafésFinaux);

        // ET l'argent est rendu
        double argentEncaisséFinal = machine.GetArgentEncaissé();
        assertEquals(argentEncaisséInitial, argentEncaisséFinal);
    }
}
