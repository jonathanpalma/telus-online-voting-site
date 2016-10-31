package models.forms;

/**
 * Created by palma on 10/31/16.
 */
public class SignUpForm {
    private String surname;
    private String name;
    private String document;
    private String pass;
    private String passConfirm;
    private String countryId;

    public SignUpForm() { }

    public SignUpForm(String surname, String name, String document, String pass, String passConfirm, String countryId) {
        this.surname = surname;
        this.name = name;
        this.document = document;
        this.pass = pass;
        this.passConfirm = passConfirm;
        this.countryId = countryId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPassConfirm() {
        return passConfirm;
    }

    public void setPassConfirm(String passConfirm) {
        this.passConfirm = passConfirm;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public Boolean isOk(){
        return (this.surname != null && this.name != null
                && this.document != null && this.pass != null
                && this.passConfirm != null && this.countryId != null);
    }

    public Boolean passMatch(){
        return (this.pass.equals(this.getPassConfirm()));
    }
}
