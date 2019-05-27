package models;

import javax.persistence.*;

@Entity
@Table(name= "passwordSet")
public class PasswordSet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "password", nullable = false)
    private char[] password;

    @Column(name = "title")
    private String title;

    @Column(name = "websiteUrl")
    private String websiteUrl;

    @Column(name = "description")
    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name = "userId")
    private User user;

    //Properties
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    //Constructors
    public PasswordSet(){}

    public PasswordSet(int id, char[] password, String title, String websiteUrl, String description, User user){
        this.id = id;
        this.password = password;
        this.title = title;
        this.websiteUrl = websiteUrl;
        this.description = description;
    }

    public PasswordSet(char[] password, String title, String websiteUrl, String description, User user){
        this.password = password;
        this.title = title;
        this.websiteUrl = websiteUrl;
        this.description = description;
    }

    //Methods
    @Override
    public String toString() {
        return String.format("PasswordSet [id=%s, password=%s, title=%s, URL=%s, Description=%s]", id, password, title, websiteUrl, description);
    }
}
