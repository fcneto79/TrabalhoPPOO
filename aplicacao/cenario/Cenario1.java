package aplicacao.cenario;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import aplicacao.item.Item;

/**
 * - - Cenário do tipo 1 - -
 * Cenário específico que herda da classe abstrata Cenario e implementa um ambiente específico.
 */
public class Cenario1 extends Cenario {

  /**
   * Construtor da classe Cenario1.
   * Chama o construtor da classe pai (Cenario) para inicializar a lista de ambientes e montar o cenário.
   */
  public Cenario1 () {
    super();
  }

  @Override
  protected int criarFantasma () {
    Random random = new Random();
    int candidatosFantasma[] = {1,2,4};
    return candidatosFantasma[random.nextInt(candidatosFantasma.length)];
  }

  // Mapa do ArrayList:
  // 0 - Hall
  // 1 - Sala de Estar
  // 2 - Cozinha
  // 3 - Corredor
  // 4 - Quarto
  // 5 - Sótão
  // 6 - Saida
  @Override
  protected void definirSaidas () {
    List<Ambiente> ambientes = new ArrayList<>(getListaAmbientes());
    
    ambientes.get(0).adicionarSaidas(
      ambientes.get(4),ambientes.get(1), null, ambientes.get(3)
    );

    ambientes.get(1).adicionarSaidas(
      ambientes.get(0), null, null, null
    );

    ambientes.get(2).adicionarSaidas(
      null, ambientes.get(3), ambientes.get(4), null
    );

    ambientes.get(3).adicionarSaidas(
      ambientes.get(2), null, ambientes.get(0), ambientes.get(5)
    );

    ambientes.get(4).adicionarSaidas(
      null, ambientes.get(0), null, ambientes.get(2)
    );

    ambientes.get(5).adicionarSaidas(
      null, null, ambientes.get(3), ambientes.get(6)
    );
  }

  @Override
  protected void definirItem (int numero) {
    int opcoes[] = {1,2,4};
    int numeroItem = numero;
    ArrayList<Ambiente> ambientes = new ArrayList<>(getListaAmbientes());
    Random random = new Random();
    while (numeroItem == numero) {
      numeroItem = opcoes[random.nextInt(opcoes.length)];
    }
    ambientes.get(numeroItem).definirItem(new Item("Use esse item para se tornar imune ao Fantasma", "Invulnerabilidade"));
  }
}
