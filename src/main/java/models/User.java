package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name= "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "userName", nullable = false)
    private String userName;

    @Column(name = "loginKey", nullable = false)
    private int loginKey;

    //@OneToMany(mappedBy = "passwordSet", cascade = CascadeType.ALL)
    //private Set<PasswordSet> passwordSets;

    //@Column
    //private ArrayList<PasswordSet> passwords;

    //Properties
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getLoginKey() {
        return loginKey;
    }

    public void setLoginKey(int loginKey) {
        this.loginKey = loginKey;
    }

    //public ArrayList<PasswordSet> getPasswords() {
        //return passwords;
    //}

    //public void setPasswords(ArrayList<PasswordSet> passwords) {
        //this.passwords = passwords;
    //}


    //Constructors
    public User(){}

    public User(int id, String userName, int loginKey){
        this.id = id;
        this.userName = userName;
        this.loginKey = loginKey;
        //this.passwords = new ArrayList<PasswordSet>();
        //this.passwords = passwords;
    }

    public User(String userName, int loginKey){
        this.userName = userName;
        this.loginKey = loginKey;
        //this.passwords = new ArrayList<PasswordSet>();
        //this.passwords = passwords;
    }

    //Methods
}
