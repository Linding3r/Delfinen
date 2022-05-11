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

  public void introLabel() {
    System.out.println("╔══════════════════════════════════════════════════════════════════╗\n" +
                       "║"+BLUE+"  ██████  ███████ ██      ███████ ██ ███    ██ ███████ ███    ██ "+RESET+" ║\n" +
                       "║"+BLUE+"  ██   ██ ██      ██      ██      ██ ████   ██ ██      ████   ██ "+RESET+" ║\n" +
                       "║"+BLUE+"  ██   ██ █████   ██      █████   ██ ██ ██  ██ █████   ██ ██  ██ "+RESET+" ║\n" +
                       "║"+BLUE+"  ██   ██ ██      ██      ██      ██ ██  ██ ██ ██      ██  ██ ██ "+RESET+" ║\n" +
                       "║"+BLUE+"  ██████  ███████ ███████ ██      ██ ██   ████ ███████ ██   ████ "+RESET+" ║\n" +
                       "╚══════════════════════════════════════════════════════════════════╝");
  }

  public void newLine(){
    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
  }

  public void invalidInput() throws InterruptedException {
    System.out.println("INVALID INPUT");
    Thread.sleep(2000);
    newLine();
  }
}
