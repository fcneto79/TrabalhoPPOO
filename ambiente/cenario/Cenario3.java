package ambiente.cenario;

/**
 * - - Cenário do tipo 3 - -
 * Este cenário possui saídas em todas as direções
 * exceto na direção sul.
 */
public class Cenario3 extends Cenario {
  
  public Cenario3 (String descricao, String nome) {
    super(true,false,true,true,descricao,nome);
  }
}