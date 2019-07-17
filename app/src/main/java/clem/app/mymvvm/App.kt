package clem.app.mymvvm

import android.app.Application
import android.content.Context
import android.util.Log
import kotlin.properties.Delegates

/**
 * Created by leon
 * on 2018/3/13 13:35
 */
class App : Application() {

    companion object {
        var CONTEXT: Context by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        CONTEXT = applicationContext
    }
}