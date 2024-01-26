package Client;

import GameLogic.DotAndBoxesGame;
import java.io.IOException;
import java.util.Scanner;

public class ClientTUI implements ClientListener{
    private Client client;
    private String username1;

    public static void main(String[] args) throws IOException{
        ClientTUI clientTUI = new ClientTUI();
        ClientTUI.runTUI();
    }

    public void runTUI() throws IOException{
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("Enter a port number: ");
            int portnumber = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter address: ");
            String address = scanner.nextLine();
            this.client = new Client(address, portnumber);
            client.addListener(this);

            System.out.println("What is your username? ");
            username1 = scanner.nextLine();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public String getUsername (String username){
        return username1;
    }

    @Override
    public void connectionLost() throws IOException {

    }

    @Override
    public void chatMessage(String username, String message) {

    }
}
