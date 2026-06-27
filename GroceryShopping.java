import java.util.Scanner;

// 1. Public class with a public main method
public class GroceryShopping {

    public static void main(String[] args) {

        // 2. String array of items to buy from a grocery shop (10-25 items)
        String[] items = {
            "Apple", "Banana", "Milk", "Bread", "Eggs",
            "Rice", "Sugar", "Salt", "Butter", "Cheese",
            "Tomato", "Onion"
        };

        // 3. float array of unit prices - same length, matching index positions
        float[] prices = {
            0.50f, 0.30f, 1.20f, 2.00f, 3.00f,
            1.50f, 0.80f, 0.40f, 2.50f, 3.20f,
            0.60f, 0.70f
        };

        // Additional challenge: Inventory Management - stock array, same length as items
        int[] stock = {
            20, 15, 10, 8, 30,
            25, 40, 50, 12, 10,
            18, 22
        };

        // 4. Import (above) + create a Scanner object to read from the console
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Welcome to the Grocery Shop =====");
        printMenu(items, prices, stock);

        // ---------- Additional challenge demos ----------

        // Item Search Functionality - test the method with different item names
        System.out.println("\n--- Testing item search ---");
        searchItem(items, "Milk");
        searchItem(items, "onion");
        searchItem(items, "Yogurt");

        // Calculate Average Price
        float averagePrice = calculateAveragePrice(prices);
        System.out.printf("%nAverage item price: $%.2f%n", averagePrice);

        // Filter Items Below a Certain Price - test with different thresholds
        System.out.println();
        filterItemsBelowPrice(items, prices, 1.00f);
        System.out.println();
        filterItemsBelowPrice(items, prices, 2.50f);

        // ---------- Main shopping loop ----------

        // 5. Outer infinite loop - runs as long as the user wants to,
        //    exits when the user types "exit" (any case)
        while (true) {
            float totalBill = 0;

            System.out.println("\nLet's start shopping! Type 'finish' when done, or 'exit' to quit anytime.");

            // 6. Inner infinite loop - runs as long as the user wants to add items,
            //    exits when the user types "finish" (any case).
            //    Otherwise checks the array for the item; if found, stores its index;
            //    if not found, throws an exception.
            while (true) {
                System.out.print("Enter item name: ");
                String userInput = scanner.nextLine().trim();

                if (userInput.equalsIgnoreCase("exit")) {
                    System.out.println("Thanks for stopping by. Goodbye!");
                    scanner.close();
                    return;
                }

                if (userInput.equalsIgnoreCase("finish")) {
                    break;
                }

                try {
                    int index = searchItem(items, userInput);

                    if (index == -1) {
                        throw new IllegalArgumentException("\"" + userInput + "\" is not sold here.");
                    }

                    System.out.print("Enter quantity: ");
                    int quantity = Integer.parseInt(scanner.nextLine().trim());

                    if (quantity <= 0) {
                        System.out.println("Quantity must be a positive number.");
                        continue;
                    }

                    // Additional challenge: Inventory Management - check stock before purchase
                    if (quantity > stock[index]) {
                        System.out.println(items[index] + " is out of stock! Only " + stock[index] + " left.");
                        continue;
                    }

                    stock[index] -= quantity;

                    // 7. Retrieve the price at the same index position and add it to the total
                    float lineTotal = prices[index] * quantity;
                    totalBill += lineTotal;

                    System.out.printf("Added %d x %s ($%.2f each) = $%.2f -- running total: $%.2f%n",
                            quantity, items[index], prices[index], lineTotal, totalBill);

                } catch (IllegalArgumentException e) {
                    System.out.println("Sorry: " + e.getMessage() + " Please try another item.");
                }
            }

            // 8. After choosing all required items, calculate and print the total bill,
            //    including the Additional challenge: Total Bill with Discounts
            float discountedTotal = totalBill;
            boolean discountApplied = false;

            if (totalBill > 100) {
                discountedTotal = totalBill * 0.90f;
                discountApplied = true;
            }

            System.out.printf("%nOriginal total: $%.2f%n", totalBill);
            if (discountApplied) {
                System.out.println("Your total exceeded $100, so a 10% discount has been applied!");
            }
            System.out.printf("Discounted total: $%.2f%n", discountedTotal);

            System.out.println("Type 'exit' to leave, or press Enter to start a new order.");
            String continueInput = scanner.nextLine().trim();
            if (continueInput.equalsIgnoreCase("exit")) {
                System.out.println("Thanks for shopping with us. Goodbye!");
                break;
            }
        }

        scanner.close();
    }

    private static void printMenu(String[] items, float[] prices, int[] stock) {
        System.out.println("\nAvailable items:");
        for (int i = 0; i < items.length; i++) {
            System.out.printf("  %-10s $%.2f   (stock: %d)%n", items[i], prices[i], stock[i]);
        }
    }

    // Additional challenge: Item Search Functionality
    private static int searchItem(String[] items, String itemName) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].equalsIgnoreCase(itemName)) {
                System.out.println(items[i] + " found at index " + i + ".");
                return i;
            }
        }
        System.out.println("Item not found.");
        return -1;
    }

    // Additional challenge: Calculate Average Price
    private static float calculateAveragePrice(float[] prices) {
        float total = 0;
        for (int i = 0; i < prices.length; i++) {
            total += prices[i];
        }
        return total / prices.length;
    }

    // Additional challenge: Filter Items Below a Certain Price
    private static void filterItemsBelowPrice(String[] items, float[] prices, float threshold) {
        System.out.printf("Items priced below $%.2f:%n", threshold);
        boolean anyFound = false;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < threshold) {
                System.out.println("  " + items[i]);
                anyFound = true;
            }
        }
        if (!anyFound) {
            System.out.println("  (no items below this price)");
        }
    }
}
