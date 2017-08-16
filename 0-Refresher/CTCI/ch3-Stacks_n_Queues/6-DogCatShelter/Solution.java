


class Solution {

  public static void main(String[] args) {
    //dequeueAny, dequeueDog, dequeueCat, enqueue
    Shelter shelter = new Shelter();
    shelter.enqueue(new Cat("Cat-A"));
    shelter.enqueue(new Dog("Dog-A"));
    shelter.enqueue(new Cat("Cat-B"));
    shelter.enqueue(new Cat("Cat-C"));
    shelter.enqueue(new Cat("Cat-D"));
    shelter.enqueue(new Cat("Cat-E"));

    
    shelter.enqueue(new Dog("Dog-B"));
    shelter.enqueue(new Dog("Dog-C"));
    shelter.enqueue(new Dog("Dog-D"));
    shelter.enqueue(new Dog("Dog-E"));

    System.out.println(shelter.dequeueAny().name);
    System.out.println(shelter.dequeueAny().name);
    System.out.println(shelter.dequeueDog().name);


  }
}