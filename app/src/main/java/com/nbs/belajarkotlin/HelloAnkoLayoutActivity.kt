package com.nbs.belajarkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import org.jetbrains.anko.*

class HelloAnkoLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        HelloAnkoLayoutUI().setContentView(this)

        val btnTest = find<Button>(R.id.btnTest)

        val edtTest = find<EditText>(R.id.edtName)

        btnTest.setOnClickListener {
            alert("Halo tamvan ${edtTest.text.toString().trim()}") {
                yesButton {
                    it.cancel()
                }

                noButton {
                    toast("Tutup App")
                    finish()

                }
            }.show()
        }
    }
}
