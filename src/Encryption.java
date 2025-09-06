import java.security.*;
public class Encryption {

    public String encrypt(String value){
        String hashHex = "";
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            //Convert password to Binary Hash
            byte[] hashBin = md.digest(value.getBytes());

            //Convert array of binaries into single line Hexadecimal value
            for(int b: hashBin){
                hashHex = hashHex + Integer.toHexString(0xff & b);
            }
        }
        catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        
        return hashHex;
    }
}