import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in); 
        Produto[] produtos = new Produto[100]; 
        int quantidadeProdutos = 0; 
        boolean sair = false; 
 
        while (!sair) { 
            System.out.println("=========================================");
            System.out.println("           PAINEL DE PRODUTOS            ");
            System.out.println("=========================================");
            System.out.println("Quantidade de produtos: " + quantidadeProdutos);
            System.out.println("1) Adicionar produto");
            System.out.println("2) Exibir (Imprimir Nota Fiscal)");
            System.out.println("3) Sair");
            System.out.print("Escolha uma opção (1-3): ");
            String opcaoStr = sc.nextLine();
            int opcao = 0;
            try {
                opcao = Integer.parseInt(opcaoStr.trim());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida: digite um número entre 1 e 3.\n");
                continue;
            }

            switch (opcao) { 
                case 1: 
                    /* Escreva aqui o código para testar se a quantidade de produtos adicionadas é 
                    maior que a capacidade do array de 100 posições */ 
                    if (quantidadeProdutos <= 100) {
                         // Escreva aqui o código de entrada para o nome do produto 
                        System.out.print("Informe o nome do produto: ");
                        String nome = sc.nextLine();

                        // Escreva aqui o código de entrada para o preço do produto
                        System.out.print("Informe o preço do produto (use ponto): ");
                        try {
                            String precoStr = sc.nextLine();
                            double preco = Double.parseDouble(precoStr);

                            Produto produto = new Produto(nome, preco); 
                            produtos[quantidadeProdutos] = produto; 
                            quantidadeProdutos++; 
     
                            System.out.println("\nProduto adicionado com sucesso!\n");
                        } catch (NumberFormatException e) {
                            System.out.println("Erro: Digite um número válido para o preço!");
                        }
                        break; 

                    } else {
                        System.out.println("Não é possível adcionar mais produtos\n");
                        break;
                    }
                                                                             
                case 2: 
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                    System.out.println("=========================================");
                    System.out.println("           MERCADO ETE LTDA           ");
                    System.out.println("       CNPJ: 00.000.000/0000-00          ");
                    System.out.println("-----------------------------------------");
                    System.out.println("Data: " + LocalDateTime.now().format(dtf));
                    System.out.println("-----------------------------------------");
                    System.out.printf("%-4s %-25s %10s\n", "ITEM", "DESCRICAO", "VALOR");
                    System.out.println("-----------------------------------------");
                    double total = 0.0;
                    for (int i = 0; i < quantidadeProdutos; i++) {
                        Produto p = produtos[i];
                        if (p != null) {
                            System.out.printf("%-4d %-25s R$%7.2f\n", i + 1, p.getNome(), p.getpreco());
                            total += p.getpreco();
                        }
                    }
                    System.out.println("-----------------------------------------");
                    System.out.printf("%-30s R$%7.2f\n", "TOTAL", total);
                    System.out.println("=========================================");
                    System.out.println("Obrigado pela preferencia!");
                    break;

                case 3: 
                    System.out.println("Saindo...");
                    sair = true; 
                    break; 
                default: 
                    System.out.println("\nOpção inválida! Tente novamente."); 
                
            } 
        }
        sc.close(); 
    }
}
