package controllers.web;

import com.google.common.collect.Lists;
import controllers.auth.Authentication;
import models.entities.*;
import models.forms.SessionForm;
import models.repositories.CountryRepository;
import models.repositories.RoleRepository;
import models.repositories.PersonRepository;
import models.repositories.StateRepository;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by palma on 10/30/16.
 */

@Named
public class Api extends Controller {
    Authentication auth;
    CountryRepository countryRepo;
    PersonRepository userRepo;
    RoleRepository roleRepo;
    StateRepository stateRepo;

    @Inject
    public Api(Authentication auth,
               CountryRepository countryRepository,
               RoleRepository roleRepository,
               PersonRepository userRepository,
               StateRepository stateRepository){
        this.auth = auth;
        this.countryRepo = countryRepository;
        this.roleRepo = roleRepository;
        this.stateRepo = stateRepository;
        this.userRepo = userRepository;
    }

    public Result role(){
        List<Role> roles = Lists.newArrayList(roleRepo.findAll());
        return ok(Json.toJson(roles));
    }

    public Result user(){
        if(!auth.isLogged()) { return auth.unauthorized(); }
        List<Person> users = Lists.newArrayList(userRepo.findAll());
        return ok(Json.toJson(users));
    }

    public Result country(){
        List<Country> countries = Lists.newArrayList(countryRepo.findAll());
        return ok(Json.toJson(countries));
    }

    public Result countryMinified(){
        List<Country> countries = Lists.newArrayList(countryRepo.findAll());
        List<CountryMinified> countriesMin = new ArrayList<CountryMinified>();

        for(Country c : countries){
            countriesMin.add(new CountryMinified(c));
        }

        return ok(Json.toJson(countriesMin));
    }

    public Result state(){
        List<State> states = Lists.newArrayList(stateRepo.findAll());
        return ok(Json.toJson(states));
    }

    public Result userSession(){
        if (!auth.isLogged()){ return auth.unauthorized(); }
        SessionForm session = new SessionForm(
                session().get("document"),
                session().get("user"),
                Integer.parseInt(session().get("rolId")),
                session().get("rolName"),
                Integer.parseInt(session().get("countryId")));
        return ok(Json.toJson(session));
    }

    public Result election(){
        List<Person> users = Lists.newArrayList(userRepo.findAll());
        return ok(Json.toJson(users));
    }


}
