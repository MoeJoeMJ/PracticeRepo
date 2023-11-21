package Classes

import Functions.dayOfWeek

abstract class AquariumFish {
    abstract val color: String
}
class Shark: AquariumFish(), FishAction {
    override val color = "gray"
    override fun eat() {
        println("hunt and eat fish")
    }
}

class Plecostomus: AquariumFish(), FishAction {
    override val color = "gold"
    override fun eat() {
        println("much on algae")
    }
}

class Dolphin {

}

interface FishAction {
    fun eat()
}

fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()
    val dolphin = Dolphin()

    print("Shark is ${shark.color}, they ")
    feedFish(shark)
    print("Pleco is ${pleco.color}, they ")
    feedFish(pleco)
//  feedFish(dolphin) ---> Throws type mismatched
}

fun feedFish(fish: FishAction) {
    fish.eat()
}

fun main() {
    makeFish()
}