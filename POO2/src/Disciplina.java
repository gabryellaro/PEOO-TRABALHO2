import java.io.*;
import java.util.Scanner;
public class Disciplina {
    //esse foram criados fora de métodos pos precisam ser puxados para main em algum momento
    private File dir=new File("diretório");
    private File disciplinas = new File(dir,"disciplinas.txt");
    private File gabaritoFile=new File(dir,"gabarito.txt");

    //cria uma disciplina(pasta e arquivo com o mesmo nome da disciplina)
    public void novoArquivo(File dir,String disciplina,String dados,String gabarito){
        File dirFile=new File(dir,disciplina);
        dirFile.mkdir();
        File file = new File(dirFile,disciplina+".txt");
        try{file.createNewFile();}catch(IOException e){}
        try{
        FileReader ler = new FileReader(file);
        FileWriter fileWriter = new FileWriter(file,true);     
        BufferedWriter escrever = new BufferedWriter(fileWriter); 
        
        escrever.write (dados);
        escrever.newLine();

        escrever.close();
        fileWriter.close();      

        BufferedReader lerb = new BufferedReader(ler);
        String linha = lerb.readLine();
        
        lerb.close();
        while(linha!= null){
            linha = lerb.readLine();
        }
    //gabarito gerado junto
        ler = new FileReader(gabaritoFile);
        fileWriter = new FileWriter(gabaritoFile,false);     
        escrever = new BufferedWriter(fileWriter); 
                
        escrever.write (gabarito);
        escrever.close();
        fileWriter.close();      
        
        lerb = new BufferedReader(ler);
        linha = lerb.readLine();
                
        lerb.close();
        while(linha!= null){
            linha = lerb.readLine();
        }
    }catch(IOException e){}       
    }
    //lista de disciplinas pro método de pesquisa(também funciona como histórico de disciplinas adicionadas)
    public void novaDisciplina(File dir,String disciplina){
        try{disciplinas.createNewFile();}catch(IOException e){}
        try{
        FileReader ler = new FileReader(disciplinas);
        FileWriter fileWriter = new FileWriter(disciplinas,true);     
        BufferedWriter escrever = new BufferedWriter(fileWriter); 
        
        escrever.write (disciplina);
        escrever.newLine();
        escrever.close();
        fileWriter.close();      
        BufferedReader lerb = new BufferedReader(ler);
        String linha = lerb.readLine();
        
        lerb.close();
        while(linha!= null){
            linha = lerb.readLine();
        }
    }catch(IOException e){}       
    }

    //cria o gabarito de uma disciplina
    public void gabarito(File dir,String gabarito){
        try{
            File file=new File(dir,"gabarito.txt");
            FileReader ler = new FileReader(file);
            FileWriter fileWriter = new FileWriter(file);     
            BufferedWriter escrever = new BufferedWriter(fileWriter); 
            
            escrever.write (gabarito);
            escrever.close();
            fileWriter.close();      
    
            BufferedReader lerb = new BufferedReader(ler);
            String linha = lerb.readLine();
            
            lerb.close();
            while(linha!= null){
                linha = lerb.readLine();
            }
        }catch(IOException e){}
    }

    //pesquisa o nome da disciplina
    public File search(String procura,File disciplinas){
        try (Scanner file = new Scanner(disciplinas)) {
            while (file.hasNextLine()){
                final String lineFromFile = file.nextLine();
                if(lineFromFile.contains(procura)) {
                    File retorno =new File(,procura + ".txt");
                    System.out.println("FUNCIONOU");
                    return retorno;
                }
            }
            file.close();
        }catch(IOException e){}             
        return null;
    }



    public File getDir() {
        return dir;
    }
    public File getDisciplinas() {
        return disciplinas;
    }
    public File getGabarito() {
        return gabaritoFile;
    }

}