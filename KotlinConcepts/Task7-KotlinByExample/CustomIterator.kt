class Animal(val name: String)

class Forest(val animals: List<Animal>)

class Zoo() {
    operator fun iterator(): Iterator<Animal> {
        val forest = Forest(listOf(Animal("Lion"), Animal("Tiger"), Animal("Giraffe")))
        return forest.animals.iterator()
    }
}

fun main() {
    val zoo = Zoo()
    for (animal in zoo) {
        println(animal.name)
    }
}