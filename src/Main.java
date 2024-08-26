import java.util.Arrays;
import hjelpeklasser.*;

public class Main {
    public static void main(String[] args) {

        int[] tabell = new int[]{8, 4, 17, 10, 6, 20, 1, 11, 15, 3, 18, 9, 2, 7, 19};
        int[] tabell2 = new int[]{0,1};
        int fakultet = 10;
        int n = 200_000, antall = 20_000; // tabellstørrelse og gjentagelser
        int[] tabell3 = Program.randPerm(n);           // en permutasjon av 1, . .  n
        long tid = 0;                    // for tidsmåling

//Oppgave 1.2.2.2:
        int[] a = Tabell.randPerm(20);              // en tilfeldig tabell
        for (int k : a) System.out.print(k + " ");  // skriver ut a
        int m = Tabell.maks(a);   // finner posisjonen til største verdi
        System.out.println("\nStørste verdi ligger på plass " + m);

//Oppgave 1.2.5.1
//        int[] a = Tabell.randPerm(20); // tilfeldig permutasjon av 1 . . 20
        int[] b = Tabell.nestMaks(a);  // metoden returnerer en tabell

        int m2 = b[0], nm = b[1];       // m for maks, nm for nestmaks

        Tabell.skrivln(a);        // se Oppgave 5 i Avsnitt 1.2.2
        System.out.print("Størst(" + a[m2] + ") har posisjon " + m2);
        System.out.println(", nest størst(" + a[nm] + ") har posisjon " + nm);


//        System.out.println("Indeksen til det største tallet er: " + Program.maks(tabell));
//        System.out.println("Indeksen til det minste tallet er: " + Program.min(tabell));
//        System.out.println("Indeksene til de minste og største tallene er: " + Arrays.toString(Program.minmaks(tabell)));
//        System.out.println("Resultatet av " + fakultet + "! er " + Program.fakultet(fakultet));
//        System.out.println("Indeksen til det største tallet i v2 er: " + Program.maksv2(tabell));
//        System.out.println("Indeksen til det største tallet i v3 er: " + Program.maksv3(tabell));
//        System.out.println("Indeksen til det største tallet i v3 er: " + Program.maksv3(tabell2));
//        System.out.println("Vi prøver med en n på: " + n + ", forskjellen blir da: " + Program.euler(n));

//        System.out.println(Arrays.toString(Program.randPerm(n))); //Skriver ut alle tallene i arrayet :-O

       /* System.out.println("/////////////////////////////////////////////////////////");
        System.out.println("TIDSBRUK ALGORITMER");
        System.out.println("n er: " + n + " og antall gjentagelser er: " + antall);
        tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) Program.kostnader(tabell3);
        tid = System.currentTimeMillis() - tid;    // medgått tid
        System.out.println("Faste kostnader: " + tid + " ms");*/

       /* tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) Program.maks(tabell3);  // Programkode 1.1.2
        tid = System.currentTimeMillis() - tid;     // medgått tid
        System.out.println("Maks1-metoden: " + tid + " ms");*/

       /* tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) Program.maksv2(tabell3);  // Programkode 1.1.4
        tid = System.currentTimeMillis() - tid;     // medgått tid
        System.out.println("Maks2-metoden: " + tid + " ms");*/

       /* tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) Program.maksv3(tabell3);  // Programkode 1.1.5
        tid = System.currentTimeMillis() - tid;     // medgått tid
        System.out.println("Maks3-metoden: " + tid + " ms");*/

       /* tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) Program.maksv3Forbedret(tabell3);  // Programkode 1.1.5
        tid = System.currentTimeMillis() - tid;     // medgått tid
        System.out.println("Maks3Gemini-metoden: " + tid + " ms");*/

       /* tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) Program.maksv3Gemini(tabell3);  // Programkode 1.1.5
        tid = System.currentTimeMillis() - tid;     // medgått tid
        System.out.println("Maks3Geminiv2-metoden: " + tid + " ms");*/

        /*tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) Program.maksv3Gemini2(tabell3);  // Programkode 1.1.5
        tid = System.currentTimeMillis() - tid;     // medgått tid
        System.out.println("MaksG-metoden: " + tid + " ms");
*/
        /*tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) Program.maksv3G8(tabell3);  // Programkode 1.1.5
        tid = System.currentTimeMillis() - tid;     // medgått tid
        System.out.println("MaksG8-metoden: " + tid + " ms");*/
    }
}