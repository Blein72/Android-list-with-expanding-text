package com.example.nikitadolgopolov.listwithexpandingtext.entity

import com.github.nitrico.lastadapter.StableId

/**
 * Created by nikita.dolgopolov
 * on 31/10/2017.
 */
data class Product(
         val text:String,
         val amount:Double
) :StableId {
    override val stableId: Long
        get() = text.hashCode().toLong()

    fun getAmountString():String = amount.toString()

}