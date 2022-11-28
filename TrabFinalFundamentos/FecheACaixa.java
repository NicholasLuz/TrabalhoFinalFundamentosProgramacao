import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.InputMismatchException;

/**
 * Classe Feche a Caixa, onde h&aacute; a cria&ccedil;&atilde;o do objeto
 * FecheACaixa.
 *
 * @author Nicholas Luz
 * @version 26 nov. 2022
 */

public class FecheACaixa {
  private int pontosAtual;
  private Tabuleiro tabuleiro;
  private Scanner scanner;
  private Placar placar;
  private final int casas = 9;
  private String jogador;

  /**
   * m&eacute;todo para inicializar o objeto FecheACaixa.
   * 
   * @param placar  objeto da classe <code>Placar</code> contendo placares do
   *                jogo.
   * @param scanner Objeto da classe <code>Scanner</code> a partir do qual
   *                ser&aacute;
   *                feita a leitura.
   * @param jogador String contendo nome do jogador.
   */
  public FecheACaixa(Placar placar, Scanner scanner, String jogador) {
    this.placar = placar;
    this.scanner = scanner;
    this.tabuleiro = new Tabuleiro(casas);
    this.pontosAtual = 0;
    this.jogador = jogador;
  }

  /**
   * Mostra em tela o primeiro menu com op&ccedil;&otilde;es para o jogador
   * escolher.
   */
  public void mostrarMenu1() {
    System.out.println("------ O que deseja fazer? ------");
    System.out.println("|  (1) Arremessar Dados         |");
    System.out.println("|  (2) Visualizar o placar      |");
    System.out.println("|  (3) Encerrar jogo            |");
    System.out.println("---------------------------------");
  }

  /**
   * L&ecirc; a resposta do jogador para o primeiro menu.
   * 
   * @return Retorna um valor inteiro (<code>int</code>), correspondendo a
   *         resposta do jogador ao primeiro menu.
   * 
   */
  public int escolherOpcaoMenu1() {
    boolean continuar = false;
    int resposta = 0;
    while (!continuar) {
      try {
        resposta = Integer.parseInt(scanner.nextLine());

        if (resposta < 1 || resposta > 3) {
          throw new InputMismatchException();
        }
        continuar = true;
      } catch (InputMismatchException | NumberFormatException e) {
        System.out.println("Valor inválido, insira valor da lista.");
      }
    }
    return resposta;
  }

  /**
   * Trata a resposta do jogador para o primeiro menu conforme o escolhido.
   * 
   * @param resposta Inteiro (<code>int</code>), correspondendo a
   *                 resposta do jogador ao primeiro menu.
   */
  public void tratarRespostaMenu1(int resposta) {
    switch (resposta) {
      case 1:
        break;
      case 2:
        placar.mostrar();
        menu1Completo();
        break;
      case 3:
        endGame(pontosAtual);
        System.exit(0);
        break;
      default:
        System.out.println("Erro inesperado aconteceu. Encerrando o jogo");
        System.exit(0);
    }
  }

  /**
   * M&eacute;todo que chama todos os m&eacute;todos para intera&ccedil;&atilde;o
   * do jogador com o primeiro menu.
   */
  public void menu1Completo() {
    mostrarMenu1();
    int resposta = escolherOpcaoMenu1();
    tratarRespostaMenu1(resposta);
  }

  /**
   * M&eacute;todo que inicia a rodada do jogo, verifica se o jogo j&aacute;
   * acabou, e chama os m&eacute;todos caso tenha acabado.
   */
  public void jogar() {
    boolean jogoTerminado = false;
    while (!jogoTerminado) {
      rodada();
      jogoTerminado = tabuleiro.checkWin();
    }

    vitoria(pontosAtual);
    placar.finalizar(jogador, pontosAtual);
  }

  /**
   * M&eacute;todo que descreve uma rodada do jogo, chamando os m&eacute;todos dos
   * menus para o jogador interagir e tamb&eacute;m lan&ccedil;a os dados.
   */
  public void rodada() {
    // System.out.println("Sua pontuação atual é: " + pontosAtual);
    // tabuleiro.desenharTabuleiro();
    menu1Completo();
    int somaDados = arremessarDados();
    menu2Completo(somaDados);
  }

  /**
   * M&eacute;todo para verificar quantidade de dados a serem lan&ccedil;ados
   * baseado nas casas fechadas do tabuleiro.
   * 
   * @return Retorna um valor inteiro (<code>int</code>), correspondendo a
   *         quantidade de dados a serem lan&ccedil;ados.
   * 
   */
  public int arremessarDados() {
    Dado dado = new Dado(6);
    int qtdDados = tabuleiro.quantidadeDados();

    int somaDados = 0;

    for (int i = 0; i < qtdDados; i++) {
      int valorDado = dado.arremessar();
      somaDados += valorDado;
      System.out.println("Dado " + (i + 1) + ": " + valorDado + "\n");
    }

    System.out.println("Sua soma foi de " + somaDados);

    return somaDados;
  }

  /**
   * Mostra em tela o segundo menu com op&ccedil;&otilde;es para o jogador
   * escolher.
   */
  public void mostrarMenu2() {
    System.out.println("----------- O que deseja fazer? --------------");
    System.out.println("| (1) Baixar casas                           |");
    System.out.println("| (2) Somar pontos e realizar nova tentativa |");
    System.out.println("| (3) Visualizar tabuleiro                   |");
    System.out.println("| (4) Visualizar placar                      |");
    System.out.println("| (5) Encerrar jogo                          |");
    System.out.println("----------------------------------------------");
  }

