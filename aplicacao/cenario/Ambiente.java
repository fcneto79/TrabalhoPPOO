package aplicacao.cenario;

import aplicacao.item.Item;

/**
 * A classe Ambiente representa um local dentro do cenário, contendo informações como nome, descrição, item e possíveis saídas para outros ambientes.
 */
public class Ambiente {
  private String nome;
  private String descricao;
  private Ambiente saidaNorte;
  private Ambiente saidaSul;
  private Ambiente saidaLeste;
  private Ambiente saidaOeste;
  private Item item;

 /**
   * Construtor da classe Ambiente.
   *
   * @param nome      O nome do ambiente.
   * @param descricao A descrição do ambiente.
   */
  public Ambiente (String nome, String descricao) {
    this.nome = nome;
    this.descricao = descricao;
    item = null;
  }

  /**
   * Retorna uma representação em string do ambiente, incluindo nome, descrição e as possíveis saídas
   *
   * @return Uma string representando o ambiente.
   */
  @Override
  public String toString () {
    String mensagemPrincipal = "Voce está no(a) " + nome + "\n" + descricao + "\n";
    StringBuilder saida = new StringBuilder("Saidas:\n");
    String itens = (item == null) ? "" : "Item:\n- " + item.getTipo() + "\n- " + item.toString();
    saida.append((saidaNorte == null) ? "" : "- norte\n");
    saida.append((saidaSul == null) ? "" : "- sul\n");
    saida.append((saidaLeste == null) ? "" : "- leste\n");
    saida.append((saidaOeste == null) ? "" : "- oeste\n");

    return mensagemPrincipal + saida.toString() + itens;
  }

  /**
   * Adiciona as saídas disponíveis para norte, sul, leste e oeste a partir deste ambiente.
   *
   * @param norte O ambiente ao norte.
   * @param sul   O ambiente ao sul.
   * @param leste O ambiente ao leste.
   * @param oeste O ambiente ao oeste.
   */
  public void adicionarSaidas (Ambiente norte, Ambiente sul, Ambiente leste, Ambiente oeste) {
    saidaNorte = norte;
    saidaSul = sul;
    saidaLeste = leste;
    saidaOeste = oeste;
  }

  /**
   * Obtém o nome do ambiente.
   *
   * @return O nome do ambiente.
   */
  public String getNome () {
    return nome;
  }

  /**
   * Define um item pertecente a esse ambiente
   * 
   * @param item
   */
  public void definirItem(Item item) {
    this.item = item;
  }

  /**
   * Retorna o item que o ambiente contém, ou null, caso ele não possua
   * 
   * @return
   */
  public Item getItem() {
    return item;
  }

  // Métodos de verificação se existe saída na direção digitada

  /**
   * Verifica se existe uma saída para o norte a partir deste ambiente.
   *
   * @return true se houver uma saída para o norte, false caso contrário.
   */
  public boolean verificarSaidaNorte () {
    return saidaNorte != null;
  }

  /**
   * Verifica se existe uma saída para o sul a partir deste ambiente.
   *
   * @return true se houver uma saída para o sul, false caso contrário.
   */
  public boolean verificarSaidaSul () {
    return saidaSul != null;
  }

  /**
   * Verifica se existe uma saída para o leste a partir deste ambiente.
   *
   * @return true se houver uma saída para o leste, false caso contrário.
   */
  public boolean verificarSaidaLeste () {
    return saidaLeste != null;
  }

 /**
   * Verifica se existe uma saída para o oeste a partir deste ambiente.
   *
   * @return true se houver uma saída para o oeste, false caso contrário.
   */
  public boolean verificarSaidaOeste () {
    return saidaOeste != null;
  }

  // Métodos para obter o ambiente da saida digitada

  /**
   * Obtém o ambiente ao norte a partir deste ambiente.
   *
   * @return O ambiente ao norte, ou null se não houver uma saída nessa direção.
   */
  public Ambiente getSaidaNorte () {
    return saidaNorte;
  }

  /**
   * Obtém o ambiente ao sul a partir deste ambiente.
   *
   * @return O ambiente ao sul, ou null se não houver uma saída nessa direção.
   */
  public Ambiente getSaidaSul () {
    return saidaSul;
  }

  /**
   * Obtém o ambiente ao leste a partir deste ambiente.
   *
   * @return O ambiente ao leste, ou null se não houver uma saída nessa direção.
   */
  public Ambiente getSaidaLeste () {
    return saidaLeste;
  }

  /**
   * Obtém o ambiente ao oeste a partir deste ambiente.
   *
   * @return O ambiente ao oeste, ou null se não houver uma saída nessa direção.
   */
  public Ambiente getSaidaOeste () {
    return saidaOeste;
  }
}
