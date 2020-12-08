package property;

public class Item {
    private int price;

    public Item() {}
    public Item (int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void effect() {
        System.out.println("效果");
    }

    public static void main(String[] args) {

    }
}
