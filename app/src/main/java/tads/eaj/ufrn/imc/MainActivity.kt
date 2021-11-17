package tads.eaj.ufrn.imc

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonAltura:Button = findViewById(R.id.buttonAltura)
        buttonAltura.setOnClickListener {
            val intent = Intent(this,MandaDadosActivity::class.java)
            startActivity(intent)
        }
        val buttonPeso:Button = findViewById(R.id.buttonPeso)
        buttonPeso.setOnClickListener {
            val intent = Intent(this,MandaDadosActivity::class.java)
            startActivity(intent)
        }

        val buttonCalcular = findViewById<Button>(R.id.buttonCalcular)
        buttonCalcular.setOnClickListener {
            val textViewAltura:TextView = findViewById(R.id.textViewAltura)
            val textViewPeso:TextView = findViewById(R.id.textViewPeso)
            calcularIMC(textViewAltura.text.toString(),textViewPeso.text.toString())
        }
    }
    fun calcularIMC(altura:String, peso:String){
        val altura = altura.toFloatOrNull()
        val peso = peso.toFloatOrNull()
        val textViewInformacao:TextView = findViewById(R.id.textViewInformacao)
        val textViewResultado:TextView = findViewById(R.id.textViewResultado)
        val informacaoResultado = arrayOf(
            "Magreza Grave",
            "Magreza Moderada",
            "Magreza Leve",
            "Saudável",
            "Sobrepeso",
            "Obesidade Grau I",
            "Obesidade Grau II (severa)",
            "Obesidade Grau III (mórbida)"
        )
        if (altura != null && peso != null) {
            val imc = peso / (altura*altura)
            textViewResultado.text = "O seu IMC é de %.2f".format(imc)
            if (imc<16) {textViewInformacao.text = informacaoResultado[0]}
            else if (imc>=16 && imc<17) {textViewInformacao.text = informacaoResultado[1]}
            else if (imc>=17 && imc<18.5) {textViewInformacao.text = informacaoResultado[2]}
            else if (imc>=18.5 && imc<25) {textViewInformacao.text = informacaoResultado[3]}
            else if (imc>=25 && imc<30) {textViewInformacao.text = informacaoResultado[4]}
            else if (imc>=30 && imc<35) {textViewInformacao.text = informacaoResultado[5]}
            else if (imc>=35 && imc<40) {textViewInformacao.text = informacaoResultado[6]}
            else if (imc>=40) {textViewInformacao.text = informacaoResultado[7]}

        }else{
            Toast.makeText(this@MainActivity, "Digite um valor Válido!", Toast.LENGTH_SHORT).show()
        }
    }
}

