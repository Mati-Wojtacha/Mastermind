
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowableOfType;

public class MastermindTest {
//    HashMap masters = new HashMap<Integer, Mastermind>();
//    HashMap colours = new HashMap<Integer, Integer[]>();
//    int[] code = new int[]{1,2,3,4};
//    int[] code2 = new int[]{1,1,1,1};
//
//    int[] code3 = new int[]{1,2,3,4,5,6,7,8,9,0};

    @Before
    public void before() {
//        Mastermind master1 = new Mastermind(code);
//        Mastermind master2 = new Mastermind(code2);
//
//        Mastermind master3 = new Mastermind(code3);
//        masters.put(1, master1);
//        masters.put(2, master2);
//
//        masters.put(3, master3);
//
//
//        colours.put(1, new int[]{1,2,3,4});
//        colours.put(2, new int[]{1,2,3});
//        colours.put(3, new int[]{1,5,2,1,5});
//        colours.put(4, new int[]{1,5,3,1});
//        colours.put(5, new int[]{5,6,7,8});
//        colours.put(6, new int[]{4,3,2,1});
//        colours.put(7, new int[]{0,6,2,1});
//        colours.put(8, new int[]{2,6,2,10});
//        colours.put(9, new int[]{1,1,1,1});
//        colours.put(10, new int[]{10,11,12,13,14,15,16,17,18,19,20});
//        colours.put(11, new int[]{0,10,9,8,7,6,5,4,3,1});
//        colours.put(12, new int[]{1,2,3,4,5,6,7,8,9,0});
    }

    @Test
    public void exc_eqaul_leng() {

        int[] code = new int[]{1,2,3,4};
        int[] colour = new int[]{1,2,3};
        Mastermind mind = new Mastermind(code);
        mind.kod();

        RuntimeException throwable = catchThrowableOfType(
                () ->{
                    mind.gra(colour);
                }, RuntimeException.class
        );
       // String mess=throwable.getMessage();
        assertThat(throwable. getMessage()).isEqualTo(Mastermind.BLAD_DLUGOSCI);
    }

