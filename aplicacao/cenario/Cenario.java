package aplicacao.cenario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A classe abstrata Cenario representa um cenário do jogo,
 * contendo uma lista de ambientes, o ambiente atual e o ambiente do fantasma.
 */
public abstract class Cenario {
  private ArrayList<Ambiente> listaAmbientes;
  private Ambiente ambienteAtual;
  private Ambiente ambienteDoFantasma;

  /**
   * Construtor da classe Cenario.
   * Inicializa a lista de ambientes e chama o método para montar o cenário.
   */
  public Cenario () {
    listaAmbientes = new ArrayList<>();
    montarCenario();
  }

  /**
   * Retorna uma lista imútavel contendo os Ambientes desse cenário
   * @return
   */
  public List<Ambiente> getListaAmbientes () {
    return Collections.unmodifiableList(listaAmbientes);
  }

  /**
   * Obtém o ambiente atual do cenário.
   *
   * @return O ambiente atual.
   */
  public Ambiente obterAmbienteAtual () {
    return ambienteAtual;
  }

  /**
   * Obtém o ambiente do fantasma
   * 
   * @return
   */
  public Ambiente obterAmbienteDoFantasma () {
    return ambienteDoFantasma;
  }

  /**
   * Método responsável por montar os cenários do jogo, que serão
   * de 3 maneiras diferentes.
   * Cada subclasse será responável por montar as saídas do seu jeito
   */
  private void montarCenario() {
    criarAmbientes();
    definirSaidas();  

    int numeroAmbienteFantasma = criarFantasma();
    definirAmbienteAtual();
    definirAmbienteDoFantasma(listaAmbientes.get(numeroAmbienteFantasma));
    definirItem(numeroAmbienteFantasma);
  }

  /**
   * Neste método, será criado todos os 6 ambientes do jogo, que serão iguais em todas as intâncias
   */
  private void criarAmbientes () {
    listaAmbientes.add(new Ambiente ("Hall", 
      "Um hall escuro e empoeirado com um grande lustre pendurado no teto." +
      " Retratos antigos adornam as paredes, os olhos parecem seguir quem passa por ali."
    ));

    listaAmbientes.add(new Ambiente ("Sala de Estar", 
      "Móveis velhos e cobertos por lençóis brancos." + 
      " Uma lareira crepitante no canto ilumina a sala, enquanto sombras dançam nas paredes."
    ));

    listaAmbientes.add(new Ambiente ("Cozinha", 
      "Utensílios enferrujados e panelas cobertas de teias de aranha." +
      " A geladeira range e balança sozinha, como se alguém estivesse tentando sair de dentro."
    ));

    listaAmbientes.add(new Ambiente ("Corredor Misterioso", 
      "Um corredor estreito com retratos desbotados de pessoas desconhecidas." +
      " Ruídos estranhos ecoam à distância, deixando o ar arrepiante."
    ));

    listaAmbientes.add(new Ambiente ("Quarto", 
      "Uma cama com lençóis desarrumados no centro do quarto." +
      " Um espelho antigo reflete imagens distorcidas e sombras que se movem sem explicação."
    ));

    listaAmbientes.add(new Ambiente ("Sotao", 
      "Escadas empoeiradas levam a um sótão escuro e repleto de caixas velhas." +
      " Ruídos estranhos vêm de cantos escuros e objetos se movem sozinhos."
    ));
    
    listaAmbientes.add(new Ambiente("Saida", ""));
  }

  /**
   * Define o ambiente inicial do cenário.
   *
   * @param ambiente
   */
  private void definirAmbienteAtual () {
    ambienteAtual = listaAmbientes.get(0);
  }

  /**
   * Define o ambiente a qual o fantasma está
   * 
   * @param ambiente
   */
  protected void definirAmbienteDoFantasma (Ambiente ambiente) {
    ambienteDoFantasma = ambiente;
  }

  /**
   * Troca o ambiente atual para o ambiente na direção especificada.
   *
   * @param direcao A direção para onde deseja trocar o ambiente ("norte", "sul", "leste" ou "oeste").
   * @return true se a troca foi bem-sucedida, false caso contrário.
   */
  public boolean trocarAmbiente (String direcao) {
    if (direcao.equals("norte") && ambienteAtual.verificarSaidaNorte()) {
      ambienteAtual = ambienteAtual.getSaidaNorte();
    }
    else if (direcao.equals("sul") && ambienteAtual.verificarSaidaSul()) {
      ambienteAtual = ambienteAtual.getSaidaSul();
    }
    else if (direcao.equals("leste") && ambienteAtual.verificarSaidaLeste()) {
      ambienteAtual = ambienteAtual.getSaidaLeste();
    }
    else if (direcao.equals("oeste") && ambienteAtual.verificarSaidaOeste()) {
      ambienteAtual = ambienteAtual.getSaidaOeste();
    }
    else {
      return false;
    }
    return true;
  }

  // Objetivo dos métodos serem protected:
  // Somente as classes do pacote cenario ter acesso
  // Como os ambientes são diferentes em cada cenário,
  // será necessário um método com permissão de acesso
  // a lista de Ambientes, mas agora restrito ao pacote.

  /**
   * Montando as saídas de cada ambiente, cada subclasse implementará de
   * maneira diferente
   * 
   */
  protected abstract void definirSaidas ();

  /**
   * Sorteando o número de um ambiente para o Fantasma
   * 
   * @return número do indíce do Ambiente
   */
  protected abstract int criarFantasma ();

  /**
   * Definindo em qual ambiente terá item
   * 
   * @param numero número do ambiente que o Fantasma está, para não repetir
   */
  protected abstract void definirItem (int numero);
}
