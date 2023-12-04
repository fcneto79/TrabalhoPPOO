//import javax.swing.SwingUtilities;
import aplicacao.jogo.Jogo;
//import janela.Aplicacao;

/**
 * A classe App representa a classe principal que inicia a aplicação do jogo.
 */
public class App {
  public static void main(String[] args) throws Exception {
    // Adicionar a janela a fila de execução do SwingUtilities é uma boa prática 
    // do java swing e garante que a aplicação seja atualizada na EDT
    // Se a interface gráfica for atualizada fora da EDT, podem 
    // ocorrer problemas de concorrência, como condições de corrida ou bloqueios,
    //SwingUtilities.invokeLater(()->{
      //Aplicacao app = new Aplicacao();
      //app.exibir();
    //});

    Jogo jogo = Jogo.criarJogo();
  }
}
