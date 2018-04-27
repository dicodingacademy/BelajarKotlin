package com.nbs.belajarkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnHitung.setOnClickListener {
            val p: Double = edtPanjang.text.toString().trim().toDouble()

            val l: Double = edtLebar.text.toString().trim().toDouble()

            Toast.makeText(this, hitungLuas(p, l).toString(), Toast.LENGTH_SHORT).show()
        }
    }

    fun hitungLuas(panjang: Double, lebar: Double) = panjang * lebar
}
