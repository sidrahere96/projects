// Java code to explain how to generate random
// password

// Here we are using random() method of util
// class in Java
import java.util.*;

public class NewClass
{
    public static void main(String[] args)
    {
        // Length of your password as I have choose
        // here to be 8
        int length = 10;
        System.out.println(geek_Password(length));
    }

    // This our Password generating method
    // We have use static here, so that we not to
    // make any object for it
    static char[] geek_Password(int len)
    {
        System.out.println(&quot;Generating password using random() : &quot;);
        System.out.print(&quot;Your new password is : &quot;);

        // A strong password has Cap_chars, Lower_chars,
        // numeric value and symbols. So we are using all of
        // them to generate our password
        String Capital_chars = &quot;ABCDEFGHIJKLMNOPQRSTUVWXYZ&quot;;
        String Small_chars = &quot;abcdefghijklmnopqrstuvwxyz&quot;;
        String numbers = &quot;0123456789&quot;;
                String symbols = &quot;!@#$%^&amp;*_=+-/.?&lt;&gt;)&quot;;


        String values = Capital_chars + Small_chars +
                        numbers + symbols;

        // Using random method
        Random rndm_method = new Random();

        char[] password = new char[len];

        for (int i = 0; i &lt; len; i++)
        {
            // Use of charAt() method : to get character value
            // Use of nextInt() as it is scanning the value as int
            password[i] =
              values.charAt(rndm_method.nextInt(values.length()));

        }
        return password;
    }
}