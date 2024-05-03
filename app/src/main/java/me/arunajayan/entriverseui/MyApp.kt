package me.arunajayan.entriverseui

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import java.util.Locale

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        updateResources(this)
    }
    fun updateResources(context: Context): Context {
        var context = context
        val locale = Locale("ml")

        Locale.setDefault(locale)

        val res = context.resources
        val config = Configuration(res.configuration)
        config.setLocale(locale)
        context = context.createConfigurationContext(config)
        return context
    }

}

