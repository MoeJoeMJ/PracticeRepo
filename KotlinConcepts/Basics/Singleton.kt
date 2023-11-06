object ObjectSingleton {
    var num: Int = 10
    fun incrementNum() {
        print(++num)
    }
}

fun main() {
    println(ObjectSingleton.num)
    ObjectSingleton.incrementNum()
}