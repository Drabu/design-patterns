/** Observalbe Pattern Playground link: https://pl.kotl.in/MURis5Y_Q */
fun main() {
    val observableData = ObservableData<String>()

    observableData.observe { it -> print(it) }

    observableData.postValue("test 1")

    observableData.postValue("test 2")
}

class ObservableData<T : Any> : Subject<T> {

    private var any = kotlin.Any()

    private val observers: ArrayList<Observalbe<T>> = ArrayList()

    override fun observe(observer: Observalbe<T>) = observers.add(observer)

    override fun removeObserver(observer: Observalbe<T>) = observers.remove(observer)

    fun postValue(t: T) {
        any = t
        notifyObservers()
    }

    override fun notifyObservers() {
        for (observer in observers) observer.update(any as T)
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
