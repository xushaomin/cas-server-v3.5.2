package org.jasig.cas.adaptors.jdbc;

import java.io.Serializable;

public class PasswordSalt implements Serializable {

	private static final long serialVersionUID = 1L;

    /** The password. */
    private String password;
    
    /** The salt. */
    private String salt;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
    
    
}
