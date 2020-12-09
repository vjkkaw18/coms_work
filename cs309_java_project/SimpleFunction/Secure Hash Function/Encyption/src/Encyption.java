import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Base64;

public class Encyption {

    public static void main(String[]args) throws FileNotFoundException, NoSuchAlgorithmException, UnsupportedEncodingException {

        boolean check = false;
        Scanner scan = new Scanner(new File("C:\\Users\\User\\Desktop\\ISU\\CPRE 431\\M03\\100k-most-used-passwords-NIST.txt"));
        ArrayList<String> list = new ArrayList<String>();
        while(scan.hasNext())
        {
            list.add(scan.next());
        }
        scan.close();

        for(int i = 0; i < 1; i++){
            check = hashFunction(list.get(i));

            if(check == true){
                System.out.println(list.get(i));
                break;
            }
        }
    }

    public static boolean hashFunction(String passcode) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        String inputString = "xgLS35S6";
        passcode = passcode + inputString;
        byte[] passCode = passcode.getBytes();

        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.reset();
        byte[] digest = md.digest(passCode);
        StringBuffer sb = new StringBuffer();
        for(byte b : digest){
            sb.append(String.format("%02x", b & 0xff));
        }
        System.out.println(sb.toString());

        Base64.Encoder encoder = Base64.getEncoder();
        String str = encoder.encodeToString(sb.toString().getBytes("UTF-8"));
        //System.out.print(str);


        if(str.equals("$6$xgLS35S6$2UjEq.dUhICPw9zgDVJXcQYQp/9ilLPQt/8Zgu0uwngI5mVvB1eKQG9SnVLjmOOfkB4Jjb5VSAXGXjY4Cf5k90:18169:0:99999:7:::\n")){
            return true;
        }
        //System.out.print(sb.toString());
        return false;
    }
}
