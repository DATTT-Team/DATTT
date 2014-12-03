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
	public String id;

	@Constraints.Email
	public String email;	
	
	@Column(unique=true)
	@Constraints.Required
	public String nick;
	
	public String firstName;
	
	public String lastName;
	
	public String passwordHash;
	
	public boolean active;

	public boolean emailValidated;
	
	@Constraints.Required
	@Formats.DateTime(pattern="yyyy-MM-dd")
	public Date registeredAt;
	
	@Formats.DateTime(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date lastLogin;
	
	public String googleAccountName;
	
	//Ein User kann mehrere Freunde haben (einseitige Annahme)
	@ManyToMany
	public Set<User> friends = new HashSet<User>();
	
	@OneToMany
	public Set<Sharing> sharings = new HashSet<Sharing>();
	
	public static Finder<Long,User> find = new Finder<Long,User>(Long.class, User.class); 
}
