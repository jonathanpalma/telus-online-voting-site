package controllers;

import controllers.auth.Authentication;
import play.mvc.*;

import javax.inject.Inject;
import javax.inject.Named;

import views.html.*;
import views.html.auth.*;

/**
 * The main set of web services.
 */
@Named
public class Application extends Controller {
    private Authentication auth;

    @Inject
    public Application(Authentication auth) {

        this.auth = auth;
    }

    public Result index() {
        return ok(index.render("Home", auth.isLogged()));
    }

    public Result login() {
        if(auth.isLogged()){ return redirect("/"); }
        return ok(login.render("", false, auth.isLogged()));
    }

    public Result signup() {
        if(auth.isLogged()){ return redirect("/"); }
        return ok(signup.render(null, false, auth.isLogged()));
    }
}
