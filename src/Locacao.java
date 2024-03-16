import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Locacao {
    private String local;
    private LocalDateTime data;
    private LocalDateTime horarario;

    private static List<Veiculo> veiculosAlugados;

    public Locacao(String local, LocalDateTime data, LocalDateTime horarario) {
        this.local = local;
        this.data = data;
        this.horarario = horarario;
        veiculosAlugados = new ArrayList<>();
    }

    public static void alugarVeiculo(String documentoCliente){
        boolean clienteEncontrado = false;

        for(PessoaFisica pessoaF : Cliente.pessoasFisicas) {
            if (pessoaF.getCpf().equals(documentoCliente)) {
                clienteEncontrado = true;
                for (Veiculo veiculo : Veiculo.veiculos) {
                    if (veiculo.isDisponibilidade()) {
                        veiculo.setDisponibilidade(false);
                        veiculosAlugados.add(veiculo);
                        System.out.println("Veículo alugado para " + pessoaF.getNome() + " com CPF: " + pessoaF.getCpf());
                        break;
                    }
                }

                if (!clienteEncontrado) {
                    for (PessoaJuridica pessoaJ : Cliente.pessoasJuridicas) {
                        if (pessoaJ.getCnpj().equals(documentoCliente)) {
                            clienteEncontrado = true;
                            for (Veiculo veiculo : Veiculo.veiculos) {
                                if (veiculo.isDisponibilidade()) {
                                    veiculo.setDisponibilidade(false);
                                    veiculosAlugados.add(veiculo);
                                    System.out.println("Veículo alugado para pessoa jurídica com CNPJ: " + pessoaJ.getCnpj());
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
                if (!clienteEncontrado) {
                    System.out.println("Cliente não encontrado.");
                }
            }
        }
    }
    public static void devolverVeiculo(String documentoCliente) {
        boolean clienteEncontrado = false;

        for (PessoaFisica pessoa : Cliente.pessoasFisicas) {
            if (pessoa.getCpf().equals(documentoCliente)) {
                clienteEncontrado = true;
                for (Veiculo veiculo : veiculosAlugados) {
                    if (veiculo.isDisponibilidade()) {
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
        }

        if (!clienteEncontrado) {
            System.out.println("Cliente não encontrado.");
        }
    }
}
