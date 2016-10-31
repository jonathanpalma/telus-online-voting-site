package controllers.crud;

import controllers.auth.Authentication;
import models.entities.Person;
import models.forms.SignUpForm;
import models.repositories.CountryRepository;
import models.repositories.PersonRepository;
import models.repositories.RoleRepository;
import org.mindrot.jbcrypt.BCrypt;
import play.data.Form;
import play.mvc.*;

import javax.inject.Inject;
import javax.inject.Named;

import views.html.auth.*;

/**
 * Created by palma on 10/31/16.
 */
@Named
public class PersonCtrl extends Controller {
    private Authentication auth;
    private CountryRepository countryRepo;
    private PersonRepository personRepo;
    private RoleRepository roleRepo;

    @Inject
    public PersonCtrl(Authentication auth,
                      CountryRepository countryRepository,
                      PersonRepository personRepository,
                      RoleRepository roleRepository) {
        this.auth = auth;
        this.countryRepo = countryRepository;
        this.personRepo = personRepository;
        this.roleRepo = roleRepository;
    }

    public Result signup(){
        if(auth.isLogged()){ return redirect("/"); }

        try {
            //Binding request in SignUpForm
            SignUpForm form = Form.form(SignUpForm.class).bindFromRequest().get();

            //If required fields are set, proceed
            if(form.isOk()){
                if (form.passMatch()) {
                    Person user = new Person();
                    user.setCountryId(countryRepo.findOne(Integer.parseInt(form.getCountryId())));
                    user.setIddocument((form.getDocument()));
                    user.setName(form.getName());
                    user.setSurname(form.getSurname());
                    user.setRoleId(roleRepo.findByName("Voter"));

                    String passwordHash = BCrypt.hashpw(form.getPass(), BCrypt.gensalt());
                    user.setPass(passwordHash);

                    personRepo.save(user);
                } else {
                    return badRequest(signup.render("Password does not match the confirm password", true, auth.isLogged()));
                }

            } else {
                return badRequest(signup.render("Required fields weren't received", true, auth.isLogged()));
            }

        } catch (Exception ex){
            ex.printStackTrace();
            return internalServerError(signup.render("An error has occurred", true, auth.isLogged()));
        }
        return ok(signup.render("You have successfully registered", false, auth.isLogged()));
    }
}
