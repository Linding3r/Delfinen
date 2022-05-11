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

  public void dolphinLogo() throws InterruptedException {
    System.out.println(BLUE+"\n\n                   YAao,\n" +
        "                    Y8888b,\n" +
        "                  ,oA8888888b,\n" +
        "            ,aaad8888888888888888bo,\n" +
        "         ,d888888888888888888888888888b,\n" +
        "       ,888888888888888888888888888888888b,\n" +
        "      d8888888888888888888888888888888888888,\n" +
        "     d888888888888888888888888888888888888888b\n" +
        "    d888888P'                    `Y888888888888,\n" +
        "    88888P'                    Ybaaaa8888888888l\n" +
        "   a8888'                      `Y8888P' `V888888\n" +
        " d8888888a                                `Y8888\n" +
        "AY/'' `\\Y8b                                 ``Y8b\n" +
        "Y'      `YP                                    ~~\n" +
        "         `'"+RESET);
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

  public void dolphinNew() throws InterruptedException {
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
        "   ▄████▀                      ▀▓████▀▀ ▀▓██████\n" +
        " ▄███████▄                                ▀▓████\n" +
        "▓▓█▀▀ ▀█▓█▄                                 ▀▀██▒\n" +
        "▓▀      ▀▓▒                                    ▀▀\n" +
        "         ▀▀"+RESET);
    Thread.sleep(3000);
    newLine();
  }
}
