```scala
class MyClass[T](val value: T) {
  def myMethod(other: MyClass[T]): Boolean = {
    value == other.value
  }
}

val obj1 = new MyClass(10)
val obj2 = new MyClass(10.0)

println(obj1.myMethod(obj2)) //This will compile but may not work as expected depending on the use case
```