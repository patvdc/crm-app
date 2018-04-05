package be.vdab.crm.repository;

import be.vdab.crm.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {



}
