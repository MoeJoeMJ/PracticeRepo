package KotlinEssentials

open class BaseBuildingMaterial(val numerNeeded: Int = 1)

class Wood : BaseBuildingMaterial(4)

class Brick : BaseBuildingMaterial(8)

class Building<T : BaseBuildingMaterial>(val buildingMaterial: T) {
    val baseMaterialsNeeded: Int = 100
    val actualMaterialsNeeded: Int = buildingMaterial.numerNeeded * baseMaterialsNeeded

    fun build() {
        println("$actualMaterialsNeeded ${buildingMaterial::class.simpleName} needed")
    }
}

fun <T: BaseBuildingMaterial> isSmallBuilding(building: Building<T>) {
    if(building.actualMaterialsNeeded < 500 ) {
        println("Small building")
    } else {
        println("Large Building")
    }
}

fun main(args: Array<String>) {
    val wood = Wood()
    val building = Building(wood)
    building.build()
    isSmallBuilding(building)
}
