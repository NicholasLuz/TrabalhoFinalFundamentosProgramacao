import java.util.Scanner;
import java.io.PrintStream;

/**
 * Metodos estaticos para manipulacao de matrizes de inteiros.
 *
 * @author Roland Teodorowitsch
 * @version 28 nov. 2022
 */
public class Matriz {

    /**
     * L&ecirc; todos os elementos de uma matriz de inteiros.
     * 
     * @param in Objeto da classe <code>Scanner</code> a partir do qual ser&aacute;
     *           feita a leitura.
     * @param m  Matriz cujos elementos ser&atilde;o lidos.
     */
    public static void le(Scanner in, int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = in.nextInt();
            }
        }
    }

    /**
     * Mostra todos os elementos de uma matriz de inteiros, cada linha da matriz
     * separada
     * por uma quebra de linha, com valores das colunas separados por um
     * espa&ccedil;o.
     * 
     * @param out Fluxo de sa&iacute;da (ou seja, objeto da classe
     *            <code>PrintStream</code>)
     *            no qual a matriz ser&aacute; impressa. Para imprimir no terminal
     *            deve-se passar
     *            <code>System.out</code> no lugar deste par&acirc;metro.
     * @param m   Matriz a ser impressa.
     */
    public static void imprime(PrintStream out, int[][] m) {
        for (int i = 0; i < m.length; ++i) {
            for (int j = 0; j < m[i].length; ++j) {
                if (j > 0)
                    out.print(" ");
                out.print(m[i][j]);
            }
            out.println();
        }
    }

    /**
     * Troca duas linhas de uma matriz de inteiros.
     * 
     * @param m  Matriz cujas linhas ser&atilde;o trocadas.
     * @param l1 Primeira linha a ser trocada.
     * @param l2 Segunda linha a ser trocada.
     * @return Retorna um valor booleano (<code>boolean</code>), correspondendo a:
     *         <code>false</code> se os n&uacute;meros de linhas forem
     *         inv&aacute;lidos, ou
     *         <code>true</code> se a troca tiver sido feita com sucesso.
     */
    public static boolean trocaLinhas(int[][] m, int l1, int l2) {
        if (l1 >= 0 && l1 < m.length && l2 >= 0 && l2 < m.length) {
            for (int j = 0; j < m[l1].length; j++) {
                int aux = m[l1][j];
                m[l1][j] = m[l2][j];
                m[l2][j] = aux;
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Troca duas colunas de uma matriz de inteiros.
     * 
     * @param m  Matriz cujas colunas ser&atilde;o trocadas.
     * @param c1 Primeira coluna a ser trocada.
     * @param c2 Segunda coluna a ser trocada.
     * @return Retorna um valor booleano (<code>boolean</code>), correspondendo a:
     *         <code>false</code> se os n&uacute;meros de colunas forem
     *         inv&aacute;lidos, ou
     *         <code>true</code> se a troca tiver sido feita com sucesso.
     */
    public static boolean trocaColunas(int[][] m, int c1, int c2) {
        if (c1 >= 0 && c1 < m[0].length && c2 >= 0 && c2 < m[0].length) {
            for (int i = 0; i < m.length; i++) {
                int aux = m[i][c1];
                m[i][c1] = m[i][c2];
                m[i][c2] = aux;
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Preenche todos os elementos de uma matriz de inteiros com valores
     * sequenciais,
     * iniciando em 1, com incremento de 1 de uma coluna para outra e da
     * &uacute;ltima
     * coluna de uma linha para a primeira coluna da pr&oacute;xima linha.
     * 
     * @param m Matriz cujos valores ser&atilde;o preenchidos sequencialmente.
     */
    public static void preencheSequencialmente(int[][] m) {
        int inicio = 1;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = inicio;
                inicio++;
            }
        }
    }

    /**
     * Preenche todos os elementos de uma matriz de inteiros com determinado valor.
     * 
     * @param m Matriz cujos valores ser&atilde;o preenchidos.
     * @param n Valor inteiro a ser atribu&iacute;do a cada um dos elementos da
     *          matriz.
     */
    public static void preenche(int[][] m, int n) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = n;
            }
        }
    }

    /**
     * Soma todos os elementos de uma matriz de inteiros.
     * 
     * @param m Matriz cujos elementos ser&atilde;o somados.
     * @return Somat&oacute;rio (<code>long</code>) dos elementos da matriz.
     */
    public static long soma(int[][] m) {
        long res = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                res += m[i][j];
            }
        }
        return res;
    }

    /**
     * Soma todos os elementos de uma linha de uma matriz de inteiros.
     * 
     * @param m Matriz cujos elementos de uma linha ser&atilde;o somados.
     * @param l Linha da matriz a ser somada.
     * @return Somat&oacute;rio (<code>long</code>) dos elementos da linha da
     *         matriz.
     */
    public static long somaLinha(int[][] m, int l) {
        long res = 0;
        for (int j = 0; j < m[l].length; j++) {
            res += m[l][j];
        }
        return res;
    }

    /**
     * Soma todos os elementos de uma coluna de uma matriz de inteiros.
     * 
     * @param m Matriz cujos elementos de uma coluna ser&atilde;o somados.
     * @param c Coluna da matriz a ser somada.
     * @return Somat&oacute;rio (<code>long</code>) dos elementos da coluna da
     *         matriz.
     */
    public static long somaColuna(int[][] m, int c) {
        long res = 0;
        for (int i = 0; i < m[c].length; i++) {
            res += m[i][c];
        }
        return res;
    }

    /**
     * Soma todos os elementos da diagonal principal de uma matriz quadrada de
     * inteiros.
     * 
     * @param m Matriz cujos elementos da diagonal principal devem ser somados.
     * @return Somat&oacute;rio (<code>long</code>) dos elementos da diagonal
     *         principal da matriz.
     */
    public static long somaDiagonalPrincipal(int[][] m) {
        long res = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (i == j) {
                    res += m[i][j];
                }
            }
        }
        return res;
    }

    /**
     * Soma todos os elementos acima da diagonal principal de uma matriz quadrada de
     * inteiros.
     * 
     * @param m Matriz cujos elementos acima da diagonal principal devem ser
     *          somados.
     * @return Somat&oacute;rio (<code>long</code>) dos elementos acima da diagonal
     *         principal da matriz.
     */
    public static long somaAcimaDiagonalPrincipal(int[][] m) {
        long res = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (i < j) {
                    res += m[i][j];
                }
            }
        }
        return res;
    }

    /**
     * Soma todos os elementos abaixo da diagonal principal de uma matriz quadrada
     * de inteiros.
     * 
     * @param m Matriz cujos elementos abaixo da diagonal principal devem ser
     *          somados.
     * @return Somat&oacute;rio (<code>long</code>) dos elementos abaixo da diagonal
     *         principal da matriz.
     */
    public static long somaAbaixoDiagonalPrincipal(int[][] m) {
        long res = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (i > j) {
                    res += m[i][j];
                }
            }
        }
        return res;
    }

    /**
     * Soma todos os elementos da diagonal secund&aacute;ria de uma matriz quadrada
     * de inteiros.
     * 
     * @param m Matriz cujos elementos da diagonal secund&aacute;ria devem ser
     *          somados.
     * @return Somat&oacute;rio (<code>long</code>) dos elementos da diagonal
     *         secund&aacute;ria da matriz.
     */
    public static long somaDiagonalSecundaria(int[][] m) {
        long res = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if ((i + j) == (m.length - 1)) {
                    res += m[i][j];
                }
            }
        }
        return res;
    }

    /**
     * Soma todos os elementos acima da diagonal secund&aacute;ria de uma matriz
     * quadrada de inteiros.
     * 
     * @param m Matriz cujos elementos acima da diagonal secund&aacute;ria devem ser
     *          somados.
     * @return Somat&oacute;rio (<code>long</code>) dos elementos acima da diagonal
     *         secund&aacute;ria da matriz.
     */
    public static long somaAcimaDiagonalSecundaria(int[][] m) {
        long res = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if ((i + j) < (m.length - 1)) {
                    res += m[i][j];
                }
            }
        }
        return res;
    }

    /**
     * Soma todos os elementos abaixo da diagonal secund&aacute;ria de uma matriz
     * quadrada de inteiros.
     * 
     * @param m Matriz cujos elementos abaixo da diagonal secund&aacute;ria devem
     *          ser somados.
     * @return Somat&oacute;rio (<code>long</code>) dos elementos abaixo da diagonal
     *         secund&aacute;ria da matriz.
     */
    public static long somaAbaixoDiagonalSecundaria(int[][] m) {
        long res = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if ((i + j) > (m.length - 1)) {
                    res += m[i][j];
                }
            }
        }
        return res;
    }

    /**
     * Descobre qual o maior valor armazenado em uma matriz de inteiros e retorna
     * este valor.
     * 
     * @param m Matriz onde ser&aacute; feita a busca pelo maior valor.
     * @return Maior valor contido na matriz.
     */
    public static int maiorValor(int[][] m) {
        int maior = m[0][0];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (maior < m[i][j]) {
                    maior = m[i][j];
                }
            }
        }
        return maior;
    }

    /**
     * Descobre qual o menor valor armazenado em uma matriz de inteiros e retorna
     * este valor.
     * 
     * @param m Matriz onde ser&aacute; feita a busca pelo menor valor.
     * @return Menor valor contido na matriz.
     */
    public static int menorValor(int[][] m) {
        int menor = m[0][0];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (menor > m[i][j]) {
                    menor = m[i][j];
                }
            }
        }
        return menor;
    }

    /**
     * Cria uma matriz que &eacute; a transposta da matriz recebida como
     * par&acirc;metro.
     * Uma matriz transposta de <code>m</code> &eacute; aquela que a primeira coluna
     * corresponde &agrave;
     * primeira linha de <code>m</code>, a segunda coluna corresponde &agrave;
     * segunda linha de <code>m</code>,
     * e assim por diante.
     * 
     * @param m Matriz da qual ser&aacute; gerada a transposta.
     * @return Matriz transposta de <code>m</code>, alocada e devidamente
     *         preenchida.
     */
    public static int[][] transposta(int[][] m) {
        int[][] transp = new int[m[0].length][m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                transp[j][i] = m[i][j];
            }
        }
        return transp;
    }

    /**
     * Verifica se uma determinada matriz &eacute; sim&eacute;trica ou n&atilde;o.
     * Uma matriz &eacute; sim&eacute;trica se ela for quadrada e se para quaisquer
     * &iacute;ndices <code>i</code> e <code>j</code>, tivermos
     * <code>m[i][j] == m[j][i]</code>.
     * 
     * @param m Matriz que ser&aacute; testada.
     * @return Retorna <code>true</code> se a matriz for sim&eacute;trica, ou
     *         <code>false</code> se ela n&atilde; for sim&eacute;trica.
     */
    public static boolean ehSimetrica(int[][] m) {
        boolean simetrica = true;
        if (m.length != m[0].length) {
            simetrica = false;
        } else {
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[i].length; j++) {
                    if (m[i][j] != m[j][i]) {
                        simetrica = false;
                        break;
                    }
                }
            }
        }

        return simetrica;
    }

    /**
     * Calcula a m&eacute;dia (<code>double</code>) de todos os elementos de uma
     * matriz de inteiros.
     * 
     * @param m Matriz da qual se calcular&aacute; a m&eacute;dia de elementos.
     * @return M&eacute;dia (<code>double</code>) dos elementos da matriz.
     */
    public static double media(int[][] m) {
        int count = 0;
        double soma = 0.0;

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                soma += m[i][j];
                count++;
            }
        }

        return soma / count;
    }

}
