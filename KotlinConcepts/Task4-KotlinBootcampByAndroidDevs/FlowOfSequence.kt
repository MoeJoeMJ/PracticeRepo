fun main() {
    val singers = listOf("Elvis","Elton","Prince","Freddie")
    val filtered = singers.map {
        println("current: $it")
        it
    }
    println("This doesn't execute the filter. $filtered")
    println("This doesn't either. ${filtered.first()}")
    println("This doesn't either. ${filtered.last()}")
    println("-----------------")
    println("This does. ${filtered.toList()}")
}

/*
OUTPUT:
This doesn't execute the filter. kotlin.sequences.TransformingSequence@25f38edc
current: Elvis
This doesn't either. Elvis
current: Elvis
current: Elton
current: Prince
current: Freddie
This doesn't either. Freddie
-----------------
current: Elvis
current: Elton
current: Prince
current: Freddie
This does. [Elvis, Elton, Prince, Freddie]
*/
