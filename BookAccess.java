public class BookAccess {
    private static void comparePrice(Book book1,Book book2)
    {
        float book1Price=book1.getPrice();
        float book2Price=book2.getPrice();
        String priceCmp="";

        if (book1Price<book2Price)
        {
            priceCmp=book1.getTitle()+" Cost less than "+ book2.getTitle();
        }
        else if(book1Price == book2Price)
        {
            priceCmp=book1.getTitle()+" is equal to " + book2.getTitle();
        }
        else
        {
            priceCmp=book1.getTitle()+" Cost greater than "+ book2.getTitle();
        }
        System.out.println(priceCmp);

    }

    public static void main(String s[])
    {
        Book book1 = new Book();
        book1.setTitle("Atomic Habits");
        book1.setAuthor("James Clear");
        book1.setPrice(20.00f);
        Book book2 = new Book();
        book2.setTitle("Sapiens");
        book2.setAuthor("Noah Harbor");
        book2.setPrice(25.00f);
        System.out.println("First Book Details:");
        System.out.println(book1);
        System.out.println("Second Book Details:");
        System.out.println(book2);
        comparePrice(book1,book2);
    }
}
