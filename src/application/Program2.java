package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("Teste DAO DEPARTMENT - 1 INSERT");
		Department newDep = new Department(null, "music");
		departmentDao.insert(newDep);
		System.out.println(newDep.getName() + " inserido com sucesso!!");
		
		System.out.println("Teste DAO DEPARTMENT - 2 DELETEBYID");
		departmentDao.deleteById(11);
		System.out.println("Delete complete!");
		
		System.out.println("Teste DAO DEPARTMENT - 3 FINDBYID");
		Department dep = departmentDao.findById(9);
		System.out.println(dep);
		
		System.out.println("Teste DAO DEPARTMENT - 4 UPDATE");
		Department department = departmentDao.findById(13);
		department.setName("Store");
		departmentDao.update(department);
		System.out.println("Teste DAO DEPARTMENT - 5 FINDALL");
		List<Department> list = departmentDao.findAll();
		
		for(Department obj : list) {
			System.out.println(obj);
		}
	}

}
