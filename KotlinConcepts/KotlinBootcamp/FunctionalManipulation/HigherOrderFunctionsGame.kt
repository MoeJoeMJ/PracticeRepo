package FunctionalManipulation

import Classes.makeFish

enum class Directions {
    NORTH, SOUTH, EAST, WEST, START, END
}

class Map() {
    private var location = mutableListOf(1, 1)
    fun updateLocation(direction: String?): Boolean {
        val newLocation = location
        when (direction) {
            "n" -> newLocation[0] -= 1
            "e" -> newLocation[1] += 1
            "s" -> newLocation[0] += 1
            "w" -> newLocation[1] -= 1
        }
        if (isInside(newLocation[0], newLocation[1])) {
            location = newLocation
            printLocation()
        }
        else {
            println("LOST!!! You've moved outside the map")
            return false
        }
        return true
    }

    private fun isInside(x: Int, y: Int): Boolean {
        if (x < 1 || x > 5 || y < 1 || y > 5) {
            return false
        }
        return true
    }

    private fun printLocation() {
        println("X: ${location[0]}, Y: ${location[1]}")
    }
}

class Game {
    var path: MutableList<Directions> = mutableListOf(Directions.START)
    val north = { path.add(Directions.NORTH) }
    val south = { path.add(Directions.SOUTH) }
    val east = { path.add(Directions.EAST) }
    val west = { path.add(Directions.WEST) }
    val end = {
        path.add(Directions.END);
        println("Game Over: $path");
        path.clear();
        false
    }

    fun makeMove(direction: String?) {
        when (direction) {
            "n" -> move(north)
            "s" -> move(south)
            "e" -> move(east)
            "w" -> move(west)
            else -> move(end)
        }
    }
}

fun move(where:() -> Boolean) {
    where()
}


fun main(args: Array<String>) {
    val game = Game()
    val map = Map()
    var isValidMove = true
    while(isValidMove) {
        println("Enter a direction: n/s/e/w: ")
        val direction = readlnOrNull()
        isValidMove = map.updateLocation(direction)
        if (isValidMove)
            game.makeMove(direction)
    }
    game.end()
}