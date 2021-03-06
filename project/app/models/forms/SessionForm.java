package models.forms;

/**
 * Created by palma on 10/30/16.
 */
public class SessionForm {
    private String user;
    private String name;
    private Integer roleId;
    private String roleName;
    private Integer countryId;

    public SessionForm() { }

    public SessionForm(String user, String name, Integer roleId, String roleName, Integer countryId) {
        this.user = user;
        this.name = name;
        this.roleId = roleId;
        this.roleName = roleName;
        this.countryId = countryId;
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

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }
}
