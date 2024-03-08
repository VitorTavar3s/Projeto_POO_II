import java.util.List;
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
            System.out.println("1 - Cadastrar/Alterar/Buscar Veículo");
            System.out.println("2 - Cadastrar/Alterar Cliente");
            System.out.println("3 - Alugar/Devolver Veículo");
            System.out.println("4 - Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> menuVeiculo();
                case 2 -> menuCliente();
                case 3 -> menuLocacao();
                case 4 -> System.out.println("Saindo...");
                default -> System.out.println("Digite uma opção válida!");
            }
        } while (opcao != 4);
    }

    public static void menuVeiculo(){
        int opcao;
        do {

            System.out.println(">>>> Menu Veículo <<<<");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Alterar");
            System.out.println("3 - Buscar");
            System.out.println("4 - Voltar Menu Anterior");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> cadastrarVeiculo();
                case 2 -> alterarVeiculo();
                case 3 -> buscarVeiculo();
                case 4 -> System.out.println();
                default -> System.out.println("Digite uma opção válida!");
            }

        }while (opcao!=4);
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
                case 1 -> cadastrarCliente();
                case 2 -> alterarCliente();
                case 3 -> System.out.println();
                default -> System.out.println("Digite uma opção válida!");
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
                case 1 -> alugarVeiculo();
                case 2 -> devolverVeiculo();
                case 3 -> System.out.println();
                default -> System.out.println("Digite uma opção válida!");
            }

        }while (opcao!=3);
    }

    public static void cadastrarVeiculo(){

    }

    public static void alterarVeiculo(){

    }

    public static void buscarVeiculo(){

    }

    public static void cadastrarCliente(){

    }
    public static void alterarCliente(){

    }
    public static void alugarVeiculo(){

    }
    public static void devolverVeiculo(){

    }
}