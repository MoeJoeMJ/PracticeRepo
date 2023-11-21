import kotlin.time.measureTime
import kotlin.time.measureTimedValue

fun main() {
    val timeTaken = measureTime {
        Thread.sleep(100)
    }
    println(timeTaken)

    val (value, newTimeTaken) = measureTimedValue {
        Thread.sleep(100)
        10
    }
    println("value: $value \ntime taken: $timeTaken")

    
}