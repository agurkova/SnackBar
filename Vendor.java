/**
 * This class implements a vendor that sells one kind of items.
 * A vendor carries out sales transactions.
 * @author (Alice Gurkova)
 * @version (11/11/2018)
 */

public class Vendor {
    // Fields:
    private int availableStock;
    private int price;
    private int currentDepositedAmount;
    private int changeDue;

    //  Constructor
    //  Parameters:
    //    int price of a single item in cents
    //    int number of items to place in stock
    public Vendor(int singleItemPrice, int numberToStock) {
        availableStock = numberToStock;
        price = singleItemPrice;
        currentDepositedAmount = 0;
        changeDue = 0;

    }

    //  Sets the quantity of items in stock.
    //  Parameters:
    //    int number of items to place in stock
    //  Return:
    //    None
    public void setStock(int numberToPlace) {
        availableStock = numberToPlace;
    }

    //  Returns the number of items currently in stock.
    //  Parameters:
    //    None
    //  Return:
    //    int number of items currently in stock
    public int getStock() {
        return availableStock;
    }

    //  Adds a specified amount (in cents) to the deposited amount.
    //  Parameters:
    //    int number of cents to add to the deposit
    //  Return:
    //    None
    public void addMoney(int centsToAdd) {
        currentDepositedAmount += centsToAdd;
    }

    //  Returns the currently deposited amount (in cents).
    //  Parameters:
    //    None
    //  Return:
    //    int number of cents in the current deposit
    public int getDeposit() {
        return currentDepositedAmount;
    }

    //  Implements a sale.  If there are items in stock and
    //  the deposited amount is greater than or equal to
    //  the single item price, then adjusts the stock
    //  and calculates and sets change and returns true;
    //  otherwise refunds the whole deposit (moves it into change)
    //  and returns false.
    //  Parameters:
    //    None
    //  Return:
    //    boolean successful sale (true) or failure (false)
    public boolean makeSale() {
        if (availableStock > 0 && currentDepositedAmount >= price) {
            availableStock--;
            changeDue = currentDepositedAmount - price;
            currentDepositedAmount = 0;
            return true;
        } else {
            changeDue = currentDepositedAmount;
            currentDepositedAmount = 0;
            return false;
        }
    }

    //  Returns and zeroes out the amount of change (from the last
    //  sale or refund).
    //  Parameters:
    //    None
    //  Return:
    //    int number of cents in the current change
    public int getChange() {
        int amountToBeReturned = changeDue;
        changeDue = 0;
        return amountToBeReturned;
    }
}
