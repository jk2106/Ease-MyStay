package com.fil.easemystay.entities;

public class Admin {
	 private String username;
	    private String userpassword;

	    public Admin(String username, String password) {
	        this.username = username;
	        this.password = password;
	        System.out.println("parth");
	    }

	    // Getter and Setter methods for the username and password attributes
	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

		@Override
		public String toString() {
			return "Admin [username=" + username + ", password=" + getPassword() + "]";
		}

}
