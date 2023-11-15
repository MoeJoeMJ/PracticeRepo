interface OuterInterface {
    class InnerClass {  // can't use the modifier "inner" inside interface

    }

    interface InnerInterface {

    }
}

class OuterClass {
    inner class InnerClass {
        fun printLocation() = println("From Inner class inside Outer class")
    }

    class InnerClass2 : InnerInterface {
        fun printLocation() = println("From Inner Class 2")
        override fun printGreetings() {

        }
    }

    interface InnerInterface {
        fun printGreetings()
    }
}

fun main() {
    OuterClass().InnerClass().printLocation()  // inner modifier class needs to be called using object
    OuterClass.InnerClass2().printLocation() // class name is suffice to call the
}