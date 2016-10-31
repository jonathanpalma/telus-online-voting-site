package controllers.web;

import com.google.common.collect.Lists;
import controllers.auth.Authentication;
import models.entities.Role;
import models.entities.Person;
import models.forms.SessionForm;
import models.repositories.RoleRepository;
import models.repositories.PersonRepository;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by palma on 10/30/16.
 */

@Named
public class Api extends Controller {
    Authentication auth;
    RoleRepository roleRepo;
    PersonRepository userRepo;

    @Inject
    public Api(Authentication auth,
               RoleRepository roleRepository,
               PersonRepository userRepository){
        this.auth = auth;
        this.roleRepo = roleRepository;
        this.userRepo = userRepository;
    }

    public Result role(){
        if(!auth.isLogged()) { return auth.unauthorized(); }
        List<Role> roles = Lists.newArrayList(roleRepo.findAll());
        return ok(Json.toJson(roles));
    }

    public Result user(){
        if(!auth.isLogged()) { return auth.unauthorized(); }
        List<Person> users = Lists.newArrayList(userRepo.findAll());
        return ok(Json.toJson(users));
    }

    public Result userSession(){
        if (!auth.isLogged()){ return auth.unauthorized(); }
        SessionForm session = new SessionForm(
                session().get("document"),
                session().get("user"),
                Integer.parseInt(session().get("rolId")),
                session().get("rolName"));
        return ok(Json.toJson(session));
    }

    public Result election(){
        List<Person> users = Lists.newArrayList(userRepo.findAll());
        return ok(Json.toJson(users));
    }


}
