import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

fun main() = Window {

    var text by remember { mutableStateOf("Please enter journal name") }

    MaterialTheme(
        colors = MaterialTheme.colors.copy(
            primary = Color(202,62,71),
            background = Color(82,82,82),
            surface = Color(49,49,49),
            error = Color.Red
        )
    ) {
        Scaffold {
            TopAppBar(
                    backgroundColor = Color(49,49,49),
                    elevation = 3.dp
            ) {
                Row {
                    TextField(
                            textStyle = TextStyle(
                                    color = Color.White,
                                    fontSize = 13.sp
                            ),
                            modifier = Modifier.weight(1f),
                            maxLines = 1,
                            onValueChange = { text = it },
                            value = text
                    )
                }
            }
        }
    }
}
