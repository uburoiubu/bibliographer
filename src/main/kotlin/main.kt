import androidx.compose.desktop.Window
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

fun main() = Window {
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme(
        colors = MaterialTheme.colors.copy(
            primary = Color(202,62,71),
            background = Color(82,82,82),
            surface = Color(49,49,49),
            error = Color.Red
        )
    ) {
        Scaffold {

        }
    }
}
