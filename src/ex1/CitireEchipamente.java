package ex1;
import java.io.*;
import java.util.*;

public class CitireEchipamente {
    public static List<Echipament> citesteEchipamente(String fisier) {
        List<Echipament> echipamente = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(fisier))) {
            while (scanner.hasNextLine()) {
                String linie = scanner.nextLine();
                String[] valori = linie.split(",");

                switch (valori[0].trim()) {
                    case "Imprimanta":
                        echipamente.add(new Imprimanta(
                                valori[1].trim(), Integer.parseInt(valori[2].trim()),
                                Double.parseDouble(valori[3].trim()), valori[4].trim(),
                                Echipament.StareEchipament.valueOf(valori[5].trim().toUpperCase()),
                                Integer.parseInt(valori[6].trim()), Integer.parseInt(valori[7].trim()),
                                Integer.parseInt(valori[8].trim()),
                                Imprimanta.TipTiparire.valueOf(valori[9].trim().toUpperCase())
                        ));
                        break;
                    case "Copiator":
                        echipamente.add(new Copiator(
                                valori[1].trim(), Integer.parseInt(valori[2].trim()),
                                Double.parseDouble(valori[3].trim()), valori[4].trim(),
                                Echipament.StareEchipament.valueOf(valori[5].trim().toUpperCase()),
                                Integer.parseInt(valori[6].trim()),
                                Copiator.FormatCopiere.valueOf(valori[7].trim().toUpperCase())
                        ));
                        break;
                    case "SistemCalcul":
                        echipamente.add(new SistemCalcul(
                                valori[1].trim(), Integer.parseInt(valori[2].trim()),
                                Double.parseDouble(valori[3].trim()), valori[4].trim(),
                                Echipament.StareEchipament.valueOf(valori[5].trim().toUpperCase()),
                                valori[6].trim(), Double.parseDouble(valori[7].trim()),
                                Integer.parseInt(valori[8].trim()),
                                SistemCalcul.SistemOperare.valueOf(valori[9].trim().toUpperCase())
                        ));
                        break;
                }
            }
        } catch (IOException e) {
            System.err.println("Eroare la citirea fisierului: " + e.getMessage());
        }

        return echipamente;
    }
}
