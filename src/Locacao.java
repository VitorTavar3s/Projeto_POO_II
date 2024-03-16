import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Locacao {
    private String local;
    private LocalDateTime data;
    private LocalDateTime horario;

    private static List<Veiculo> veiculosAlugados = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public Locacao(String local, LocalDateTime data, LocalDateTime horario) {
        this.local = local;
        this.data = data;
        this.horario = horario;
        veiculosAlugados = new ArrayList<>();
    }

    public static void alugarVeiculo(String documentoCliente) {
        boolean clienteEncontrado = false;
        boolean veiculoEncontrado = false;
        Scanner scanner = new Scanner(System.in);



        for (PessoaFisica pessoaF : Cliente.pessoasFisicas) {
            if (pessoaF.getCpf().equals(documentoCliente)) {
                clienteEncontrado = true;
                System.out.println("Digite a placa do veículo que deseja alugar:");
                String placaVeiculo = scanner.nextLine().toUpperCase();
                veiculoEncontrado = alugarVeiculoParaPF(pessoaF, placaVeiculo);
                break;
            }
        }

        if (!clienteEncontrado) {
            for (PessoaJuridica pessoaJ : Cliente.pessoasJuridicas) {
                if (pessoaJ.getCnpj().equals(documentoCliente)) {
                    clienteEncontrado = true;
                    System.out.println("Digite a placa do veículo que deseja alugar:");
                    String placaVeiculo = scanner.nextLine().toUpperCase();
                    veiculoEncontrado = alugarVeiculoParaPJ(pessoaJ, placaVeiculo);
                    break;
                }
            }
        }

        if (!clienteEncontrado) {
            System.out.println("Cliente não encontrado.");
        } else if (!veiculoEncontrado) {
            System.out.println("Veículo não disponível ou não encontrado.");
        }
    }

    private static boolean alugarVeiculoParaPF(PessoaFisica pessoaF, String placaVeiculo) {
        for (Veiculo veiculo : Veiculo.veiculos) {
            if (veiculo.getPlaca().equals(placaVeiculo) && veiculo.isDisponibilidade()) {
                veiculo.setDisponibilidade(false);
                veiculosAlugados.add(veiculo);
                System.out.println("Veículo " + veiculo.getModelo() + " alugado para " + pessoaF.getNome() + " com CPF: " + pessoaF.getCpf());
                return true;
            }
        }
        return false;
    }

    private static boolean alugarVeiculoParaPJ(PessoaJuridica pessoaJ, String placaVeiculo) {
        for (Veiculo veiculo : Veiculo.veiculos) {
            if (veiculo.getPlaca().equals(placaVeiculo) && veiculo.isDisponibilidade()) {
                veiculo.setDisponibilidade(false);
                veiculosAlugados.add(veiculo);
                System.out.println("Veículo " + veiculo.getModelo() + " alugado para " + pessoaJ.getRazaoSocial() + " com CNPJ: " + pessoaJ.getCnpj());
                return true;
            }
        }
        return false;
    }
    public static void devolverVeiculo(String documentoCliente) {

        boolean clienteEncontrado = false;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a placa do veículo que deseja devolver:");
        String placaVeiculo = scanner.nextLine().toUpperCase();

        boolean veiculoEncontrado = false;


        for (PessoaFisica pessoa : Cliente.pessoasFisicas) {
            if (pessoa.getCpf().equals(documentoCliente)) {
                clienteEncontrado = true;
                for (Veiculo veiculo : veiculosAlugados) {
                    if (veiculo.getPlaca().equals(placaVeiculo)) {
                        veiculoEncontrado = true;
                        veiculo.setDisponibilidade(true);
                        veiculosAlugados.remove(veiculo);
                        System.out.println("Veículo devolvido por pessoa física com CPF: " + pessoa.getCpf());
                        break;
                    }
                }
                break;
            }
        }

        if (!clienteEncontrado) {
            for (PessoaJuridica pessoa : Cliente.pessoasJuridicas) {
                if (pessoa.getCnpj().equals(documentoCliente)) {
                    clienteEncontrado = true;
                    for (Veiculo veiculo : veiculosAlugados) {
                        if (veiculo.isDisponibilidade()) {
                            veiculo.setDisponibilidade(true);
                            veiculosAlugados.remove(veiculo);
                            System.out.println("Veículo devolvido por pessoa jurídica com CNPJ: " + pessoa.getCnpj());
                            // Calcular desconto pode ser aqui
                            break;
                        }
                    }
                    break;
                }
            }

            if (!clienteEncontrado) {
                System.out.println("Cliente não encontrado.");
            }
        }
    }
}
