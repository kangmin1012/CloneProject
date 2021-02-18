package paytalab.clone.passorder.domain.util

import android.content.Context
import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowInsetsController
import android.widget.Toast

fun Context.showToast(message : String){
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}

fun Window.setStatusBarIcon(){
    this.apply {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            setDecorFitsSystemWindows(false)
            val controller = insetsController
            controller?.setSystemBarsAppearance(
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
                WindowInsetsController.APPEARANCE_LIGHT_NAVIGATION_BARS
            )
        }
        else{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
        }
    }
}