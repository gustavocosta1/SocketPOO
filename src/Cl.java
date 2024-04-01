import java.io.*;
import java.net.Socket;

public class Cl {
    public static void main(String[] args) throws Exception {
        Socket cl = new Socket("localhost",24);
        while (true) {
            System.out.println("Digite o dado a ser enviado: ");
            BufferedReader br_user = new BufferedReader(new InputStreamReader(System.in));
            String linha = br_user.readLine();
            System.out.println("Preparando dados...");
            PrintStream ps = new PrintStream(cl.getOutputStream());
            ps.println(linha);
            System.out.println("Dados enviados\n_____________________");
            System.out.println("Aguardando resposta do servidor...");
            BufferedReader br_sv = new BufferedReader(new InputStreamReader(cl.getInputStream()));
            System.out.println("Servidor responde: "+br_sv.readLine()+"\n______________________");
            //br_sv.close();ps.close();br_user.close();cl.close();
        }

    }
}
