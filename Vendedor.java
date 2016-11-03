/** Aluno Jéferson Bueno Turma: 53  prova GrauA Lab I*/

public class Vendedor{
    private String nome;
    private int tipo;
    
    public Vendedor(String nome, int tipo){
       setTipo(tipo);
       setNome(nome);       
    }
    
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        if(nome.length() < 7)
            this.nome = "NomeIndefinido";
        else
            this.nome = nome;
    }

    public int getTipo() {
    	return this.tipo;
    }
    
    public void setTipo(int tipo) {
        if(tipo != 1 && tipo != 2)
            this.tipo = 2;
        else
            this.tipo = tipo;
    }
    
    public String traduzTipo(){
        return this.tipo == 1 ? "Comissionado" : "Sem comissão";
    }
}
