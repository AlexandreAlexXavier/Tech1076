package ProjetoIMDB;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CatalogoFilmes {
    private static Map<String, Filme> catalogo = new HashMap<>();
    private static Map<String, Ator> atores = new HashMap<>();
    private static Map<String, Diretor> diretores = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("==== Menu ====");
            System.out.println("1. Cadastrar Filme");
            System.out.println("2. Cadastrar Ator");
            System.out.println("3. Cadastrar Diretor");
            System.out.println("4. Associar Filme com Atores e Diretor");
            System.out.println("5. Pesquisar Filme por Nome");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarFilme(scanner);
                    break;
                case 2:
                    cadastrarAtor(scanner);
                    break;
                case 3:
                    cadastrarDiretor(scanner);
                    break;
                case 4:
                    associarFilmeAtoresDiretor(scanner);
                    break;
                case 5:
                    pesquisarFilmePorNome(scanner);
                    break;
                case 6:
                    System.out.println("Saindo do programa. Até mais!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void cadastrarFilme(Scanner scanner) {
        System.out.print("Nome do Filme: ");
        String nomeFilme = scanner.nextLine();
        System.out.print("Data de Lançamento: ");
        String dataLancamento = scanner.nextLine();
        System.out.print("Orçamento: ");
        double orcamento = scanner.nextDouble();
        scanner.nextLine(); // Consumir a quebra de linha após o número
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Nome do Diretor: ");
        String nomeDiretor = scanner.nextLine();
        Diretor diretor = diretores.get(nomeDiretor);
        if (diretor == null) {
            diretor = new Diretor(nomeDiretor, "");
            diretores.put(nomeDiretor, diretor);
        }

        Filme filme = new Filme(nomeFilme, dataLancamento, orcamento, descricao, diretor);
        catalogo.put(nomeFilme.toLowerCase(), filme);

        System.out.println("Filme cadastrado com sucesso!");
    }

    private static void cadastrarAtor(Scanner scanner) {
        System.out.print("Nome do Ator: ");
        String nomeAtor = scanner.nextLine();
        System.out.print("Data de Nascimento do Ator: ");
        String dataNascimentoAtor = scanner.nextLine();

        Ator ator = new Ator(nomeAtor, dataNascimentoAtor);
        atores.put(nomeAtor.toLowerCase(), ator);

        System.out.println("Ator cadastrado com sucesso!");
    }

    private static void cadastrarDiretor(Scanner scanner) {
        System.out.print("Nome do Diretor: ");
        String nomeDiretor = scanner.nextLine();
        System.out.print("Data de Nascimento do Diretor: ");
        String dataNascimentoDiretor = scanner.nextLine();

        Diretor diretor = new Diretor(nomeDiretor, dataNascimentoDiretor);
        diretores.put(nomeDiretor.toLowerCase(), diretor);

        System.out.println("Diretor cadastrado com sucesso!");
    }

    private static void associarFilmeAtoresDiretor(Scanner scanner) {
        System.out.print("Nome do Filme: ");
        String nomeFilme = scanner.nextLine();
        Filme filme = catalogo.get(nomeFilme.toLowerCase());
        if (filme == null) {
            System.out.println("Filme não encontrado.");
            return;
        }

        System.out.print("Nome do Diretor: ");
        String nomeDiretor = scanner.nextLine();
        Diretor diretor = diretores.get(nomeDiretor.toLowerCase());
        if (diretor == null) {
            diretor = new Diretor(nomeDiretor, "");
            diretores.put(nomeDiretor.toLowerCase(), diretor);
        }

        filme.diretor = diretor;

        System.out.print("Quantidade de Atores: ");
        int quantidadeAtores = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha após o número

        for (int i = 0; i < quantidadeAtores; i++) {
            System.out.print("Nome do Ator " + (i + 1) + ": ");
            String nomeAtor = scanner.nextLine();
            Ator ator = atores.get(nomeAtor.toLowerCase());
            if (ator == null) {
                ator = new Ator(nomeAtor, "");
                atores.put(nomeAtor.toLowerCase(), ator);
            }

            filme.adicionarAtor(ator);
        }

        System.out.println("Filme associado com sucesso!");
    }

    private static void pesquisarFilmePorNome(Scanner scanner) {
        System.out.print("Digite o nome do filme para pesquisa: ");
        String nomePesquisa = scanner.nextLine().toLowerCase();

        for (Map.Entry<String, Filme> entry : catalogo.entrySet()) {
            if (entry.getKey().contains(nomePesquisa)) {
                System.out.println(entry.getValue().nome);
            }
        }
    }

}
