package gisty.support

interface Identifier<T> {
    val value: T
}

abstract class PersistedIdentifier<T>(override val value: T): Identifier<T> {
    override fun equals(obj: Any?): Boolean {
        return when(obj){
            is PersistedIdentifier<*> -> obj.value == value
            else -> false
        }
    }

    override fun hashCode() = 31 * value!!.hashCode()
}

abstract class EmptyIdentifier: Identifier<Nothing> {
    override val value: Nothing
      get() = throw NoSuchElementException()

    override fun equals(obj: Any?): Boolean {
        return when(obj){
            is EmptyIdentifier -> this == obj
            else -> false
        }
    }

    override fun hashCode() = 0
}
