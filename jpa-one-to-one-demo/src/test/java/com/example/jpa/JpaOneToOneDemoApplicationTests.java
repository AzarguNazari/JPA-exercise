package com.example.jpa;

import com.example.jpa.model.User;
import com.example.jpa.repository.UserProfileRepository;
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
public class JpaOneToOneDemoApplicationTests {

	@Autowired
	private UserProfileRepository userProfileRepository;

	@Autowired
	private UserRepository userRepository;

	@Test
	public void user1HasProfileOne() {
		long user1ID = 1;
		Optional<User> user = userRepository.findById(user1ID);
		assertAll("user1 has profile1",
				() -> assertThat(user).isNotNull(),
				() -> assertThat(user).isNotEmpty(),
				() -> assertThat(user.get().getId()).isEqualTo(1),
				() -> assertThat(user.get().getUserProfile().getId()).isEqualTo(1));
	}

}
