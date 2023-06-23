package org.example.webclient.dtoClasses;

import org.example.webclient.domain.modelClasses.UserAccountModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDto implements Serializable {
    private String username;
    private List<String> roles;
    private String permissions;

    private String topics;

    public UserDto() {

    }

    public UserDto(UserAccountModel model) {
        setUsername(model.getUsername());
        List<String> roleList = new ArrayList<>();
        model.getRoles().forEach(role -> {
            roleList.add(role.getRolename());
        });
        setRoles(roleList);
        setPermissions(model.getRoles().get(0).getFunction());
        setTopics(model.getTopics());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }
}
