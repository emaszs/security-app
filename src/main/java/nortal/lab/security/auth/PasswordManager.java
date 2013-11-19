package nortal.lab.security.auth;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.springframework.security.crypto.codec.Hex;
import org.springframework.stereotype.Component;

@Component
public class PasswordManager {

    /**
     * Check if user's pasword match
     * 
     * @param hash stored password
     * @param salt - password's salt
     * @param provided is a password entered in login box
     * @return
     */
    public boolean checkPassword(final String hash, final String salt, final String provided) {
        // TODO: use salt and provided password, and chek if hashes match
        // Pseudo code Hex.encode(SHA1(salt + provided)) equals hash
        // You may use Spring's BCrypt also
        
        return hash.equals(provided);
    }

    /**
     * Generates user password hash
     * 
     * @param passwordHash
     * @param salt
     * @return
     */
    public String generateUserPasswordHash(final String passwordHash, final String salt) {
        // TODO: add the code and generate password hash
        // Pseudo code is Hex.encode(SHA1(salt + password))
        // You may use Spring's BCrypt also
        MessageDigest cript;
        try {
            cript = MessageDigest.getInstance("SHA-1");
            cript.reset();
            cript.update((salt + passwordHash).getBytes("utf-8"));
            String saltedPasswordHash = new String(Hex.encode(cript.digest()));
            return saltedPasswordHash;
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        return null;
    }

    public String generateRandomStr() {
        Random r = new Random();
        String result = "";
        for (int i = 0; i < 32; i++) {
            result = result + (char) ('0' + r.nextInt(10));
        }
        return result;
    }
}
