package com.github.moqigit.codelab.ui.test

import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.github.moqigit.codelab.R
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.qrcode.QRCodeWriter
import kotlinx.android.synthetic.main.activity_qr_code_test.*

class QrCodeTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr_code_test)

        val info = "二维码是真的"

        val bitmap = createQRCode(info, 240, 240)
        Glide.with(this)
            .load(bitmap)
            .into(qr_test_iv)
    }

    private fun createQRCode(content: String, width: Int, height: Int): Bitmap{
        val bm = QRCodeWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hashMapOf(EncodeHintType.CHARACTER_SET to "UTF-8"))
        val pixels = IntArray(bm.width * bm.height)
        for (i in 0 until bm.height){
            for (j in 0 until bm.width){
                if (bm[i,j]){
                    pixels[i * bm.width + j] = Color.BLACK
                } else {
                    pixels[i * bm.width + j] = Color.WHITE
                }
            }
        }
        return Bitmap.createBitmap(pixels, bm.width, bm.height, Bitmap.Config.RGB_565)
    }
}