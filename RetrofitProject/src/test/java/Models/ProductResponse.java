package Models;

import java.util.Comparator;
import java.util.List;

public class ProductResponse {
    private Product product;
    private List<Product> products;
    private String error;

    public boolean ok() {
        return product != null;
    }

    public Product getProduct() {
        return product;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setProducts(List<Product> product) {
        this.products = product;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ProductResponse{" +
                "product=" + product +
                ", error='" + error + '\'' +
                '}';
    }

    public static final Comparator<Product> COMPARE_BY_COUNT = new Comparator<Product>() {
        @Override
        public int compare(Product lhs, Product rhs) {
            return (int) (lhs.getId() - rhs.getId());
        }
    };
}
