package com.company;

public class Ui {
  public final String BLUE = "\u001B[34m";
  public final String RESET = "\u001B[0m";


  public void mainMenu() {
    System.out.println("""
        ╔════════════════════════════════╗
        ║              MENU              ║
        ╠════════════════════════════════╣
        ║   1:  Tilføj Ny Medlem         ║
        ║   2:  Liste Af Medlemer        ║
        ║   9:  SHUTDOWN                 ║
        ╚════════════════════════════════╝
        """);
  }

  public void introLabel() throws InterruptedException {
    System.out.println("╔══════════════════════════════════════════════════════════════════╗\n" +
                       "║"+BLUE+"  ██████  ███████ ██      ███████ ██ ███    ██ ███████ ███    ██ "+RESET+" ║\n" +
                       "║"+BLUE+"  ██   ██ ██      ██      ██      ██ ████   ██ ██      ████   ██ "+RESET+" ║\n" +
                       "║"+BLUE+"  ██   ██ █████   ██      █████   ██ ██ ██  ██ █████   ██ ██  ██ "+RESET+" ║\n" +
                       "║"+BLUE+"  ██   ██ ██      ██      ██      ██ ██  ██ ██ ██      ██  ██ ██ "+RESET+" ║\n" +
                       "║"+BLUE+"  ██████  ███████ ███████ ██      ██ ██   ████ ███████ ██   ████ "+RESET+" ║\n" +
                       "╚══════════════════════════════════════════════════════════════════╝");
    Thread.sleep(3000);
    newLine();
  }


  public void newLine(){
    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
  }

  public void invalidInput() throws InterruptedException {
    System.out.println("INVALID INPUT");
    Thread.sleep(2000);
    newLine();
  }

  public String activePassiveChoice(){
    return """
        ╔════════════════╗
        ║      Vælg:     ║
        ╠════════════════╣
        ║  1:  Aktiv     ║
        ║  2:  Passiv    ║
        ╚════════════════╝
        """;
  }

  public String compNonCompChoice(){
    return """
        ╔═════════════════════════╗
        ║          Vælg:          ║
        ╠═════════════════════════╣
        ║  1:  Konkurrencesvømmer ║
        ║  2:  Motionssvømmer     ║
        ╚═════════════════════════╝
        """;
  }

  public void dolphinLogo() throws InterruptedException {
    System.out.println(BLUE+"\n\n                   ▓█▄▄▄\n" +
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
        "         ▀▀"+RESET);
    Thread.sleep(3000);
    newLine();
  }
}
