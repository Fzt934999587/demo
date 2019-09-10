package com.cy.rmodel;

import com.cy.pojo.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RopUserLogin {

	private String userName;
	private String passWord;
}
