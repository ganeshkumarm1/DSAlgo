package Soundex;

public class Main {
    public static void checkMatch(String name1, String name2, Soundex soundex) {
        String soundex1 = soundex.getSoundex(name1);
        String soundex2 = soundex.getSoundex(name2);

        String result = name1 + " and " + name2 + " are phonetically ";
        if(soundex1.equals(soundex2)) {
            System.out.println(result + "same");
        }
        else {
            System.out.println(result + "different");
        }
    }

    public static void main(String[] args) {
        Soundex soundex = new Soundex();

        checkMatch("bye", "boy", soundex);
        checkMatch("Vicky", "Vikky", soundex);
        checkMatch("Alexander", "Alyxendar", soundex);
        checkMatch("Java", "Jala", soundex);
    }
}
