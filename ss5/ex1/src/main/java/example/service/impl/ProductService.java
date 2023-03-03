package example.service.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iProductRepository ;

    @Override
    public List<Product> listProduct(String nameSearch) {
        if (nameSearch == null) {
            nameSearch = "";
        }
        return iProductRepository.listProduct(nameSearch);
    }

    @Override
    public Object create(Product product) {
        iProductRepository.create(product);
        return null;
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void update(Product product) {
        iProductRepository.update(product);
    }

    @Override
    public void delete(int id) {
        iProductRepository.delete(id);
    }
}
