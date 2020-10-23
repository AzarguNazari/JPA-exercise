package com.example.jpa;

import com.example.jpa.model.Address;
import com.example.jpa.model.Name;
import com.example.jpa.model.User;
import com.example.jpa.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaEmbeddableDemoApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void user1HasAllTheInformation() {

		User user1 = generateUser();

		Optional<User> foundUser1 = userRepository.findById(user1.getId());

		assertAll("User 1 has all the information",
				() -> assertThat(foundUser1).isNotNull(),
				() -> assertThat(foundUser1).isNotEmpty(),
				() -> assertThat(foundUser1.get()).isNotNull(),
				() -> assertThat(foundUser1.get().getId()).isEqualTo(user1.getId()),
				() -> assertThat(foundUser1.get().getName()).isEqualTo(user1.getName()),
				() -> assertThat(foundUser1.get().getEmail()).isEqualTo(user1.getEmail()),
				() -> assertThat(foundUser1.get().getAddress()).isNotNull(),
				() -> assertThat(foundUser1.get().getAddress().getAddressLine1()).isEqualTo(user1.getAddress().getAddressLine1()));
	}

	private User generateUser(){
		User user1 = new User();
		user1.setId(1L);

		user1.setEmail("EMAIL1");

		Name user1Name = new Name("FIRSTNAME1", "MIDDLENAME1", "LASTNAME1");

		user1.setName(user1Name);

		Address user1Address = new Address("ADDRESS1", "ADDRESS2", "CITY1", "STATE1", "COUNTRY1", "ZIP1");
		user1.setAddress(user1Address);

		return user1;
	}

}
