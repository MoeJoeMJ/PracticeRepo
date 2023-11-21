fun main() {
    val numbers = (1..10).toList()
    println("Chunked: ${numbers.chunked(3)}")
    println("Windowed: ${numbers.windowed(3)}")
    println("Step 2 partial window: ${numbers.windowed(3, step = 2, partialWindows = true)}")
    println("Window summed: ${numbers.windowed(3) { it.sum() }}")
}

/*
Output:
    Chunked: [[1, 2, 3], [4, 5, 6], [7, 8, 9], [10]]
    Windowed: [[1, 2, 3], [2, 3, 4], [3, 4, 5], [4, 5, 6], [5, 6, 7], [6, 7, 8], [7, 8, 9], [8, 9, 10]]
    Step 2 partial window: [[1, 2, 3], [3, 4, 5], [5, 6, 7], [7, 8, 9], [9, 10]]
    Window summed: [6, 9, 12, 15, 18, 21, 24, 27]
*/
