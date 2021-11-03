public class Forbruger {
    
    private String navn = "";
    private int maalerNr = 0;
    private int nyAflaesning = 0;
    private int forrigeAflaesning = 0;
    private int maalerMax = 0;

    public Forbruger() {}

    public Forbruger(String navn, int maalerNr, int målerMax) {
        this.navn = navn;
        this.maalerNr = maalerNr;
        this.maalerMax = målerMax;
    }

    public int getMaalerNr() {
        return maalerNr;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public void aflaesMaaler(int maalerVaerdi){
        this.forrigeAflaesning = nyAflaesning;
        this.nyAflaesning = maalerVaerdi;
    }
    
    public int beregnForbrug(){
        if(nyAflaesning < forrigeAflaesning)
            return maalerMax - forrigeAflaesning + nyAflaesning;
        else
            return nyAflaesning - forrigeAflaesning;
    }
}
