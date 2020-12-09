package pl.coderslab.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String username;

    private String email;


    private String password;

    @Transient
    private String passwordConfirm;



    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Meow> meows = new ArrayList<>();


    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<PrivateMeow> sentPrivateMeows = new ArrayList<>();

    @OneToMany(mappedBy = "recipient", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<PrivateMeow> receivedPrivateMeows = new ArrayList<>();


    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public List<Meow> getMeows() {
        return meows;
    }

    public void setMeows(List<Meow> meows) {
        this.meows = meows;
    }


    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }


    public List<PrivateMeow> getSentPrivateMeows() {
        return sentPrivateMeows;
    }

    public void setSentPrivateMeows(List<PrivateMeow> sentPrivateMeows) {
        this.sentPrivateMeows = sentPrivateMeows;
    }

    public List<PrivateMeow> getReceivedPrivateMeows() {
        return receivedPrivateMeows;
    }

    public void setReceivedPrivateMeows(List<PrivateMeow> receivedPrivateMeows) {
        this.receivedPrivateMeows = receivedPrivateMeows;
    }
}
