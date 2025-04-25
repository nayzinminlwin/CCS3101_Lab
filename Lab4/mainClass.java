package Lab4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class mainClass
{
    public static void main(String[] args) {

        Circle circle0 = new Circle(20,true);
        MyDate startDate = new MyDate(12, 12, 2024);
        MyDate endDate = new MyDate(11, 1, 2025);
        Loan studentLoan = new Loan(8000, 10, startDate, endDate);
        String o_i_a_cat = "O-i-i-a-i-o, o-i-i-i-a-i";

        ArrayList<Object> campur = new ArrayList<Object>();
        // Collections.addAll(campur,circle0,o_i_a_cat,startDate,endDate,studentLoan);
        // campur.addAll(Arrays.asList(circle0,o_i_a_cat,startDate,endDate,studentLoan));
        campur.addAll(List.of(circle0,o_i_a_cat,startDate,endDate,studentLoan));

        for (Object OO : campur) {
            System.out.println(OO.toString());
        }
    }
}