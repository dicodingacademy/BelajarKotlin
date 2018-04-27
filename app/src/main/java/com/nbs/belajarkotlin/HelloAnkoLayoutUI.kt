package com.nbs.belajarkotlin

import android.view.Gravity
import org.jetbrains.anko.*

class HelloAnkoLayoutUI: AnkoComponent<HelloAnkoLayoutActivity>{
    override fun createView(ui: AnkoContext<HelloAnkoLayoutActivity>) = with(ui) {
        verticalLayout {
            imageView(R.drawable.img_mu) {
                id = R.id.imgClubLogo
            }.lparams(width = dip(100), height = dip(100)){
                margin = dip(16)
                gravity = Gravity.CENTER
            }

            editText {
                id = R.id.edtName
                hint = "Ketik apa aja disini"
            }.lparams(width = matchParent, height = wrapContent){
                leftMargin = dip(16)
                rightMargin = dip(16)
                bottomMargin = dip(16)
            }

            button {
                id = R.id.btnTest
                text = "Klik dong bos!"
            }.lparams(width = matchParent, height = wrapContent){
                leftMargin = dip(16)
                rightMargin = dip(16)
            }
        }
    }

}