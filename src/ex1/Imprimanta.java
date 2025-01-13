package ex1;
public class Imprimanta extends Echipament {
    private int ppm; // Pagini per minut
    private int dpi; // Rezolutie
    private int pCar; // Pagini per cartus
    private TipTiparire tipTiparire;

    public enum TipTiparire {
        COLOR,
        ALB_NEGRU
    }

    // Constructor
    public Imprimanta(String denumire, int nrInv, double pret, String zonaMag, StareEchipament stare,
                      int ppm, int dpi, int pCar, TipTiparire tipTiparire) {
        super(denumire, nrInv, pret, zonaMag, stare);
        this.ppm = ppm;
        this.dpi = dpi;
        this.pCar = pCar;
        this.tipTiparire = tipTiparire;
    }

    // Seteaza tipul de tiparire
    public void setTipTiparire(TipTiparire tipTiparire) {
        this.tipTiparire = tipTiparire;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Imprimanta{ppm=%d, dpi=%d, pCar=%d, tipTiparire='%s'}",
                ppm, dpi, pCar, tipTiparire);
    }
}
