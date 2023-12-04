package janela;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import aplicacao.jogo.Jogo;

public class Aplicacao {
  private JFrame janela;
  private JTextArea descricaoAmbiente;
  private JTextArea itensAmbiente;
  private JTextField terminal;

  Jogo meuJogo;

  public Aplicacao () {
    construirJanela();
    meuJogo = Jogo.criarJogo();
  }

  private void construirJanela () {
    janela = new JFrame("Fuga da casa mal assombrada");
    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    criarComponentes();
        
    montarJanela();
  }

  private void criarComponentes () {
    descricaoAmbiente = new JTextArea("Estou aquiii");
    itensAmbiente = new JTextArea("Oiieeeee");

    descricaoAmbiente.setEditable(false);
    itensAmbiente.setEditable(false);
  }

  private void montarJanela () {
    int largura = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    int altura = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    janela.setSize(largura / 2, (3 * altura) / 4);

    janela.setLayout(new BorderLayout());

    JPanel painelCentral = new JPanel();
    painelCentral.setLayout(new BoxLayout(painelCentral, BoxLayout.Y_AXIS));

    terminal = new JTextField();
    Dimension tamanhoAreaTexto = new Dimension(400,50);
    terminal.setPreferredSize(tamanhoAreaTexto);

    JPanel painelInferior = new JPanel(new FlowLayout());

    JButton botaoCapturar = new JButton("Pegar comando");

    botaoCapturar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String textoCapturado = terminal.getText();
        JOptionPane.showMessageDialog(janela, "Comando Digitado: \n" + textoCapturado);
      }
    });

    painelInferior.add(terminal);
    painelInferior.add(botaoCapturar);

    janela.add(painelCentral, BorderLayout.CENTER);
    janela.add(descricaoAmbiente,BorderLayout.WEST);
    janela.add(itensAmbiente,BorderLayout.EAST);
    janela.add(painelInferior, BorderLayout.SOUTH);
  }

  public void exibir() {
    janela.setVisible(true);
  }

  public void editarDescricaoAmbiente (String novaDescricao) {
    descricaoAmbiente.setText(novaDescricao);
  }

  public void editarTextoItens (String novaDescricao) {
    itensAmbiente.setText(novaDescricao);
  }
}