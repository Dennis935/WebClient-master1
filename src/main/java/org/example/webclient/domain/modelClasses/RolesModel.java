package org.example.webclient.domain.modelClasses;

import org.example.webclient.entityClasses.RolesEntity;

import java.io.Serializable;

public class RolesModel implements Serializable {
    private String rolename;
    private String function;

    public RolesModel() {

    }

    public RolesModel(RolesEntity role) {
        setRolename(role.getRolename());
        setFunction(role.getFunction());
    }


    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}
