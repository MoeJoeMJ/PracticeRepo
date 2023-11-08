package Functions

import kotlin.random.Random

val rollDice = { Random.nextInt(12) + 1}

val rollDice1 = { sides: Int ->
    if (sides == 0) 0
    else Random.nextInt(sides) + 1
}

val rollDice2: (Int) -> Int = { sides ->
    if (sides == 0) 0
    else Random.nextInt(sides) + 1
}

val gamePlay = {diceRoll: Int -> println(diceRoll)}

fun main() {
    println(rollDice())
    println(rollDice1(6))
    println(rollDice2(0))
    gamePlay(rollDice2(10))
}