// Decorator Patern
// https://pl.kotl.in/h1AIwrE77

fun main() {

    var myStyleOfBrew: Bewrage = DarkRoast()
    println(myStyleOfBrew.cost())
    myStyleOfBrew = Moca(myStyleOfBrew)
    myStyleOfBrew = Moca(myStyleOfBrew)
    myStyleOfBrew = Whip(myStyleOfBrew)

    println(myStyleOfBrew.cost())
}

class Moca(brew: Bewrage) : Contindment(brew) {
    override fun cost() = bewrage.cost() + 1
}

class Whip(brew: Bewrage) : Contindment(brew) {
    override fun cost() = bewrage.cost() + 9
}

abstract class Contindment(val bewrage: Bewrage) : Bewrage()

abstract class Bewrage {
    private val description: String = "Unknown description"
    fun getDescription() = description
    abstract fun cost(): Int
}

class HouseBlend : Bewrage() {
    override fun cost() = 22
}

class DarkRoast : Bewrage() {
    override fun cost() = 7
}

class Decaf : Bewrage() {
    override fun cost() = 10
}

class Espresso : Bewrage() {
    override fun cost() = 12
}
