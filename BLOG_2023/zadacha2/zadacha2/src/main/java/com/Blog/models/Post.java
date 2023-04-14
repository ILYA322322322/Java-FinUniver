package com.Blog.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String desc;
    private String publicationDate;
    private String category;
    private String user;
    private String creation_date;
    private String update_date;

    @ManyToOne
    @JoinColumn(name="user", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private User lastName;
    
}
