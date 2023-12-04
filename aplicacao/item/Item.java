package aplicacao.item;

/**
 * A classe Item representa um objeto no jogo, contendo informações como descrição e tipo.
 */
public class Item {
  private String descricao;
  private String tipoItem;
  
  /**
   * Construtor da classe Item.
   *
   * @param descricao A descrição do item.
   */
  public Item(String descricao, String tipoItem){
    this.descricao = descricao;
    this.tipoItem = tipoItem;
  }

  /**
   * Obter o tipo do Item
   * 
   * @return
   */
  public String getTipo () {
    return tipoItem;
  }

  /**
   * Obter a descrição do item
   */
  @Override
  public String toString () {
    return descricao;
  }
}
