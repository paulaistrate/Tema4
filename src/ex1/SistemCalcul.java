package ex1;
public class SistemCalcul extends Echipament {
    private String tipMon;
    private double vitProc;
    private int cHdd; // Capacitatea HDD
    private SistemOperare sistemOperare;

    public enum SistemOperare {
        WINDOWS,
        LINUX
    }

    // Constructor
    public SistemCalcul(String denumire, int nrInv, double pret, String zonaMag, StareEchipament stare,
                        String tipMon, double vitProc, int cHdd, SistemOperare sistemOperare) {
        super(denumire, nrInv, pret, zonaMag, stare);
        this.tipMon = tipMon;
        this.vitProc = vitProc;
        this.cHdd = cHdd;
        this.sistemOperare = sistemOperare;
    }

    // Instaleaza un sistem de operare
    public void instaleazaSistemOperare(SistemOperare sistemOperare) {
        this.sistemOperare = sistemOperare;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", SistemCalcul{tipMon='%s', vitProc=%.2f, cHdd=%d, sistemOperare='%s'}",
                tipMon, vitProc, cHdd, sistemOperare);
    }
}
