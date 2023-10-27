package com.fil.easemystay.entities;

public class Admin {
	 private String user_name;
	    private String password;

	    public Admin(String username, String password) {
	        this.user_name = username;
	        this.password = password;
	    }

	    // Getter and Setter methods for the user_name and password attributes
	    public String getUsername() {
	        return user_name;
	    }

	    public void setUsername(String username) {
	        this.user_name = username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

		@Override
		public String toString() {
			return "Admin [user_name=" + user_name + ", password=" + password + "]";
		}

}
