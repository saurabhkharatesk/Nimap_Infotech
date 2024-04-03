package edu.main.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.main.entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{

}
