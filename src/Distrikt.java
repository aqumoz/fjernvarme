public class Distrikt {
    
    private String navn = "";
    private float prisPrM3 = 0.0f;
    private Forbruger[] forbrugere = new Forbruger[200];
    private int antalForbrugere = 0;

    public Distrikt() {
        
    }

    public Distrikt(String navn, float prisPrM3) {
        this.navn = navn;
        this.prisPrM3 = prisPrM3;
    }

    public void setForbruger(Forbruger forbruger){

        if(antalForbrugere <= 200){
            forbrugere[antalForbrugere] = forbruger;
            antalForbrugere++;
        }
        else
            System.out.println("Fejl: Der er ikke plads til flere forbrugere i dette distrikt! (Maks kapacitet er 200)");
    }

    public float afregnForbruger(int målerNr){

        for (Forbruger forbruger : forbrugere) {
            if(forbruger != null && forbruger.getMaalerNr() == målerNr)
                return forbruger.beregnForbrug() * prisPrM3;
        }
        return -1;
    }

}
