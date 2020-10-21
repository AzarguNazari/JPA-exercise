package com.example.jpa;

import com.example.jpa.model.Comment;
import com.example.jpa.model.Post;
import com.example.jpa.repository.CommentRepository;
import com.example.jpa.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.transaction.Transactional;

@SpringBootApplication
@EnableJpaAuditing
public class JpaOneToManyDemoApplication implements ApplicationRunner {

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private PostRepository postRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaOneToManyDemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Post post1 = new Post();
		post1.setTitle("About canada");
		post1.setContent("Canada is one of the most beautiful countries in the world");
		post1.setDescription("This post is about canada");

		postRepository.save(post1);

		Comment comment1 = new Comment();
		comment1.setText("Yes, I have already visited Canada once");
		comment1.setPost(post1);

		commentRepository.save(comment1);

	}
}
