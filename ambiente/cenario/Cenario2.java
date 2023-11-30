package ambiente.cenario;

/**
 * - - Cenário do tipo 2 - -
 * Este cenário possui saídas em todas as direções
 * exceto na direção norte.
 */
public class Cenario2 extends Cenario {
  
  public Cenario2 (String descricao, String nome) {
    super(false,true,true,true,descricao,nome);
  }
}
