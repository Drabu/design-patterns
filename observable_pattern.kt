// https://pl.kotl.in/EMC0YAZ2Z

/** Observalbe Pattern */
fun main() {
    val userOne = User("John Doe", "Joe")

    userOne.observe { it -> print(it) }

    userOne.setNickName("John")
    userOne.setNickName("Wick")
}

class User(private var fullName: String, private var nickName: String) : Subject<User> {

    fun setFullName(fullName: String) {
        this.fullName = fullName
        notifyObservers()
    }

    fun setNickName(nickName: String) {
        this.nickName = nickName
        notifyObservers()
    }

    override fun toString() = "NickName : $nickName FullName : $fullName"

    // Obervable Pattern Contents
    private val observers: ArrayList<Observalbe<User>> = ArrayList()

    override fun observe(observer: Observalbe<User>) = observers.add(observer)

    override fun removeObserver(observer: Observalbe<User>) = observers.remove(observer)

    override fun notifyObservers() {
        for (observer in observers) observer.update(this)
    }
}

interface Subject<T> {
    fun observe(observer: Observalbe<T>): Boolean
    fun removeObserver(observer: Observalbe<T>): Boolean
    fun notifyObservers()
}

fun interface Observalbe<T> {
    fun update(any: T)
}
