import java.io.IOException;
import java.util.Collections;
import java.util.List;

import Models.Product;
import Models.ProductResponse;

public class Test {
    public static void main(String[] args) throws IOException, InterruptedException {
        MiniMarketService service = new MiniMarketService();
        Product tempProduct = new Product();
        //tempProduct.setId(100L);
        tempProduct.setPrice(100);
        tempProduct.setTitle("Robul Food");
        tempProduct.setCategoryTitle("Food");

        System.out.println("Creations: " + service.createProduct(tempProduct));
        Thread.sleep(1000);
        List<Product> products = service.getProducts().getProducts();
        Collections.sort(products, ProductResponse.COMPARE_BY_COUNT);
        for (Product product: products) {
            System.out.println(product);
        }
        if (products != null)
            tempProduct.setId(products.get(products.size() - 1).getId());
        System.out.println("Get product: " + service.getProduct(tempProduct.getId()));

        tempProduct.setPrice(200);
        System.out.println("Update: " + service.updateProduct(tempProduct));
        System.out.println("Get product: " + service.getProduct(tempProduct.getId()));
        products = service.getProducts().getProducts();
        Collections.sort(products, ProductResponse.COMPARE_BY_COUNT);
        for (Product product: products) {
            System.out.println(product);
        }
        if (products != null)
            tempProduct.setId(products.get(products.size() - 1).getId());
        System.out.println("Delete product: " + service.deleteProduct(tempProduct.getId()));
        //System.out.println(service.getProduct(tempProduct.getId()));
    }
}

