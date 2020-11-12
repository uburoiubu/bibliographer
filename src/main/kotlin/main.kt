import androidx.compose.desktop.Window
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.parse

val client = HttpClient(CIO) {
    install(JsonFeature) {
        serializer = KotlinxSerializer()
    }
}

fun main() = Window {

    var result by remember { mutableStateOf("") }

    var query by remember { mutableStateOf("") }

    MaterialTheme(
        colors = MaterialTheme.colors.copy(
            primary = Color(202,62,71),
            background = Color(82,82,82),
            surface = Color(49,49,49),
            error = Color.Red
        )
    ) {
        Scaffold {
            ScrollableColumn {
                TopAppBar(
                        backgroundColor = Color(49,49,49),
                        elevation = 3.dp
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "Your search query: ", color = Color.White, fontSize = 12.sp)
                        TextField(
                                textStyle = TextStyle(
                                        color = Color.White,
                                        fontSize = 12.sp
                                ),
                                modifier = Modifier.weight(1f),
                                maxLines = 1,
                                onValueChange = { query = it },
                                value = query
                        )
                    }
                }
                Button(
                        modifier = Modifier.padding(16.dp),
                        onClick = { GlobalScope.launch { result = search() } },
                        content = { Text("Search") }
                )
                Text(
                        modifier = Modifier.padding(16.dp),
                        text = result,
                        fontSize = 12.sp,
                        color = Color.LightGray
                )
            }
        }
    }
}

suspend fun search() : String {
    val response = client.get<String>("http://api.crossref.org/journals")
    val format = Json {
        prettyPrint = true
    }
    val result = format.parseToJsonElement(response)

    return format.encodeToString(result)
}
