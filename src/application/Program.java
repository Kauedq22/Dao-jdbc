package application;

import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {

		Department obj = new Department(1, "books");
		Seller seller = new Seller(21, "Isa Pinto", "isaadoraPinto@gmail.com", new Date(), 2022.0 , obj);
		
		System.out.println(seller);


	}
}
