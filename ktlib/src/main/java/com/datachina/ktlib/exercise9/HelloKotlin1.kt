package com.datachina.ktlib.exercise9

/**
 * 注解 (annotation)
 * meta-annotation (元注解)
 */

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER,
        AnnotationTarget.EXPRESSION, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.PROPERTY_SETTER,
        AnnotationTarget.PROPERTY_GETTER,
        AnnotationTarget.FIELD)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
annotation class MyAnnotation

@MyAnnotation
class MyClass {

    @MyAnnotation
    fun myMethod(@MyAnnotation a: Int): Int {
        return (@MyAnnotation 10)
    }
}

class MyClass2 @MyAnnotation constructor(a: Int)

class MyClass3 {
    var a: Int? = null
        @MyAnnotation set
}
