public class CadastroBicicleta {

    private Bicicleta [] bicicletas;
    private int index;

    public CadastroBicicleta() {
        bicicletas = new Bicicleta[10];
        index = 0;
    }

    public boolean adicionaBicicleta (int codigo, String modelo, int quantidade) {
        if (index >= bicicletas.length) {
            return false;
        } else {
            Bicicleta novaBicicleta = new Bicicleta(codigo, modelo, quantidade);

            bicicletas[index] = novaBicicleta;
            index++;
            return true;
        }
    }
    
    public void mostraBicicletas(){
        for (int i = 0; i < index; i++){
            System.out.println("***********************************\nBicicleta " + (i + 1)+ ": \n"+bicicletas[i].toString());
        }
    }
    
    public Bicicleta buscaBicicletaPeloModelo(String modelo) {
        for (int i = 0; i < index; i++) {
            if (bicicletas[i] != null) {
                if (bicicletas[i].getModelo().equals(modelo)){
                    return bicicletas[i];
                }
            }
        }
        return null;
    }
    
    public int totalUnidades() { //OPÇÃO 9 MENU
        int total = 0;

        for (int i = 0; i < index; i++){
            total += bicicletas[i].getQuantidade();
        }
        return total;
    }

    public Bicicleta buscaBicicletaPeloCodigo(int codigo) {
        for (int i = 0; i < index; i++) {
            if (bicicletas[i].getCodigo() == codigo) {
                return bicicletas[i];
            }
        }
        return null;
    }
    
    public boolean checarBicicletaDisponivel() {
        for (int i = 0; i < index; i++) {
            if(bicicletas[i].getQuantidade() > 0) {
                return true;
            }
        }
        return false;
    }
}