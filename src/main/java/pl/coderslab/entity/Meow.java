package pl.coderslab.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "meows")
public class Meow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(max = 50)
    private String title;

    @NotEmpty
    @Size(max = 140)
    private String meowText;

    LocalDate created = LocalDate.now();

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "meow", fetch = FetchType.EAGER)
    private List<Comment> comments = new ArrayList<>();


    public Meow() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMeowText() {
        return meowText;
    }

    public void setMeowText(String meowText) {
        this.meowText = meowText;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return title;
    }
}
