package edu.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.main.entity.Category;
import edu.main.entity.Product;
import edu.main.repository.CategoryRepository;
import edu.main.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository pr;
	@Autowired
	CategoryRepository cr;
	

	@Override
	public Product getprodByid(int productid) {
	   return pr.findById(productid).get();
	}

	@Override
	public void updateProd(Product product) {
		 Category c  =   cr.findBycategoryId(product.getCategory().getCategoryId());
		 product.setCategory(c);
		  pr.save(product);
	}

	@Override
	public List<Product> getallprod(int page, int pagesize) {
		Pageable pagable= PageRequest.of(page, pagesize);
		Page<Product> pageproduct = pr.findAll(pagable);
		List<Product> prodList=pageproduct.getContent();
		return prodList;
	}

	@Override
	public void deleteprod(int productid) {
		pr.deleteById(productid);
	}

	@Override
	public Product addprod(Product prod) {
		return pr.save(prod);
	}

	@Override
	public boolean isProductExist(int id) {
		return pr.existsById(id);
	}

}
