import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Sv {
    public static void main(String[] args) throws Exception{
        ServerSocket sv = new ServerSocket(24);
        System.out.println("Ouvindo a porta: "+sv.getLocalPort());
        Socket connect = sv.accept();
        System.out.println("Conexao aceita. Endereço: "+connect.getLocalAddress());

        while (true) {
            BufferedReader ent_user = new BufferedReader(new InputStreamReader(connect.getInputStream()));
            System.out.println("Dados recebidos: "+ent_user.readLine()+"\n__________________________");
            Scanner aux = new Scanner(System.in);
            PrintStream sai = new PrintStream(connect.getOutputStream());
            System.out.println("Digite a resposta ao usuario: ");
            sai.println(aux.nextLine());
            System.out.println("Aguardando o usuario...");
            //sai.close();aux.close();ent_user.close();connect.close();sv.close();
        }
    }
}
