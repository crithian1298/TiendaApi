package com.Javacristhian.tienda_api.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="usuario",uniqueConstraints = {@UniqueConstraint(columnNames= {"username"}),@UniqueConstraint(columnNames= {"email"})})
public class usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String username;
	private String email;
	private String password ;
	
	@ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name="usuario_roles",joinColumns =
	@JoinColumn(name="usuario_id",referencedColumnName="id"),inverseJoinColumns =@JoinColumn(name="rol_id",referencedColumnName = "id"))
	private Set<rol>roles=new HashSet<>();
}
