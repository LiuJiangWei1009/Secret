package com.jayce.vexis.base

import android.app.Application
import android.content.IntentFilter
import android.graphics.Typeface
import android.util.Log
import com.creezen.tool.AndroidTool
import com.creezen.tool.BaseTool
import com.creezen.tool.BaseTool.setFont
import com.creezen.tool.Constant.BROAD_LOGOUT
import com.creezen.tool.Constant.BROAD_NOTIFY
import com.jayce.vexis.GlobalReceiver

class Env: Application() {

    private val globalReceiver = GlobalReceiver()

    private val filter = IntentFilter().apply {
        addAction(BROAD_LOGOUT)
        addAction(BROAD_NOTIFY)
    }

    override fun onCreate() {
        super.onCreate()
        BaseTool.register(applicationContext)

        val font = AndroidTool.readPrefs {
            it.getString("font", "华文行楷")
        }
        setFont(font as String)
        registerReceiver(globalReceiver, filter, RECEIVER_NOT_EXPORTED)
    }
}