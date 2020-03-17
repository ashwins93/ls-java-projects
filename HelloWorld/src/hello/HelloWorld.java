package hello;

public class HelloWorld {
  public static void main(String[] args) {
    Greeter greeter = new Greeter();

    String greeting = greeter.greet("World");

    System.out.println(greeting);
  }
}