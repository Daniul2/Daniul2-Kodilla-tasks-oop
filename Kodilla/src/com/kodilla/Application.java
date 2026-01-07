package com.kodilla;
// task 1
public class Application {
    public static void main(String[] args) {
        String name = "Adam";
        double age = 20.0;
        double height = 178.0;

        if (name != null) {
            if (age > 30 && height > 160) {
                System.out.println("User is older than 30 and higher then 160cm");
            } else {
                System.out.println("User is younger than 30 or lower than 160cm");
            }
        }
    }
}
