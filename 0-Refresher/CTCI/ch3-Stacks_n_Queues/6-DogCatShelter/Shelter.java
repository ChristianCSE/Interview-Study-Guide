
import java.util.*;

class Shelter {

  LinkedList<Dog> Dogs;
  LinkedList<Cat> Cats;
  int overalTimestamp;

  public Shelter(){
    Dogs = new LinkedList<Dog>();
    Cats = new LinkedList<Cat>();
    overalTimestamp = 0;
  }

  //in case Animal type is sent but not dog or cat
  public void enqueue(Animal animal) {

    if(animal instanceof Dog ) {
      animal.timestamp = overalTimestamp;
      Dogs.addLast((Dog)animal); //not the best way to do this!
      overalTimestamp++;
    } else if(animal instanceof Cat ) {
      animal.timestamp = overalTimestamp;
      Cats.addLast((Cat)animal); //not the best way to do this!
      overalTimestamp++;
    }
  }

  public Animal dequeueAny() {
    //might not have to check timestamps if one is empty!
    if(Dogs.size() == 0){
      return dequeueDog();
    } 
    if(Cats.size() == 0) {
      return dequeueCat();
    }
    //else have to do timestamp comparison
    return (Dogs.peek().timestamp > Cats.peek().timestamp) ? dequeueCat() : dequeueDog();
  }

  public Animal dequeueDog(){
    if(Dogs.size()!=0){
      return Dogs.pollFirst();
    } else{
      return null;
    }
  }

  public Animal dequeueCat(){
    if(Cats.size()!=0){
      return Cats.pollFirst();
    } else {
      return null;
    }
  }

}

//could've just done string type and just used animal
abstract class Animal {
  int timestamp; 
  String name;
  public Animal(String name) {
    //this.timestamp = timestamp; 
    //an animal doesn't come with a timestamp 
    //(that's in the context of being added to the shelter)
    this.name = name;
  }

}



class Dog extends Animal {
  public Dog(String name) {
    super(name);
  }
}


class Cat extends Animal {
  public Cat(String name) {
    super(name);
  }
}