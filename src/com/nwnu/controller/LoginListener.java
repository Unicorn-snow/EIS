package com.nwnu.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginListener implements ActionListener{

	String usr;
	String passwd;
	
	public LoginListener(String usr, String passwd) {
		// TODO Auto-generated constructor stub
		this.usr = usr;
		this.passwd = passwd;
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("submit");
		System.out.println(passwd);
		
	}
	

}
