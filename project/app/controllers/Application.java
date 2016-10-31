package controllers;

import play.mvc.*;

import javax.inject.Named;
import javax.inject.Singleton;

import views.html.*;

/**
 * The main set of web services.
 */
@Named
@Singleton
public class Application extends Controller {

    //private final PersonRepository personRepository;

    // We are using constructor injection to receive a repository to support our desire for immutability.
    //@Inject
    //public Application(final PersonRepository personRepository) {

        //this.personRepository = personRepository;
    //}

    public Result index() {

        return ok(index.render("Home"));

    }
}
