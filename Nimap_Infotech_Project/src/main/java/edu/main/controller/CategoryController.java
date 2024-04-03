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

import edu.main.entity.Category;
import edu.main.entity.Product;
import edu.main.exception.CategoryNotFoundException;
import edu.main.exception.ProductNotFoundException;
import edu.main.service.CategoryService;



@RestController
public class CategoryController {

	@Autowired
	CategoryService cr;
	
	@GetMapping("/api/categories")
	public ResponseEntity<Object> getallcategory(@RequestParam (value = "page",defaultValue = "0",required = false)Integer page){
		List<Category> catlist = cr.getallcategory(page,2);
		return new ResponseEntity<Object>(catlist,HttpStatus.OK);
	}
	
	@PostMapping("/api/categories")
	public ResponseEntity<Object> saveCategories(@RequestBody Category category) {
		category = cr.addCategory(category);
		return new ResponseEntity<Object>("Categorie is added sucessfully with id = " + category.getCategoryId(),HttpStatus.CREATED);
	}
	
	@GetMapping("/api/categories/{di}")
	public ResponseEntity<Object> getcategory(@PathVariable("di") int categoryid) {
		boolean isProductExist = cr.isCategoryExist(categoryid);
		if(isProductExist)
		{
			Category product=cr.getcategoryByid(categoryid);
			return new ResponseEntity<>(product,HttpStatus.OK);
		}else {
			throw new CategoryNotFoundException();
		}
	}
	
	@PutMapping("/api/categories/{di}")
	public ResponseEntity<Object> updateCategory(@RequestBody Category category,@PathVariable("di") int id){
		boolean isProductExist = cr.isCategoryExist(id);
		if(isProductExist)
		{
			category.setCategoryId(id);
			cr.updateCategory(category);
			return new ResponseEntity<Object>("Category is update successfully" , HttpStatus.OK);
		}else {
			throw new CategoryNotFoundException();
		}	
	}
	
	@DeleteMapping("/api/categories/{di}")
	public ResponseEntity<Object> deleteCategoryById(@PathVariable("di") int categoryid) {
		boolean isProductExist = cr.isCategoryExist(categoryid);
		if(isProductExist)
		{
			cr.deleteCategoryById(categoryid);
			return new ResponseEntity<Object>("Category is delete successfully" , HttpStatus.OK);
		}else {
			throw new CategoryNotFoundException();
		}
	
	}  
	
	
}