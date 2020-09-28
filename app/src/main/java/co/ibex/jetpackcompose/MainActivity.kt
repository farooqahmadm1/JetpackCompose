package co.ibex.jetpackcompose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Column {
                    newsStory()
                    Greeting("Android")
                }
            }
        }
    }

    @Composable
    fun Greeting(name: String) {
        Surface(color = Color.Yellow) {
            Text(text = "Hello $name!")
        }
    }


    @Composable
    fun newsStory() {
        Surface(color = Color.White) {
            val image = imageResource(id = R.drawable.header)
            MaterialTheme() {
                val typography = MaterialTheme.typography
                Column(modifier = Modifier.padding(16.dp)) {
                    val imageModifier = Modifier
                        .preferredHeightIn(maxHeight = 180.dp)
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(12.dp))
                    Image(
                        asset = image,
                        modifier = imageModifier,
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.preferredHeight(16.dp))
                    Column {
                        Text(
                            text = "A day in Shark Fin",
                            style = typography.h6,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = "A day with so much",
                            style = typography.body1
                        )
                        Text(
                            text = "It's Just Amaze",
                            style = typography.body2
                        )
                    }
                }
            }
        }
    }

//
//    @Preview(showBackground = true, name = "News Story")
//    @Composable
//    fun newsStoryPreview() {
//        newsStory()
//    }

    @Preview(showBackground = true, name = "News")
    @Composable
    fun newsPreview() {
        Greeting(name = "Farooq")
    }
}