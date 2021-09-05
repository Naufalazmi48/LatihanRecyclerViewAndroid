package com.example.submissionandroidpemula.utils

import java.text.NumberFormat
import java.util.*

object CurrencyConverter {
    fun rupiah(value: Int): String {
        val localId = Locale("in", "ID")
        val formatter = NumberFormat.getCurrencyInstance(localId)
        return formatter.format(value)
    }
}