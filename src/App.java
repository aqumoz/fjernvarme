
/**
 * Denne klasse er lavet til at teste klasserne 'Distrikt' og 'Forbruger'.
 * 
 * @author Anders Møller Jensen
 * @version 20211102
 */
public class App {
    
    public static void main(String[] args) throws Exception {

        // --- Test af 'Forbruger' klassen ---
        System.out.println("--- Test af 'Forbruger' klassen ---");

        Forbruger forbruger1 = new Forbruger("Anders Møller Jensen", 1234, 150);
        System.out.println("Det forventes at getMaalerNr() returnerer 1234. Den værdi den returnerer er: " + forbruger1.getMaalerNr());
        System.out.println("Det forventes at getNavn() returnerer 'Anders Møller Jensen'. Den værdi den returnerer er: " + forbruger1.getNavn());

        forbruger1.setNavn("Peter Vilhelm Carl Kyhn");
        System.out.println("Det forventes at getNavn() returnerer 'Peter Vilhelm Carl Kyhn'. Den værdi den returnerer er: " + forbruger1.getNavn());

        // Når måleren lige er blevet installeret og ikke er blevet aflæst forventes det at forbruget er 0.
        System.out.println("Det forventes at beregnForbrug() returnerer 0. Den værdi den returnerer er: " + forbruger1.beregnForbrug());

        // Første gang måleren aflæses forventes forbruget at være det samme som aflæsningen.
        forbruger1.aflaesMaaler(50);
        System.out.println("Det forventes at beregnForbrug() returnerer 50. Den værdi den returnerer er: " + forbruger1.beregnForbrug());

        // Anden gang måleren aflæses forventes forbruget at være differencen mellem den nye aflæsning og den gamle.
        forbruger1.aflaesMaaler(110);
        System.out.println("Det forventes at beregnForbrug() returnerer 60. Den værdi den returnerer er: " + forbruger1.beregnForbrug());

        // Ved en ny aflæsning af måleren, hvor den nye aflæsning er mindre end den forrige betyder det at måleren 
        // har været maksetud, og er startet forfra fra 0.
        forbruger1.aflaesMaaler(20);
        System.out.println("Det forventes at beregnForbrug() returnerer 60. Den værdi den returnerer er: " + forbruger1.beregnForbrug());


        // --- Test af 'Distrikt' klassen ---
        System.out.println("\n--- Test af 'Distrikt' klassen ---");

        Distrikt asgaard = new Distrikt("Asgård", 10.42f);

        Forbruger thor = new Forbruger("Thor", 1, 150);
        thor.aflaesMaaler(120);
        Forbruger odin = new Forbruger("Odin", 2, 100);
        odin.aflaesMaaler(20);
        Forbruger frigg = new Forbruger("Frigg", 3, 160);
        frigg.aflaesMaaler(150);
        Forbruger balder = new Forbruger("Balder", 4, 150);

        asgaard.setForbruger(thor);
        asgaard.setForbruger(odin);
        asgaard.setForbruger(frigg);
        asgaard.setForbruger(balder);
        

        Distrikt jotunheim = new Distrikt("Jotunheim", 9.12f);
        
        Forbruger njord = new Forbruger("Njord", 15, 210);
        njord.aflaesMaaler(20);
        Forbruger frej = new Forbruger("Frej", 16, 160);
        frej.aflaesMaaler(65);
        Forbruger freja = new Forbruger("Freja", 17, 140);
        freja.aflaesMaaler(130);

        jotunheim.setForbruger(njord);
        jotunheim.setForbruger(frej);
        jotunheim.setForbruger(freja);


        // Thor, Odin, Frigg og Balder bor allesammen i Asgård, og har målernumrene 1, 2, 3 og 4,
        // så ved afregning af forbrug bør resultatet være større eller lig 0.
        System.out.println("Thor: " + asgaard.afregnForbruger(1));
        System.out.println("Odin: " + asgaard.afregnForbruger(2));
        System.out.println("Frigg: " + asgaard.afregnForbruger(3));
        System.out.println("Balder: " + asgaard.afregnForbruger(4));
        
        //Freja (målernummer: 17) bor ikke i Asgård, så ved forsøg på afregning af Freja i Asgård bør resultatet blive -1.
        System.out.println("Freja: " + asgaard.afregnForbruger(17));
        
        // Lige så, bor Balder (målernummer: 4) ikke i Jotunheim, så ved forsøg på afregning af Balder i Jotunheim bør resultatet blive -1.
        System.out.println("Balder: " + jotunheim.afregnForbruger(4));
        
        // Njord's (målernummer: 15) måler er blevet aflæst til 20 og prisPrM3 er 9,12 i Jotunheim,
        // så hans afregning bør give 20 * 9,12 = 182,4.
        System.out.println("Njord: " + jotunheim.afregnForbruger(15));

    }
}
