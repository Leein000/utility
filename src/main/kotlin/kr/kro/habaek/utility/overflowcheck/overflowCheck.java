package kr.kro.habaek.utility.overflowcheck;

public class overflowCheck {

    public static void main(String[] args) {


        String a = " ";
        String b = " ";

        boolean check = (a.equals(b));
        System.out.println("a == b:" + check);

        int i = Integer.MAX_VALUE + 1;
        System.out.println(i);
        String value = Integer.toUnsignedString(i);
        System.out.println(value);
    }
}
