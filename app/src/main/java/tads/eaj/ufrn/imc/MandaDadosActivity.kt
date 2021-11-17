package tads.eaj.ufrn.imc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MandaDadosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manda_dados)


    }

    fun doFechar(v:View){
        finish()
    }
}