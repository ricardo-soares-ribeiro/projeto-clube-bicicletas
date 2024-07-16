
public class Membro {

    private int matricula;
    private String nome;
    private String cidade;
    private Bicicleta bicicleta;

    public Membro(int matricula, String nome, String cidade, Bicicleta bicicleta) {
        setMatricula(matricula);
        setNome(nome);
        setCidade(cidade);
        setBicicleta(bicicleta);
    }
    
    public Bicicleta getBicicleta(){
        return bicicleta;
    }
    
    public void setBicicleta(Bicicleta novaBicicleta){
        this.bicicleta = novaBicicleta;
    }
    
    public int getMatricula(){
        return matricula;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getCidade(){
        return cidade;
    }
    
    public void setMatricula(int novaMatricula){
        this.matricula = novaMatricula;
    }
    
    public void setNome(String novoNome){
        this.nome = novoNome;
    }
    
    public void setCidade(String novaCidade){
        this.cidade = novaCidade;
    }
    
    public String toString() {
        return "Matrícula: "+matricula+"\nNome: "+nome+"\nCidade: "+cidade+"\nBicicleta: {\n"+bicicleta+"\n}";
    }
}
