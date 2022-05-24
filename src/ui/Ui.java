package ui;

import disciplins.Competition;
import entities.Member;

import java.util.ArrayList;

public class Ui {
  public final String BLUE = "\u001B[34m";
  public final String RESET = "\u001B[0m";
  public final String YELLOW = "\033[0;33m";
  public final String RED = "\u001B[31m";

  //**********************************************************
  //**************************MENU****************************
  //**********************************************************

  public void mainMenu() {
    System.out.println("""
        ╔════════════════════════════════════╗
        ║              MENU                  ║
        ╠════════════════════════════════════╣
        ║   1:  Tilføj Ny Medlem             ║
        ║   2:  Liste Af Medlemmer           ║
        ║   3:  Sortere Medlemmer            ║
        ║   4:  Slet Medlem                  ║
        ║   5:  Ændre Betalingsstatus        ║
        ║   6:  Ændre Aktivitetsstatus       ║
        ║   7:  Årsregnskab                  ║
        ║   8:  Tilføj/Fjern Træner          ║
        ║   9:  Tilføj svømmetid             ║
        ║   10: Se top 5 over svømmetider    ║
        ║   11: Se Svømmestævner             ║
        ║   0:  SHUTDOWN                     ║
        ╚════════════════════════════════════╝
        """);
  }

  public String consoleOrSwing(){
    return """
        ╔═══════════════════════════════════════════════════╗
        ║      Kør programmet i konsollen eller Swing:      ║
        ╠═══════════════════════════════════════════════════╣
        ║  1:  Konsollen                                    ║
        ║  2:  Swing UI                                     ║
        ╚═══════════════════════════════════════════════════╝
        """;
  }

  public void sortMenu() {
    System.out.println("""
        ╔══════════════════════════════════════╗
        ║           SORTERINGSMENU             ║
        ╠══════════════════════════════════════╣
        ║   1:  Sorter efter Efternavn         ║
        ║   2:  Sorter efter Fornavn           ║
        ║   3:  Sorter efter Alder             ║
        ║   4:  Sorter efter Aktivitets Status ║
        ║   5:  Sorter efter Svømme Status     ║
        ║   6:  Sorter efter Anciennitet       ║
        ║   7:  Sorter efter ID nummer         ║
        ║   8:  Sorter efter Betaling Status   ║
        ║   9:  Hovedmenu                      ║
        ╚══════════════════════════════════════╝
        """);
  }

  public String activePassiveChoice() {
    return """
        ╔════════════════╗
        ║      Vælg:     ║
        ╠════════════════╣
        ║  1:  Aktiv     ║
        ║  2:  Passiv    ║
        ╚════════════════╝
        """;
  }

  public String compNonCompChoice() {
    return """
        ╔═════════════════════════╗
        ║          Vælg:          ║
        ╠═════════════════════════╣
        ║  1:  Konkurrencesvømmer ║
        ║  2:  Motionssvømmer     ║
        ╚═════════════════════════╝
        """;
  }

  public String paidNotPaidChoice() {
    return """
        ╔═════════════════════════╗
        ║          Vælg:          ║
        ╠═════════════════════════╣
        ║  1:  Betalt             ║
        ║  2:  Ikke betalt        ║
        ╚═════════════════════════╝
        """;
  }

  public String chooseTrainer() {
    return """
        ╔═════════════════════════╗
        ║          Vælg:          ║
        ╠═════════════════════════╣
        ║  1:  Egon Olsen         ║
        ║  2:  Benny Frandsen     ║
        ╚═════════════════════════╝
        """;
  }

  public String removeOrAddTrainer() {
    return """
        ╔═════════════════════════╗
        ║          Vælg:          ║
        ╠═════════════════════════╣
        ║  1:  Tilføj Træner      ║
        ║  2:  Fjern Træner       ║
        ╚═════════════════════════╝
        """;
  }

  public String yesNo() {
    return """
        ╔═════════════════════════╗
        ║          Vælg:          ║
        ╠═════════════════════════╣
        ║  1:  Ja                 ║
        ║  2:  Nej                ║
        ╚═════════════════════════╝
        """;
  }

  public String swimmingStyle() {
    return """
        ╔═════════════════════════╗
        ║          Vælg:          ║
        ╠═════════════════════════╣
        ║  1:  Butterfly          ║
        ║  2:  Crawl              ║
        ║  3:  Backcrawl          ║
        ║  4:  Breaststroke       ║
        ╚═════════════════════════╝
        """;
  }

