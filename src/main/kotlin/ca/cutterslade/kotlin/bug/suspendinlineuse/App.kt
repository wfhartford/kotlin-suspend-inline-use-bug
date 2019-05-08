package ca.cutterslade.kotlin.bug.suspendinlineuse

import kotlinx.coroutines.runBlocking

class CloseableThing : AutoCloseable {
  override fun close() = Unit
}

fun main() {
  runBlocking {
    CloseableThing().doSomethingAndClose(::something)
  }
}

suspend fun something(thing: CloseableThing) {
  println(thing)
}

suspend inline fun CloseableThing.doSomethingAndClose(
    something: suspend (CloseableThing) -> Unit
): Unit = use { something(this) }
