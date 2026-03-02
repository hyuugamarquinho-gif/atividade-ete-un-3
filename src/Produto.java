public class Produto {
  private String nome; 
  private double preco; 
 
  public Produto(String nome, double preco) { 
      this.nome = nome; 
      this.preco = preco; 
  } 
 
  // Escreva aqui o código para o método getNome() { 
  public String getNome(){
    return nome;
  }

  // Escreva aqui o código para o método getPreco() {
  public double getpreco(){
    return preco;
  } 

  // Escreva aqui o código para o método exibirInformacoes() {
  public void exibirInformacoes(){
  System.out.println("Nome: " + nome + " - " + "Preço: R$" + String.format("%.2f", preco));
}

}
