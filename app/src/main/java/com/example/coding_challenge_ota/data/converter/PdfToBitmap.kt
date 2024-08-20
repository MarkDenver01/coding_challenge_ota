package com.example.coding_challenge_ota.data.converter

import android.content.Context
import android.graphics.Bitmap
import android.graphics.pdf.PdfRenderer
import android.os.ParcelFileDescriptor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File

object PdfToBitmap {

    suspend fun convert(context: Context, filename: String): Bitmap = withContext(Dispatchers.IO) {
        val pdfRenderer = PdfRenderer(
            /* input = */ ParcelFileDescriptor.open(
                /* file = */ File(
                    /* parent = */ context.filesDir,
                    /* child = */ filename
                ),
                /* mode = */ ParcelFileDescriptor.MODE_READ_ONLY
            )
        )

        val page = pdfRenderer.openPage(0)
        val bitmap = Bitmap.createBitmap(page.width, page.height, Bitmap.Config.ARGB_8888)
        page.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)
        page.close()
        pdfRenderer.close()
        return@withContext bitmap
    }

}
