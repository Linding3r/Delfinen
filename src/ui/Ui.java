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
        ║   4:  Ændre Betaling Status    ║
        ║   9:  SHUTDOWN                 ║
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
    System.out.println("╔══════════════════════════════════════════════════════════════════╗\n" +
        "║" + BLUE + "  ██████  ███████ ██      ███████ ██ ███    ██ ███████ ███    ██ " + RESET + " ║\n" +
        "║" + BLUE + "  ██   ██ ██      ██      ██      ██ ████   ██ ██      ████   ██ " + RESET + " ║\n" +
        "║" + BLUE + "  ██   ██ █████   ██      █████   ██ ██ ██  ██ █████   ██ ██  ██ " + RESET + " ║\n" +
        "║" + BLUE + "  ██   ██ ██      ██      ██      ██ ██  ██ ██ ██      ██  ██ ██ " + RESET + " ║\n" +
        "║" + BLUE + "  ██████  ███████ ███████ ██      ██ ██   ████ ███████ ██   ████ " + RESET + " ║\n" +
        "╚══════════════════════════════════════════════════════════════════╝");
    Thread.sleep(3000);
    newLine();
  }

  public void dolphinLogo() throws InterruptedException {
    System.out.println(BLUE + "\n\n                   ▓█▄▄▄\n" +
        "                    ▓████▄▄\n" +
        "                  ▄▄▓███████▄▄\n" +
        "            ▄▄▄▄▄████████████████▄▄▄\n" +
        "         ▄▄███████████████████████████▄▄\n" +
        "       ▄█████████████████████████████████▄▄\n" +
        "      ▄█████████████████████████████████████▄\n" +
        "     ▄███████████████████████████████████████▄\n" +
        "    ▄██████▒▀                    ▀▓████████████▄\n" +
        "    █████▒▀                    ▓▄▄▄▄▄███████████\n" +
        "   ▄████▀      ®Lindinger      ▀▓████▀▀ ▀▓██████\n" +
        " ▄███████▄                                ▀▓████\n" +
        "▓▓█▀▀ ▀█▓█▄                                 ▀▀██▒\n" +
        "▓▀      ▀▓▒                                    ▀▀\n" +
        "         ▀▀" + RESET);
    Thread.sleep(3000);
    newLine();
  }

  public String asciiLines(){
    return BLUE + "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓" + RESET;
  }

  //**********************************************************
  //********************VARIOUS SOUTS*************************
  //**********************************************************

  public void newLine() {
    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
  }

  public void invalidInput() throws InterruptedException {
    System.out.println("INVALID INPUT");
    Thread.sleep(2000);
    newLine();
  }

}




