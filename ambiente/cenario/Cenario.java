package ambiente.cenario;

/**
 * Super classe responsável por moldar todas as formas que o cenário
 * do jogo pode atingir
 */
public abstract class Cenario {
  private boolean saidaNorte;
  private boolean saidaSul;
  private boolean saidaLeste;
  private boolean saidaOeste;

  private String nomeCenario;
  private String descricao;

  public Cenario (boolean norte, boolean sul, boolean leste, boolean oeste, String descricao, String nome) {
    this.saidaNorte = norte;
    this.saidaSul = sul;
    this.saidaLeste = leste;
    this.saidaOeste = oeste;
    this.descricao = descricao;
    this.nomeCenario = nome;
  }

  @Override
  public String toString () {
    return String.format(
      "Você está na %s\n%s\n%s",nomeCenario,descricao, getSaidas()
    );
  }

  /**
   * Método responsável por gerar uma String informando quais são as 
   * saidas do ambiente atual
   * 
   * @return String contendo todas as saídas que o cenário possui
   */
  public String getSaidas () {
    StringBuilder saidas = new StringBuilder("Saidas:\n");

    saidas.append(saidaNorte ? "Norte\n" : "");
    saidas.append(saidaSul ? "Sul\n" : "");
    saidas.append(saidaLeste ? "Leste\n" : "");
    saidas.append(saidaOeste ? "Oeste\n" : "");

    return saidas.toString();
  }
}