package aplicacao.arquivo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivo {

  /**
   * Método responsável por gravar os relatórios no arquivo texto.
   * 
   * @param texto Conteúdo a ser escrito no arquivo
   */
  public static void escreverNoArquivo(String texto) {
    String caminhoArquivo = "src/arquivos/relatorio.txt";

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo,true))) {
      writer.write(texto);
    } 
    catch (IOException e) {
      System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
    }
  }
}
