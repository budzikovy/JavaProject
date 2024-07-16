import services.ProductService;
import utils.Initializer;
import view.CLI;

public class Main {
    public static void main(String[] args) {
        ProductService productManager = new ProductService();
        Initializer.initializeProducts(productManager);

        CLI cli = new CLI(productManager);
        cli.start();
    }
}