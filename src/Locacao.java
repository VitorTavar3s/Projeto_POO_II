import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Locacao {
    private String localLocacao;
    private LocalDate dataLocacao;
    private LocalTime horarioLocacao;
    private String localDevolucao;
    private LocalDateTime dataDevolucao;
    private LocalDateTime horarioDevolucao;

    private static List<Veiculo> veiculosAlugados = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public Locacao(String localLocacao,
                   LocalDate dataLocacao,
                   LocalTime horarioLocacao,
                   String localDevolucao,
                   LocalDateTime dataDevolucao,
                   LocalDateTime horarioDevolucao) {
        this.localLocacao = localLocacao;
        this.dataLocacao = dataLocacao;
        this.horarioLocacao = horarioLocacao;
        this.localDevolucao = localDevolucao;
        this.dataDevolucao = dataDevolucao;
        this.horarioDevolucao = horarioDevolucao;
    }

    public static boolean alugarVeiculo(String documentoCliente) {
        System.out.println("Digite o local onde o veículo será alugado:");
        String localLocacao = scanner.nextLine();

        for (Veiculo veiculo : Veiculo.veiculos) {
            System.out.println("Veículo: " + veiculo);
        }
        System.out.println("Digite a placa do veículo que deseja alugar:");
        String placaVeiculo = scanner.nextLine().toUpperCase();

        LocalDate dataLocacao = LocalDate.now();
        LocalTime horarioLocacao = LocalTime.now();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = dateFormatter.format(dataLocacao);

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        String horarioFormatado = timeFormatter.format(horarioLocacao);

        Locacao locacao = new Locacao(localLocacao, dataLocacao, horarioLocacao, null,
                null, null);

        boolean veiculoEncontrado = false;
        for (PessoaFisica pessoaF : Cliente.pessoasFisicas) {
            if (pessoaF.getCpf().equals(documentoCliente)) {
                veiculoEncontrado = alugarVeiculoParaPF(pessoaF, placaVeiculo, locacao,
                        dataFormatada, horarioFormatado);
                break;
            }
        }

        if (!veiculoEncontrado) {
            for (PessoaJuridica pessoaJ : Cliente.pessoasJuridicas) {
                if (pessoaJ.getCnpj().equals(documentoCliente)) {
                    veiculoEncontrado = alugarVeiculoParaPJ(pessoaJ, placaVeiculo, locacao,
                            dataFormatada, horarioFormatado);
                    break;
                }
            }
        }

        if (!veiculoEncontrado) {
            System.out.println("Não foi possível alugar o veículo.");
        }

        return veiculoEncontrado;
    }

    private static boolean alugarVeiculoParaPF(PessoaFisica pessoaF, String placaVeiculo, Locacao locacao,
                                               String dataFormatada, String horarioFormatado) {
        for (Veiculo veiculo : Veiculo.veiculos) {
            if (veiculo.getPlaca().equals(placaVeiculo) && veiculo.isDisponibilidade()) {
                veiculo.setDisponibilidade(false);
                Locacao.veiculosAlugados.add(veiculo);
                System.out.println(String.format("Veículo %s alugado para %s com CPF %s, no dia %s às %s. Local: %s",
                        veiculo.getModelo(), pessoaF.getNome(), pessoaF.getCpf(), dataFormatada,
                        horarioFormatado, locacao.localLocacao));
                return true;
            }
        }
        return false;
    }

    private static boolean alugarVeiculoParaPJ(PessoaJuridica pessoaJ, String placaVeiculo, Locacao locacao,
                                               String dataFormatada, String horarioFormatado) {
        for (Veiculo veiculo : Veiculo.veiculos) {
            if (veiculo.getPlaca().equals(placaVeiculo) && veiculo.isDisponibilidade()) {
                veiculo.setDisponibilidade(false);
                Locacao.veiculosAlugados.add(veiculo);
                System.out.println(String.format("Veículo %s alugado para %s com CNPJ %s, no dia %s às %s. Local: %s",
                        veiculo.getModelo(), pessoaJ.getRazaoSocial(), pessoaJ.getCnpj(), dataFormatada,
                        horarioFormatado, locacao.localLocacao));
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
