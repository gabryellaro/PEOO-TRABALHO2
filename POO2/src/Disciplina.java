import java.io.*;

public class Disciplina {
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
}