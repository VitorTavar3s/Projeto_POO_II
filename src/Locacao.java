import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Locacao {
    private String local;
    private LocalDateTime data;
    private LocalDateTime horarario;

    private List<Veiculo> veiculosAlugados;

    public Locacao(String local, LocalDateTime data, LocalDateTime horarario) {
        this.local = local;
        this.data = data;
        this.horarario = horarario;
        this.veiculosAlugados = new ArrayList<>();
    }

    public static void alugarVeiculo(String documentoCliente){
        boolean clienteEncontrado = false;

        for(PessoaFisica pessoaF : Cliente.pessoasFisicas){
            if(pessoaF.getCpf().equals(documentoCliente)){
                clienteEncontrado = true;
                //Implementar
                System.out.println("Veículo alugado para " +pessoaF.getNome()+ "  com CPF: " + pessoaF.getCpf());
                break;
            }

            if(!clienteEncontrado){
                for (PessoaJuridica pessoaJ : Cliente.pessoasJuridicas){
                    if(pessoaJ.getCnpj().equals(documentoCliente)){
                        // Implementar
                        clienteEncontrado = true;
                        System.out.println("Veículo alugado para pessoa jurídica com CNPJ: " + pessoaJ.getCnpj());
                        break;
                    }
                }
            }

            if (!clienteEncontrado) {
                System.out.println("Cliente não encontrado.");
            }
        }

    }
    public static void devolverVeiculo(String documentoCliente, List<PessoaFisica> pessoasFisicas, List<PessoaJuridica> pessoasJuridicas, List<Veiculo> veiculos) {
        boolean clienteEncontrado = false;

        for (PessoaFisica pessoa : pessoasFisicas) {
            if (pessoa.getCpf().equals(documentoCliente)) {
                clienteEncontrado = true;
                // Implentar
                System.out.println("Veículo devolvido por pessoa física com CPF: " + pessoa.getCpf());
                // Calcular desconto
                break;
            }
        }

        if (!clienteEncontrado) {
            for (PessoaJuridica pessoa : pessoasJuridicas) {
                if (pessoa.getCnpj().equals(documentoCliente)) {
                    clienteEncontrado = true;
                    // Implentar
                    System.out.println("Veículo devolvido por pessoa jurídica com CNPJ: " + pessoa.getCnpj());
                    // Calcular desconto
                    break;
                }
            }
        }

        if (!clienteEncontrado) {
            System.out.println("Cliente não encontrado.");
        }
    }
}
