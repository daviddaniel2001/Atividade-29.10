package com.example.atividade_29_10

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TelaPrincipal : AppCompatActivity() {

    private lateinit var textoContador: TextView
    private lateinit var botaoIniciar: Button
    private var contador = 10 // Valor inicial do contador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        // Inicializando as views
        textoContador = findViewById(R.id.textoContador)
        botaoIniciar = findViewById(R.id.botaoIniciar)

        // Configurando o botão de iniciar
        botaoIniciar.setOnClickListener {
            iniciarContagem()
        }
    }

    private fun iniciarContagem() {
        botaoIniciar.isEnabled = false // Desabilita o botão enquanto o contador está rodando
        val handler = Handler(Looper.getMainLooper())

        // Função para decrementar o contador
        fun decrementar() {
            if (contador >= 0) {
                textoContador.text = contador.toString()
                contador--
                if (contador >= 0) {
                    handler.postDelayed({ decrementar() }, 1000) // Aguarda 1 segundo antes de chamar novamente
                } else {
                    botaoIniciar.isEnabled = true // Habilita o botão após o contador terminar
                    contador = 10 // Reseta o valor do contador
                }
            }
        }

        decrementar()
    }
}
