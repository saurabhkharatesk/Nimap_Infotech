package edu.main.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Category {
	
	  @Id
	  private int categoryId;
	  private String categoryName;
	  
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
	  
	  
}
