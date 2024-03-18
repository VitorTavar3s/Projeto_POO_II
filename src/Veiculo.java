import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Veiculo {

    String placa;
    String marca;
    String modelo;
    String tipo;

    private Locacao locacao;
    Double valorLocacao;
    boolean disponibilidade  = true;
    static List<Veiculo> veiculos = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public Veiculo(String placa,
                   String marca,
                   String modelo,
                   String tipo,
                   Double valorLocacao,
                   boolean disponibilidade) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.valorLocacao = valorLocacao;
        this.disponibilidade = true;
    }

    @Override
    public String toString() {
        return "{Placa='" + placa + '\'' + ", Marca='" + marca + '\'' + ", Modelo='" + modelo + '\'' +
                ", Tipo=" + tipo + ", Valor Diaria=" + valorLocacao + '}';
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

    public Locacao getLocacao() {
        return locacao;
    }

    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
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
                System.out.println("Veículo da placa: " + placa + " já cadastrada, cadastre outro veículo.\n");
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

        Double valorLocacao = 0D;

        switch (tipo){
            case "P":
                tipo = "Pequeno";
                valorLocacao = 100D;
                break;
            case "M":
                tipo = "Médio";
                valorLocacao = 150D;
                break;
            case "S":
                tipo = "SUV";
                valorLocacao = 200D;
                break;
        }


        Veiculo veiculo = new Veiculo(placa,marca,modelo,tipo,valorLocacao,true);
        veiculos.add(veiculo);
        System.out.println("Veículo cadastrado com sucesso!");
        return true;
    }

    public static boolean alterarVeiculo(){
        if (veiculos.isEmpty()){
            System.out.println("Nenhum veículo cadastrado! Primeiro cadastre um veículo para poder fazer alteração!");
        }else {

            System.out.println("Veículos:");
            for (Veiculo veiculo : veiculos) {
                System.out.println(veiculo);
            }
            System.out.println("Digite a placa do veículo que deseja alterar:");
            String placa = scanner.nextLine().toUpperCase();
            Veiculo veiculoSelecionado = null;
            for (Veiculo veiculo : veiculos) {
                if (placa.equals(veiculo.getPlaca())) {
                    veiculoSelecionado = veiculo;
                    break;
                }
            }
            if (veiculoSelecionado == null) {
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
                    for (Veiculo veiculo : veiculos) {
                        if (veiculo.getPlaca().equals(novaPlaca)) {
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
                    switch (novoTipo) {
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
        }
            return true;
    }

    public static void buscarVeiculo(){
        if (veiculos.isEmpty()){
            System.out.println("Nenhum veículo cadastrado! Primeiro cadastre um veículo para poder executar buscas!");
        }else {
            System.out.println("Digite o modelo do veículo que quer procurar:");
            String modelo = scanner.nextLine();

            boolean encontrado = false;

            for (Veiculo veiculo : veiculos) {
                if (veiculo.getModelo().toLowerCase().contains(modelo.toLowerCase())) {
                    System.out.println(veiculo);
                    encontrado = true;
                }
            }

            if (!encontrado) {
                System.out.println("Desculpe, não temos o veículo do modelo " + modelo + "!");
            }
        }
    }

}
