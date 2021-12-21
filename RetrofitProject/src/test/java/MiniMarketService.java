import java.io.IOException;
import java.util.List;

import Models.Category;
import Models.CategoryResponse;
import Models.Product;
import Models.ProductResponse;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class MiniMarketService {
    private final MiniMarketApi api;

    public MiniMarketService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://minimarket1.herokuapp.com/market/api/v1/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        api = retrofit.create(MiniMarketApi.class);
    }

    public CategoryResponse getCategory(Long id) throws IOException {
        Response<Category> response = api.getCategory(id).execute();
        CategoryResponse categoryResponse = new CategoryResponse();
        if (response.isSuccessful()) {
            categoryResponse.setCategory(response.body());
        } else {
            categoryResponse.setError(response.errorBody().string());
        }
        return categoryResponse;
    }

    public ProductResponse getProducts() throws IOException {
        Response<List<Product>> response = api.getProducts().execute();
        ProductResponse productResponse = new ProductResponse();
        if (response.isSuccessful()) {
            productResponse.setProducts(response.body());
        } else {
            productResponse.setError(response.errorBody().string());
        }
        return productResponse;
    }

    public ProductResponse getProduct(Long id) throws IOException {
        Response<Product> response = api.getProduct(id).execute();
        ProductResponse productResponse = new ProductResponse();
        if (response.isSuccessful()) {
            productResponse.setProduct(response.body());
        } else {
            productResponse.setError(response.errorBody().string());
        }
        return productResponse;
    }

    public String createProduct(Product product) throws IOException {
        Response response = api.createProduct(product).execute();
        if (response.isSuccessful()) {
            return "Product successfully created.";
        } else {
            return "Error: " + response.errorBody().string();
        }
    }

    public String updateProduct(Product product) throws IOException {
        Response response = api.updateProduct(product).execute();
        if (response.isSuccessful()) {
            return "Product successfully updated.";
        } else {
            return "Error: " + response.errorBody().string();
        }
    }

    public String deleteProduct(Long id) throws IOException {
        Response response = api.deleteProduct(id).execute();
        if (response.isSuccessful()) {
            return "Product successfully deleted.";
        } else {
            return "Error: " + response.errorBody().string();
        }
    }
}
