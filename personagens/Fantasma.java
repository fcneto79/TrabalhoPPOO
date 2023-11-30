/**
 * 
 */


package personagens;

public class Fantasma {
  private static Fantasma instaciaUnica;

  private Fantasma () {

  }

  public static Fantasma getInstancia () {
    if (instaciaUnica == null) {
      instaciaUnica = new Fantasma();
    }

    return instaciaUnica;
  }
}
