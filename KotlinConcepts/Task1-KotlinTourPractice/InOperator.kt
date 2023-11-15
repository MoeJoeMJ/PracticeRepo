fun main() {
    val supported = setOf("HTTP", "HTTPS", "FTP")
    val requested = "smtp"
    val isSupported = requested.uppercase() in supported // Write your code here
    println("Support for $requested: $isSupported")
}