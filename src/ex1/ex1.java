package ex1;
import java.io.*;
import java.util.*;

public class ex1 {
    public static void main(String[] args) {
        List<Echipament> echipamente = CitireEchipamente.citesteEchipamente("electronice.txt");
        Scanner scanner = new Scanner(System.in);
        boolean ruleaza = true;

        while (ruleaza) {
            System.out.println("\n--- Meniu ---");
            System.out.println("1. Afisarea tuturor echipamentelor");
            System.out.println("2. Afisarea imprimantelor");
            System.out.println("3. Afisarea copiatoarelor");
            System.out.println("4. Afisarea sistemelor de calcul");
            System.out.println("5. Modificarea starii unui echipament");
            System.out.println("6. Setarea modului de tiparire pentru imprimante");
            System.out.println("7. Setarea formatului de copiere pentru copiatoare");
            System.out.println("8. Instalarea unui sistem de operare pe un sistem de calcul");
            System.out.println("9. Afisarea echipamentelor vandute");
            System.out.println("10. Salvarea echipamentelor in fisier binar (serializare)");
            System.out.println("11. Incarcarea echipamentelor din fisier binar (deserializare)");
            System.out.println("12. Iesire");
            System.out.print("Alege o optiune: ");

            int optiune = scanner.nextInt();
            scanner.nextLine(); // Consumare newline

            switch (optiune) {
                case 1:
                    echipamente.forEach(System.out::println);
                    break;

                case 2:
                    echipamente.stream()
                            .filter(e -> e instanceof Imprimanta)
                            .forEach(System.out::println);
                    break;

                case 3:
                    echipamente.stream()
                            .filter(e -> e instanceof Copiator)
                            .forEach(System.out::println);
                    break;

                case 4:
                    echipamente.stream()
                            .filter(e -> e instanceof SistemCalcul)
                            .forEach(System.out::println);
                    break;

                case 5:
                    System.out.print("Introduceti numarul de inventar al echipamentului: ");
                    int nrInv = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Introduceti noua stare (ACHIZITIONAT, EXPUS, VANDUT): ");
                    String stareNoua = scanner.nextLine();

                    echipamente.stream()
                            .filter(e -> e.getNrInv() == nrInv)
                            .findFirst()
                            .ifPresentOrElse(
                                    e -> e.setStare(Echipament.StareEchipament.valueOf(stareNoua.toUpperCase())),
                                    () -> System.out.println("Echipamentul nu a fost gasit.")
                            );
                    break;

                case 6:
                    System.out.print("Introduceti numarul de inventar al imprimantei: ");
                    int nrInvImprimanta = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Introduceti modul de tiparire (COLOR, ALB_NEGRU): ");
                    String tiparireNoua = scanner.nextLine();

                    echipamente.stream()
                            .filter(e -> e instanceof Imprimanta && e.getNrInv() == nrInvImprimanta)
                            .map(e -> (Imprimanta) e)
                            .findFirst()
                            .ifPresentOrElse(
                                    i -> i.setTipTiparire(Imprimanta.TipTiparire.valueOf(tiparireNoua.toUpperCase())),
                                    () -> System.out.println("Imprimanta nu a fost gasita.")
                            );
                    break;

                case 7:
                    System.out.print("Introduceti numarul de inventar al copiatorului: ");
                    int nrInvCopiator = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Introduceti formatul de copiere (A3, A4): ");
                    String formatNou = scanner.nextLine();

                    echipamente.stream()
                            .filter(e -> e instanceof Copiator && e.getNrInv() == nrInvCopiator)
                            .map(e -> (Copiator) e)
                            .findFirst()
                            .ifPresentOrElse(
                                    c -> c.setFormatCopiere(Copiator.FormatCopiere.valueOf(formatNou.toUpperCase())),
                                    () -> System.out.println("Copiatorul nu a fost gasit.")
                            );
                    break;

                case 8:
                    System.out.print("Introduceti numarul de inventar al sistemului de calcul: ");
                    int nrInvSistem = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Introduceti sistemul de operare (WINDOWS, LINUX): ");
                    String sistemNou = scanner.nextLine();

                    echipamente.stream()
                            .filter(e -> e instanceof SistemCalcul && e.getNrInv() == nrInvSistem)
                            .map(e -> (SistemCalcul) e)
                            .findFirst()
                            .ifPresentOrElse(
                                    s -> s.instaleazaSistemOperare(SistemCalcul.SistemOperare.valueOf(sistemNou.toUpperCase())),
                                    () -> System.out.println("Sistemul de calcul nu a fost gasit.")
                            );
                    break;

                case 9:
                    echipamente.stream()
                            .filter(e -> e.getStare() == Echipament.StareEchipament.VANDUT)
                            .forEach(System.out::println);
                    break;

                case 10:
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("echip.bin"))) {
                        oos.writeObject(echipamente);
                        System.out.println("Echipamentele au fost salvate in fisierul echip.bin.");
                    } catch (IOException e) {
                        System.err.println("Eroare la salvare: " + e.getMessage());
                    }
                    break;

                case 11:
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("echip.bin"))) {
                        echipamente = (List<Echipament>) ois.readObject();
                        System.out.println("Echipamentele au fost incarcate din fisierul echip.bin.");
                    } catch (IOException | ClassNotFoundException e) {
                        System.err.println("Eroare la incarcare: " + e.getMessage());
                    }
                    break;

                case 12:
                    ruleaza = false;
                    break;

                default:
                    System.out.println("Optiune invalida.");
            }
        }

        scanner.close();
    }
}
