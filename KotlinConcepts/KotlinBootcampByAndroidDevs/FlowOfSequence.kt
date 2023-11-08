fun main() {
    val singers = listOf("Elvis","Elton","Prince","Freddie")
    val filtered = singers.asSequence().map {
        println("current: $it")
        it
    }

}