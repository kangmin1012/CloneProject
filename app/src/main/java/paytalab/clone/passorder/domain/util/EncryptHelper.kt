package paytalab.clone.passorder.domain.util

import android.util.Base64
import java.io.UnsupportedEncodingException
import java.security.InvalidAlgorithmParameterException
import java.security.InvalidKeyException
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*
import javax.crypto.BadPaddingException
import javax.crypto.Cipher
import javax.crypto.IllegalBlockSizeException
import javax.crypto.NoSuchPaddingException
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

class EncryptHelper private constructor() {
    private object EncrpytHelperHolder {
        val INSTANCE = EncryptHelper()
    }

    private fun makePlain(text: String): String {
        val times = Math.floor((text.length / 16).toDouble()).toInt() + 1
        val zeroCount = 16 - text.length % 16
        val builder = StringBuilder()

        // Put Zero String
        builder.append(zeroCount.toString())

        // Put #s
        while (builder.length != 16) builder.append("#")

        // Put raw text
        builder.append(text)

        // Put 0s
        while (builder.length != 16 * (times + 1)) {
            builder.append("0")
        }

        // Example 7###############passorder0000000
        return builder.toString()
    }

    @Throws(
        NoSuchPaddingException::class,
        NoSuchAlgorithmException::class,
        InvalidAlgorithmParameterException::class,
        InvalidKeyException::class,
        UnsupportedEncodingException::class,
        BadPaddingException::class,
        IllegalBlockSizeException::class
    )

    fun encrypt(raw: String?): String? {
        if (raw == null) return raw
        val cipher = Cipher.getInstance("AES/CBC/NoPadding")
        val keySpec = SecretKeySpec(AES_ENCRYPTION_KEY_SHA_BYTES, "AES")
        val ivSpec = IvParameterSpec(INIT_VECTOR_SHA_BYTES)
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec)
        val result = makePlain(raw)
        val results = cipher.doFinal(result.toByteArray(charset("UTF-8")))
        return Base64.encodeToString(results, Base64.DEFAULT)
    }

    companion object {
        fun get(): EncryptHelper {
            return EncrpytHelperHolder.INSTANCE
        }

        private var isInitiated = false
        private const val AES_ENCRYPTION_KEY = "VKDOWHGMDKZOCLDJEKRTQOSNCMVZXXDL"
        private const val INIT_VECTOR = "ZZXOCMDKFFOEQWSA"
        var AES_ENCRYPTION_KEY_SHA_BYTES: ByteArray? = null
        var INIT_VECTOR_SHA_BYTES: ByteArray? = null

        fun init() {
            if (isInitiated) return

            AES_ENCRYPTION_KEY_SHA_BYTES = sha256Encrypt(AES_ENCRYPTION_KEY)
            INIT_VECTOR_SHA_BYTES = sha256Encrypt(INIT_VECTOR)
            INIT_VECTOR_SHA_BYTES = Arrays.copyOfRange(INIT_VECTOR_SHA_BYTES, 0, 16)
            isInitiated = true
        }

        private fun sha256Encrypt(sha: String): ByteArray {
            try {
                // Create MD5 Hash
                val digest = MessageDigest.getInstance("SHA-256")
                digest.update(sha.toByteArray(charset("UTF-8")))
                return digest.digest()
            } catch (e: NoSuchAlgorithmException) {
                e.printStackTrace()
            } catch (e: UnsupportedEncodingException) {
                e.printStackTrace()
            }
            return ByteArray(32)
        }
    }
}