fun main() {
    val listOfStrings: List<String?> = listOf("Hi","Hello","Namaste",null)
    for (str in listOfStrings) {
        print("${str?.length?: -1} ")
    }
}