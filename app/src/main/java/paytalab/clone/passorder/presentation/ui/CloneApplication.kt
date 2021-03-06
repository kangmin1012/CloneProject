package paytalab.clone.passorder.presentation.ui

import android.app.Application
import android.content.Context
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.renderscript.ScriptGroup
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.core.content.ContextCompat
import dagger.hilt.android.HiltAndroidApp
import paytalab.clone.passorder.R
import paytalab.clone.passorder.domain.util.EncryptHelper

@HiltAndroidApp
class CloneApplication : Application() {

    private lateinit var mImm : InputMethodManager

    companion object {
        private lateinit var cloneApplication: CloneApplication
        fun getInstance(): CloneApplication = cloneApplication
    }

    override fun onCreate() {
        super.onCreate()
        cloneApplication = this
        EncryptHelper.init()
        mImm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        // 비밀번호 관련 암호화
//        EncryptHelper.get().encrypt("string")
    }

    fun getInputMethodManager() : InputMethodManager = mImm

    fun setTitleGradient(textView: TextView): Shader {
        val paint = textView.paint

        val width = paint.measureText(textView.text.toString())

        return LinearGradient(
            0f,
            0f,
            width,
            textView.textSize,
            intArrayOf(
                ContextCompat.getColor(this, R.color.point_02),
                Color.parseColor("#ff2d2d")
            ),
            null,
            Shader.TileMode.CLAMP
        )
    }
}