/**
 * Created by xuwei on 2018/1/24.
 */

fun main(args: Array<String>) {
    println("..")
    val print = fun(x : Int) { println(x)}
    listOf(1,2,3,4).forEach(print)

    val oddLength = compose(::isOdd, ::length)
    val strings = listOf("a", "ab", "abc", "abcd")
    println(strings.filter(oddLength))

    println(curryAdd(1)(2))

    println(facorial(10))

    println(curryAdd3(1)(2))

    println(double(2))


    val sum = fun Int.(other: Int):Int = this+other
    println(1.sum(2))

    val PI = 3.14

    val s = "a is $PI"
    println(s)

    val items = setOf("orange", "apple", "banana", "kiwi")
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }

    val fruits = listOf("banana", "avocado", "apple", "kiwi")
    fruits.filter{ it.startsWith("a")}.sortedBy { it }.map { it.toUpperCase() }.forEach { println(it) }

    val myFruits = fruits.filter { s -> s.length > 5 }
    myFruits.forEach { println(it) }

    val c  = '1'
    for (c in '1'..'3') {
        println(c)
    }

    val x = 1

    when (x) {
        1 -> print("x == 1")
        2 -> print("x == 2")
        else -> { // Note the block
            print("x is neither 1 nor 2")
        }
    }

    Constructors(1)


}

fun isOdd(x : Int) = x % 2 != 0
fun length(s : String) = s.length
fun <A,B,C> compose(f: (B)->C, g: (A)-> B) : (A) -> (C) { return {x -> f(g(x))}}

fun curryAdd(x: Int) : (Int) -> Int {return {y -> x+y}}
fun curryAdd3(x: Int) : (y: Int)  -> Int { return { z->x+z } }

fun facorial(n : Int) : Int {
    if (n == 0) return 1
    return n * facorial(n-1)
}

fun double(x: Int): Int {
    return x+x
}

fun triple(double: (Int) -> Int): (Int) -> Int {
    return {x -> double(x) + x}
}



fun firstCoroutineDemo0() {

}

class Constructors {
    init {
        println("Init block")
    }

    constructor(i: Int) {
        println("constructor")
    }
}

interface MyInterface {
    fun bar()
    fun foo() {
        // optional body
    }
}

class Child : MyInterface {
    override fun bar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        println("bar")
    }

}

infix fun Int.shl(x : Int) : Int {
    return x.shl(x)
}
