import java.io.File;
import java.util.Scanner;
/*Lista de afazeres:
    -Fazer menu

    -Fazer uma forma de editar um arquivo ja criado
    (mecanismo de pesquisa de disciplina[?])

    -Fazer o código rodar para mais de um único aluno

    -Criar um método para calcular a media(calcular nota repetidas vezes)

    -Encontrar alguma forma de transformar os dados do arquivo,
    em um array de objetos(ou de respostas/notas)
    e transformar esse array em um objeto novamente*/
public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Disciplina disciplina=new Disciplina();
        Aluno aluno=new Aluno();
        //cria a pasta das discipinas
        File dir=new File("Disciplinas");
        dir.mkdir();

        //criando uma nova disciplina
        System.out.println("Nome disciplina: ");
        String nomeDisciplina=input.nextLine();
        System.out.println("Respostas e Aluno ");
        String respostas=input.nextLine();String nomeAluno= input.nextLine();
        String dados = respostas.toUpperCase()+"\t"+nomeAluno;
        disciplina.novoArquivo(dir,nomeDisciplina,dados);

        //calcular a nota do aluno
        System.out.println("Digite o gabarito das questões");
        String gabarito=input.nextLine();
        System.out.println(aluno.calcularNota(respostas, gabarito.toUpperCase()));
        input.close();
    }
}


