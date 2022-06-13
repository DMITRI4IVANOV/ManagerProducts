package Product.Manager;

import Product.Book;
import Product.Product;
import Product.Repository.ProductRepository;
import Product.Smartphone;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        this.repository.save(product);
    }

    public Product[] searchBy( String text) {
        Product[] products = this.repository.findAll();

        Product[] result = new Product[0];

        for ( Product item: products) {
            if (this.matches(item, text)) {
                int length = result.length + 1;
                Product[] tmp = new Product[length];
                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = item;
                result = tmp;
            }
        }
        return result;
    }
    public boolean matches(Product product, String search){
        if (product instanceof Book){
            Book book = (Book) product;
            if (book.getTitle().equalsIgnoreCase(search)){
                return true;
            }
            if (book.getAuthor().equalsIgnoreCase(search)){
                return true;
            }
            return false;
        } else if ( product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getTitle().equalsIgnoreCase(search)) {
                return true;
            }
            if (smartphone.getCompany().equalsIgnoreCase(search)) {
                return true;
            }
            return false;
        }else {
            if (product.getTitle().equalsIgnoreCase(search)){
                return true;
            }
            return false;

        }
    }

}