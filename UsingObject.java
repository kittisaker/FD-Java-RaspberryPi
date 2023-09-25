import java.util.ArrayList;
import java.util.List;

public class UsingObject {
    public static void main(String[] args) {

        List<ShoppingCartItem> items = new ArrayList<>();

        items.add(0, new ShoppingCartItem("Raspberry Pi 4, 4Gb", 1, 59.95F));
        items.add(new ShoppingCartItem("Micro-HDMI cable", 2, 5.9F));
        items.add(new ShoppingCartItem("Raspberry Pi 4 power supply", 1, 9.95F));

        showInfo(items);
   }

   static void showInfo(List<ShoppingCartItem> items){
        double total = 0D;
        for(ShoppingCartItem item : items){
            
            System.out.println(item.getName());
            System.out.println("    " + item.getQuantity() + "\tx\t"
                + item.getPrice() + "\t= " + item.getTotal() + " Euro");
            System.out.println("Price : " + item.getPrice());
            total += item.getTotal();
        }
        System.out.println("\nTotal for shopping cart:\n   " + total + " Euro");
   }
}
