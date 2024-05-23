package application;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== TEST 1: SELLER FINDBYID =====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("\n=== TEST 2: Seller findByDepartment =====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: Seller findAll =====");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("\n=== TEST 4: Seller Insert =====");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n=== TEST 5: Seller Update =====");
		seller = sellerDao.findById(1);
		seller.setName("Bob Brown");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 6: Seller Delete =====");
		sellerDao.deleteById(Integer.parseInt(JOptionPane.showInputDialog("Digite o id do seller a ser deletado: ")));
		System.out.println("Usar deleted sucessfull!");
	}
}
