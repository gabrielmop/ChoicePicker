import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        int nummaximo;
        int numero;
        Random num1 = new Random();
        int resposta;
        ArrayList<String> lista = new ArrayList<>(List.of());
        Scanner scan = new Scanner(System.in);

        do{
        int removidos = 1;
        lista.clear();
        System.out.println("Bem-Vindo ao ChoicePicker");
        System.out.println("Esse app gera uma sugestão de forma aleatória baseado em uma lista que voce escolher");
        System.out.println("Digite Quantos números você quer que sejam gerados:");
        numero = scan.nextInt();
        System.out.println("Agora escolha um arquivo para preencher a lista");
        System.out.println("OBS: Talvez a janela esteja atras do console, minimize o console para verificar a janela");

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Escolha um arquivo para preencher a lista");
        fileChooser.setCurrentDirectory(new File("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop"));
        int retorno = fileChooser.showOpenDialog(null);


        if (retorno == JFileChooser.APPROVE_OPTION) {
            File arquivo = fileChooser.getSelectedFile();
            try {
                BufferedReader br = new BufferedReader(new FileReader(arquivo));
                String Linha;
                while ((Linha = br.readLine()) != null) {

                    lista.add(Linha);
                    if (Linha.startsWith("--")) {
                        lista.remove(Linha);
                        break;
                    }
                    if (Linha.contains("//")) {
                        lista.remove(Linha);
                        removidos++;
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        nummaximo = lista.size();
        do {
            for (int a = 0; a < numero; a++) {
                int resultado = num1.nextInt(0, nummaximo);
                System.out.printf("O numero sorteado foi: %d - %s \n", resultado + removidos, lista.get(resultado));
            }
            System.out.println("Digite 1 para Gerar outro número ou 2 pra redefinir parametros");
            resposta = scan.nextInt();
        } while (resposta == 1);
    }while (resposta == 2);
    }
}
