package models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import play.db.ebean.Model;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class User extends Model{
	
	@Id
	@GeneratedValue
	public String id;

	@Constraints.Required
	public String email;	
	
	@Column(unique=true)
	@Constraints.Required
	public String nick;
	
	public String firstName;
	
	public String lastName;
	
	public String passwordHash;
	
	public boolean active;
	
	@Constraints.Required
	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date registeredAt = new Date();
	
	public String googleAccountName;
	
	//Ein User kann mehrere Freunde haben (einseitige Annahme)
	@ManyToMany
	public Set<User> friends = new HashSet<User>();
	
	public static Finder<Long,User> find = new Finder<Long,User>(Long.class, User.class); 
}
