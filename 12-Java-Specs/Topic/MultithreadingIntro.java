
class MultithreadingIntro{


 public static void main(String[] args){
  int n = 8; 
  for(int i = 0; i < 8; i++){
   Multithreading obj = new Multithreading();
   obj.start();
  }
  System.out.println("========");
  for(int i = 0; i < 8; i++){
   Thread objs = new Thread(new Multithreader());
   objs.start();
  }
 }
}
//can no longer extend (multi-inheritance isn't allowed)
class Multithreading extends Thread {
 public void run(){
  try{
   System.out.println("Thread " + 
    Thread.currentThread().getId() + " is running");
  } catch (Exception e){
   System.out.println("Exception caught");
  }
 }
}

//or create new class and IMPLEMENT (multiple extends aka
//multi-inheritance isn't allowed) Runnable interface and OVERRIDE run()
//Have to now instantiate a Thread obj 

class Multithreader implements Runnable {
 public void run(){
  try{
   System.out.println("Thread "+ Thread.currentThread().getId() + " is running");
  } catch(Exception e){
   System.out.println("Exception caught");
  }
 }
}
