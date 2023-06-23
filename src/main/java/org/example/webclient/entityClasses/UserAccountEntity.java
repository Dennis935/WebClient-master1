package org.example.webclient.entityClasses;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user_account")
public class UserAccountEntity implements Serializable {
    @Id
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;

    @ManyToMany
            @JoinTable(
                    name = "assignment",
                    joinColumns = @JoinColumn(name = "username"),
                    inverseJoinColumns = @JoinColumn(name = "rolename")
            )
    List<RolesEntity> roles;

    @Basic
    @Column(name = "topics")
    private String topics;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RolesEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RolesEntity> roles) {
        this.roles = roles;
    }

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }
}
