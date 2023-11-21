import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

fun main() {
    val tenMinutes = 10.minutes
    val hundredSeconds = 100.seconds
    val fiftySeconds = 50.seconds

    println("Calculate duration: ${hundredSeconds - fiftySeconds} \n")  // 50s

    println("String representation: ${hundredSeconds.toString(DurationUnit.MINUTES,2)} \n")  // 1.67m

    println("Convert Duration: \n" +
                "${hundredSeconds.inWholeMinutes} \n" +  //  1
                "${hundredSeconds.toDouble(DurationUnit.MINUTES)} \n"  // 1.6666666666666667
    )

    println("Compare duration: ten minutes equals 600 seconds? ${tenMinutes == 600.seconds} \n")  // true

    println("Breaking into components: ${5000.seconds.toComponents{ hours, minutes, seconds, _ -> "${hours}h ${minutes}m ${seconds}s" }}")  // 1h 23m 20s

}