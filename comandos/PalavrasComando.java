//package comandos;

public class PalavrasComando {
    // um vetor constante que guarda todas as palavras de comandos válidas
    private static final String[] comandosValidos = {
        "ir", "entrar", "sair", "ajuda", "verificar", "pegar"
    };

    public static String getComandos(){
        String comandos = " ";
        for(String comando: comandosValidos){
            comandos += comando + " ";
        }
        return comandos;
    }

    /**
     * Verifica se uma dada String é uma palavra de comando válida. 
     * @return true se a string dada é um comando valido, false se não é.
     */
    public boolean ehComando(String umaString) {
        for(int i = 0; i < comandosValidos.length; i++) {
            if(comandosValidos[i].equals(umaString))
                return true;
        }
        // se chegamos aqui, a string não foi encontrada nos comandos.
        return false;
    }
}
