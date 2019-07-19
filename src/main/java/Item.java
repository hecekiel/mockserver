public class Item {
    int Id;
    String title;
    String category_id;
    float price;
    String currency_id;
    int quantity;
    String condition;
    String[] pictures;

    public Item(int id) {
        this.Id = id;
        this.title = "Titulo del item";
        this.category_id = "MLA" + Id;
        this.price = 100.0F;
        this.currency_id = "ARS";
        this.quantity = 10;
        this.condition = "New";
        this.pictures = new String[] {"img1.png", "img2.png"};
    }
}
