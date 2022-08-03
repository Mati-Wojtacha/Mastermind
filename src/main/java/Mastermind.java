import java.awt.desktop.ScreenSleepEvent;

public class Mastermind {

    int liczba_pow = 0;
    int kod[];
    public static final String ROWNA_DLUGOSC = "dlugosci kodu jesr rowna z kolorami";
    public static final String BLAD_DLUGOSCI = "liczba podanych kolorow jest mniejsza od " +
            "dlugosci kodu podaj ponownie kolory";
    public static final String ZA_DUZO = "liczba podanych kolorow jest wieksza od dlugosci kodu";

    String sprawdzanie(int kolor[]) {
        if (kolor.length > kod.length) {
            return ZA_DUZO;
        }
        else if(kolor.length<kod.length){
            throw new RuntimeException(BLAD_DLUGOSCI);
        }
            return ROWNA_DLUGOSC;
    }

    Wynik wynik(int kolor[]) {
        int poprawne=0;
        int znalezione=0;
        int pomocnicza[] = new int[kod.length];
        System.out.println("\nkolor: ");
        for (int i = 0; i < kod.length; i++) {
            System.out.print(kolor[i]+" ");

            if (kolor[i] == kod[i]) {
                pomocnicza[i]=kolor[i];
                poprawne++;
            } else {
                for (int j = 0; j < kod.length; j++) {
                    if (kolor[i] == kod[j]) {
                        //System.out.println(pomocnicza+" "+kolor[i]);
                        if(pomocnicza[j]!=kolor[i]) {
                            znalezione++;
                        }
                    }
                }
            }
        }
        liczba_pow++;
        System.out.println("\nPoprawne:"+ poprawne+"\t Znalezione: "+znalezione);
        return new Wynik(poprawne, znalezione);
    }

    boolean sprawdz_rezultat(int poprawne){
        if(poprawne== kod.length){
         //   System.out.println("rozwiazales w "+liczba_pow+" probie");
            return true;
        }
        else {
           // System.out.println("Proboj dalej proba nr. " + liczba_pow);
            return false;
        }
    }

    boolean gra(int kolor[]){
        Wynik wartosci;
        sprawdzanie(kolor);
        wartosci=wynik(kolor);
    //    System.out.println("Poprawne: " + wartosci.poprawnie + "\nznalezione " + wartosci.znalezione);
        return sprawdz_rezultat(wartosci.poprawnie);
    }

    String pow_wart() {
        //System.out.println("\nkod ");
        for (int i = 0; i < kod.length; i++) {
          //  System.out.print(kod[i]+ " ");
            for (int j = i; j < kod.length; j++) {
                if(i!=j) {
                    if (kod[i] == kod[j]) {
                        return ("wartosci sie powtarzaja w " + i + " " + j);
                    }
                }
            }
        }
        return null;
    }
    Mastermind(int kod[]) {
        this.kod = kod;
        String powtarzlne = pow_wart();

        if(powtarzlne!=null){
      //      System.out.println(powtarzlne);
        }
    }
    void kod(){
        System.out.println("\nkod");
        for(int i=0; i<kod.length; i++)
            System.out.print(kod[i]+ " ");

    }
    /*
    public static void main(String[] args) {
        int kolor[]= new int[4];
        int kod[] = new int[4];
        kod[0]=0;
        kod[1]=1;
        kod[2]=2;
        kod[3]=3;
        kolor[0]=3; //popr
        kolor[1]=2; //popr
        kolor[2]=2; //popr
    //    kolor[3]=10; //popr
        Mastermind master = new Mastermind(kod);
        System.out.println(master.gra(kolor));
        System.out.println(master.gra(kolor));
       // kolor[3]=3;
     //   System.out.println(master.gra(kolor));
    }

     */
}
