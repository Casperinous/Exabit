package main.java.com.exabit.Utils;

import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;
import org.springframework.util.Base64Utils;

import java.io.UnsupportedEncodingException;

/**
 * Created by nikostot on 10/9/2016.
 */
public final class HtmlUtils {

    private static PolicyFactory policy = Sanitizers.FORMATTING.and(Sanitizers.LINKS);

    public static String CleanFromHtml(String message, boolean isencoded){

        

        if( !isencoded ) return  policy.sanitize(message);

        String dmessage = "";
        byte[] nmsg = new byte[0];
        // Decode message
        byte[] bmessage = Base64Utils.decodeFromString(message);
        try {
            //Construct new decoded string
            dmessage = new String(bmessage, "UTF-8");
            //Sanitize
            dmessage = policy.sanitize(dmessage);
            //Get Bytes to Encode
            nmsg = dmessage.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.toString();
        }

        //Return encoded;
        return Base64Utils.encodeToString(nmsg);
    }
}
