package org.unitec.elementosandroid

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Estacion {

    var temp_c:String?=null
}