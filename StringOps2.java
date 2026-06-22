public class StringOps2 {
    public static void main(String s[])
    {
        String s1="The Quick Brown Fox Jumped Over the Lazy Dog";
        System.out.println(s1.length());
        char[] strAsArr=s1.toCharArray();
        System.out.println(strAsArr.length);
        System.out.println("The first char of the string " + strAsArr[0]);
        System.out.println("The last char of the string " + strAsArr[strAsArr.length-1]);
        System.out.println("The Index of T is "+ s1.indexOf('T'));
        System.out.println("The Index of gx is "+ s1.indexOf('g'));

    }
    
}
