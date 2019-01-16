package ru.ponomaryov.se.hellobye;

public class HelloBye {

    public static void main(String[] args) {
        hello("Artem");
    }

    private static void hello(String name) {
        display("Hello, " + name + "!");
        bye(name);
    }

    private static void bye(String name) {
        display("Good bye, " + name + "!");
    }

    private static void display(String text) {
        System.out.println(text);
    }

}
