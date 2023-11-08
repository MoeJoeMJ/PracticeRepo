package KotlinEssentials

import kotlin.random.Random

class Note(val title: String,var pages: Int){}

class Puppy {
    fun playWithNote(note: Note) {
        note.pages = note.tornPages(Random.nextInt(20))
    }
}

fun Note.getWeight(pages: Int): Double = pages * 1.5

fun Note.tornPages(tornPages: Int) : Int = if(tornPages < pages) pages - tornPages else 0

fun main() {
    val note = Note("Effective",100)
    println("Weight of the note: ${note.getWeight(note.pages)}")
    val puppy = Puppy()
    while (note.pages > 0) {
        puppy.playWithNote(note)
        println("Pages left in the note: ${note.pages}")
    }
    println(note.getWeight(note.pages))
}