import java.io.File;
import java.util.Scanner;
/*Lista de afazeres:
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
        File dir = new File("diretório");
        dir=disciplina.getDir();
        dir.mkdir();
        Aluno aluno=new Aluno();
        int opção=0;
        while(opção!=3){
        System.out.println("ESCOLHA UMA OPÇÃO:\n1-CRIAR DISCIPLINA\n2-GERAR MÉDIAS(ORDEM ALFABÉTICA E DECRESCENTE)\n3-SAIR");
        opção=input.nextInt();
            switch(opção){
                case 1:
                //criando uma nova disciplina
                /*OBS:CASO FECHE OU PROGRAMA OU VOLTE PARA O MENU QUEIRA ACIONAR 
                UM NOVO ALUNO NUMA DISCIPINA JA EXISTENTE, APENAS DIGITE O NOME DELA NOVAMENTE*/
                System.out.println("Nome disciplina(Para editar uma disciplina digite o nome dela novamente): ");
                String nomeDisciplina= input.next();
                System.out.println("Respostas e Aluno ");
                String respostas=input.next();
                aluno.tamanhoResposta(respostas);//caso o gabarito seja mais de 10 letras
                String nomeAluno= input.nextLine();
                //junta as strings de repostas e nome do aluno, separando elas por um tab;
                String dados = respostas.toUpperCase()+"\t"+nomeAluno;
                //Arquivo da disciplina
                System.out.println("Insira o gabarito Oficial:");
                String gabarito=input.next();
                aluno.tamanhoResposta(gabarito);      
                disciplina.novoArquivo(dir,nomeDisciplina,dados,gabarito);
                //Disciplina adiconada a lista de disciplinas
                disciplina.novaDisciplina(dir,nomeDisciplina);
                //adicionando outros alunos
                int loop=0;
                while(loop != 2){
                    System.out.println("DESEJA ADICIONAR OUTRO ALUNO?\n1-SIM\n2-NÃO");
                    loop=input.nextInt();
                    if(loop==1){
                        System.out.println("Respostas e Aluno ");
                        respostas=input.next();
                        nomeAluno=input.nextLine();
                        aluno.tamanhoResposta(respostas);
                        disciplina.novoArquivo(dir,nomeDisciplina,dados,gabarito);
                    }
                    else if(loop==2){
                        break;
                    }
                    else{
                        System.out.println("OPÇÃO INVÁLIDA");
                    }
                }
                continue;
                case 2:
                System.out.println("Insira o nome da disciplina :");
                String pesquisa=input.next();
                /*o método tem que entregar a string ou o File ?
                  talvez os dois, por isso talvez tenha que sobreescrever o método, pois é preciso pegar o arquivo designado
                */
                disciplina.search(pesquisa,disciplina.getDisciplinas());
                //System.out.println("O gabarito oficial de "+);
                continue;
            }
        }
        input.close();
    }
        /*calcular a nota do aluno
        System.out.println("Digite o gabarito das questões");
        String gabarito=input.nextLine();
        System.out.println(aluno.calcularNota(respostas, gabarito.toUpperCase()));*/
}