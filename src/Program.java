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
}
