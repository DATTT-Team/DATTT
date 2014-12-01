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
public class Dattt extends Model{
	
	@Id
	@GeneratedValue
	public String id;

	@Constraints.Required
	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date createAt = new Date();

	@Constraints.Required
	public String name;
	
	public String body;
	
	public String location;
	
	public User owner;

	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date deatline = new Date();
	
	@ManyToMany(mappedBy="dattts")
	public Set<Tag> tags = new HashSet<Tag>();
	
	public static Finder<Long,Dattt> find = new Finder<Long,Dattt>(Long.class, Dattt.class); 
}
