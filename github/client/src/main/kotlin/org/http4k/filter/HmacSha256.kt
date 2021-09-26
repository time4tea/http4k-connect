package org.http4k.filter

import org.http4k.util.Hex
import java.security.MessageDigest
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

object HmacSha256 {

    fun hash(payload: String): String = hash(payload.toByteArray())

    fun hash(payload: ByteArray): String = Hex.hex(MessageDigest.getInstance("SHA-256").digest(payload))

    fun hmacSHA256(key: ByteArray, data: String): ByteArray {
        val algorithm = "HmacSHA256"
        return Mac.getInstance(algorithm).run {
            init(SecretKeySpec(key, algorithm))
            doFinal(data.toByteArray(charset("UTF8")))
        }
    }
}
