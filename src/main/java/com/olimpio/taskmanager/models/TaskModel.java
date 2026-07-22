package com.olimpio.taskmanager.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;



@Entity
@Table(name = "TASK_TB")
public class TaskModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private LocalDateTime dateBegin;

    @Column
    private LocalDateTime dateEnd;

    @Column(nullable = false, unique = true)
    private String title;

    @Column
    private boolean completed;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public LocalDateTime getDateBegin() {return dateBegin;}
    public void setDateBegin(LocalDateTime dateBegin) { this.dateBegin = dateBegin; }

    public LocalDateTime getDateEnd() {return dateEnd;}
    public void setDateEnd(LocalDateTime dateEnd) { this.dateEnd = dateEnd; }

    public String getTitle() { return title;}
    public void setTitle(String title) { this.title = title; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
