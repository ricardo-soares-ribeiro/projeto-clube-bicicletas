
public class Bicicleta {

    private int codigo;
    private String modelo;
    private int quantidade;

    public Bicicleta(int codigo, String modelo, int quantidade) {
        setCodigo(codigo);
        setModelo(modelo);
        setQuantidade(quantidade);
    }

    public int getCodigo(){
        return codigo;
    }
    
    public String getModelo(){
        return modelo;
    }
    
    public int getQuantidade(){
        return quantidade;
    }
    
    public void setCodigo(int novoCodigo){
        this.codigo = novoCodigo;
    }
    
    public void setModelo(String novoModelo) {
        this.modelo = novoModelo;
    }
    
    public void setQuantidade(int novaQuantidade){
        this.quantidade = novaQuantidade;
    }
    
    public String toString(){
        return "Código: "+codigo+"\nModelo: "+modelo+"\nQuantidade: "+quantidade;
    }
}