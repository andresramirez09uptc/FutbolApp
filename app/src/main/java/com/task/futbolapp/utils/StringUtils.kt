package com.task.futbolapp.utils

fun String.getIdFromUrl(): Int? =
    this.split("/").lastOrNull()?.toIntOrNull()
