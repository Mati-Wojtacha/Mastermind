import java.util.HashMap;

public class MasterDef {

    HashMap masters = new HashMap<Integer, Mastermind>();
    HashMap colours = new HashMap<Integer, Integer[]>();
    int[] code = new int[]{1,2,3,4};
    int[] code2 = new int[]{1,1,1,1};

    int[] code3 = new int[]{1,2,3,4,5,6,7,8,9,0};

    MasterDef(){
        Mastermind master1 = new Mastermind(code);
        Mastermind master2 = new Mastermind(code2);

        Mastermind master3 = new Mastermind(code3);
        masters.put(1, master1);
        masters.put(2, master2);

        masters.put(3, master3);


        colours.put(1, new int[]{1,2,3,4});
        colours.put(2, new int[]{1,2,3});
        colours.put(3, new int[]{1,5,2,1,5});
        colours.put(4, new int[]{1,5,3,1});
        colours.put(5, new int[]{5,6,7,8});
        colours.put(6, new int[]{4,3,2,1});
        colours.put(7, new int[]{0,6,2,1});
        colours.put(8, new int[]{2,6,2,10});
        colours.put(9, new int[]{1,1,1,1});
        colours.put(10, new int[]{10,11,12,13,14,15,16,17,18,19,20});
        colours.put(11, new int[]{0,10,9,8,7,6,5,4,3,1});
        colours.put(12, new int[]{1,2,3,4,5,6,7,8,9,0});
    }
}

