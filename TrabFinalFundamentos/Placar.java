import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Classe Placar, onde h&aacute; a cria&ccedil;&atilde;o do objeto placar.
 *
 * @author Nicholas Luz
 * @version 26 nov. 2022
 */

public class Placar {
  private final int TAM = 10;
  private String[] nomes;
  private int[] pontos;
  private String nomeArquivo = "placar.csv";

  int numItens;

  /**
   * m&eacute;todo para inicializar o objeto placar.
   */
  public Placar() {
    numItens = 0;
    nomes = new String[TAM + 1];
    pontos = new int[TAM + 1];
  }

  /**
   * m&eacute;todo para chamar o m&eacute;todo carregar o placar, tratamento de
   * erro e chamar o m&eacute;todo limpar placar.
   */
  public void iniciar() {
    try {
      carregar(nomeArquivo);
      System.out.println("> Placar carregado com sucesso...");
    } catch (Exception e) {
      System.out.println("> Iniciando com placar vazio...");
      limpar();
    }
  }

  /**
   * m&eacute;todo para chamar os m&eacute;todos adicionar o resultado do jogo
   * atual ao placar,
   * mostrar e salvar no arquivo csv.
   * 
   * @param nome   String contendo nome do jogador para salvar no placar.
   * @param pontos Inteiro contendo pontua&ccedil;&atilde;o do jogador para salvar
   *               no placar.
   */
  public void finalizar(String nome, int pontos) {
    adicionar(nome, pontos);
    mostrar();
    try {
      salvar(nomeArquivo);
    } catch (FileNotFoundException e) {
      System.out.println("Não foi possível salvar o seu placar.");
    }
  }

  /**
   * m&eacute;todo para limpar o placar.
   */
  public void limpar() {
    numItens = 0;
  }

  /**
   * m&eacute;todo para mostrar o placar em tela.
   */
  public void mostrar() {
    System.out.println("----- Placar -----------------");
    for (int i = 0; i < numItens; i++) {
      System.out.printf("%2d. %-20s > %3d\n", i + 1, nomes[i], pontos[i]);
    }
    System.out.println("------------------------------");
  }

  /**
   * m&eacute;todo para adicionar o resultado do jogo atual ao placar, realizar a
   * verifica&ccedil;&atilde;o dos 10 menores e ordenar.
   * 
   * @param n String contendo nome do jogador.
   * @param p Inteiro contendo pontua&ccedil;&atilde;o do jogador.
   */
  public void adicionar(String n, int p) {
    nomes[numItens] = n;
    pontos[numItens] = p;
    ++numItens;

    for (int i = 0; i < numItens - 1; i++) {
      int pos = i;
      for (int j = i + 1; j < numItens; j++) {
        if (pontos[j] < pontos[pos]) {
          pos = j;
        }
      }
      if (pos != i) {
        int aux = pontos[pos];
        pontos[pos] = pontos[i];
        pontos[i] = aux;
        String aux2 = nomes[pos];
        nomes[pos] = nomes[i];
        nomes[i] = aux2;
      }
    }
    if (numItens > TAM) {
      numItens = TAM;
    }
  }

  /**
   * m&eacute;todo para adicionar salvar placar no arquivo csv.
   * 
   * @param nomeArquivo String contendo nome do arquivo para salvar.
   */
  public void salvar(String nomeArquivo) throws FileNotFoundException {
    PrintWriter out = new PrintWriter(nomeArquivo);
    for (int i = 0; i < numItens; i++) {
      out.printf("%s;%d\n", nomes[i], pontos[i]);
    }

    out.close();
  }

  /**
   * m&eacute;todo para carregar arquivo csv contendo placar e adicionar os
   * valores ao nosso placar, caso haja arquivo.
   * 
   * @param nomeArquivo String contendo nome do arquivo para salvar.
   */
  public void carregar(String nomeArquivo) throws FileNotFoundException {
    Scanner inFile = new Scanner(new File(nomeArquivo));
    numItens = 0;
    while (inFile.hasNextLine()) {
      String linha = inFile.nextLine();
      String[] campos = linha.split(";");
      if (campos.length != 2) {
        System.out.println("> Numero invalido de campos no arquivo CSV...");
        break;
      }
      String n = campos[0];
      int p = Integer.parseInt(campos[1].trim());

      adicionar(n, p);
    }
    inFile.close();
  }
}
