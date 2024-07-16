public class CadastroMembro {

    private Membro [] membros;
    private int index;

    public CadastroMembro() {
        membros = new Membro[10];
        index = 0;
    }
    
    public boolean adicionaMembro(int matricula, String nome, String cidade, Bicicleta bicicleta) {
        if(index >= membros.length) {
            return false;
        } else {
            Membro novoMembro = new Membro(matricula, nome, cidade, bicicleta);

            membros[index] = novoMembro;
            index++;
            return true;
        }
    }
    
    public void mostraMembros() { //OPÇÃO 2 MENU
        for(int i = 0; i < index; i++){
            System.out.println("***********************************\nMembro " + (i + 1)+ ": \n"+membros[i].toString());
        }
    }
    
    public Membro buscaMembroPeloNome(String nome) {
        for (int i = 0; i < membros.length; i++) {
            if (membros[i] != null) {
                if (membros[i].getNome().equals(nome)){
                    return membros[i];
                }
            }
        }
        return null;
    }
    
    public Membro buscaMembroPelaMatricula(int matricula) {
        for (int i = 0; i < index; i++) {
            if (membros[i].getMatricula() == matricula){
                return membros[i];
            }
        }
        return null;
    }
}