  /**
   * L&ecirc; a resposta do jogador para o segundo menu.
   * 
   * @return Retorna um valor inteiro (<code>int</code>), correspondendo a
   *         resposta do jogador ao segundo menu.
   * 
   */
  public int escolherOpcaoMenu2() {
    boolean continuar = false;
    int resposta = 0;
    while (!continuar) {
      try {
        resposta = Integer.parseInt(scanner.nextLine());

        if (resposta < 1 || resposta > 5) {
          throw new InputMismatchException();
        }
        continuar = true;
      } catch (InputMismatchException | NumberFormatException e) {
        System.out.println("Valor inválido, insira valor da lista.");
      }
    }
    return resposta;
  }

  /**
   * Trata a resposta do jogador para o segundo menu conforme o escolhido.
   * 
   * @param resposta  Inteiro (<code>int</code>), correspondendo a
   *                  resposta do jogador ao segundo menu.
   * @param somaDados Inteiro (<code>int</code>), correspondendo a soma dos dados
   *                  que foram lan&ccedil;ados previamente.
   */
  public void tratarRespostaMenu2(int resposta, int somaDados) {
    switch (resposta) {
      case 1:
        try {
          fecharCasas(somaDados);
        } catch (NumberFormatException e) {
          System.out.println("Valor inválido, insira valor inteiro pertencente ao tabuleiro.");
          tratarRespostaMenu2(resposta, somaDados);
        }
        break;
      case 2:
        pontosAtual += somaDados;
        System.out.println("Seus pontos agora são: " + pontosAtual);
        rodada();
        break;
      case 3:
        tabuleiro.desenharTabuleiro();
        System.out.println("Sua soma dos dados é: " + somaDados);
        menu2Completo(somaDados);
        break;
      case 4:
        placar.mostrar();
        System.out.println("Sua soma dos dados é: " + somaDados);
        menu2Completo(somaDados);
        break;
      case 5:
        endGame(pontosAtual);
        System.exit(0);
        break;
      default:
        System.out.println("Erro inesperado aconteceu. Encerrando o jogo");
        System.exit(0);
    }
  }

  /**
   * M&eacute;todo que chama todos os m&eacute;todos para intera&ccedil;&atilde;o
   * do jogador com o segundo menu.
   * 
   * @param somaDados Inteiro (<code>int</code>), correspondendo a soma dos dados
   *                  que foram lan&ccedil;ados previamente.
   */
  public void menu2Completo(int somaDados) {
    mostrarMenu2();
    int resposta = escolherOpcaoMenu2();
    tratarRespostaMenu2(resposta, somaDados);
  }

  /**
   * M&eacute;todo que l&ecirc; as casas que o jogador deseja fechar e faz o
   * tratamento
   * verificando se &eacute; poss&iacute;vel ou n&atilde;o.
   * 
   * @param somaDados Inteiro (<code>int</code>), correspondendo a soma dos dados
   *                  que foram lan&ccedil;ados previamente.
   */
  public void fecharCasas(int somaDados) {
    System.out.println(
        "Qual(is) casa(s) deseja baixar? Caso for mais de uma, digite-as separadas por espaços. Digite 0 para voltar ao menu.");

    String s = scanner.nextLine();

    if (s.equals("0")) {
      System.out.println("Sua soma dos dados é: " + somaDados);
      menu2Completo(somaDados);
      return;
    }

    String[] casas = s.split(" ");

    Set<String> set = new HashSet<String>();
    int somaCasas = 0;

    for (int i = 0; i < casas.length; i++) {
      if (set.add(casas[i]) == false) {
        // elemento duplicado digitado, pois não é possível adicionar no set.
        System.out.println("Casas não podem ser iguais.");
        fecharCasas(somaDados);
        return;
      }
      somaCasas += Integer.parseInt(casas[i].trim());
    }

    if (somaDados != somaCasas) {
      System.out.println("Soma das casas não corresponde à soma dos dados. Insira outro valor.");
      fecharCasas(somaDados);
      return;
    }

    for (int i = 0; i < casas.length; i++) {
      if (tabuleiro.checarCasaFechada(Integer.parseInt(casas[i]) - 1)) {
        System.out.println("Casa " + casas[i] + " já foi fechada.\n");
        fecharCasas(somaDados);
        return;
      }
    }

    for (int i = 0; i < casas.length; i++) {
      tabuleiro.fecharCasa(Integer.parseInt(casas[i]) - 1);
    }

    tabuleiro.desenharTabuleiro();
  }

  /**
   * M&eacute;todo que mostra em tela mensagem de vit&oacute;ria com a
   * pontua&ccedil;&atilde;o do jogador.
   * 
   * @param pontosAtual Inteiro (<code>int</code>), correspondendo a
   *                    pontua&ccedil;&atilde;o do jogador no momento.
   */
  public void vitoria(int pontosAtual) {
    System.out.println("Parabéns, você ganhou o jogo!! Sua pontuação foi de: " + pontosAtual);
  }

  /**
   * M&eacute;todo que mostra em tela mensagem de agradecimento por participar do
   * jogo com a pontua&ccedil;&atilde;o do jogador.
   * 
   * @param pontosAtual Inteiro (<code>int</code>), correspondendo a
   *                    pontua&ccedil;&atilde;o do jogador no momento.
   */
  public void endGame(int pontosAtual) {
    System.out.println("Obrigado por participar do jogo! Sua pontuação final foi de " + pontosAtual + " pontos.");
  }

}