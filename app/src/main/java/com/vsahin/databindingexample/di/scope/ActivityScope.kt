package com.vsahin.databindingexample.di.scope

import javax.inject.Scope
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope

