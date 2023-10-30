package com.sammy;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

import com.sammy.entity.Address;
import com.sammy.entity.Category;
import com.sammy.entity.Emp;
import com.sammy.entity.Mobile;
import com.sammy.entity.Product;
import com.sammy.repository.AddressRepo;
import com.sammy.repository.CategoryRepo;
import com.sammy.repository.EmpRepo;
import com.sammy.repository.MobileRepo;
import com.sammy.repository.ProductRepo;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private EmpRepo empRepo;

	@Autowired
	private MobileRepo mobileRepo;
	
	//OneToMany or ManyToOne
	@Autowired
	private AddressRepo addressRepo;

	
	//ManyToMany
	@Autowired
	private CategoryRepo cateRepo;
	
	@Autowired
	private ProductRepo pRepo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		 * Emp emp = new Emp(); emp.setEmpName("Rahul");
		 * 
		 * Mobile mb = new Mobile(); mb.setMobileName("Iphone 13");
		 * 
		 * // emp.setMobile(mb); //Bi directional mb.setEmp(emp);
		 * 
		 * //Bi directional empRepo.save(emp); mobileRepo.save(mb);
		 * 
		 * //Uni directional // empRepo.save(emp); // mobileRepo.save(mb);
		 * System.out.println("Save Success");
		 */
		
		//Uni Directional
		/*
		 * Emp emp = empRepo.findById(1).get(); System.out.println("Name=" +
		 * emp.getEmpName()); System.out.println("Mobile=" +
		 * emp.getMobile().getMobileName());
		 */
		
		
		//Bi Directional
		/*
		 * Mobile mb = mobileRepo.findById(4).get(); System.out.println("Emp Name="
		 * +mb.getEmp().getEmpName()); System.out.println("Mobile="
		 * +mb.getMobileName());
		 */
		
		
		
		//ONETOMANY or MANYTOONE 
		/*
		 * Emp emp=new Emp(); emp.setEmpName("Ankit");
		 * 
		 * Address ad=new Address(); ad.setAddress("Odisha");
		 * ad.setType("Permanent address"); ad.setEmp(emp);
		 * 
		 * Address ad2=new Address(); ad2.setAddress("Pune");
		 * ad2.setType("Current address"); ad2.setEmp(emp);
		 * 
		 * Address ad3=new Address(); ad3.setAddress("Bangalore");
		 * ad3.setType("Office address"); ad3.setEmp(emp);
		 * 
		 * List<Address> addList = Arrays.asList(ad,ad2,ad3);
		 * 
		 * emp.setAddress(addList);
		 * 
		 * empRepo.save(emp); System.out.println("Success");
		 */
		
		//FETCHING DATA Emp to Address(UNI DIRECTIONAL)
		
		/*
		 * Emp emp = empRepo.findById(5).get(); System.out.println("Emp Name="
		 * +emp.getEmpName());
		 * emp.getAddress().forEach(e->System.out.println(e.getAddress() + "=" +
		 * e.getType()));
		 */
		
		//FETCHING DATA Address To Emp(BI DIRECTIONAL)
		
		/*
		 * Address ad = addressRepo.findById(1).get(); System.out.println("Address="
		 * +ad.getAddress()); System.out.println("Emp Name=" +ad.getEmp().getEmpName());
		 */
		
		//MANYTOMANY ADD DATA
		
		/*
		 * Category ca1=new Category(); ca1.setCategoryname("Electronics");
		 * 
		 * Category ca2=new Category(); ca2.setCategoryname("Mobile");
		 * 
		 * Category ca3=new Category(); ca3.setCategoryname("Cloths");
		 * 
		 * 
		 * Product p1=new Product(); p1.setProductname("TV");
		 * 
		 * Product p2=new Product(); p2.setProductname("OnePlus mobile");
		 * 
		 * Product p3=new Product(); p3.setProductname("Iphone 14");
		 * 
		 * Product p4=new Product(); p4.setProductname("Shirt");
		 * 
		 * Product p5=new Product(); p5.setProductname("Jeans");
		 * 
		 * 
		 * ca1.getProducts().add(p1); ca1.getProducts().add(p2);
		 * ca1.getProducts().add(p3); ca1.getProducts().add(p4);
		 * ca1.getProducts().add(p5);
		 * 
		 * 
		 * 
		 * ca2.getProducts().add(p2); ca2.getProducts().add(p3);
		 * 
		 * 
		 * ca3.getProducts().add(p4); ca3.getProducts().add(p5);
		 * 
		 * 
		 * 
		 * p1.getCategories().add(ca1); p2.getCategories().add(ca1);
		 * p3.getCategories().add(ca1); p4.getCategories().add(ca1);
		 * p5.getCategories().add(ca1);
		 * 
		 * 
		 * p2.getCategories().add(ca2); p3.getCategories().add(ca2);
		 * 
		 * p4.getCategories().add(ca3); p5.getCategories().add(ca3);
		 * 
		 * 
		 * cateRepo.save(ca1); cateRepo.save(ca2); cateRepo.save(ca3);
		 * System.out.println("Save success");
		 */
		
		//FETCH DATA
		
		/*
		 * Category ca = cateRepo.findById(2).get(); System.out.println("Category Name="
		 * +ca.getCategoryname());
		 * ca.getProducts().forEach(e->System.out.println(e.getProductname()));
		 */
		
		Product p = pRepo.findById(6).get();
		
		System.out.println("Product Name=" +p.getProductname());
		p.getCategories().forEach(e->System.out.println(e.getCategoryname()));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
