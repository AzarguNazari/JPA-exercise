package com.example.jpa;

import com.example.jpa.model.Address;
import com.example.jpa.model.User;
import com.example.jpa.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaElementCollectionDemoApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void user1HasAllCorrectInformation() {

		User user1 = generateUser();

		Optional<User> user = userRepository.findById(user1.getId());

		assertAll("User 1 has all information",
				() -> assertThat(user).isNotNull(),
				() -> assertThat(user).isNotEmpty(),
				() -> assertThat(user.get()).isNotNull(),
				() -> assertThat(user.get().getAddresses()).isNotEmpty(),
				() -> assertThat(user.get().getAddresses()).hasSize(2),
				() -> assertThat(user.get().getPhoneNumbers()).isNotEmpty(),
				() -> assertThat(user.get().getPhoneNumbers()).hasSize(2));

	}

	private User generateUser(){
		User user1 = new User();
		user1.setEmail("EMAIL1");
		user1.setId(1L);
		user1.setName("NAME");

		Address address1 = new Address("HOSUE1", "STREET1", "CITY1", "COUNTRY1", "STATE1", "ZIP1");
		Address address2 = new Address("HOSUE2", "STREET2", "CITY2", "COUNTRY2", "STATE2", "ZIP2");

		Set<Address> address = new HashSet<>();
		address.add(address1);
		address.add(address2);

		user1.setAddresses(address);

		Set<String> phoneAddress = new HashSet<>();
		phoneAddress.add("051245123");
		phoneAddress.add("051235123");

		user1.setPhoneNumbers(phoneAddress);

		return user1;
	}

}
