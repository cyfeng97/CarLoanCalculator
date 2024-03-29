package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            calculateRepayment()
        }
    }

    private fun calculateRepayment() {
        //TODO get inputs and show outputs
        if(editTextCarPrice.text.isEmpty()){
            editTextCarPrice.setError(getString(R.string.error_input))
            return
        }
        val carPrice: Int = editTextCarPrice.text.toString().toInt()
        val downPayment: Int = editTextDownPayment.text.toString().toInt()
        val loan = carPrice - downPayment

        textViewLoan.setText(getString(R.string.loan) + "${loan}")

        val interestRate: Float = editTextInterestate.text.toString().toFloat()
        val loanPeriod: Int = editTextLoanPeriod.text.toString().toInt()
        val interest = loan * interestRate/100 * loanPeriod

        textViewInterest.setText(getString(R.string.interest) + "${interest}")

        val monthlyRepayment = (loan + interest) / loanPeriod / 12

        textViewMonthlyRepayment.setText(getString(R.string.monthly_repayment) + "${monthlyRepayment}")
    }

    fun reset(view : View){
        //TODO clear all inputs and output
        editTextCarPrice.setText("")
        editTextDownPayment.setText("")
        editTextInterestate.setText("")
        editTextLoanPeriod.setText("")
        textViewLoan.setText(getString(R.string.loan))
        textViewInterest.setText(getString(R.string.interest))
        textViewMonthlyRepayment.setText(getString(R.string.monthly_repayment))

    }
}
