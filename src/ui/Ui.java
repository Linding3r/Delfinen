package ui;

public class Ui {
  public final String BLUE = "\u001B[34m";
  public final String RESET = "\u001B[0m";


  //**********************************************************
  //**************************MENU****************************
  //**********************************************************

  public void mainMenu() {
    System.out.println("""
        ╔════════════════════════════════╗
        ║              MENU              ║
        ╠════════════════════════════════╣
        ║   1:  Tilføj Ny Medlem         ║
        ║   2:  Liste Af Medlemer        ║
        ║   3:  Sortere Medlemmer        ║
        ║   4:  Slet Medlem              ║
        ║   5:  Ændre Betaling Status    ║
        ║   99:  SHUTDOWN                ║
        ╚════════════════════════════════╝
        """);
  }

  public void sortMenu() {
    System.out.println("""
        ╔══════════════════════════════════════╗
        ║           SORTERINGS MENU            ║
        ╠══════════════════════════════════════╣
        ║   1:  Sorter efter Efternavn         ║
        ║   2:  Sorter efter Fornavn           ║
        ║   3:  Sorter efter Alder             ║
        ║   4:  Sorter efter Aktivitets Status ║
        ║   5:  Sorter efter Svømme Status     ║
        ║   6:  Sorter efter Anciennitet       ║
        ║   7:  Sorter efter ID nummer         ║
        ║   8:  Sorter efter Betaling Status   ║
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
    Thread.sleep(1000);
    newLine();

  }

  public void dolphinLogo() throws InterruptedException {
    String dolphine = BLUE + "\n\n                   ▓█▄▄▄\n" +
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
    System.out.println(dolphine);

  }

  public String asciiLines(){
    return BLUE + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒" +
        "▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓" + RESET;
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
      Thread.sleep(50);
    }
    Thread.sleep(1000);
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

}




