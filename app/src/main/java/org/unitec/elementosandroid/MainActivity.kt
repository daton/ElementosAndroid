package org.unitec.elementosandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
///////
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    var estacion=Estacion();
       TareaCargarEstacion(applicationContext,estacion,this)
           .execute(null,null,null)
    }
}
