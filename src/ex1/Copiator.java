package ex1;
public class Copiator extends Echipament {
    private int pTon; // Pagini per toner
    private FormatCopiere formatCopiere;

    public enum FormatCopiere {
        A3,
        A4
    }

    // Constructor
    public Copiator(String denumire, int nrInv, double pret, String zonaMag, StareEchipament stare,
                    int pTon, FormatCopiere formatCopiere) {
        super(denumire, nrInv, pret, zonaMag, stare);
        this.pTon = pTon;
        this.formatCopiere = formatCopiere;
    }

    // Seteaza formatul de copiere
    public void setFormatCopiere(FormatCopiere formatCopiere) {
        this.formatCopiere = formatCopiere;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Copiator{pTon=%d, formatCopiere='%s'}",
                pTon, formatCopiere);
    }
}
