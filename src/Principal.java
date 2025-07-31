import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Loja loja = null;
        Produto produto = null;

        while (true) {
            System.out.println("\nMENU:");
            System.out.println("(1) Criar uma loja");
            System.out.println("(2) Criar um produto");
            System.out.println("(3) Sair");
            System.out.println("Escolha uma opção");
            int opcao = teclado.nextInt();

            if (opcao == 1) {
                teclado.nextLine();
                System.out.println("Nome da loja: ");
                String nomeLoja = teclado.nextLine();

                System.out.println("Quantidade de funcionarios: ");
                int qtdFunc = teclado.nextInt();

                System.out.println("Salário base dos funcionários: ");
                double salarioBase = teclado.nextDouble();

                teclado.nextLine();
                System.out.println("Rua: ");
                String rua = teclado.nextLine();
                System.out.println("Cidade: ");
                String cidade = teclado.nextLine();
                System.out.println("Estado: ");
                String estado = teclado.nextLine();
                System.out.println("Pais: ");
                String pais = teclado.nextLine();
                System.out.println("CEP: ");
                String cep = teclado.nextLine();
                System.out.println("Número: ");
                String numero = teclado.nextLine();
                System.out.println("Complemento: ");
                String complemento = teclado.nextLine();

                System.out.println("Dia da fundação: ");
                int dia = teclado.nextInt();
                System.out.println("Mês da fundação: ");
                int mes = teclado.nextInt();
                System.out.println("Ano da fundação: ");
                int ano = teclado.nextInt();

                System.out.println("Tamanho do estoque de produtos: ");
                int tamanhoEstoque = teclado.nextInt();

                Endereco endereco = new Endereco(rua, cidade, estado, pais, cep, numero, complemento);
                Data dataFundacao = new Data(dia, mes, ano);
                loja = new Loja(nomeLoja, qtdFunc, salarioBase, endereco, dataFundacao, tamanhoEstoque);

                System.out.println("Loja criada com sucesso!");

            } else if (opcao == 2) {
                if (loja == null) {
                    System.out.println("Você precisa criar uma loja primeiro!");
                    continue;
                }

                teclado.nextLine();
                System.out.println("Nome do produto: ");
                String nomeProd = teclado.nextLine();
                System.out.println("Preço do produto: ");
                double preco = teclado.nextDouble();
                System.out.println("Dia da validade: ");
                int dia = teclado.nextInt();
                System.out.println("Mês da validade: ");
                int mes = teclado.nextInt();
                System.out.println("Ano da validade: ");
                int ano = teclado.nextInt();

                Data validade = new Data(dia, mes, ano);
                produto = new Produto(nomeProd, preco, validade);

                System.out.println("Produto criado com sucesso!");

                loja.insereProduto(produto);

            } else if (opcao == 3) {
                System.out.println("Encerrando o programa...");
                break;

            } else {
                System.out.println("Opção inválida!");
            }

            if (loja != null && produto != null) {
                System.out.println("\n--- Resultado Final ---");
                Data dataRef = new Data(20,10,2023);
                if (produto.estaVencido(dataRef)) {
                    System.out.println("PRODUTO VENCIDO");
                }else {
                    System.out.println("PRODUTO NÃO VENCIDO");
                }

                System.out.println("\nInformações da loja:");
                System.out.println(loja);
                break; //Encerra após criar dois objetos
            }
        }

        teclado.close();
    }
}