package tads.eaj.ufrn.imc

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MandaDadosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manda_dados)



    }

    fun mandaDados(v:View){
        val intent = Intent()
        val ediTextValor:EditText = findViewById(R.id.editTextValor)
        intent.putExtra("DADOS",ediTextValor.text.toString())
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
    fun doFechar(v:View){
        finish()
    }


}