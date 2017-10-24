//Filename TextFields.java
//subs DEDivided.java

import java.io.PrintWriter;

public class TextFields {
    PrintWriter pw = new PrintWriter(System.out, true);

  public void intro() {
    pw.println("Welcome to Deadly Encounter!");
    pw.println("Please enter your name >>");
  }

  public void gameStart() {
    pw.println("");
    pw.println("");
    pw.println(".");
    pw.println("..");
    pw.println("...");
    pw.println("You awaken in a dimly lit area of a dark, dank hole in the earth.");
    pw.println("Beside you is a torch set in a nook in the ground");
    pw.println("that casts its light in a small circle.");
    pw.println("Shadows move silently just beyond the glow of your meager light.");
    pw.println("You pick up the torch and consider for a moment what you'll do");
    pw.println("to the bastard that put you here.");
    pw.println("");
    pw.println("");
  }

  
}
