package models.forms;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by palma on 10/30/16.
 */
public class SessionForm {
    private String user;
    private String name;
    private Integer roleId;
    private String roleName;
    private Boolean admin;

    public SessionForm() { }

    public SessionForm(String user, String name, Integer roleId, String roleName, Boolean isAdmin) {
        this.user = user;
        this.name = name;
        this.roleId = roleId;
        this.roleName = roleName;
        this.admin = admin;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Boolean isAdmin() {
        return this.admin;
    }
}
