package com.example.jpa;

import com.example.jpa.model.Post;
import com.example.jpa.model.Tag;
import com.example.jpa.repository.PostRepository;
import com.example.jpa.repository.TagRepository;
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
public class JpaManyToManyDemoApplicationTests {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private TagRepository tagRepository;

	@Test
	public void post1HasTwoTags() {

		long post1ID = 1;

		Optional<Post> post1 = postRepository.findById(post1ID);

		assertAll("Post 1 has two tags",
				() -> assertThat(post1).isNotNull(),
				() -> assertThat(post1).isNotEmpty(),
				() -> assertThat(post1.get()).isNotNull(),
				() -> assertThat(post1.get().getId()).isEqualTo(post1ID),
				() -> assertThat(post1.get().getTags()).isNotEmpty());
	}

	@Test
	public void tag1HasTwoPosts() {

		long tag1ID = 1;

		Optional<Tag> tag1 = tagRepository.findById(tag1ID);

		assertAll("Tag 1 has two posts",
				() -> assertThat(tag1).isNotNull(),
				() -> assertThat(tag1).isNotEmpty(),
				() -> assertThat(tag1.get()).isNotNull(),
				() -> assertThat(tag1.get().getId()).isEqualTo(tag1ID),
				() -> assertThat(tag1.get().getPosts()).isNotEmpty());
	}

}
