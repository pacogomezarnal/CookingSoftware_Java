package Controlador;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
* <h1>LibMD5</h1>
* Clase que nos permite generar un hash MD5 para almacenarlo en la BBDD
* 
*
* @author  Paco Gómez
* @version 1.0
* @since   2016-05-17
* @see <a href="">Java. LoginInterface</a>
*/
public class LibMD5 {

	public LibMD5() {
		
	}
	public static String getMD5(char[] pass){
		//Librreria de codificacion
		MessageDigest m;
		String hashtext="";
		try {
			m = MessageDigest.getInstance("MD5");
			m.reset();
			byte[] digest = m.digest(toBytes(pass));
			BigInteger bigInt = new BigInteger(1,digest);
			hashtext = bigInt.toString(16);
			// Now we need to zero pad it if you actually want the full 32 chars.
			while(hashtext.length() < 32 ){
			  hashtext = "0"+hashtext;
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hashtext;
	}
	
	private static byte[] toBytes(char[] chars) {
	    CharBuffer charBuffer = CharBuffer.wrap(chars);
	    ByteBuffer byteBuffer = Charset.forName("UTF-8").encode(charBuffer);
	    byte[] bytes = Arrays.copyOfRange(byteBuffer.array(),
	            byteBuffer.position(), byteBuffer.limit());
	    Arrays.fill(charBuffer.array(), '\u0000'); // clear sensitive data
	    Arrays.fill(byteBuffer.array(), (byte) 0); // clear sensitive data
	    return bytes;
	}
}
