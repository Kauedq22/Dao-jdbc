package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("------ Teste 1: seller findById ------");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n------ Teste 2: seller findByDepartment ------");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for(Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("\n------ Teste 3: seller FindAll ------");
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		 System.out.println("\n------ Teste 4: seller Insert ------");
		Seller newSeller = new Seller(null, "Neymar", "NeymarJr@gmail.com", new Date(), 30000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserido! novo id " + newSeller.getId()); 
		
		System.out.println("\n------ Teste 5: seller Update ------");
		seller = sellerDao.findById(11);
		seller.setName("Bruce Waine");
		sellerDao.update(seller);
		System.out.println("Atualizado");
		
		System.out.println("\n------ Teste 6: seller Delete ------");
		System.out.print("Entre com id para deletar: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("id: " + id + " deletado");
		sc.close();
	}
}
