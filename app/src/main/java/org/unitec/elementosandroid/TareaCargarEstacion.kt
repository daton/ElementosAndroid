package org.unitec.elementosandroid

import android.content.Context
import android.os.AsyncTask
import android.widget.TextView
import android.widget.Toast
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.client.RestTemplate

class TareaCargarEstacion(private var ctx: Context?, private var estacion:Estacion?,
                          private var activity: MainActivity?)
    : AsyncTask<Void,Void,Void>() {

    override fun onPostExecute(result: Void?) {

        //Invocamos nuestra vistaa del MainActivity
        activity?.findViewById<TextView>(R.id.txtActual)?.text=estacion?.temp_c




    }

    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun doInBackground(vararg p0: Void?): Void? {
        try {
            var url ="https://api.weatherlink.com/v1/NoaaExt.json?user=001D0A0040AE&pass=Campitos1973&apiToken=8DA86B5995E94BA3BD3EBD811086F906";


            val restTemplate = RestTemplate()
            restTemplate.messageConverters.add(MappingJackson2HttpMessageConverter())


            val maper = ObjectMapper()
            //  usuarios = maper.readValue(estring, object : TypeReference<ArrayList<Usuario>>() {})

            val respuesta = restTemplate.getForObject(url, String::class.java)

             estacion = maper.readValue(respuesta, Estacion::class.java)


            println("DESPUES DE REST");
        } catch (t: Throwable) {

        }
        return null

    }


}