package models.forms;

/**
 * Created by palma on 10/30/16.
 */
public class AuthUserForm {
    private String user;
    private String pass;
    public AuthUserForm() { }
    public AuthUserForm(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public boolean isOk(){
        return (this.user != null && this.pass != null);
    }
}
