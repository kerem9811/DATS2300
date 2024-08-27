package hjelpeklasser;

import java.util.*;

public class Tabell {

    private Tabell() { // privat standardkonstruktør - hindrer instansiering
    }

    public static void fratilKontroll(int tablengde, int fra, int til) {
        if (fra < 0)                                  // fra er negativ
            throw new ArrayIndexOutOfBoundsException("fra(" + fra + ") er negativ!");

        if (til > tablengde)                          // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException("til(" + til + ") > tablengde(" + tablengde + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }

    public static void skriv(int[] tabell, int fra, int til) {
        fratilKontroll(tabell.length, fra, til);
        if (til - fra > 0) System.out.print(tabell[fra]);
        for (int i = fra + 1; i < til; i++) System.out.print(" " + tabell[i]);
    }

    public static void skriv(int[] tabell) {
        skriv(tabell, 0, tabell.length);
    }

    public static void skrivln(int[] tabell, int fra, int til) {
        skriv(tabell, fra, til);
        System.out.println();
    }

    public static void skrivln(int[] tabell) {
        skrivln(tabell, 0, tabell.length);
    }

    //    Bytter om to indeksverdier i en tabell
    public static void bytt(int[] tabell, int i, int j) {
        int temp = tabell[i];
        tabell[i] = tabell[j];
        tabell[j] = temp;
    }

    //    Bytter to characters i et char-array
    public static void bytt(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    //    Lager et array med lengde n, som er tilfeldig stokket om.
    public static int[] randPerm(int n)  // en effektiv versjon
    {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k + 1);        // en tilfeldig tall fra 0 til k
            bytt(a, k, i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }

    //    Bytter om arrayet du putter in
    public static void randPerm(int[] tabell)  // stokker om arrayet
    {
        Random r = new Random();     // en randomgenerator

        for (int k = tabell.length - 1; k > 0; k--) {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            bytt(tabell, k, i);
        }
    }

    public static int[] nestMaks(int[] a) // ny versjon
    {
        int n = a.length;     // tabellens lengde
        if (n < 2) throw      // må ha minst to verdier
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = 0;      // m er posisjonen til største verdi
        int nm = 1;     // nm er posisjonen til nest største verdi

        // bytter om m og nm hvis a[1] er større enn a[0]
        if (a[1] > a[0]) {
            m = 1;
            nm = 0;
        }

        int maksverdi = a[m];                // største verdi
        int nestmaksverdi = a[nm];           // nest største verdi

        for (int i = 2; i < n; i++) {
            if (a[i] > nestmaksverdi) {
                if (a[i] > maksverdi) {
                    nm = m;
                    nestmaksverdi = maksverdi;     // ny nest størst

                    m = i;
                    maksverdi = a[m];              // ny størst
                } else {
                    nm = i;
                    nestmaksverdi = a[nm];         // ny nest størst
                }
            }
        } // for

        return new int[]{m, nm};    // n i posisjon 0, nm i posisjon 1

    } // nestMaks

    public static int[] nestMin(int[] tabell) {
        int n = tabell.length;   // tabellens lengde

        if (n < 2) throw new IllegalArgumentException
                ("a.length(" + n + ") < 2!");

        int m = Tabell.min(tabell);   // m er posisjonen til tabellens minste verdi

        int nm = 0;   // nm står for nestmin

        if (m == 0) nm = Tabell.min(tabell, 1, n);              // leter i a[1:n>
        else if (m == n - 1) nm = Tabell.min(tabell, 0, n - 1);     // leter i a[0:n-1>
        else {
            int mv = Tabell.min(tabell, 0, m);                   // leter i a[0:m>
            int mh = Tabell.min(tabell, m + 1, n);                 // leter i a[m+1:n>
            nm = tabell[mh] < tabell[mv] ? mh : mv;           // hvem er minst?
        }

        int[] b = {m, nm};
        return b;  // minste verdi i b[0], nest minste i b[1]

    } // nestMin


    //    Returnerer indeksen til største verdi innenfor et intervall i arrayet
    public static int maks(int[] tabell, int fra, int til) {
        /*if (fra < 0 || til > tabell.length || fra >= til) {
            throw new IllegalArgumentException("Illegalt intervall!");
        }*/
        Tabell.fratilKontroll(tabell.length, fra, til);

        int m = fra;              // indeks til største verdi i a[fra:til>
        int maksverdi = tabell[fra];   // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++) {
            if (tabell[i] > maksverdi) {
                m = i;                // indeks til største verdi oppdateres
                maksverdi = tabell[m];     // største verdi oppdateres
            }
        }

        return m;  // posisjonen til største verdi i a[fra:til>
    }

    //    Returnerer indeksen til den største verdien i hele arrayet.
    public static int maks(int[] tabell)  // bruker hele tabellen
    {
        return maks(tabell, 0, tabell.length);     // kaller metoden over
    }

    // min-metodene - se Oppgave 1 i Avsnitt 1.2.1
    public static int min(int[] tabell, int fra, int til) {
//        Hvis fra er mindre enn 0, til er større enn tabellens størrelse, eller fra er større eller lik til = ulovlig
//        Husk at fra betyr fra og med, mens til betyr IKKE til og med.
        if (fra < 0 || til > tabell.length || fra >= til) throw new IllegalArgumentException("Ulovlig intervall!");

        int m = fra;             // indeks til minste verdi i tabell[fra:til>
        int minverdi = tabell[fra];   // minste verdi i tabell[fra:til>

        for (int i = fra + 1; i < til; i++)
            if (tabell[i] < minverdi) {
                m = i;               // indeks til minste verdi oppdateres
                minverdi = tabell[m];     // minste verdi oppdateres
            }

        return m;  // posisjonen til minste verdi i tabell[fra:til>
    }

    public static int min(int[] tabell)  // bruker hele tabellen
    {
        return min(tabell, 0, tabell.length);     // kaller metoden over
    }    // n i posisjon 0, nm i posisjon 1

    /*
    * Sjekk at Programkode 1.2.13 a) virker.
    * Obs: metoden returnerer størst og nest størst verdi og ikke indeksene.
    * Legg inn en setning som skriver ut tabellen b etter ut turneringen er gjennomført.
    * Dermed kan en se resultatet av turneringen.
    * */
    public static int[] nestMaksv2(int[] tabell)   // en turnering
    {
        int n = tabell.length;                // for å forenkle notasjonen

        if (n < 2) // må ha minst to verdier!
            throw new IllegalArgumentException("Array size(" + n + ") < 2!");

        int[] b = new int[2*n];          // turneringstreet
        System.arraycopy(tabell,0,b,n,n);     // legger a bakerst i b

        for (int k = 2*n-2; k > 1; k -= 2)   // lager turneringstreet
            b[k/2] = Math.max(b[k],b[k+1]);

        int maksverdi = b[1], nestmaksverdi = Integer.MIN_VALUE;

        for (int m = 2*n - 1, k = 2; k < m; k *= 2)
        {
            int tempverdi = b[k+1];  // ok hvis maksverdi er b[k]
            if (maksverdi != b[k]) { tempverdi = b[k]; k++; }
            if (tempverdi > nestmaksverdi) nestmaksverdi = tempverdi;
        }
        System.out.println("Array etter turneringstre: " + Arrays.toString(Tabell.nestMin(b)));
//        return new int[] {maksverdi,nestmaksverdi}; // størst og nest størst
        return Tabell.nestMin(b); // størst og nest størst

    } // nestMaks

}