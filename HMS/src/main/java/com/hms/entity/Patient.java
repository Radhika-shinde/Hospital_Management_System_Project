package com.hms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="patients")
public class Patient {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    
	    
	   

}
