package models.forms;

/**
 * Created by palma on 10/30/16.
 */
public class AuthUserForm {
    private String document;
    private String pass;
    public AuthUserForm() { }
    public AuthUserForm(String document, String pass) {
        this.document = document;
        this.pass = pass;
    }
    public String getDocument() {
        return document;
    }
    public void setDocument(String document) {
        this.document = document;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public boolean isOk(){
        return (this.document != null && this.pass != null);
    }
}
