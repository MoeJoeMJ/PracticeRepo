package Classes

abstract class Spice(val name: String, val spiciness: String = "Mild", color: SpiceColor) : SpiceColor by color {
    abstract fun prepareSpice()
}

class Curry(name: String, spiciness: String, color: SpiceColor = YellowSpiceColor) : Spice(name, spiciness, color), Grinder {
    override fun grind() {
    }

    override fun prepareSpice() {
        grind()
    }
}

interface Grinder {
    fun grind()
}

interface SpiceColor {
    val color: String
}

object YellowSpiceColor : SpiceColor {
    override val color = "Yellow"
}

fun main() {
    val curry = Curry("Curry Powder", "Hot", YellowSpiceColor)
    println("Name: ${curry.name}\nSpiciness: ${curry.spiciness}\nColor: ${curry.color}")
}
