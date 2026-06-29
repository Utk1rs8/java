import java.util.Scanner;
public class BookMenu {
    public static void main(String s[])
    {
        Scanner scanner = new Scanner(System.in);
        Book[] books= new Book[10];
        int bkIdx=0;
        while(true)
        {
            System.err.println("Press 1 to view books.\nPress 2 to add books.\nAny other to exit.");
            String userAction=scanner.nextLine();
            if(userAction.equals("1"))
            {
                for(int i=0;i<books.length;i++)
                {
                    if(books[i]!=null)
                    {
                        System.out.println(books[i]);
                    }
                }
            }
            else if(userAction.equals("2"))
            {
                if(bkIdx==10)
                {
                    System.out.println("10 books added cannot add anymore");
                    continue;
                }
                System.out.println("Enter the title of the book: ");
                String tmpTitle=scanner.nextLine();
                System.out.println("Enter the author of the book: ");
                String tmpAuthor=scanner.nextLine();
                System.out.println("Enter the price of the book: ");
                float tmpPrice=Float.parseFloat(scanner.nextLine());
                Book bkTmp = new Book();
                bkTmp.setTitle(tmpTitle);
                bkTmp.setAuthor(tmpAuthor);
                bkTmp.setPrice(tmpPrice);
                books[bkIdx++]=bkTmp;
            }
            else
                break;
        }
    }
}
