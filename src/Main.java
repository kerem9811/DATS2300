import java.util.Arrays;
import static javax.swing.JOptionPane.showMessageDialog;

import hjelpeklasser.*;

public class Main {
    public static void main(String[] args) {
        /**/

        int[] tabell = new int[]{8, 4, 17, 10, 6, 20, 1, 11, 15, 3, 18, 9, 2, 7, 19};
        int[] tabell2 = new int[]{0, 1};
        int fakultet = 10;
        int n = 200_000, antall = 20_000; // tabellstørrelse og gjentagelser
        int[] tabell3 = Program.randPerm(n);           // en permutasjon av 1, . .  n
        long tid = 0;                    // for tidsmåling

//Oppgave 1.2.2.2:
        /*int[] a = Tabell.randPerm(2000);              // en tilfeldig tabell
        for (int k : a) System.out.print(k + " ");  // skriver ut a
        int m = Tabell.maks(a);   // finner posisjonen til største verdi
        System.out.println("\nStørste verdi ligger på plass " + m);*/

//Oppgave 1.2.5.1
//        int[] a = Tabell.randPerm(20); // tilfeldig permutasjon av 1 . . 20
//        int[] b = Tabell.nestMaks(a);  // metoden returnerer en tabell
//
//        int m2 = b[0], nm = b[1];       // m for maks, nm for nestmaks
//
//        Tabell.skrivln(a);        // se Oppgave 5 i Avsnitt 1.2.2
//        System.out.print("Størst(" + a[m2] + ") har posisjon " + m2);
//        System.out.println(", nest størst(" + a[nm] + ") har posisjon " + nm);

//        Tabell.nestMaksv2(a);
//        System.out.println("Turneringstre: " + Arrays.toString(Tabell.nestMaksv2(a)));

//        Oppgave 1.3.3.1: Sjekk at Programkode 1.3.3 f) virker. Lag en serie permutasjoner (bruk randPerm) av tallene fra 1 til 10. Skriv ut resultatet.
       /* int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Tabell.randPerm(array);
        System.out.println("Array før sortering: " + Arrays.toString(array));
        Tabell.boblesorteringV2(array);
        System.out.println("Array etter sortering: " + Arrays.toString(array));*/

//       1.3.3.2: Sammenlign Programkode 1.3.3 e) og f). Kall dem boblesortering1 og boblesortering2.
//       Lag så store tilfeldige permutasjoner at den ene bruker noen sekunder. Ta en kopi før du sorterer.
//       Hvor lang tid vil den andre bruke (på kopien).
//        int[] arrayBoble = Tabell.randPerm(1000);
      /*  int[] arrayBoble2 = Tabell.randPerm(1000);
        int[] arrayBoble3 = arrayBoble2.clone();
        System.out.println("Cloned arrays.");
        if (Arrays.equals(arrayBoble2, arrayBoble3)) {
            System.out.println("Arrays are equal.");
        } else {
            System.out.println("Arrays are not equal.");
        }*/

        /*Tabell.randPerm(arrayBoble2);
        System.out.println("Randomizing array 2");
        if (Arrays.equals(arrayBoble, arrayBoble2)) {
            System.out.println("Equal arrays");
        } else {
            System.out.println("Not equal arrays");
        }*/

    /*    tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) Tabell.boblesorteringV1(arrayBoble);
        tid = System.currentTimeMillis() - tid;     // medgått tid
        System.out.println("BoblesorteringV1: " + tid + " ms");*/

       /* tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) Tabell.boblesorteringV2(arrayBoble2);
        tid = System.currentTimeMillis() - tid;     // medgått tid
        System.out.println("BoblesorteringV2: " + tid + " ms");

        tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) Tabell.boblesorteringV2x(arrayBoble3);
        tid = System.currentTimeMillis() - tid;     // medgått tid
        System.out.println("BoblesorteringV2: " + tid + " ms");*/

        //    1.3.5.2: Sjekk at metoden lineærsøk gir korrekt returverdi hvis det søkes etter en verdi som er mindre enn den minste i tabellen.
//    Hva skjer hvis tabellen er tom, dvs. a.length = 0? La a være tabellen i Figur 1.3.5 a).
//    Hva blir returverdiene fra lineærsøk hvis vi søker etter 2, 15, 16, 40 og 41?
       /* int[] arrayToSearch = Tabell.randPerm(10);
        System.out.println("Array 1: " + Arrays.toString(arrayToSearch));
        int[] arrayToSearch2 = new int[]{};
        System.out.println("Array 2: " + Arrays.toString(arrayToSearch2));
        System.out.println("Lineærsøk etter en manglende verdi: " + Tabell.linearSearchOld(arrayToSearch, 1));
        System.out.println("Lineærsøk i et tomt array: " + Tabell.linearSearchOld(arrayToSearch2, 1));
        System.out.println("Lineærsøk 1: " + Tabell.linearSearch(array,0,9,5));
//        System.out.println("Lineærsøk 2: " + Tabell.linearSearch(arrayToSearch2,0,9,0));
        System.out.println("Usortert søk: " + Tabell.unsortedSearch(arrayToSearch,5));*/

//        INEFFEKTIV FIBONACCI
        /*tid = System.currentTimeMillis();    // leser av klokken
        long fibo = Program.fib(100);
        tid = System.currentTimeMillis() - tid;     // medgått tid
        System.out.println("Fibonacci ble " + fibo + " og tok " + tid + " ms");*/

        tid = System.currentTimeMillis();    // leser av klokken
//        long fiboBinet = Program.fibonacciBinet(79);
//        long tverrsum = Program.tverrsum(fiboBinet);
//        int sifferrot = Program.sifferrot(fiboBinet);
        tid = System.currentTimeMillis() - tid;     // medgått tid
//        System.out.println("Fibonacci ble " + fiboBinet + " og tok " + tid + " ms");
//        System.out.println("Fibonacci ble " + fiboBinet + ", sifferroten er " + sifferrot + " og tok " + tid + " ms");
        showMessageDialog(null, Arrays.toString(Program.tverrsumAvFibonacciTall(100)));
    }
}