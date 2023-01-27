package com.sixoutoften.recepier.ui.home.document_detail

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Space
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.findNavController
import com.sixoutoften.recepier.databinding.ActivityDocumentDetailBinding
import com.sixoutoften.recepier.theme.RecepierTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DocumentDetailActivity : ComponentActivity() {

//    private lateinit var binding: ActivityDocumentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ScreenContent()
        }
//        binding = ActivityDocumentDetailBinding.inflate(layoutInflater)
//        setContentView(binding.root)

    }

    @Preview(showSystemUi = true, showBackground = true, uiMode = UI_MODE_NIGHT_NO)
    @Composable
    private fun ScreenContent() {
//        RecepierTheme {
//            Scaffold(
//                modifier = Modifier
//                    .fillMaxHeight()
//                    .fillMaxWidth(),
//                content = {
//
//                }
//            )
//
//        }
        RecepierTheme(isDarkTheme = true) {
            Column(
                modifier = Modifier.padding(24.dp).fillMaxSize()
            ) {
                Text(
                    text = "yyoyoyo",
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(text = "Simple compose")
                Button(
                    onClick = {
                        Toast.makeText(LocalContext.current, "Save", Toast.LENGTH_SHORT)
                            .show()
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Save")
                }
            }

        }
    }
}
