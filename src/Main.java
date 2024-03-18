import java.util.Scanner;

public class Main {
        static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao;


        do {
            System.out.println("################################################");
            System.out.println("##### ADA LocateCar - Locadora de Veículos #####");
            System.out.println("################################################\n");


            System.out.println(">>>> Menu <<<<");
            System.out.println("1 - Menu Veículo");
            System.out.println("2 - Menu Cliente");
            System.out.println("3 - Menu Aluguel");
            System.out.println("4 - Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> menuVeiculo();
                case 2 -> menuCliente();
                case 3 -> menuLocacao();
                case 4 -> System.out.println("Saindo...");
                default -> System.out.println("Opção " + opcao + " é inválida, Digite 1, 2, 3 ou 4! \n");
            }
        } while (opcao != 4);
    }

    public static boolean menuVeiculo(){
        int opcao;
        do {

            System.out.println(">>>> Menu Veículo <<<<");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Alterar");
            System.out.println("3 - Buscar");
            System.out.println("4 - Voltar Menu Anterior");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> Veiculo.cadastrarVeiculo();
                case 2 -> Veiculo.alterarVeiculo();
                case 3 -> Veiculo.buscarVeiculo();
                case 4 -> {return false;}
                default -> System.out.println("Opção " + opcao + " é inválida, Digite 1, 2, 3 ou 4! \n");
            }

        }while (opcao!=4);
        return true;
    }
    public static void menuCliente(){
        int opcao;
        do {

            System.out.println(">>>> Menu Cliente <<<<");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Alterar");
            System.out.println("3 - Voltar Menu Anterior");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> Cliente.cadastrarCliente();
                case 2 -> Cliente.alterarCliente();
                case 3 -> System.out.println();
                default -> System.out.println("Opção " + opcao + " é inválida, Digite 1, 2 ou 3! \n");
            }

        }while (opcao!=3);
    }

    public static void menuLocacao(){
        int opcao;
        do {

            System.out.println(">>>> Menu Locação <<<<");
            System.out.println("1 - Alugar");
            System.out.println("2 - Devolver");
            System.out.println("3 - Voltar Menu Anterior");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1 ->{
                    System.out.println("Digite o CPF ou CNPJ(Apenas números):");
                    scanner.nextLine();
                    Locacao.alugarVeiculo(scanner.nextLine());}
                case 2 -> {System.out.println("Digite o CPF ou CNPJ(Apenas números):");
                    scanner.nextLine();
                    Locacao.devolverVeiculo(scanner.nextLine());}
                case 3 -> System.out.println();
                default -> System.out.println("Opção " + opcao + " é inválida, Digite 1, 2 ou 3! \n");
            }

        }while (opcao!=3);
    }
}
