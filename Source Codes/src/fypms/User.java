package fypms;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class User {
	private String name;
	private String email;
	protected UserLogin userLogin;
	
	public User() {};
	
	public User(UserLogin userLogin) {
		this.userLogin = userLogin;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean changePW(String newPassword) {
        this.password = newPassword;

        if (this instanceof Student) {
            UserIO.writeStudentPassword(this.userID, newPassword);
			return true;
        } else if (this instanceof Supervisor) {
            UserIO.writeSupervisorPassword(this.userID, newPassword);
			return true;
        } else if (this instanceof FYPCoordinator) {
			UserIO.writeCoordinatorPassword(this.userID, newPassword);
			return true;
		}
		
		return false; //when true, go back to UserView
    }
}