package com.olimpio.taskmanager.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

import com.olimpio.taskmanager.models.TaskModel;

@Entity
@Table(
        name = "USER_TB",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_user_username",
                        columnNames = "username"
                ),
                @UniqueConstraint(
                        name = "uk_user_email",
                        columnNames = "email"
                )
        }
)
public class UserModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column()
    private String firstName;

    @Column()
    private String lastName;

    @Column(nullable = false)
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<TaskModel> tasks = new ArrayList<>();

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() {return password;}
    public void setPassword(String password) { this.password = password; }

    public List<TaskModel> getTasks() { return tasks; }
    public void setTasks(List<TaskModel> tasks) { this.tasks = tasks; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
}
