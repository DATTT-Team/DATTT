package models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.ebean.Model;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class Sharing extends Model{
	
	@Id
	public String id;
	@Constraints.Required
	@ManyToOne
	public Dattt dattt;
	@Constraints.Required
	@ManyToOne
	public User user;
	public boolean readAllowed;
	public boolean checkAllowed;
	public boolean addAllowed;
	public boolean modAllowed;
	
	public Sharing(Dattt dattt, User user) {
		this.dattt = dattt;
		this.user = user;
	}
	
	public static Finder<Long,Sharing> find = new Finder<Long,Sharing>(Long.class, Sharing.class); 
}
