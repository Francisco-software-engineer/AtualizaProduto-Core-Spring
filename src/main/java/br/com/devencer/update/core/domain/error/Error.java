package br.com.devencer.update.core.domain.error;

public class Error {
  public static void emptyUpdateTable(String param) {
    //"Error: Empty source/update table - Nothing to update."
    throw new CoreError(param + " - Nothing to update.");
  }

  public static void emptyAddTable(String param) {
    //"Error: Empty source/update table - Nothing to add."
    throw new CoreError(param + " - Nothing to add.");
  }

}
