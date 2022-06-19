import java.io.*;
import java.util.ArrayList;
public class Disciplina {

    //cria uma disciplina(pasta e arquivo com o mesmo nome da disciplina)
    public void novoArquivo(File dir,String disciplina,String dados){
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
            System.out.println(linha);
            linha = lerb.readLine();
        }
    }catch(IOException e){}       
    }
    public void novaDisciplina(File dir,String disciplina){
        File file = new File(dir,"disciplinas.txt");
        try{file.createNewFile();}catch(IOException e){}
        try{
        FileReader ler = new FileReader(file);
        FileWriter fileWriter = new FileWriter(file,true);     
        BufferedWriter escrever = new BufferedWriter(fileWriter); 
        
        escrever.write (disciplina);
        escrever.newLine();
        escrever.close();
        fileWriter.close();      
        BufferedReader lerb = new BufferedReader(ler);
        String linha = lerb.readLine();
        
        lerb.close();
        while(linha!= null){
            System.out.println(linha);
            linha = lerb.readLine();
        }
    }catch(IOException e){}       
    }
    //cria o gabarito de uma disciplina
    public void gabarito(File dir,String gabarito){
        File file=new File(dir,"gabarito.txt");
        try{
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

    public String procurarDisciplina(String procura,File disciplinas){
    ArrayList<String> linha = new ArrayList<>();
    try {
    FileReader reader=new FileReader(disciplinas);
    BufferedReader bReader = new BufferedReader(reader);
    String ler;
    bReader.close();
    while (( ler = bReader.readLine()) != null) {
    linha.add(ler);
    }
    } catch (IOException e) {}
    String[] lista = linha.toArray(new String[0]);
    
        for(String elemento : lista){
            if(elemento.equals(procura)){
                return elemento;
            }
        }
    }


}