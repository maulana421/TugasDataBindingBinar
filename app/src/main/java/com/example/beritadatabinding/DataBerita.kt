package com.example.beritadatabinding

import java.io.Serializable
import java.text.DateFormat
import java.util.*

data class DataBerita(
    val judul : String,
    val tanggal : String,
    val jurnalis : String,
    val img : Int,
    val deskripsi : String

): Serializable