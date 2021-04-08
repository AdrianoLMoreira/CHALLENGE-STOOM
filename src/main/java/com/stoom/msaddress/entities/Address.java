package com.stoom.msaddress.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//GETS E SETS, CONSTRUCTORS, HASH CODE AND EQUALS ESTÃO SENDO GERENCIADOS PELO LOMBOK ATRAVÉS DAS ANOTAÇÕES ABAIXO
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String streetName;
	private Long number;
	private String complement;
	private String neighbourhood;
	private String zipcode;
	private String latitude;
	private String longitude;
	private String city;
	private String state;
	private String country;
	
}