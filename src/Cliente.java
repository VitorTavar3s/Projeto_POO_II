import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    static ArrayList<PessoaFisica> pessoasFisicas = new ArrayList<>();
    static ArrayList<PessoaJuridica> pessoasJuridicas = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void cadastrarCliente() {
        System.out.println("Digite o tipo de cliente a ser cadastrado (F - Pessoa Física / J - Pessoa Jurídica):");
        char tipoCliente = scanner.next().toUpperCase().charAt(0);

        scanner.nextLine();

        if (tipoCliente == 'F') {
            System.out.println("Digite o nome da pessoa física:");
            String nome = scanner.nextLine();
            System.out.println("Digite o CPF da pessoa física:");
            String cpf = scanner.nextLine();

            for (PessoaFisica pessoa : pessoasFisicas) {
                if (pessoa.getCpf().equals(cpf)) {
                    System.out.println("CPF já cadastrado. Não é possível cadastrar novamente.");
                    return;
                }
            }

            PessoaFisica pessoaFisica = new PessoaFisica(nome, cpf);
            pessoasFisicas.add(pessoaFisica);
            System.out.println("Cliente pessoa física cadastrado com sucesso!");
        } else if (tipoCliente == 'J') {
            System.out.println("Digite a razão social da pessoa jurídica:");
            String razaoSocial = scanner.nextLine();
            System.out.println("Digite o CNPJ da pessoa jurídica:");
            String cnpj = scanner.nextLine();

            for (PessoaJuridica pessoa : pessoasJuridicas) {
                if (pessoa.getCnpj().equals(cnpj)) {
                    System.out.println("CNPJ já cadastrado. Não é possível cadastrar novamente.");
                    return;
                }
            }

            PessoaJuridica pessoaJuridica = new PessoaJuridica(razaoSocial, cnpj);
            pessoasJuridicas.add(pessoaJuridica);
            System.out.println("Cliente pessoa jurídica cadastrado com sucesso!");
        } else {
            System.out.println("Opção inválida!");
        }
    }

    public static void alterarCliente() {
        System.out.println("Digite o tipo de cliente a ser alterado (F - Pessoa Física / J - Pessoa Jurídica):");
        char tipoCliente = scanner.next().toUpperCase().charAt(0);
        scanner.nextLine();

        if (tipoCliente == 'F') {
            System.out.println("Lista de clientes pessoa física cadastrados:");
            for (PessoaFisica pessoa : pessoasFisicas) {
                System.out.println("CPF: " + pessoa.getCpf() + " | Nome: " + pessoa.getNome());
            }

            System.out.println("Digite o CPF da pessoa física que deseja alterar:");
            String cpf = scanner.nextLine();

            for (PessoaFisica pessoa : pessoasFisicas) {
                if (pessoa.getCpf().equals(cpf)) {
                    System.out.println("O que deseja alterar no cliente? Escolha a opção:");
                    System.out.println("1 - Nome");
                    System.out.println("2 - CPF");

                    int opcao = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcao) {
                        case 1:
                            System.out.println("Digite o novo nome:");
                            String novoNome = scanner.nextLine();
                            pessoa.setNome(novoNome);
                            System.out.println("Nome alterado com sucesso!");
                            return;
                        case 2:
                            System.out.println("Digite o novo CPF:");
                            String novoCpf = scanner.nextLine();

                            for (PessoaFisica p : pessoasFisicas) {
                                if (p.getCpf().equals(novoCpf)) {
                                    System.out.println("CPF já cadastrado. Não é possível alterar.");
                                    return;
                                }
                            }

                            pessoa.setCpf(novoCpf);
                            System.out.println("CPF alterado com sucesso!");
                            return;
                        default:
                            System.out.println("Opção inválida.");
                            return;
                    }
                }
            }
            System.out.println("CPF não encontrado.");
        } else if (tipoCliente == 'J') {
            System.out.println("Lista de clientes pessoa jurídica cadastrados:");
            for (PessoaJuridica pessoa : pessoasJuridicas) {
                System.out.println("CNPJ: " + pessoa.getCnpj() + " | Razão Social: " + pessoa.getRazaoSocial());
            }

            System.out.println("Digite o CNPJ da pessoa jurídica que deseja alterar:");
            String cnpj = scanner.nextLine();

            for (PessoaJuridica pessoa : pessoasJuridicas) {
                if (pessoa.getCnpj().equals(cnpj)) {
                    System.out.println("O que deseja alterar no cliente? Escolha a opção:");
                    System.out.println("1 - Razão Social");
                    System.out.println("2 - CNPJ");

                    int opcao = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcao) {
                        case 1:
                            System.out.println("Digite a nova razão social:");
                            String novaRazaoSocial = scanner.nextLine();
                            pessoa.setRazaoSocial(novaRazaoSocial);
                            System.out.println("Razão social alterada com sucesso!");
                            return;
                        case 2:
                            System.out.println("Digite o novo CNPJ:");
                            String novoCnpj = scanner.nextLine();

                            for (PessoaJuridica p : pessoasJuridicas) {
                                if (p.getCnpj().equals(novoCnpj)) {
                                    System.out.println("CNPJ já cadastrado. Não é possível alterar.");
                                    return;
                                }
                            }

                            pessoa.setCnpj(novoCnpj);
                            System.out.println("CNPJ alterado com sucesso!");
                            return;
                        default:
                            System.out.println("Opção inválida.");
                            return;
                    }
                }
            }
            System.out.println("CNPJ não encontrado.");
        } else {
            System.out.println("Opção inválida!");
        }
    }
}
