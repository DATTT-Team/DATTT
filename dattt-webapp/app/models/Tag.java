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
public class Tag extends Model{
	
	@Id
	public String id;
	@Constraints.Required
	public String name;
	public String info;
//	@ManyToMany(mappedBy="tags")
//	public Set<Dattt> dattts = new HashSet<Dattt>();
	
	public Tag(String name) {
		this.name = name;
	}
	
	public static Finder<Long,Tag> find = new Finder<Long,Tag>(Long.class, Tag.class); 
}