  public String juniorOrSenior(){
    return """
        ╔════════════════════════════════╗
        ║              MENU              ║
        ╠════════════════════════════════╣
        ║   1:  Junior                   ║
        ║   2:  Senior                   ║
        ╚════════════════════════════════╝
        """;
  }

  //**********************************************************
  //*********************ASCII ART****************************
  //**********************************************************

  public void introLabel() throws InterruptedException {
    String intro = "╔══════════════════════════════════════════════════════════════════╗\n" +
        "║" + BLUE + "  ██████  ███████ ██      ███████ ██ ███    ██ ███████ ███    ██ " + RESET + " ║\n" +
        "║" + BLUE + "  ██   ██ ██      ██      ██      ██ ████   ██ ██      ████   ██ " + RESET + " ║\n" +
        "║" + BLUE + "  ██   ██ █████   ██      █████   ██ ██ ██  ██ █████   ██ ██  ██ " + RESET + " ║\n" +
        "║" + BLUE + "  ██   ██ ██      ██      ██      ██ ██  ██ ██ ██      ██  ██ ██ " + RESET + " ║\n" +
        "║" + BLUE + "  ██████  ███████ ███████ ██      ██ ██   ████ ███████ ██   ████ " + RESET + " ║\n" +
        "╚══════════════════════════════════════════════════════════════════╝\n\n\n\n\n";
    System.out.println(intro);
    Thread.sleep(0);
    newLine();

  }

  public void dolphinLogo() throws InterruptedException {
    String dolphin = BLUE + "\n\n                   ▓█▄▄▄\n" +
        "                    ▓████▄▄\n" +
        "                  ▄▄▓███████▄▄\n" +
        "            ▄▄▄▄▄████████████████▄▄▄\n" +
        "         ▄▄███████████████████████████▄▄\n" +
        "       ▄█████████████████████████████████▄▄\n" +
        "      ▄█████████████████████████████████████▄\n" +
        "     ▄███████████████████████████████████████▄\n" +
        "    ▄██████▒▀                    ▀▓████████████▄\n" +
        "    █████▒▀                    ▓▄▄▄▄▄███████████\n" +
        "   ▄████▀                      ▀▓████▀▀ ▀▓██████\n" +
        " ▄███████▄                                ▀▓████\n" +
        "▓▓█▀▀ ▀█▓█▄                                 ▀▀██▒\n" +
        "▓▀      ▀▓▒                                    ▀▀\n" +
        "         ▀▀" + RESET;
    System.out.println(dolphin);

  }

  public String asciiLines(){
    return BLUE + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░" +
                  "▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒" +
                  "▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓" + RESET;
  }

  public String asciiLinesCompetition(){
    return BLUE + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒" +
        RESET;
  }

  public void loadingBar() throws InterruptedException {
    System.out.println("\n\n                     LOADING");
    String bar ="░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░";
    int procent = 6;
    String solidBar = BLUE + "▓" + RESET;
    for (int i = 0; i <= 46; i++) {
      procent += 2;
      solidBar += BLUE + "▓" + RESET;
      bar = bar.substring(0,46-i);
      System.out.print("|" + solidBar + bar + "| " + procent + "/100%\r");
      Thread.sleep(5);
    }
    Thread.sleep(0);
    newLine();
  }

  //**********************************************************
  //********************VARIOUS SOUTS*************************
  //**********************************************************

  public void newLine() {
    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
  }

  public void invalidInput() throws InterruptedException {
    System.out.println("INVALID INPUT");
    Thread.sleep(1500);
    newLine();
  }

  public void confirmInput(){
    newLine();
    System.out.println(YELLOW + "Vil du bekræfte, at dataene er udfyldt korrekt?" + RESET);
  }

  public String memberListToString(ArrayList<Member> memberList) {
    String member = "\n";
    for (int i = 0; i < memberList.size(); i++) {
      member += memberList.get(i).toString();
    }
    return asciiLines() + "\n" + member + "\n" + asciiLines() + "\n\n\n";
  }

  public String competitionListToString(ArrayList<Competition> competitionsList) {
    String competition = "\n";
    for (int i = 0; i < competitionsList.size(); i++) {
      competition += competitionsList.get(i).toString();
    }
    return asciiLinesCompetition() + "\n" + competition + "\n" + asciiLinesCompetition() + "\n\n\n";
  }

}




