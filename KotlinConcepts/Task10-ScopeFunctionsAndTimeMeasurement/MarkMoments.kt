import kotlin.time.TimeSource

fun main() {
    val timeSource = TimeSource.Monotonic
    val mark1 = timeSource.markNow()
    Thread.sleep(300)
    val mark2 = timeSource.markNow()
    println(mark2 - mark1)  // outputs around 300ms
}