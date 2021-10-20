package com.module.base.ktdemo

/**
 *
 * @author  Shenhui
 * @version 1.0
 * @since   2021/9/5  21:11
 */
@Target(AnnotationTarget.CLASS,
        AnnotationTarget.FUNCTION,
        AnnotationTarget.FIELD,
        AnnotationTarget.EXPRESSION,
        AnnotationTarget.TYPE,
        AnnotationTarget.LOCAL_VARIABLE,
        AnnotationTarget.TYPEALIAS,
        AnnotationTarget.TYPE_PARAMETER,
        AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.SOURCE)
@Repeatable
annotation class MagicClass