package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name= "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

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

    //public String getUsername() {
        //return username;
    //}

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //public ArrayList<PasswordSet> getPasswords() {
        //return passwords;
    //}

    //public void setPasswords(ArrayList<PasswordSet> passwords) {
        //this.passwords = passwords;
    //}

    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {return null;}

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }


    //Constructors
    public User(){}

    public User(int id, String userName, String password){
        this.id = id;
        this.username = userName;
        this.password = password;
        //this.passwords = new ArrayList<PasswordSet>();
        //this.passwords = passwords;
    }

    public User(String userName, String password){
        this.username = userName;
        this.password = password;
        //this.passwords = new ArrayList<PasswordSet>();
        //this.passwords = passwords;
    }

    public User(int id, String userName){
        this.id = id;
        this.username = userName;
        //this.passwords = new ArrayList<PasswordSet>();
        //this.passwords = passwords;
    }
    //Methods
}
