package model.dao;

import java.util.List;

import model.entities.Department;
import model.entities.Seller;

public interface DepartmentDao {
	
	void insert(Department obj);
	void update(Department obj);
	void deleteById(Integer id);
	Seller findById(Integer id);
	List<Seller> findAll();
	
}
