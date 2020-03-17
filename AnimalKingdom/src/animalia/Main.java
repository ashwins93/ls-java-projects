package animalia;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Main {
  private static ArrayList<Animal> list = new ArrayList<>();

  private static ArrayList<Animal> filterList(ArrayList<Animal> source, Predicate<Animal> predicate) {
    list.clear();

    for (Animal animal : source) {
      if (predicate.test(animal)) {
        list.add(animal);
      }
    }

    return list;
  }

  private static void printAnimal(Animal animal) {
    System.out.println("---");
    System.out.println("Name: " + animal.getName());
    System.out.println("Year: " + animal.getYear());
  }

  private static void printAnimalList(ArrayList<Animal> animals) {
    for (Animal animal : animals) {
      printAnimal(animal);
    }
  }

  public static void main(String[] args) {
    ArrayList<Animal> animals = new ArrayList<>(15);

    animals.add(new Mammal("Panda", 1869));
    animals.add(new Mammal("Zebra", 1778));
    animals.add(new Mammal("Koala", 1816));
    animals.add(new Mammal("Sloth", 1804));
    animals.add(new Mammal("Armadillo", 1758));
    animals.add(new Mammal("Raccoon", 1758));
    animals.add(new Mammal("Bigfoot ", 2021));

    animals.add(new Bird("Pigeon", 1837));
    animals.add(new Bird("Peacock", 1821));
    animals.add(new Bird("Toucan", 1758));
    animals.add(new Bird("Parrot", 1824));
    animals.add(new Bird("Swan", 1758));

    animals.add(new Fish("Salmon", 1758));
    animals.add(new Fish("Catfish", 1817));
    animals.add(new Fish("Perch", 1758));

    System.out.println("Year Order");
    animals.sort((a1, a2) -> a2.getYear() - a1.getYear());
    printAnimalList(animals);

    System.out.println("Name Order");
    animals.sort((a1, a2) -> a1.getName().compareToIgnoreCase(a2.getName()));
    printAnimalList(animals);

    System.out.println("Move Order");
    animals.sort((a1, a2) -> a1.move().compareToIgnoreCase(a2.move()));
    printAnimalList(animals);

    System.out.println("Animals with lungs");
    printAnimalList(filterList(animals, animal -> animal.breath().contains("lungs")));

    System.out.println("Animals with lungs and year 1758");
    printAnimalList(filterList(animals, animal -> animal.breath().contains("lungs") && animal.getYear() == 1758));

    System.out.println("Animals with lungs and lay eggs");
    printAnimalList(
        filterList(animals, animal -> animal.breath().contains("lungs") && animal.reproduce().contains("eggs")));

    System.out.println("1758 animals sorted");
    filterList(animals, animal -> animal.getYear() == 1758);
    list.sort((a1, a2) -> a1.getName().compareToIgnoreCase(a2.getName()));
    printAnimalList(list);

    System.out.println("Just mammals");
    filterList(animals, animal -> animal instanceof Mammal);
    list.sort((a1, a2) -> a1.getName().compareToIgnoreCase(a2.getName()));
    printAnimalList(list);
  }
}