class Consumer<in T> {
    fun consumeAny(item: T) {
        println("$item has been consumed")
    }
}


fun main() {
    val stringConsumer = Consumer<String>()

    val anyConsumer: Consumer<Any> = Consumer<Any>()

    stringConsumer.consumeAny("Hello, Kotlin!")
}
