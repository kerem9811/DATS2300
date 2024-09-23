package TEST;
import static java.io.IO.println;
import static javax.swing.JOptionPane.showMessageDialog;

public class HanoisTårn {

    public static long flyttTårn(int n, char fra, char til, char hjelpe) {
        if (n == 1) {
//            System.out.println("Flytt disk 1 fra " + fra + " til " + til);
            return 1; // Ett trekk når vi flytter én disk
        } else {
            long antallTrekk = 0;
            antallTrekk += flyttTårn(n - 1, fra, hjelpe, til); // Flytt n-1 disker til hjelpepinnen
//            System.out.println("Flytt disk " + n + " fra " + fra + " til " + til);
            antallTrekk++; // Legg til ett trekk for å flytte den største disken
            antallTrekk += flyttTårn(n - 1, hjelpe, til, fra); // Flytt n-1 disker fra hjelpepinnen til målpinnen
            return antallTrekk; // Returner totalt antall trekk
        }
    }

    void main() {
        long tid = 0;
        tid = System.currentTimeMillis();    // leser av klokken
        int antallDisker = 29;
        long totaltAntallTrekk = flyttTårn(antallDisker, 'A', 'C', 'B');
        tid = System.currentTimeMillis() - tid;
//        System.out.println("Totalt antall trekk: " + totaltAntallTrekk + ", tok " + tid + " ms.");
       showMessageDialog(null,"Totalt antall trekk: " + totaltAntallTrekk + ".\nDette tok " + tid + " ms.");
       println("hello");
    }
}