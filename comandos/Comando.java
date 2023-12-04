package comandos;

import java.util.ArrayList;

/**
 * A classe Comando representa um comando inserido pelo jogador no jogo, contendo uma palavra de comando válida.
 */
public class Comando {
    private String palavraDeComando;
    private static ArrayList<String> comandosValidos = new ArrayList<>();

    /** 
     * Inicialização estática da lista de comandos válidos
     */
    static {
        ArrayList<String> palavras = new ArrayList<>();
        palavras.add("norte");
        palavras.add("sul");
        palavras.add("leste");
        palavras.add("oeste");
        palavras.add("pegar");
        palavras.add("usar");
        palavras.add("ajuda");
        comandosValidos.addAll(palavras);
    }
    
    /**
     * Construtor da classe Comando.
     * Cria um objeto comando com a palavra fornecida.
     *
     * @param palavra A palavra de comando.
     */
    public Comando(String palavra) {
        palavraDeComando = palavra;
    }

    /**
     * Obtém a palavra de comando deste comando.
     * Se o comando não foi reconhecido, o resultado é null.
     *
     * @return A palavra de comando.
     */
    public String getPalavraDeComando() {
        return palavraDeComando;
    }

    /**
     * Verifica se o comando é válido.
     *
     * @return true se o comando foi reconhecido como válido, false caso contrário.
     */
    public boolean ehValido() {
        return comandosValidos.contains(palavraDeComando);
    }
}
