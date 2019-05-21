package org.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.bookstore.entity.Category;



public class CategoryDAO extends JpaDAO<Category> implements GenericDAO<Category>  {

	public CategoryDAO(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public Category create(Category category) {
		return super.create(category);
	}

	@Override
	public Category update(Category category) {
		return super.update(category);
	}

	@Override
	public Category get(Object id) {
		return super.find(Category.class, id);
	}

	@Override
	public void delete(Object id) {
		super.delete(Category.class, id);
	}

	@Override
	public List<Category> listAll() {
		return super.findwithNamedQuery("Category.findAll");
	}

	@Override
	public long count() {
		return super.countwithNamedQuery("Category.countAll");
	}
	
	public Category findByName(String categoryName) {
		
		List<Category> result = super.findwithNamedQuery("Category.findByName", "categoryName",categoryName);
		
		if(result != null && result.size()>0){
			return result.get(0);
		}
		return null;
	}

}
