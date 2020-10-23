package com.example.jpa;

import com.example.jpa.model.Employee;
import com.example.jpa.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaCompositePrimaryKeyDemoApplicationTests {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	public void employee1WithCompany1Exists() {

		List<Employee> company1Employees = employeeRepository.findByEmployeeIdentityCompanyId("1");

		assertAll("Company 1 has three employees",
				() -> assertThat(company1Employees).isNotNull(),
				() -> assertThat(company1Employees).hasSize(3));

	}

}
