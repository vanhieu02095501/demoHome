package com.fsofter.home.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Column(nullable = false,unique = true,length = 45)
    @NotBlank(message = "{email.notBlank}")
    @Email(message = "{email.invalid}")
    private String email;

    @Column(length = 15,nullable = false)
    @NotBlank(message = "{password.notBlank}")
    @Size(min = 6, message = "{password.size}")
    private String password;

    @NotBlank(message = "{firstName.notBlank}")
    @Column(length = 45,nullable = false,name = "first_name")
    private String firstName;

    @NotBlank(message = "{lastName.notBlank}")
    @Column(length = 45,nullable = false,name = "last_name")
    private String lastName;

    private boolean enabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
