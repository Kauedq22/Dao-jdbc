package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		System.out.println("------ Teste 1: department findById ------");
		Department department = departmentDao.findById(2);
		System.out.println(department);
		
		System.out.println("\n------ Teste 2: department findByAll ------");
		List<Department> list = departmentDao.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n------ Teste 3: department Update ------");
		department = departmentDao.findById(3);
		department.setName("Food");
		departmentDao.update(department);
		System.out.println("Atualizado!");
		
		System.out.println("\n------ Teste 4: department Insert ------");
		Department newDepartment = new Department(null, "Games");
		departmentDao.insert(newDepartment);
		System.out.println("Inserido! novo id " + newDepartment.getId());
		
		System.out.println("\n------ Teste 5: department Delete ------");
		System.out.print("Entre com Id para ser deletado: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Id: " + id + " deletado");
		sc.close();
	}
}
