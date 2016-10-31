package controllers.auth;

import models.forms.AuthUserForm;
import models.entities.Person;
import models.repositories.PersonRepository;
import org.mindrot.jbcrypt.BCrypt;
import play.data.Form;
import play.mvc.Result;
import javax.inject.Inject;
import javax.inject.Named;
import static play.mvc.Http.Context.Implicit.session;
import static play.mvc.Results.*;

import views.html.auth.*;

/**
 * Created by palma on 10/30/16.
 */
@Named
public class Authentication {
    PersonRepository userRepo;

    @Inject
    public  Authentication(PersonRepository userRepository) { this.userRepo = userRepository; }

    public Authentication(){ }
    public Result authenticate(){
        if(isLogged()){ return redirect("/"); }
        //Binding request in UserForm
        AuthUserForm userForm = Form.form(AuthUserForm.class).bindFromRequest().get();
        //If credentials are set proceed
        if(userForm.isOk()){
            //Getting user by user and pass
            Person user = login(userForm.getDocument(), userForm.getPass());
            //If user exists
            if (user != null){
                //Clear actual session and put members in new one
                session().clear();
                session().put("document", user.getIddocument());
                session().put("user", user.getName() + " " + user.getSurname());
                session().put("rolId", user.getRoleId().getId().toString());
                session().put("rolName", user.getRoleId().getName());
                session().put("countryId", user.getCountryId().getId().toString());

                //Checking if user is an administrator
                if (user.getRoleId().getName().equals("Admin")){
                    session().put("admin", "true");
                }
                return redirect("/");
            } else {
                return status(401, login.render("The user or/and password are incorrect", true, isLogged()));
                //return ok(login.render("Usuario o contraseña incorrecta", true));
            }
        }
        return badRequest("Error. Required fields weren't received");
    }
    public Person login(String document, String pass){
        Person user = null;
        String passHash = null;
        user = userRepo.findByDocument(document);
        if (user != null){
            passHash = user.getPass();
            if (BCrypt.checkpw(pass.trim(), passHash)) {
                return user;
            }
        }
        return null;
    }
    public Result logout(){
        if(isLogged()){
            session().clear();
        }
        return redirect("/");
    }
    public Result authRedirect(String url){
        return redirect(url);
    }
    public Result unauthorized() {
        return status(401, "Unauthorized access");
        //return ok(login.render("Usuario no autorizado", true));
    }
    public boolean isLogged(){
        return (!(session().isEmpty() || session() == null));
    }

    public boolean isAdmin() {
        return (isLogged() && session().get("admin") != null);
    }

}
