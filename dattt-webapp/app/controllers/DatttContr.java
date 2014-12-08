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
        return ok(create_dattt.render(datttForm));
    }
    
    public static Result create() {
    	Form<Dattt> filledForm = datttForm.bindFromRequest();
    	
    	if(filledForm.hasErrors()) {
    		return badRequest("notOK");
//            return badRequest(create_dattt.render(filledForm));
        } else {
            Dattt created = filledForm.get();
            created.createAt = new Date();
            created.save();
            return redirect(controllers.routes.Application.index());
            //später mal nach DatttContr.list()
        }
    	
    }
    
    public static Result change() {
        return ok("TODO");
    }

}

