package org.jasig.cas.authentication.handler;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasig.cas.authentication.handler.PasswordEncoder;
import org.jasig.cas.util.Md5Encrypt;

public class MD5PasswordEncoder implements PasswordEncoder {
	
	protected static final Log log = LogFactory.getLog(MD5PasswordEncoder.class);

	public String encode(String strSource) {
		String strPassMD5 = Md5Encrypt.md5(strSource);
		return strPassMD5;
	}

	@Override
	public String encode(String strSource, String salt) {
		String strPassMD5 = Md5Encrypt.md5(this.encode(strSource) + salt);
		return strPassMD5;
	}
	
	
}
