package com.stoom.msaddress.resources.exception;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//GETS E SETS, CONSTRUCTORS, HASH CODE AND EQUALS ESTÃO SENDO GERENCIADOS PELO LOMBOK ATRAVÉS DAS ANOTAÇÕES ABAIXO
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer status;
	private String msg;
	private Long timeStamp;
	
}
