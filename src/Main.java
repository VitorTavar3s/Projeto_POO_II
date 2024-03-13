import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
        static Scanner scanner = new Scanner(System.in);
        static List<Veiculo> veiculos = new ArrayList<>();
        static ArrayList<PessoaFisica> pessoasFisicas = new ArrayList<>();
        static ArrayList<PessoaJuridica> pessoasJuridicas = new ArrayList<>();

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
                case 1 -> Cliente.cadastrarCliente();
                case 2 -> alterarVeiculo();
                case 3 -> buscarVeiculo();
                case 4 -> {return false;}
                default -> System.out.println("Digite uma opção válida!");
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

    public static boolean cadastrarVeiculo(){
        scanner.nextLine();
        System.out.println("Digite a placa do veículo:");
        String placa = scanner.nextLine().toUpperCase();

        for (Veiculo veiculo: veiculos) {
            if (veiculo.getPlaca().equals(placa)){
                System.out.println("Placa de veículo já cadastrada, cadastre outro veículo.\n");
                return false;
            }
        }

        System.out.println("Digite a marca do veículo:");
        String marca = scanner.nextLine();
        System.out.println("Digite o modelo do veículo:");
        String modelo = scanner.nextLine();
        System.out.println("Digite qual o tipo do veículo (P-PEQUENO / M-MÉDIO / S-SUV):");
        char tipo = scanner.next().toUpperCase().charAt(0);

        Veiculo veiculo = new Veiculo(placa,marca,modelo,tipo);
        veiculos.add(veiculo);
        System.out.println("Veículo cadastrado com sucesso!");
        return true;
    }

    public static boolean alterarVeiculo(){
        scanner.nextLine();
        System.out.println("Veículos:");
        for (Veiculo veiculo: veiculos) {
            System.out.println(veiculo);
        }
        System.out.println("Digite a placa do veículo que deseja alterar:");
        String placa = scanner.nextLine().toUpperCase();
        Veiculo veiculoSelecionado = null;
        for (Veiculo veiculo: veiculos) {
            if (placa.equals(veiculo.getPlaca())){
                veiculoSelecionado = veiculo;
                break;
            }
        }
        if(veiculoSelecionado == null) {
            System.out.println("Placa não encontrada,voltando pro menu anterior.");
            return false;
        }


        System.out.println("O que deseja alterar no veículo? Escolha a opção: ");
        System.out.println("1 - Placa");
        System.out.println("2 - Marca");
        System.out.println("3 - Modelo");
        System.out.println("4 - Tipo");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                scanner.nextLine();
                System.out.println("Digite a nova placa: ");
                String novaPlaca = scanner.nextLine().toUpperCase();
                for (Veiculo veiculo: veiculos) {
                    if (veiculo.getPlaca().equals(novaPlaca)){
                        System.out.println("Placa de veículo já cadastrada, voltando ao menu anterior.\n");
                        return false;
                    }
                }
                veiculoSelecionado.setPlaca(novaPlaca);
                break;
            case 2:
                System.out.println("Digite a nova marca: ");
                String novoMarca = scanner.next();
                veiculoSelecionado.setMarca(novoMarca);
                break;
            case 3:
                System.out.println("Digite o novo modelo: ");
                String novoModelo = scanner.next();
                veiculoSelecionado.setModelo(novoModelo);
                break;
            case 4:
                System.out.println("Digite o novo tipo: ");
                char novoTipo = scanner.next().toUpperCase().charAt(0);
                veiculoSelecionado.setTipo(novoTipo);
                break;
            default:
                System.out.println("Opção inválida.");
        }
        return true;
    }

    public static void buscarVeiculo(){
        scanner.nextLine();
        System.out.println("Digite o modelo do veículo que quer procurar:");
        String modelo = scanner.nextLine();

        for (Veiculo veiculo: veiculos) {
            if (veiculo.getModelo().toLowerCase().contains(modelo)){
                System.out.println(veiculo);
            }
        }
    }




    
    public static void alugarVeiculo(){

    }
    public static void devolverVeiculo(){

    }

    public static void tipoVeiculo(char tipo){}

}