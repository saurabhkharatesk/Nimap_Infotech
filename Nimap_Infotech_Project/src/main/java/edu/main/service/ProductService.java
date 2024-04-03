package edu.main.service;

import java.util.List;

import edu.main.entity.Product;

public interface ProductService {
	public Product getprodByid(int productid);
	public List<Product> getallprod(int page,int pagesize);
	public Product addprod(Product prod);
	public void updateProd(Product product);
	public void deleteprod(int productid);
	
	public boolean isProductExist(int id);
}
