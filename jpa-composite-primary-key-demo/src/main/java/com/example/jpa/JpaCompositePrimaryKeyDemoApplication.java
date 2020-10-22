package com.example.jpa;

import com.example.jpa.model.Employee;
import com.example.jpa.model.EmployeeIdentity;
import com.example.jpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaCompositePrimaryKeyDemoApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaCompositePrimaryKeyDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		employeeRepository.deleteAllInBatch();
		Employee employee = new Employee(new EmployeeIdentity("E-123", "D-457"),
				"name",
				"example@email.com",
				"052345234");

		employeeRepository.save(employee);

		employeeRepository.findById(new EmployeeIdentity("E-123", "D-457"));
		employeeRepository.findByEmployeeIdentityCompanyId("D-457");
	}
}
