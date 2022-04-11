package com.example.demo.client;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Client {
    @Id
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private String gender;
    //@Transient





    public Client() {

    }

    public Client(Long id, String first_name, String last_name, String email, String gender) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;

    }

    public Client(String first_name, String last_name, String email, String gender) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String email) {
        this.gender = gender;
    }



    @Override
    public String toString() {
        return "Client{" +
                "ID='" + id + '\'' +
                ", First Name='" + first_name + '\'' +
                ", Last Name='" + last_name + '\'' +
                ", Email='" + email + '\'' +
                ", Gender='" + gender + '\'' +
                '}';
    }
}
