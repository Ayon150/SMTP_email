import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.util.Base64;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class practice_email {
    public static DataOutputStream dos;
    public static BufferedReader br;
    public static void main(String[] args) throws Exception{
        String user = "s2110276150@ru.ac.bd";
        String pass = "rroi eddj rdnr dubp";

        String username = new String(Base64.getEncoder().encode(user.getBytes()));
        String password = new String(Base64.getEncoder().encode(pass.getBytes()));

        SSLSocket s = (SSLSocket)SSLSocketFactory.getDefault().createSocket("smtp.gmail.com", 465);

        dos = new DataOutputStream(s.getOutputStream());
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        send("EHLO smtp.gmail.com\r\n");
        message();
        message();
        message();
        message();
        message();
        message();
        message();
        message();
        message();

        send("AUTH LOGIN\r\n");
        message();

        send(username + "\r\n");
        message();

        send(password + "\r\n");
        message();

        send("Mail FROM:<s2110276150@ru.ac.bd>" + "\r\n");
        message();

        send("RCPT TO:<ayonkundu10@gmail.com>" + "\r\n");
        message();

        send("Data\r\n");
        message();

        send("From:s2110276150@ru.ac.bd\r\n");
        send("To:ayonkundu10@gmail.com\r\n");
        send("Subject:3Y2S"+"\r\n");
        send("2110276150\r\n");
        send(".\r\n");
        message();

        send("Quit\r\n");
        message();


    }
    
    public static void message() throws Exception{
        System.out.println("Server: " + br.readLine());
    }

    public static void send(String s) throws Exception{
        dos.writeBytes(s);
        Thread.sleep(1000);
        System.out.println("Client: " + s);
    }
}