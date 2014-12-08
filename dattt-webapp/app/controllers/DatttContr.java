package controllers;

import java.util.Date;

import play.*;
import static play.data.Form.*;
import play.data.Form;
import play.mvc.*;
import views.html.*;
import models.*;

public class DatttContr extends Controller {
	
	final static Form<Dattt> datttForm = form(Dattt.class);

    public static Result list() {
        return ok("TODO");
    }
    
    public static Result details() {
        return ok("TODO");
    }
    
    public static Result create_form() {
        return ok(create_dattt.render(form(Dattt.class)));
    }
    
    public static Result create() {
        return ok("TODO");
    }
    
    public static Result change() {
        return ok("TODO");
    }

}

