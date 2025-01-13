package ex1;
import java.io.Serializable;

public abstract class Echipament implements Serializable {
    private String denumire;
    private int nrInv;
    private double pret;
    private String zonaMag;
    private StareEchipament stare;

    public enum StareEchipament {
        ACHIZITIONAT,
        EXPUS,
        VANDUT
    }

    // Constructor
    public Echipament(String denumire, int nrInv, double pret, String zonaMag, StareEchipament stare) {
        this.denumire = denumire;
        this.nrInv = nrInv;
        this.pret = pret;
        this.zonaMag = zonaMag;
        this.stare = stare;
    }

    // Getteri si setteri
    public String getDenumire() { return denumire; }
    public int getNrInv() { return nrInv; }
    public double getPret() { return pret; }
    public String getZonaMag() { return zonaMag; }
    public StareEchipament getStare() { return stare; }
    public void setStare(StareEchipament stare) { this.stare = stare; }

    @Override
    public String toString() {
        return String.format("Echipament{denumire='%s', nrInv=%d, pret=%.2f, zonaMag='%s', stare='%s'}",
                denumire, nrInv, pret, zonaMag, stare);
    }
}
