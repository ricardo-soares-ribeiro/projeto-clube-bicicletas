import java.util.Scanner;

public class Clube {

    private static CadastroMembro cadastroMembro = new CadastroMembro();
    private static CadastroBicicleta cadastroBicicleta = new CadastroBicicleta();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[]args){
        int opcao = 0;
        
        do{
            menu();
            opcao = scanner.nextInt();

            switch (opcao) {
               case 1:
                   incluirMembro();
                   break;
                   
                case 2:
                    mostrarMembros();
                   break;
                   
                case 3:
                    pesquisarMembroPorNome();
                    break;
                    
                case 4:
                    incluirBicicleta();
                    break;
                    
                case 5:
                    mostrarBicicletas();
                    break;
                    
                case 6:
                    pesquisarBicicletaPeloModelo();
                    break;
                    
                case 7:
                    emprestarBicicleta();
                    break;
                    
                case 8:
                    devolverBicicleta();
                    break;
                    
                case 9:
                    unidadesDisponiveis();
                    break;
                    
                case 10:
                    System.out.println("___PROGRAMA ENCERRADO___");
                    break;
                    
                default:
                    System.out.println("OPÇÃO INVÁLIDA");
                    break;
            }
        } while (opcao != 10);
    }
    
    public static void menu() {
        System.out.println("🚲 🚲 🚲 🚲 🚲 🚲 🚲 🚲 🚲 🚲 🚲 🚲 🚲 🚲");
        System.out.println("🚲       ESCOLHA UMA OPÇÃO         🚲");
        System.out.println("🚲 🚲 🚲 🚲 🚲 🚲 🚲 🚲 🚲 🚲 🚲 🚲 🚲 🚲");
        System.out.println("🚲 1. Incluir membro               🚲");
        System.out.println("🚲 2. Mostrar membros              🚲");
        System.out.println("🚲 3. Pesquisar membro por nome    🚲");                    
        System.out.println("🚲 4. Incluir bicicleta            🚲");
        System.out.println("🚲 5. Mostrar bicicletas           🚲");
        System.out.println("🚲 6. Pesquisar modelo bicicleta   🚲");                      
        System.out.println("🚲 7. Emprestar bicicleta          🚲");
        System.out.println("🚲 8. Devolver bicicleta           🚲");
        System.out.println("🚲 9. Unidades disponíveis         🚲");
        System.out.println("🚲 10. Sair do programa            🚲");
        System.out.println("🚲 🚲 🚲 🚲 🚲 🚲 🚲 🚲 🚲 🚲 🚲 🚲 🚲 🚲");
    }
    
    private static void incluirMembro() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Crie uma matrícula (ex: 444, 555, 666): ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Informe o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Informe a cidade: ");
        String cidade = scanner.nextLine();

        if (cadastroMembro.adicionaMembro(matricula, nome, cidade, null)) {
            System.out.println("** NOVO MEMBRO ADICIONADO COM SUCESSO **\n");
        } else {
            System.out.println("** NÃO FOI POSSÍVEL ADICIONAR O NOVO MEMBRO (CADASTRO CHEIO) **\n");
        }
        
    }
    
    private static void mostrarMembros(){ //OPÇÃO 2 MENU
        cadastroMembro.mostraMembros();
    }
    
    private static void pesquisarMembroPorNome() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o nome do membro: ");
        String nome = scanner.nextLine();

        Membro membro = cadastroMembro.buscaMembroPeloNome(nome);

        if (membro != null) {
            System.out.println(membro.toString());
        } else {
            System.out.println("Membro não encontrado.");
        }
    }
    
    private static void incluirBicicleta() {
        System.out.println("Informe o código da bicicleta:");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Informe o modelo da bicicleta:");
        String modelo = scanner.nextLine();

        System.out.println("Informe a quantidade de unidades:");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        if (cadastroBicicleta.adicionaBicicleta(codigo, modelo, quantidade)) {
            System.out.println("** NOVA BICICLETA ADICIONADA COM SUCESSO **\n");
        } else {
            System.out.println("** NÃO FOI POSSÍVEL ADICIONAR A BICICLETA (CADASTRO CHEIO) **\n");
        }

    }
    
    private static void mostrarBicicletas() {
        cadastroBicicleta.mostraBicicletas();
    }
    
    private static void pesquisarBicicletaPeloModelo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o modelo de bicicleta: ");
        String modelo = scanner.nextLine();

        Bicicleta bicicleta = cadastroBicicleta.buscaBicicletaPeloModelo(modelo);

        if (bicicleta != null) {
            System.out.println(bicicleta.toString());
        } else {
            System.out.println("Bicicleta não encontrada.");
        }
    }
    
    private static void unidadesDisponiveis() {
        int total = cadastroBicicleta.totalUnidades();
        System.out.println("Quantidade total de unidades disponíveis: " + total);
    }

    public static void emprestarBicicleta() {
        System.out.println("Informe a matrícula do membro: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        Membro membro = cadastroMembro.buscaMembroPelaMatricula(matricula);

        if (membro == null) {
            System.out.println("Membro não encontrado.");
            return;
        }

        if (membro.getBicicleta() != null) {
            System.out.println("Membro já possui uma bicicleta emprestada.");
            return;
        }

        System.out.println("Informe o código da bicicleta:");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        Bicicleta bicicleta = cadastroBicicleta.buscaBicicletaPeloCodigo(codigo);

        if (bicicleta == null) {
            System.out.println("Bicicleta não encontrada.");
            return;
        }

        if (cadastroBicicleta.checarBicicletaDisponivel() == false) {
            System.out.println("Bicicleta não disponível.");
            return;
        }

        membro.setBicicleta(bicicleta);
        bicicleta.setQuantidade(bicicleta.getQuantidade() - 1);

        System.out.println("** BICICLETA EMPRESTADA COM SUCESSO **");
    }

    public static void devolverBicicleta() {
        System.out.println("Informe a matrícula do membro:");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        Membro membro = cadastroMembro.buscaMembroPelaMatricula(matricula);
        if (membro == null) {
            System.out.println("Membro não encontrado.");
            return;
        }

        Bicicleta bicicleta = membro.getBicicleta();
        if (bicicleta == null) {
            System.out.println("Membro não possui bicicleta emprestada.");
            return;
        }

        bicicleta.setQuantidade(bicicleta.getQuantidade() + 1);
        membro.setBicicleta(null);
        System.out.println("** BICICLETA DEVOLVIDA COM SUCESSO **");
    }
}