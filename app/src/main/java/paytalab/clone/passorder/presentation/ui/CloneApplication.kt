package paytalab.clone.passorder.presentation.ui

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import paytalab.clone.passorder.domain.util.EncryptHelper

@HiltAndroidApp
class CloneApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        EncryptHelper.init()

        // 비밀번호 관련 암호화
//        EncryptHelper.get().encrypt("string")
    }
}