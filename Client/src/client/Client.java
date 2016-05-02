package client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;
/**
 *
 * @author nevin
 */
public class Client {
    InetAddress IPAddress;
    public Client() throws IOException{
        recieve();
    }
    
    private void recieve() throws UnknownHostException, IOException{
        String answer;
        IPAddress = InetAddress.getByName("localhost");
        System.out.println(IPAddress.getHostAddress());
        String serverAddress = JOptionPane.showInputDialog(
           "Enter IP Address of a machine that is\n" +
           "running the date service on port 9090:");
        Socket s = new Socket(serverAddress, 9090);
        BufferedReader input =
            new BufferedReader(new InputStreamReader(s.getInputStream()));
        
        while(true){
            answer = input.readLine();
            JOptionPane.showMessageDialog(null, answer);
        }
    }
        

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Client client = new Client();
        System.exit(0);
    }
}
