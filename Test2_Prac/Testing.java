package Test2_Prac;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;

public class Testing {
    public static void main(String[] args) {
        Integer[] iArr = { 1, 2, 3, 4, 5 };
        ArrayList<Integer> iList = new ArrayList<>(Arrays.asList(iArr));
        Collections.shuffle(iList);
        System.out.println(iList);
    }
}