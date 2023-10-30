package com.example.mycalc

import android.os.Bundle
import net.objecthunter.exp4j.ExpressionBuilder
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycalc.ui.theme.MycalcTheme

class main : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MycalcTheme {
                // A surface container using the 'background' color from the theme
                Surface() {
                    CalculatorApp()
                }
            }
        }
    }
}

@Composable
fun CalculatorApp() {
    var calculation by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(text = calculation, fontSize = 34.sp)
        Spacer(modifier = Modifier.height(16.dp))

        Row {
            CalculatorButton(
                text = "1",
                onClick = { calculation += "1" }
            )
            CalculatorButton(
                text = "2",
                onClick = { calculation += "2" }
            )
            CalculatorButton(
                text = "3",
                onClick = { calculation += "3" }
            )
            CalculatorButton(
                text = "+",
                onClick = { calculation += "+" }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            CalculatorButton(
                text = "4",
                onClick = { calculation += "4" }
            )
            CalculatorButton(
                text = "5",
                onClick = { calculation += "5" }
            )
            CalculatorButton(
                text = "6",
                onClick = { calculation += "6" }
            )
            CalculatorButton(
                text = "-",
                onClick = { calculation += "-" }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            CalculatorButton(
                text = "7",
                onClick = { calculation += "7" }
            )
            CalculatorButton(
                text = "8",
                onClick = { calculation += "8" }
            )
            CalculatorButton(
                text = "9",
                onClick = { calculation += "9" }
            )
            CalculatorButton(
                text = "*",
                onClick = { calculation += "*" }
            )

        }

        Spacer(modifier = Modifier.height(16.dp))

        Row {
                CalculatorButton(
                    text = "0",
                    onClick = { calculation += "0" }
                )
            CalculatorButton(
                text = "=",
                onClick = { calculation = evaluate(calculation) }
            )
            CalculatorButton(
                text = "C",
                onClick = { calculation = "" }
            )
            CalculatorButton(
                text = "/",
                onClick = { calculation += "/" }
            )
        }
    }
}

@Composable
fun CalculatorButton(text: String, onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .padding(8.dp)
            .size(80.dp),
        onClick = onClick
    ) {
        Text(text = text)
    }
}

fun evaluate(calculation: String): String {

    return try {
        val result = ExpressionBuilder(calculation).build().evaluate().toString()
        result
    } catch (e: Exception) {
        "Error"
    }
}