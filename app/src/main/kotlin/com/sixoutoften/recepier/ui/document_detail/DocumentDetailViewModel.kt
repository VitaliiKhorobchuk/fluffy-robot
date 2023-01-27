package com.sixoutoften.recepier.ui.document_detail

import android.app.Application
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.provider.OpenableColumns
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.SavedStateHandle
import com.sixoutoften.recepier.RecepierApp
import com.sixoutoften.recepier.util.RLogger
import dagger.hilt.android.lifecycle.HiltViewModel
import java.net.URL
import javax.inject.Inject

@HiltViewModel
class DocumentDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val logger: RLogger,
    application: Application
) : AndroidViewModel(application) {

    fun saveObtainedFiles(dataIntent: Intent) {
        dataIntent.data?.let {
            importFile(it)
        }

        dataIntent.clipData?.let { clipData ->
            for (i in 0 until clipData.itemCount) {
                val uri = clipData.getItemAt(i).uri
                importFile(uri)

            }
        }
    }

    private fun importFile(uri: Uri) {
        val fileName = getFileName(uri)
        logger.d("obtained file $fileName")
    }

    private fun getFileName(uri: Uri): String? {
        // Obtain a cursor with information regarding this uri
        val cursor: Cursor? =
            getApplication<RecepierApp>().contentResolver.query(
                uri,
                null,
                null,
                null,
                null)

        cursor ?: return "Empty cursor"
        if (cursor.count <= 0) {
            cursor.close()
            return null
        }
        cursor.moveToFirst()
        val fileName: String =
            cursor.getString(cursor.getColumnIndexOrThrow(OpenableColumns.DISPLAY_NAME))
        cursor.close()
        return fileName
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    private fun saveFileUsingMediaStore(context: Context, url: String, fileName: String, mimeType: String) {
        val contentValues = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, fileName)
            put(MediaStore.MediaColumns.MIME_TYPE, mimeType)
            put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOCUMENTS)
        }
        val resolver = context.contentResolver
        val uri = resolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, contentValues)
        if (uri != null) {

            URL().openStream().use { input ->
                resolver.openOutputStream(uri).use { output ->
                    input.copyTo(output!!, DEFAULT_BUFFER_SIZE)
                }
            }
        }
    }
}