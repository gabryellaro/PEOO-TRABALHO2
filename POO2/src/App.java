import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
/*Lista de afazeres:
    -Fazer menu

    -Fazer o código rodar para mais de um único aluno

    -Criar um método para calcular a media(calcular nota repetidas vezes)

    -Encontrar alguma forma de transformar os dados do arquivo,
    em um array de objetos(ou de respostas/notas)
    -ler a linha do arquivo e adiconar num array;
    -separar a linha com um .split() separando em respostas e nome do aluno
    e transformar esse array em um objeto novamente
    
    -Usar .split pra separar o nome das repostas*/

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Disciplina disciplina=new Disciplina();
        //Aluno aluno=new Aluno();
        ArrayList<String> disciplinas = new ArrayList<String>();
        //ArrayList<String> listaAlunos = new ArrayList<String>();
        //ArrayList<String> listaRespostas = new ArrayList<String>();
        //cria a pasta das discipinas
        File dir=new File("Disciplinas");
        dir.mkdir();
        int opção=0;
        while(opção!=3){
        System.out.println("ESCOLHA UMA OPÇÃO:\n1-CRIAR DISCIPLINA\n2-EDITAR DISCIPLINA\n3-SAIR");
        opção=input.nextInt();
            switch(opção){
                case 1:
                //criando uma nova disciplina
                System.out.println("Nome disciplina: ");
                String nomeDisciplina= input.next();
                System.out.println("Respostas e Aluno ");
                String respostas=input.nextLine();
                String nomeAluno= input.nextLine();
                String dados = respostas.toUpperCase()+"\t"+nomeAluno;
                disciplina.novoArquivo(dir,nomeDisciplina,dados);
                disciplina.novaDisciplina(dir,nomeDisciplina);
                continue;
                case 2:
                System.out.println("Insira o nome da disciplina que deseja editar:");
                String nomeDisciplinaProcurada=input.next();
                for(String elemento : disciplinas){
                    if(elemento.equals(nomeDisciplinaProcurada)){
                        System.out.println(elemento);
                    }
                }
                
    
            }
        }
        /*calcular a nota do aluno
        System.out.println("Digite o gabarito das questões");
        String gabarito=input.nextLine();
        System.out.println(aluno.calcularNota(respostas, gabarito.toUpperCase()));*/
        input.close();
            }
}