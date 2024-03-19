package Feb1;

public class TestEdibleTodo {
  public static void main(String[] args) {
    Object[] objects = { new Tiger(), new Chicken(), new Apple(), new Orange() };
    for (int i = 0; i < objects.length; i++) {
      if (objects[i] instanceof Animal) {
        System.out.println(((Animal) objects[i]).sound());
      }
      if (objects[i] instanceof Edible) {
        System.out.println(((Edible) objects[i]).howToEat());
      }
    }
  }

}

abstract class Animal {
  /** Return animal sound */
  public abstract String sound();
}

class Chicken extends Animal implements Edible {
  @Override
  public String howToEat() {
    return "Chicken: Fry it";
  }

  @Override
  public String sound() {
    return "Chicken: cock-a-doodle-doo";
  }
}

class Tiger extends Animal {
  @Override
  public String sound() {
    return "Tiger: RROOAARR";
  }
}

abstract class Fruit implements Edible {
  // Data fields, constructors, and methods omitted here
}

class Orange extends Fruit {
  Orange() {
  }

  @Override
  public String howToEat() {
    return "Orange: Remove the peel, then take out the slices and eat them one by one";
  }
}

class Apple extends Fruit {
  Apple() {
  }

  @Override
  public String howToEat() {
    return "Apple: Bite into it";
  }
}