import java.util.Scanner;
public class ExceptionTrail {
    public static void main(String s[])
    {
        Scanner scanner = new Scanner(System.in);
        String strArr[] = new String[5];
        int strIdx = 0;
        while (true) {
            System.out.println("Press 1 to add String,\n2 to get particular index,\n3 to get length string in any index,\n4 to get all string in array,\nother no. to exit.");
            String userAction = scanner.nextLine();
            if(userAction.equals("1"))
            {
                if (strIdx == 5) {
                    System.out.println("There are already 5 Strings");
                } else{
                    System.out.println("Enter any String: ");
                    String inputStr= scanner.nextLine();
                    strArr[strIdx++]=inputStr;
                }
            }
            else if(userAction.equals("2") ){
                System.out.println("Enter the Index you want to retrive: ");
                int retIdx=Integer.parseInt(scanner.nextLine());
                System.out.println(strArr[retIdx]);

            }
            else if(userAction.equals("3"))
            {
                System.out.println("Enter the Index you want to check the length of: ");
                int retIdx=Integer.parseInt(scanner.nextLine());
                System.out.println(strArr[retIdx].length()); 
            }
            else if(userAction.equals("4"))
            {
                for( int i=0;i<5;i++){
                    System.out.println(strArr[i]);
                }
            }
            else
                break;
        }
        scanner.close();
    }
}