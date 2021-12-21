package Models;

import java.util.List;

public class CategoryResponse {
    private Category category;
    private List<Product> products;
    private String error;

    public boolean ok() {
        return category != null;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
                "product=" + category +
                ", error='" + error + '\'' +
                '}';
    }
}
