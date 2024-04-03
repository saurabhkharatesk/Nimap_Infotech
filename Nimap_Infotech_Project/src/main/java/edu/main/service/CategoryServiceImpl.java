package edu.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.main.entity.Category;
import edu.main.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryRepository cr; 
	
	@Override
	public List<Category> getallcategory(int page, int pagesize) {
		Pageable p=PageRequest.of(page,pagesize);
		Page<Category> pageCategory=cr.findAll(p);
		List<Category> categoryList=pageCategory.getContent();
		return categoryList;
	}

	@Override
	public void updateCategory(Category category) {
		   cr.save(category);
	}

	@Override
	public Category getcategoryByid(int categoryid) {
		return cr.findById(categoryid).get();
	}

	@Override
	public void deleteCategoryById(int categoryid) {
		cr.deleteById(categoryid);
	}

	@Override
	public Category addCategory(Category category) {
		return cr.save(category);
	}

	@Override
	public boolean isCategoryExist(int id) {
		return cr.existsById(id);
	}

}
