package edu.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.main.entity.Product;
import edu.main.exception.ProductNotFoundException;
import edu.main.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService ps;
	
	
	@GetMapping("/api/products")
	public ResponseEntity<Object> getallproduct(@RequestParam(value = "page",defaultValue = "0",required = false)Integer page){
		List<Product> prodlist = ps.getallprod(page,1);
		return new ResponseEntity<Object>(prodlist,HttpStatus.OK);
	}
	
	@PostMapping("/api/products")
	public ResponseEntity<Object> saveProducts(@RequestBody Product product) {
		product = ps.addprod(product);
		return new ResponseEntity<Object>("Product is added sucessfully with id = " + product.getProdId(),HttpStatus.CREATED);
	}
	
	
	@GetMapping("/api/products/{di}")
	public ResponseEntity<Object>  getproduct(@PathVariable("di") int productId) {
		boolean isProductExist = ps.isProductExist(productId);
		if(isProductExist)
		{
			Product product=ps.getprodByid(productId);
			return new ResponseEntity<>(product,HttpStatus.OK);
		}else {
			throw new ProductNotFoundException();
		}
	}
	
	
	
	@PutMapping("/api/products/{di}")
	public ResponseEntity<Object> updateproduct(@RequestBody Product product ,@PathVariable("di") int id){
		boolean isProductExist = ps.isProductExist(id);
		if(isProductExist)
		{
			product.setProdId(id);
			ps.updateProd(product);
			return new ResponseEntity<Object>("Product is update successfully" , HttpStatus.OK);
		}else {
			throw new ProductNotFoundException();
		}
    }
	
	
	@DeleteMapping("/api/products/{di}")
	public ResponseEntity<Object> deleteProduct(@PathVariable("di") int productId) {
		boolean isProductExist = ps.isProductExist(productId);
		if(isProductExist)
		{
			ps.deleteprod(productId);
			return new ResponseEntity<Object>("Product is delete successfully" , HttpStatus.OK);
		}else {
			throw new ProductNotFoundException();
		}
	
	}
	
}
