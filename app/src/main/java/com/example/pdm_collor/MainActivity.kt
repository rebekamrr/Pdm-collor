package com.example.pdm_collor

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var layout: View
    private lateinit var cor: TextView
    private lateinit var red: SeekBar
    private lateinit var green: SeekBar
    private lateinit var blue: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //ids
        this.red = findViewById(R.id.seekRed )
        this.green = findViewById(R.id.seekGreen )
        this.blue = findViewById(R.id.seekBlue )
        this.cor= findViewById(R.id.text)
        this.layout= findViewById(R.id.tview)

        //
        this.red.setOnSeekBarChangeListener(this.OnChange())
        this.green.setOnSeekBarChangeListener(this.OnChange())
        this.blue.setOnSeekBarChangeListener(this.OnChange())

    }

inner class OnChange: SeekBar.OnSeekBarChangeListener {
    private lateinit var layout: View
    private lateinit var cor: TextView

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

        this.cor = findViewById(R.id.text)
        this.layout = findViewById(R.id.tview)

        //gerando as cores
        this.layout.setBackgroundColor(Color.rgb(red.progress, green.progress, blue.progress))

        //convertendo e apresentando na tela de acordo com o progresso
        this.cor.text = String.format("%02X%02X%02X",  red.progress, green.progress, blue.progress)

    }
    override fun onStartTrackingTouch(seekBar: SeekBar?) {}
    override fun onStopTrackingTouch(seekBar: SeekBar?) {}
}
}
