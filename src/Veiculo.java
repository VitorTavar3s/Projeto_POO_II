import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Veiculo {

    String placa;
    String marca;
    String modelo;
    String tipo;
    boolean disponibilidade;
    static List<Veiculo> veiculos = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public Veiculo(String placa, String marca, String modelo, String tipo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "{Placa='" + placa + '\'' + ", Marca='" + marca + '\'' + ", Modelo='" + modelo + '\'' + ", Tipo=" + tipo + '}';
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public static boolean cadastrarVeiculo(){
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
        String tipo = scanner.next().toUpperCase();
        scanner.nextLine();

        switch (tipo){
            case "P":
                tipo = "Pequeno";
                break;
            case "M":
                tipo = "Médio";
                break;
            case "S":
                tipo = "SUV";
                break;
        }


        Veiculo veiculo = new Veiculo(placa,marca,modelo,tipo);
        veiculos.add(veiculo);
        System.out.println("Veículo cadastrado com sucesso!");
        return true;
    }

    public static boolean alterarVeiculo(){
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
                System.out.println("Digite o novo tipo (P-PEQUENO / M-MÉDIO / S-SUV): ");
                String novoTipo = scanner.next().toUpperCase();
                switch (novoTipo){
                    case "P":
                        novoTipo = "Pequeno";
                        break;
                    case "M":
                        novoTipo = "Médio";
                        break;
                    case "S":
                        novoTipo = "SUV";
                        break;
                }
                veiculoSelecionado.setTipo(novoTipo);
                break;
            default:
                System.out.println("Opção inválida.");
        }
        return true;
    }

    public static void buscarVeiculo(){
        System.out.println("Digite o modelo do veículo que quer procurar:");
        String modelo = scanner.nextLine();

        for (Veiculo veiculo: veiculos) {
            if (veiculo.getModelo().toLowerCase().contains(modelo)){
                System.out.println(veiculo);
            }
        }
    }

}
