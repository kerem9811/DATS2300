import java.util.Arrays;
import java.util.Random;

public class Program {
    public static int maks(int[] tabell) // a er en heltallstabell
    {
        if (tabell.length < 1) throw new java.util.NoSuchElementException("Tabellen a er tom!");
        int maks = 0; // indeks til foreløpig største verdi
        for (int i = 1; i < tabell.length; i++) // obs: starter med i = 1
        {
            if (tabell[i] >= tabell[maks]) maks = i; // indeksen oppdateres
        }
        return maks; // returnerer indeksen/posisjonen til største verdi
    } // maks

    public static int min(int[] tabell) // En heltallstabell
    {
        if (tabell.length < 1) throw new java.util.NoSuchElementException("Tabellen er tom!");
        int minst = 0; // indeks til foreløpig minste verdi, siden det er første
        for (int i = 1; i < tabell.length; i++) // obs: starter med i = 1
        {
            if (tabell[i] <= tabell[minst]) minst = i; // indeksen oppdateres
        }
        return minst; // returnerer indeksen/posisjonen til minste verdi
    }

    public static int[] minmaks(int[] tabell) {
        return new int[]{min(tabell), maks(tabell)}; //Returnerer indexen til det minste tallet i en tabell, så det største.
    }

    public static long fakultet(int n) {
        if (n < 0) throw new IllegalArgumentException("n < 0");
        long fakultet = 1;
        for (int i = 2; i <= n; i++) {
            fakultet *= i;
        }
        return fakultet;
    }

    public static int maksv2(int[] tabell) {
        int maksindeks = 0;               // indeks til største verdi
        int maksverdi = tabell[0];    // største verdi

        for (int i = 1; i < tabell.length; i++)
            if (tabell[i] > maksverdi) {
                maksverdi = tabell[i];     // største verdi oppdateres
                maksindeks = i;                // indeks til største verdi oppdateres
            }
        return maksindeks;   // returnerer indeks/posisjonen til største verdi
    }

    public static int maksv3(int[] tabell)  // versjon 3 av maks-metoden
    {
        if (tabell.length < 1) throw new java.util.NoSuchElementException("Tabellen er tom!");
        int sist = tabell.length - 1;       // siste posisjon i tabellen
        int storst = 0;                     // indeks til største verdi
        int maksverdi = tabell[0];          // største verdi
        int temp = tabell[sist];            // tar vare på siste verdi
        tabell[sist] = 0x7fffffff;          // legger tallet 2147483647 sist

        for (int i = 0; ; i++)         // i starter med 0
            if (tabell[i] >= maksverdi) {      // denne blir sann til slutt
                if (i == sist) {             // sjekker om vi er ferdige
                    tabell[sist] = temp;          // legger siste verdi tilbake
                    return temp >= maksverdi ? sist : storst;   // er siste størst?
                } else {
                    maksverdi = tabell[i];        // maksverdi oppdateres
                    storst = i;                   // m oppdateres
                }
            }
    } // maks

    public static int maksv3Forbedret(int[] tabell) {
        if (tabell.length == 0) {
            throw new java.util.NoSuchElementException("Tabellen er tom!");
        }

        int maksverdi = tabell[0];
        int maksIndeks = 0;

        for (int i = 1; i < tabell.length; i++) {
            if (tabell[i] > maksverdi) {
                maksverdi = tabell[i];
                maksIndeks = i;
            }
        }

        return maksIndeks;
    }

    public static int maksv3Gemini(int[] tabell) {
        int sist = tabell.length - 1;
        int storst = 0;
        int maksverdi = tabell[0];

        // Endre siste verdi hvis den er større enn maksverdi
        if (tabell[sist] > maksverdi) {
            maksverdi = tabell[sist];
            storst = sist;
        }

        tabell[sist] = 0x7fffffff;

        for (int i = 0; i < sist; i++) {
            if (tabell[i] >= maksverdi) {
                maksverdi = tabell[i];
                storst = i;
            }
        }

        tabell[sist] = maksverdi; // Gjenopprett siste verdi

        return storst;
    }

    public static int maksv3Gemini2(int[] tabell) {
        int lengde = tabell.length;
        int storst = 0;
        int maksverdi = tabell[0];

        // Unroll løkken 4 ganger for å redusere overhead
        for (int i = 1; i < lengde - 3; i += 4) {
            if (tabell[i] > maksverdi) {
                maksverdi = tabell[i];
                storst = i;
            }
            if (tabell[i + 1] > maksverdi) {
                maksverdi = tabell[i + 1];
                storst = i + 1;
            }
            if (tabell[i + 2] > maksverdi) {
                maksverdi = tabell[i + 2];
                storst = i + 2;
            }
            if (tabell[i + 3] > maksverdi) {
                maksverdi = tabell[i + 3];
                storst = i + 3;
            }
        }

        // Håndter de resterende elementene
        for (int i = (lengde / 4) * 4; i < lengde; i++) {
            if (tabell[i] > maksverdi) {
                maksverdi = tabell[i];
                storst = i;
            }
        }

        return storst;
    }

    public static int maksv3G8(int[] tabell) {
        int lengde = tabell.length;
        int storst = 0;
        int maksverdi = tabell[0];

        // Unroll løkken 8 ganger
        for (int i = 1; i < lengde - 7; i += 8) {
            if (tabell[i] > maksverdi) {
                maksverdi = tabell[i];
                storst = i;
            }
            if (tabell[i + 1] > maksverdi) {
                maksverdi = tabell[i + 1];
                storst = i + 1;
            }
            if (tabell[i + 2] > maksverdi) {
                maksverdi = tabell[i + 2];
                storst = i + 2;
            }
            if (tabell[i + 3] > maksverdi) {
                maksverdi = tabell[i + 3];
                storst = i + 3;
            }
            if (tabell[i + 4] > maksverdi) {
                maksverdi = tabell[i + 4];
                storst = i + 4;
            }
            if (tabell[i + 5] > maksverdi) {
                maksverdi = tabell[i + 5];
                storst = i + 5;
            }
            if (tabell[i + 6] > maksverdi) {
                maksverdi = tabell[i + 6];
                storst = i + 6;
            }
            if (tabell[i + 7] > maksverdi) {
                maksverdi = tabell[i + 7];
                storst = i + 7;
            }
        }

        // Håndter de resterende elementene
        for (int i = (lengde / 8) * 8; i < lengde; i++) {
            if (tabell[i] > maksverdi) {
                maksverdi = tabell[i];
                storst = i;
            }
        }

        return storst;
    }

    public static double harmonisk(int n) {
        double sum = 0.0;
        for (int i = 1; i <= n; i++) sum += 1.0 / i;
        return sum;
    }

    public static double euler(int n) {
        return harmonisk(n) - Math.log(n);
    }

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

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

    public static int kostnader(int[] tabell)  // legges i class Program
    {
        int maksverdi = 0;
        for (int i = 1; i < tabell.length; i++) {
        }  // en tom blokk
        return maksverdi;
    }
}
