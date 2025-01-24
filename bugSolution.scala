```scala
class MyClass[T](val value: T) {
  def myMethod(other: MyClass[T]): Boolean = {
    value == other.value
  }
}

//solution 1:  Use type parameter bounds to restrict comparison to compatible types
class MyClass2[T](val value: T) {
  def myMethod2[U >: T <: T](other: MyClass2[U]): Boolean = {
     value == other.value
  }
}

val obj1 = new MyClass2(10)
val obj2 = new MyClass2(10) 
println(obj1.myMethod2(obj2))

//solution 2: Implement a more robust comparison method
class MyClass3[T](val value: T)(implicit ev: T => Ordered[T]) {
  def myMethod3(other: MyClass3[T]): Boolean = {
    value compare other.value == 0
  }
}
val obj3 = new MyClass3(10)
val obj4 = new MyClass3(10)
println(obj3.myMethod3(obj4)) 
```