package com.cdc.mitrais.jpa_jpql.entity;

import java.io.Serializable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")

public class Staff implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int sid;
	private String sname;
	
	public Staff() {}
	
	public Staff(int sid, String sname) {
		super();
		this.setSid(sid);
		this.setSname(sname);
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}
}
