package com.example.jpa;

import com.example.jpa.model.Comment;
import com.example.jpa.model.Post;
import com.example.jpa.repository.CommentRepository;
import com.example.jpa.repository.PostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaOneToManyDemoApplicationTests {

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private PostRepository postRepository;

	@Test
	public void post1HasTwoComments() {

		long post1ID = 1;
		long comment1 = 1;
		long comment2 = 2;

		Optional<Post> post = postRepository.findById(post1ID);

		List<Comment> comments = commentRepository.findByPostId(post1ID);

		assertAll("Post 1 exists",
				() -> assertThat(post).isNotNull(),
				() -> assertThat(post).isNotEmpty(),
				() -> assertThat(post.get().getId()).isEqualTo(1));

		assertAll("Post 1 has two comments",
				() -> assertThat(comments).isNotNull(),
				() -> assertThat(comments).isNotEmpty(),
				() -> assertThat(comments).hasSize(2),
				() -> assertThat(comments.get(0).getId()).isEqualTo(1),
				() -> assertThat(comments.get(1).getId()).isEqualTo(2));



	}

}
