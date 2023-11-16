import kotlin.reflect.KProperty

class Wonders {
    var india: String by Delegate()
}

class Delegate {
    operator fun getValue(wonders: Wonders, property: KProperty<*>): String {
        return "${property.name} has Taj Mahal"
    }

    operator fun setValue(wonders: Wonders, property: KProperty<*>, s: String) {

    }


}
fun main() {
    val wonders = Wonders()
    wonders.india = "Taj Mahal"
    println(wonders.india)
}