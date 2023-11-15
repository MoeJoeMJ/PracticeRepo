fun main() {
    var pizzaSlices = 0
    // Start refactoring here
    while(pizzaSlices < 7) {
        pizzaSlices++
        println("There's only $pizzaSlices number of pizza slices")
    }
    pizzaSlices++
    // End refactoring here
    println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
}