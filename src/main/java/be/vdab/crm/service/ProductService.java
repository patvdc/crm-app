package be.vdab.crm.service;

import be.vdab.crm.entity.Product;
import be.vdab.crm.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts() {return repository.findAll();}

    public void save(Product p) {repository.save(p);}


    public void delete(int id) {
        repository.deleteById(id);
    }
}
