package com.example.calculadoradeimc.datasource

import android.annotation.SuppressLint
import androidx.compose.ui.text.font.FontWeight

object Calcularions {
    @SuppressLint("DefaultLocale")
    fun calcularIMC(height: String, weight: String, response: (String, Boolean)->Unit){
        if(height.isNotEmpty() && weight.isNotEmpty()){
            val weightFormatted = weight.replace(",",".").toDoubleOrNull()
            val heightFormatted = weight.toDoubleOrNull()
            if(weightFormatted != null && heightFormatted != null){
                val imc = weightFormatted / (heightFormatted / 100 * heightFormatted / 100)
                val imcFormatted = String.format("%.2f", imc)
                when{
                    imc < 18.5 -> {
                        response("$imcFormatted  Abaixo do peso", false)
                    }
                    imc in 18.5..24.9 -> {
                        response("$imcFormatted  Peso normal", false)
                    }
                    imc in 25.0..29.9 -> {
                        response("$imcFormatted  Sobrepeso", false)

                    }
                    imc in 30.0..34.9 -> {
                        response("$imcFormatted  Obesidade grau I", false)
                    }
                    imc in 35.0..39.9 -> {
                        response("$imcFormatted  Obesidade grau II", false)
                    }
                    else -> {
                        response("$imcFormatted  Obesidade grau III", false)
                    }
                }
            }
        }else{
            response("Preencha todos os campos", true)
        }
    }
}