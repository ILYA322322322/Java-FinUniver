package com.ToDoList.ToDoList.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
    private String lastName;
    private String firstName;
    private String parentName;
    private String birthday;
    private String creation_date;
    private String update_date;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Task> tasks;

    public void updateClient(User user){
        if(user.login != null){
            this.login = user.login;
        }
        if(user.lastName != null){
            this.lastName = user.lastName;
        }
        if(user.firstName != null){
            this.firstName = user.firstName;
        }
        if(user.parentName != null){
            this.parentName = user.parentName;
        }
        if(user.birthday != null){
            this.birthday = user.birthday;
        }
        if(user.creation_date != null){
            this.creation_date = user.creation_date;
        }
        if(user.update_date != null){
            this.update_date = user.update_date;
        }
    }
}
