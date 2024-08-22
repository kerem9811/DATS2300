import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] tabell = new int[]{8, 4, 17, 10, 6, 20, 1, 11, 15, 3, 18, 9, 2, 7, 19};
        int fakultet = 20;

        System.out.println("Indeksen til det største tallet er: " + Program.maks(tabell));
        System.out.println("Indeksen til det minste tallet er: " + Program.min(tabell));
        System.out.println("Indeksene til de minste og største tallene er: " + Arrays.toString(Program.minmaks(tabell)));
        System.out.println("Fakultetet av " + fakultet + " er " + Program.fakultet(fakultet));
    }
}