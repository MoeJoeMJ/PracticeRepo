open class WaterSupply(var isClean: Boolean)

class TapWater : WaterSupply(false) {
    fun addChemicalCleaner() {
        isClean = true
        println("Tap Water is cleaned")
    }
}

class ShopWater : WaterSupply(true)

class Aquarium<out T: WaterSupply>(val waterSupply: T) {
    fun addWater(cleaner: WaterCleaner<T>) {
        if (!waterSupply.isClean) {
            cleaner.clean(waterSupply)
        }
        println("Water successfully added")
    }
}

interface WaterCleaner<in T: WaterSupply> {
    fun clean(waterSupply: T)
}

class TapWaterCleaner(): WaterCleaner<TapWater> {
    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaner()
    }

}
fun addItem(aquarium: Aquarium<WaterSupply>) {
    println("Item added")
}


fun main() {
    val tapWater = TapWater()
    val aquarium = Aquarium(tapWater)
    addItem(aquarium)
    val cleaner = TapWaterCleaner()
    aquarium.addWater(cleaner)
}

/*
Output:
Item added
Tap Water is cleaned
Water successfully added
*/
