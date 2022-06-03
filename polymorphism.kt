//Polymorphism 
//The eseence of polymorphism here gives us the liberty of writing code thats always closed for modifications 
//but open for extensions. Open and close principle from SOLID principles of software development.
// Link to playground https://pl.kotl.in/cZdJptP9_

fun main() {
    demo(MallardDuck())
    demo(RoboDuck())
}

fun demo(duck : Duck) = duck.quak()


interface Duck{
    fun quak()
}

class MallardDuck : Duck{
    override fun quak(){
        print("Mallard Duck quaks!")
    }
}

class RoboDuck : Duck{
    override fun quak(){
        print("Robot Duck quaks!")
    }
}