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
	public String id;
	@Constraints.Required
	public String title;
	@Constraints.Required
	@Formats.DateTime(pattern="yyyy-MM-dd")
	public Date createAt = new Date();
	public String body;
	public String location;
	public User owner;
	@Formats.DateTime(pattern="yyyy-MM-dd")
	public Date deadline = new Date();
//    @ManyToMany(mappedBy="dattts")
//	public Set<Tag> tags = new HashSet<Tag>();
	@OneToMany
	public Set<Sharing> sharings = new HashSet<Sharing>();
	
	public Dattt(String title, Date createAt) {
		this.title = title;
		this.createAt = createAt;
	}
	
	public static Finder<Long,Dattt> find = new Finder<Long,Dattt>(Long.class, Dattt.class); 
}
