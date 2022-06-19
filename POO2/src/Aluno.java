import exception.GabaritoInvalidoException;

//ainda sem propósito exato
public class Aluno{
    protected String nome;
    protected String respostas;
    protected int nota;
    public Aluno(String nome,String respostas,int nota){
        this.nome=nome;
        this.respostas=respostas;
        this.nota=nota;
    }
    public Aluno(){}

    //caso o usuário escreva a string de um tamanho diferente do proposto
    public String tamanhoResposta(String resposta) throws GabaritoInvalidoException{
        if (resposta.length() == 10){
           return resposta;
        }else{
            throw new GabaritoInvalidoException();
        }
     }

    //a idéia era pegar 2 strings, separar os caractéres de cada uma e comparalos individualmente(funcional)
    public int calcularNota(String rAluno,String gabarito){
        //split separa a string, com a configuração dele, ele vai separar caractére por caractére
        String[] s1= rAluno.split("");
        //Caso todas as respostas seja indenticas
        if(rAluno.equals("VVVVVVVVVV")||rAluno.equals("FFFFFFFFFF")){
            return 0;
        }
        String[] s2= gabarito.split("");
        int nota=0;
        for(int i=0;i<gabarito.length();i++){
            if(s1[i].equals(s2[i])){
                nota+=1;
            }
        }
        return nota;
    }
    
    //getters e setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getRespostas() {
        return respostas;
    }
    public void setRespostas(String respostas) {
        this.respostas = respostas;
    }
    public int getNota() {
        return nota;
    }
    public void setNota(int nota) {
        this.nota = nota;
    }
}