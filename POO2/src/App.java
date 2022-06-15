import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //cira a pasta das discipinas
        File dir=new File("Disciplinas");
        dir.mkdir();

        //criando uma nova disciplina
        Scanner input = new Scanner(System.in);
        DisciplinaGestor disciplina=new DisciplinaGestor();
        String nome=input.nextLine();
        disciplina.novoArquivo(dir,nome);

     
      /* 
        File arquivo = new File("POO.txt");
        try{
        arquivo.createNewFile();
       
        FileReader ler = new FileReader(arquivo);
        FileWriter fileWriter = new FileWriter(arquivo); 
        String data = null;
        data = input.nextLine();

        BufferedWriter escrever = new BufferedWriter(fileWriter);

        escrever.write(data);

        escrever.close();
        fileWriter.close();
        input.close();
        
        BufferedReader lerb = new BufferedReader(ler);
        String linha = lerb.readLine();
        escrever.newLine();
        lerb.close();

        while(linha!= null){
            System.out.println(linha);
            linha = lerb.readLine();
        }
       
        }
        catch(IOException ex) {

        }*/
        input.close();
    }
}


