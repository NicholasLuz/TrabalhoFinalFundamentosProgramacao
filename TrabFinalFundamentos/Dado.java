import java.util.Random;

/**
 * Classe Dado, onde h&aacute; a cria&ccedil;&atilde;o do objeto dado.
 *
 * @author Nicholas Luz
 * @version 26 nov. 2022
 */

public class Dado {
  private int faces;
  private Random r;

  /**
   * m&eacute;todo para inicializar o objeto placar.
   */
  public Dado(int f) {
    faces = f;
    r = new Random();
  }

  /**
   * Arremessa um dado, resultando valor entre 1 e as faces totais do dado.
   * 
   * @return Retorna um valor inteiro (<code>int</code>), correspondendo ao
   *         valor do dado.
   */
  public int arremessar() {
    int valor = (r.nextInt(faces) + 1);

    return valor;
  }

}
