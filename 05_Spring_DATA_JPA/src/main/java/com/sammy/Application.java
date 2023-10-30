package com.sammy;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.sammy.entity.Student;
import com.sammy.repository.StudentRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		StudentRepo stRepo = context.getBean(StudentRepo.class);

		/*
		 * Student st = new Student(); st.setName("varun"); st.setAddress("india");
		 * 
		 * stRepo.save(st);
		 */

		/*
		 * List<Student> list =(List<Student>) stRepo.findAll(); // list.forEach(student
		 * -> System.out.println(student));
		 */
		// First get the data then UPDATE OR DELETE the DATA
		/*
		 * Student st = stRepo.findById(2).get(); System.out.println(st);
		 */

		// UPDATE DATA
		/*
		 * st.setName("Rahul kumar"); st.setAddress("UK");
		 * 
		 * Student updateStudent = stRepo.save(st); System.out.println(updateStudent);
		 * System.out.println("Updated Data");
		 */

		// DELETE DATA
		/*
		 * stRepo.delete(st); System.out.println("Delete successfully");
		 */

		// SPRING DATA JPA
		// Get student by Name
		/*
		 * Student st = stRepo.findByName("sammy"); System.out.println(st);
		 */

		// get by student address
		/*
		 * Student st = stRepo.findByAddress("India"); System.out.println(st);
		 */

		// get student by And
		/*
		 * Student st = stRepo.findByNameAndAddress("sammy", "India");
		 * System.out.println(st);
		 */

		/*
		 * List<Student> st =stRepo.findByNameOrAddress("sammy", "usa"); st.forEach(e
		 * ->System.out.println(e));
		 */

		// List<Student> st = stRepo.findByAddressIsNull();

		/*
		 * List<Student> st = stRepo.findByAddressIsNotNull(); st.forEach(e
		 * ->System.out.println(e));
		 */

		/*
		 * List<Student> st = stRepo.findByNameLike("arun");
		 * st.forEach(e->System.out.println(e));
		 */

		/*
		 * List<Student> st = stRepo.findByNameStartingWith("p");
		 * st.forEach(e->System.out.println(e));
		 */

		/*
		 * List<Student> st = stRepo.findByNameEndingWith("n");
		 * st.forEach(e->System.out.println(e));
		 */

		/*
		 * List<Student> st = stRepo.findByNameContaining("a");
		 * st.forEach(e->System.out.println(e));
		 */

		/*
		 * List<Student> st = stRepo.findByOrderByNameDesc();
		 * st.forEach(e->System.out.println(e));
		 */

		/*
		 * boolean f = stRepo.existsByName("dndnc"); System.out.println(f);
		 */

		// custom query using
		/*
		 * Student st = stRepo.getStudentByNameAndAddress("sammy", "India");
		 * System.out.println(st);
		 */

		/*
		 * List<Student> st = stRepo.searchname("prashant");
		 * st.forEach(e->System.out.println(e));
		 */

		/*
		 * List<Student> st = stRepo.getByNameOrAddress("prashant", "india");
		 * st.forEach(e -> System.out.println(e));
		 */

		// PAGINATION

		// sorting
		Sort sort = Sort.by("id").descending();

		List<Student> list = stRepo.findAll(sort);
		
		System.out.println("--------Sorting Student details-------------");
		list.forEach(e -> System.out.println(e));
		System.out.println("--------------Pagination---------------");

		Pageable pagable = PageRequest.of(0, 3, sort);
		Page<Student> page = stRepo.findAll(pagable);
		page.get().forEach(e -> System.out.println(e));

		System.out.println("----------Methods-------------");
		System.out.println("Size=" + page.getSize());
		System.out.println("Total Elements=" + page.getTotalElements());
		System.out.println("Total Pages=" + page.getTotalPages());

	}

}
