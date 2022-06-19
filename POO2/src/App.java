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
                try {
                    aluno.tamanhoResposta(respostas);//caso o gabarito esteja errado;
                } catch (Exception e) {
                    System.out.println(e);
                }
                String nomeAluno= input.nextLine();
                //junta as strings de repostas e nome do aluno, separando elas por um tab;
                String dados = respostas.toUpperCase()+"\t"+nomeAluno;
                //Arquivo da disciplina    
                disciplina.novoArquivo(nomeDisciplina,dados);
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
                        try {
                            aluno.tamanhoResposta(respostas);//caso o gabarito esteja errado;
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        dados = respostas.toUpperCase()+"\t"+nomeAluno;
                        disciplina.novoArquivo(nomeDisciplina,dados);
                    }
                }
                continue;
                case 2:
                System.out.println("INSIRA O NOME DA DISCIPLINA :");
                String pesquisa=input.next();
                System.out.println("INSIRA O GABARITO OFICAL :");
                String gabarito=input.next();
                try {
                    aluno.tamanhoResposta(gabarito);//caso o gabarito esteja errado;
                } catch (Exception e) {
                    System.out.println(e);
                }  
                disciplina.gabarito(disciplina.search(pesquisa), gabarito,pesquisa);
                System.out.println("O gabarito oficial de: "+pesquisa+" é :"+gabarito);
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