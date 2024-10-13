package com.sprapp.demo

fun String.toSlug() = lowercase().replace(" ", "-")