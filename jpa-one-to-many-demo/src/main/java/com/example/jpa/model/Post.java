package com.example.jpa.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by rajeevkumarsingh on 21/11/17.
 */
@Entity
@Table(name = "posts")
@Data
public class Post extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String title;

    private String description;

    @Lob
    private String content;
}
