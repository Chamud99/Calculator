package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.Locale
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        val cost = binding.costOfService.text.toString().toDouble()
        val selectedId = binding.tipOptions.checkedRadioButtonId
        val tipPercentage = when(selectedId) {
            R.id.option_twenty_present -> 0.2
            R.id.option_fifteen_present -> 0.15
            else -> 0.1
        }
          var tip = cost*tipPercentage
        var roundUp = binding.roundTip.isChecked
        if (roundUp) {
            tip = ceil(tip)
        }
        val locale = Locale("si","LK")
        val currencyTip = NumberFormat.getCurrencyInstance(locale).format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, currencyTip)
    }


    }