    @Test
    public void code_equal_colour(){

         int[] code = new int[]{1,2,3,4};
         Mastermind mind = new Mastermind(code);
           mind.kod();
        int [] colour = new int[]{1,2,3,4};
        boolean expected = true;

        //when
        boolean result = mind.gra(colour);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void chech_result_false(){
         int[] code = new int[]{1,2,3,4};
        Mastermind mind = new Mastermind( code);
        mind.kod();

        boolean expected = false;
        boolean result = mind.sprawdz_rezultat(2);

        assertThat(result).isEqualTo(expected);
    }
    @Test
    public void chech_result_true(){
         int[] code = new int[]{1,2,3,4};

        Mastermind mind = new Mastermind(code);
        mind.kod();

        boolean expected = true;


        boolean result = mind.sprawdz_rezultat(4);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void code_notequal_colour(){

         int[] code = new int[]{1,2,3,4};

        int[] colour = new int[]{1,5,3,1};
        Mastermind mind = new Mastermind(code);
        mind.kod();

        
        boolean expected = false;

        //when
        boolean result = mind.gra(colour);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void equal_leng(){

         int[] code = new int[]{1,2,3,4};
        int[] colour = new int[]{1,2,3,4};

        Mastermind mind = new Mastermind(code);
        mind.kod();

        String expected = Mastermind.ROWNA_DLUGOSC;

        String result = mind.sprawdzanie(colour);

        assertThat(result).isEqualTo(expected);
    }


    @Test
    public void too_much_leng(){

         int[] code = new int[]{1,2,3,4};
         int[] colour = new int[]{1,5,2,1,5};

        Mastermind mind = new Mastermind(code);
        mind.kod();

     
        String expected = Mastermind.ZA_DUZO;


        String result = mind.sprawdzanie(colour);

        assertThat(result).isEqualTo(expected);
    }


    @Test
    public void chech_repeat_number() {


        int[] code2 = new int[]{1,1,1,1};
        Mastermind mind = new Mastermind(code2);
        mind.kod();
        
     
        
        String expected = "wartosci";

        String result = mind.pow_wart();
        assertThat(result, containsString(expected));
    }

    @Test
    public void chech_not_reapeat_number() {
         int[] code = new int[]{1,2,3,4};

        Mastermind mind = new Mastermind(code);
        mind.kod();
        
        
        
        String result = mind.pow_wart();

        assertThat(result).isNull();
    }

    @Test
    public void result_true() {

        int[] code = new int[]{1,2,3,4};
        int[] colour= new int[]{1,2,3,4};
        Mastermind mind = new Mastermind(code);
        mind.kod();

        
        
        Wynik result = mind.wynik(colour);

        assertThat(result.poprawnie).isEqualTo(4);
        assertThat(result.znalezione).isEqualTo(0);
    }

    @Test
    public void result_not_true() {

        int[] code = new int[]{1,2,3,4};
        int []colour = new int[]{5,6,7,8};
        Mastermind mind = new Mastermind(code);
        mind.kod();

        
        
        Wynik result = mind.wynik(colour);

        assertThat(result.poprawnie).isEqualTo(0);
        assertThat(result.znalezione).isEqualTo(0);
    }

    @Test
    public void result_found_and_true() {

         int[] code = new int[]{1,2,3,4};

        int [] colour= new int[]{1,5,3,1};
        Mastermind mind = new Mastermind(code);
        mind.kod();

        
        
        Wynik result = mind.wynik(colour);

        assertThat(result.poprawnie).isEqualTo(2);
        assertThat(result.znalezione).isEqualTo(1);
    }

    @Test
    public void result_found_all() {
         int[] code = new int[]{1,2,3,4};
         int[] colour = new int[]{4,3,2,1};


        Mastermind mind = new Mastermind(code);
        mind.kod();

        
        Wynik result = mind.wynik(colour);

        assertThat(result.poprawnie).isEqualTo(0);
        assertThat(result.znalezione).isEqualTo(4);
    }

    @Test
    public void result_found_half() {
        int[] code = new int[]{1,2,3,4};

        int[] colour= new int[]{0,6,2,1};

        Mastermind mind = new Mastermind(code);
        mind.kod();

        
        Wynik result = mind.wynik(colour);

        assertThat(result.poprawnie).isEqualTo(0);
        assertThat(result.znalezione).isEqualTo(2);
    }

    @Test
    public void result_found_repeat() {

        int[] code = new int[]{1,2,3,4};
        int[] colour =  new int[]{2,6,2,10};


        Mastermind mind = new Mastermind(code);
        mind.kod();

        
        Wynik result = mind.wynik(colour);

        assertThat(result.poprawnie).isEqualTo(0);
        assertThat(result.znalezione).isEqualTo(2);
    }

    @Test
    public void result_repeat() {

         int[] code = new int[]{1,2,3,4};
        int [] colour =  new int[]{0,0,3,1};

        Mastermind mind = new Mastermind (code);
        mind.kod();

        Wynik result = mind.wynik(colour);

        assertThat(result.poprawnie).isEqualTo(1);
        assertThat(result.znalezione).isEqualTo(0);
    }

    @Test
    public void result_big_not_true() {

        int[] code3 = new int[]{1,2,3,4,5,6,7,8,9,0};
        int [] colour = new int[]{10,11,12,13,14,15,16,17,18,19,20};
        Mastermind mind = new Mastermind(code3);
        mind.kod();


        Wynik result = mind.wynik(colour);

        assertThat(result.poprawnie).isEqualTo(0);
        assertThat(result.znalezione).isEqualTo(0);
    }

    @Test
    public void result_big_found() {


        int[] code3 = new int[]{1,2,3,4,5,6,7,8,9,0};
      int[] colour = new int[]{1,1,3,3,3,3,5,4,3,1};
        Mastermind mind = new Mastermind(code3);
        mind.kod();

        Wynik result = mind.wynik(colour);

        assertThat(result.poprawnie).isEqualTo(1);
        assertThat(result.znalezione).isEqualTo(8);
    }
    @Test
    public void result_big_true() {


        int[] code3 = new int[]{1,2,3,4,5,6,7,8,9,0};
        int [] colour= new int[]{1,2,3,4,5,6,7,8,9,0};
        Mastermind mind = new Mastermind(code3);
        mind.kod();

        Wynik result = mind.wynik(colour);

        assertThat(result.poprawnie).isEqualTo(10);
        assertThat(result.znalezione).isEqualTo(0);
    }
}
