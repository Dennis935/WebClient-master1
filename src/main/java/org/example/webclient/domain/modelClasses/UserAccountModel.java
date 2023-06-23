package org.example.webclient.domain.modelClasses;

import org.example.webclient.entityClasses.UserAccountEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserAccountModel implements Serializable {
    private String username;
    private String password;
    private List<RolesModel> roles;

    private String topics;

    public UserAccountModel() {

    }

    public UserAccountModel(UserAccountEntity entity) {
        setUsername(entity.getUsername());
        setPassword(entity.getPassword());
        List<RolesModel> roles = new ArrayList<>();
        entity.getRoles().forEach(role -> roles.add(new RolesModel(role)));
        setRoles(roles);
        setTopics(entity.getTopics());
    }


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

    public List<RolesModel> getRoles() {
        return roles;
    }

    public void setRoles(List<RolesModel> roles) {
        this.roles = roles;
    }

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }
}
