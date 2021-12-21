package Models;

import java.util.List;

public class Category {
    private Long id;
    private List<Product> products;
    private String title;

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProducts(List<Product> products){
        this.products = products;
    }

    public List<Product> getProducts(){
        return products;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
