package aplicacao.jogo;

import aplicacao.cenario.*;
import aplicacao.item.Item;
import comandos.Comando;
import aplicacao.arquivo.Arquivo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import java.time.LocalDateTime;

/**
 * A classe Jogo representa a lógica principal do jogo, incluindo a criação do cenário, interações do jogador e processamento de comandos.
 */
public class Jogo {
  private static Scanner console = new Scanner(System.in);
  private static Jogo instanciaJogo;
  private Cenario cenarioJogo;
  private ArrayList<Item> meusItens;

  private ArrayList<String> comandosUtilizados;
  private ArrayList<String> cenariosPassados;

  /**
   * Construtor privado da classe Jogo.
   * Inicializa o jogo criando o cenário e iniciando o loop principal.
   */
  private Jogo () {
    meusItens = new ArrayList<>();
    comandosUtilizados = new ArrayList<>();
    cenariosPassados = new ArrayList<>();
    criarCenario();
    jogar();
  }

  /**
   * Método responsável por gravar logs no arquivo texto
   * 
   */
  private void escreverArquivo () {
    Arquivo.escreverNoArquivo("Relatório da execução: " + LocalDateTime.now() + "\n");
    Arquivo.escreverNoArquivo("Lista de comandos utilizados:\n");
    for (String it : comandosUtilizados) {
      Arquivo.escreverNoArquivo("- " + it + "\n");
    }
    Arquivo.escreverNoArquivo("Lista de cenários passados:\n");
    for (String it : cenariosPassados) {
      Arquivo.escreverNoArquivo("- " + it + "\n");
    }
  }

  /**
   * Método estático para criar uma instância única do jogo (Singleton).
   *
   * @return A instância única do jogo.
   */
  public static Jogo criarJogo () {
    if (instanciaJogo == null) {
      instanciaJogo = new Jogo();
    }
    return instanciaJogo;
  }

  /**
   * Cria o cenário do jogo.
   */
  public void criarCenario () {
    Random random = new Random();
    int numeroCenario = random.nextInt(1,4);
    if (numeroCenario == 1) {
      cenarioJogo = new Cenario1();
    }
    else if (numeroCenario == 2) {
      cenarioJogo = new Cenario2();
    }
    else if (numeroCenario == 3) {
      cenarioJogo = new Cenario3();
    }
    else {
      System.out.println("numero inválido");
    }
  }

  /**
   * Inicia o loop principal do jogo.
   */
  public void jogar () {
    boolean jogando = true;
    imprimirBoasVindas();
    
    while (jogando) {
      cenariosPassados.add(cenarioJogo.obterAmbienteAtual().getNome());
      if (terminouJogo()) {
        System.out.println("Parabéns, você conseguiu fugir da casa!");
        jogando = false;
      }
      else {
        System.out.println(cenarioJogo.obterAmbienteAtual());
        
        if (!fantasmaMatou()) {
          Comando comando = new Comando (getString());
          if (verificaComando(comando)) {
            processarComando(comando);
          }
          else {
            System.out.println("Comando inválido");
          }
        }
        else {
          jogando = false;
        }
      }
    }
    escreverArquivo();
  }

  /**
   * Verifica se o jogador já chegou a saida
   * 
   * @return true caso chegou a saida ou false caso contrário
   */
  private boolean terminouJogo () {
    return cenarioJogo.obterAmbienteAtual().getNome().equals("Saida");
  }

  /**
   * Verifica se o jogador foi morto pelo Fantasma 
   * 
   * @return true caso foi morto ou false caso contrário
   */
  private boolean fantasmaMatou () {
    if (cenarioJogo.obterAmbienteAtual() == cenarioJogo.obterAmbienteDoFantasma()) {
      for(Item item : meusItens) {
        if (item.getTipo().equals("Invulnerabilidade")) {
          System.out.println("Você foi salvo pelo seu item de Invulnerabilidade");
          meusItens.remove(item);
          return false;
        }
      }
      System.out.println("O Fantasma matou você");
      return true;
    }
    return false;
  }

  /**
   * Verifica se um comando digitado é valido
   * 
   * @param comando
   * @return
   */
  private boolean verificaComando (Comando comando) {
    return comando.ehValido();
  }

  /**
   * Processa o comando inserido pelo jogador.
   *
   * @param comando O comando inserido pelo jogador.
   */
  private void processarComando (Comando comando) {
    if (comando.getPalavraDeComando().equals("ajuda")) {
      mensagemDeAjuda();
    }
    else if (comando.getPalavraDeComando().equals("pegar"))  {
      if (cenarioJogo.obterAmbienteAtual().getItem() == null) {
        System.out.println("Não há itens aqui!");
      }
      meusItens.add(cenarioJogo.obterAmbienteAtual().getItem());
      System.out.println("Item pego com sucesso!\n");
      Comando comando2 = new Comando(getString());
      if (verificaComando(comando2)) {
        processarComando(comando2);
      }
      else {
        System.out.println("Comando Inválido");
      }
    }
    else {
      if (!cenarioJogo.trocarAmbiente(comando.getPalavraDeComando())) {
        System.out.println("Não há saída nessa direção");
      }
    }
  }

  /**
   * Exibir as mensagens de ajuda para o jogador
   */
  private void mensagemDeAjuda () {
    System.out.println("Você solicitou a opção de ajuda");
    System.out.println("* Para você jogar, basta digitar a direção que deseja ir, por exemplo:");
    System.out.println("- - Imagine que tenha as opções norte e leste, basta digitar, por exemplo leste");
    System.out.println("- - que o ambiente que você está irá mudar");
    System.out.println("* Se o ambiente tiver um item, basta digitar pegar!");
    System.out.println("* Se por acaso você entrar no ambiente que o fantasma está, sem um item");
    System.out.println("- - o jogo finaliza e você perde");
  }

  /**
   * Imprime a mensagem de boas-vindas do jogo.
   */
  private void imprimirBoasVindas () {
    System.out.println();
    System.out.println("Bem-vindo à fuga da casa mal assombrada!");
    System.out.println("Seu objetivo é explorar a casa em busca de itens e descobrir sua saída");
    System.out.println("Mas cuidado! Há um fantasma a espreita, se ele te achar, você morre!");
    System.out.println("Digite 'ajuda' se voce precisar de ajuda.");
    System.out.println();
  }

  /**
   * Obtém a entrada do jogador como uma string.
   *
   * @return A string inserida pelo jogador.
   */
  private String getString () {
    System.out.print("> ");
    String texto = console.nextLine();
    comandosUtilizados.add(texto);
    return texto;
  }
}
