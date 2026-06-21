public class PrintStrAsCharArr {
    public static void main(String s[])
    {
        String myStr="The Quick Brown Fox Jumped Over the Lazy Dog";
        char[] chrArr= myStr.toCharArray();
        for (int i=0;i<chrArr.length;i++)
        {
            System.out.println(chrArr[i]);
        }
    }
}
