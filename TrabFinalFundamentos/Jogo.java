import java.util.Scanner;

/**
 * Classe Jogo, onde &eacute; rodado a main do programa.
 *
 * @author Nicholas Luz
 * @version 26 nov. 2022
 */

public class Jogo {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Placar placar = new Placar();

    placar.iniciar();

    System.out.println("Digite o seu nome: ");
    String nome = scanner.nextLine();

    FecheACaixa fecheACaixa = new FecheACaixa(placar, scanner, nome);

    System.out.println("\nOlá, " + nome + ", bem-vindo ao Feche a Caixa.\n");

    fecheACaixa.jogar();

  }
}