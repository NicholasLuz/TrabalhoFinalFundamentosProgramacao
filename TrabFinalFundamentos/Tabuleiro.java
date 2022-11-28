/**
 * Classe Tabuleiro, onde h&aacute; a cria&ccedil;&atilde;o do objeto tabuleiro.
 *
 * @author Nicholas Luz
 * @version 26 nov. 2022
 */

public class Tabuleiro {
  private boolean[] tabuleiro;

  /**
   * m&eacute;todo para inicializar o objeto tabuleiro.
   */
  public Tabuleiro(int qtdCasas) {
    tabuleiro = new boolean[qtdCasas];
  }

  /**
   * m&eacute;todo para desenhar o tabuleiro em tela.
   */
  public void desenharTabuleiro() {
    System.out.println();
    System.out.println("Tabuleiro: ");

    for (int i = 0; i < tabuleiro.length; i++) {
      if (tabuleiro[i] == false) {
        System.out.print("[" + (i + 1) + "] ");
      } else {
        System.out.print("[X] ");
      }
    }
    System.out.println();
    System.out.println();
  }

  /**
   * Checa se a casa atual do tabuleiro est&aacute; fechada ou n&atilde;o.
   * 
   * @param i Inteiro contendo index para verificar no tabuleiro.
   * @return Retorna um valor booleano (<code>boolean</code>), correspondendo a:
   *         <code>false</code> se a casa do tabuleiro estiver aberta, ou
   *         <code>true</code> se a casa estiver fechada.
   */
  public boolean checarCasaFechada(int i) {
    return tabuleiro[i];
  }

  /**
   * Fecha a casa atual do tabuleiro no ind&iacute; i;
   * 
   * @param i Inteiro contendo index para verificar no tabuleiro.
   */
  public void fecharCasa(int i) {
    tabuleiro[i] = true;
  }

  /**
   * Checa se a todas casas do tabuleiro est&atilde;o fechadas, ou seja, se o jogo
   * acabou.
   * 
   * @return Retorna um valor booleano (<code>boolean</code>), correspondendo a:
   *         <code>true</code> se todas as casas do tabuleiro estiverem fechadas,
   *         ou
   *         <code>false</code> se alguma casa estiver aberta.
   */
  public boolean checkWin() {
    boolean win = true;
    for (int i = 0; i < tabuleiro.length; i++) {
      if (!tabuleiro[i]) {
        win = false;
      }
    }

    return win;
  }

  /**
   * Verifica a quantidade de dados baseado no tabuleiro.
   * 
   * @return Retorna um valor inteiro (<code>int</code>), correspondendo a
   *         quantidade de dados a serem jogados.
   */
  public int quantidadeDados() {
    int ultimoElementoAberto = 0;
    for (int i = tabuleiro.length - 1; i >= 0; i--) {
      if (!tabuleiro[i]) {
        ultimoElementoAberto = i + 1;
        break;
      }
    }

    int resultado = ultimoElementoAberto / 6;
    int resto = ultimoElementoAberto % 6;
    if (resto > 0) {
      return resultado + 1;
    }
    return resultado;
  }
}
