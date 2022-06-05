//Strategy Pattern
//In strategy pattern you primarly focus on assignning values dynamically without re-writing a lot code 
//https://pl.kotl.in/jfxX1ctap
fun main() {

    fly(MallardDuck())
    
    fly(RoboDuck())
    
    fly(FLexibleDuck(FlyHigh(), MuteQuak()))
    
    
    quak(MallardDuck())
    
    quak(RoboDuck())
    
    quak(FLexibleDuck(FlyHigh(), MuteQuak()))
    
}

fun fly(duck: Duck) = duck.performFly() 

fun quak(duck: Duck) = duck.perfromQuak()

abstract class Duck(val flayable: Flyable, val quackBehaviour: QuakBehaviour) {
    
    fun performFly() = flayable.fly()
    
    fun perfromQuak() = quackBehaviour.quak()

    abstract fun swim()
}


class MallardDuck : Duck(NoFly(), LoudQuak()){
    
    override fun swim(){
        print("Mallard Duck swims!")
    }
}

class RoboDuck : Duck(NoFly(), MuteQuak()){
    
    override fun swim(){
        print("Robot Duck swims!")
    }
    
}

class FLexibleDuck(val flyable: Flyable, val quakBehaviour: QuakBehaviour): Duck(flyable, quakBehaviour){

     override fun swim(){
        print("FLexibleDuck Duck swims!")
    }
   
}

 
interface Flyable{
    fun fly()
 }
 

class FlyHigh: Flyable{
    override fun fly(){
         print("We fly high!!!!")
     }
 }
 
 class FlyLow: Flyable{
    override fun fly(){
         print("We fly lowwww!!!!")
     }
 }
 
 class NoFly: Flyable{
    override fun fly(){
         print("We don't fly")
     }
 }
 
 
 interface QuakBehaviour{
     fun quak()
 }
 
 
 class MuteQuak: QuakBehaviour{
     override fun quak(){
         print("mute quakkk!!")
     }
 }
 
  class LoudQuak: QuakBehaviour{
     override fun quak(){
         print("loud quakkk!!")
     }
 }