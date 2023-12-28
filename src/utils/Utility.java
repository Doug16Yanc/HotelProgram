package utils;

public class Utility {
    public static void printMessage(String message){
        System.out.println("************************************\n");
        System.out.println(message);
        System.out.println("************************************\n");
    }
    public static void printGreen(String message){
        System.out.println("\u001B[32m" + message + "\u001B[0m");
    }
    public static void printRed(String message){
        System.out.println("\u001B[31m" + message + "\u001B[0m");
    }
    public static void printBlue(String message){
        System.out.println("\u001B[34m" + message + "\u001B[0m");
    }
}
