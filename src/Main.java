import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Produto {
  private String nome; 
  private double preco; 
 
  public Produto(String nome, double preco) { 
      this.nome = nome; 
      this.preco = preco; 
  } 

  public String getNome() {
    return nome;
  }

  public double getpreco() {
    return preco;
  } 

  public void exibirInformacoes() {
  System.out.println("Nome: " + nome + " - " + "Preço: R$" + String.format("%.2f", preco));
}

}

public class Main {
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
            System.out.print("\n");
            int opcao = 0;
            try {
                opcao = Integer.parseInt(opcaoStr.trim());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida: digite um número entre 1 e 3.\n");
                continue;
            }

            switch (opcao) {
                case 1: 
                    if (quantidadeProdutos >= produtos.length) {
                        System.out.println("Não é possível adcionar mais produtos\n");
                        break;
                    }
                        System.out.print("Informe o nome do produto: ");
                        String nome = sc.nextLine();

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
                                                                             
                case 2: 
                    if (quantidadeProdutos == 0) {
                        System.out.println("Não há produtos a serem exibidos");
                        break;
                    }

                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                    System.out.println("=========================================");
                    System.out.println("        SUPERMERCADO ETE LTDA            ");
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
                    System.out.println("\n");
                    break;

                case 3: 
                    System.out.println("Encerrando o programa...\n");
                    sair = true; 
                    break; 
                default: 
                    System.out.println("\nOpção inválida! Tente novamente."); 
                
            } 
        }
        sc.close(); 
    }
}


