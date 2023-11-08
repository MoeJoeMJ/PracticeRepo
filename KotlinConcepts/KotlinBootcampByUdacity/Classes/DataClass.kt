package Classes

data class SpiceContainer(val label: String,val color: String,var Weight: Int) {}

fun main() {
    val spiceContainer = SpiceContainer("Curry Powder","Red",15)
    val (x,y,z) = spiceContainer  // Decomposition
    println("Name: $x\nColor: $y\nWeight: $z")
}