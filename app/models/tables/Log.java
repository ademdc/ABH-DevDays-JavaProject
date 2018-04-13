package models.tables;

import models.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;
import java.sql.Timestamp;


@Entity
@Table(name = "logs")
public class Log extends BaseModel {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "logging_time")
    private Timestamp logging_time;

    @Column(name = "description")
    private String description;


    public Log() { }


    public UUID getId() { return id; }


    public void setId(UUID id) { this.id = id; }


    public Timestamp getLogging_time() { return logging_time; }


    public void setLogging_time(long logging_time) { this.logging_time = new Timestamp(logging_time); }


    public String getDescription() { return description; }


    public void setDescription(String description) { this.description = description; }
}