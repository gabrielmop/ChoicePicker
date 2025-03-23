import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int nummaximo;
        int numero;
        Random num1;
        int resposta;
       ArrayList<String> lista = new java.util.ArrayList<>(List.of());
        int removidos = 1;
        Scanner scan = new Scanner(System.in);

        lista.clear();
        System.out.println("Bem-Vindo ao ChoicePicker");
        System.out.println("Esse app gera uma sugestão de jogo aleatoriamente baseado em uma lista que voce escolher");
        System.out.println("Digite Quantos números você quer que sejam gerados:");
        numero = scan.nextInt();
        System.out.println("Agora escolha um arquivo para preencher a lista");

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Escolha um arquivo para preencher a Lista");
        fileChooser.setCurrentDirectory(new File("C:\\Users\\gabri\\Desktop"));
        int retorno = fileChooser.showOpenDialog(null);

       if(retorno == JFileChooser.APPROVE_OPTION)
       {
           File arquivo = fileChooser.getSelectedFile();
           System.out.println("Arquivo selecionado: " + arquivo.getAbsolutePath());


           try {
               BufferedReader br = new BufferedReader(new FileReader(arquivo));
                String Linha;
                while((Linha = br.readLine()) != null)
                {

                    lista.add(Linha);
                    if(Linha.startsWith("--"))
                    {
                        lista.remove(Linha);
                        break;
                    }
                    if(Linha.contains("//"))
                    {
                        lista.remove(Linha);
                        removidos++;
                    }
                }
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
       }
       nummaximo = lista.size();
       for (int a = 0; a < nummaximo; a++)
       {
           System.out.printf("O jogo é: %d - %s \n",a + removidos, lista.get(a));
       }






    }
}