package com.example.interfacegrafica

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.launch
import java.util.Date

class MainActivity : ComponentActivity() {

    private lateinit var MinhaViewModelQueEuCrieiAgoraPouco: MinhaViewBemSimples

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MinhaViewModelQueEuCrieiAgoraPouco = ViewModelProvider(this).get(MinhaViewBemSimples::class.java)

        setContent {

              MainScreen(MinhaViewModelQueEuCrieiAgoraPouco)

        }
    }
}



@Composable
fun MinhaSaudacao(nome:String = "World", adj:String, modificador:Modifier){
    Text(text = "Hello $adj $nome !", modifier = modificador)
}





@Composable
fun Greeting(name: String, modificador: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modificador
    )
}

@Preview(showBackground = true)
@Composable
fun MinhaPreview() {


    }


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(umaViewModel: MinhaViewBemSimples){
    var contadorNaView by remember {
        mutableStateOf(0)
    }

    val contadorProvenineteDaMinhaModelView by umaViewModel.contadorDaViewPublico.collectAsState()


    Scaffold(
        topBar = {

            TopAppBar(
                title = { Text(text = "Somar e Subtrair", color = Color(0xFFF845BE), fontWeight = FontWeight.Bold)},

            )
        },
        content = { paddingValues -> Log.i("paddingValues", "$paddingValues")
            Column(
                modifier = Modifier
                    .background(Color(0xFFFAC1E5))
                    .fillMaxSize()
            ) {
                Spacer(modifier = Modifier.height(100.dp))
                Row(modifier = Modifier.padding(all = 12.dp)){
                    Column(horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .padding(12.dp)
                    ){
                        Icon(
                            imageVector = Icons.Default.AddCircle,
                            tint = Color(0xFFF845BE),
                            contentDescription = "Icons of a pendent task",
                        )
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Column(
                        modifier = Modifier

                            .padding(10.dp)
                            .width(500.dp)

                    ){
                        Button(modifier = Modifier
                            .width(300.dp)
                            , onClick = {
                            contadorNaView += 1 //estudante
                            umaViewModel.incrementaContador() //prof
                            Log.i("##### NOSSO_LOG", "Valor do Contador = $contadorNaView")
                        }) {
                            Text(text = "INCREMENTA CONTADOR",
                                fontSize = 20.sp,
                                color = Color(0xFFFFFFFF),
                                fontWeight = FontWeight.Bold,
                                fontStyle = FontStyle.Italic,
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }

                Row(modifier = Modifier.padding(all = 12.dp)){
                    Column(horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier

                            .padding(12.dp)

                    ){
                        Icon(
                            imageVector = Icons.Default.Delete,
                            tint = Color(0xFFF845BE),
                            contentDescription = "Icons of a pendent task",
                        )
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Column(
                        modifier = Modifier

                            .padding(10.dp)
                            .width(500.dp)

                    ){
                        Button(modifier = Modifier
                            .width(300.dp)
                            , onClick = {
                            contadorNaView -= 1
                            umaViewModel.subtraiContador()
                            Log.i("##### NOSSO_LOG", "Valor do Contador = $contadorNaView")
                        }) {
                            Text(text = "SUBTRAI CONTADOR",
                                fontSize = 20.sp,
                                color = Color(0xFFFFFFFF),
                                fontWeight = FontWeight.Bold,
                                fontStyle = FontStyle.Italic,
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }

                Row(modifier = Modifier.padding(all = 12.dp)){
                    Column(horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .padding(12.dp)

                    ){
                        Icon(
                            imageVector = Icons.Default.Done,
                            tint = Color(0xFFF845BE),
                            contentDescription = "Icons of a pendent task",
                        )
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Column(
                        modifier = Modifier

                            .padding(10.dp)
                            .width(500.dp)

                    ){

                            Text(text = "Valor Contador (ViewModel)= $contadorProvenineteDaMinhaModelView",
                                fontSize = 20.sp,
                                color = Color(0xFF673AB7),
                                fontWeight = FontWeight.Bold,
                                fontStyle = FontStyle.Italic,
                            )

                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }


                Row(modifier = Modifier.padding(all = 12.dp)){
                    Column(horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier

                            .padding(12.dp)

                    ){
                        Icon(
                            imageVector = Icons.Default.Done,
                            tint = Color(0xFFF845BE),
                            contentDescription = "Icons of a pendent task",
                        )
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Column(
                        modifier = Modifier

                            .padding(10.dp)
                            .width(500.dp)

                    ){

                            Text( text = "Valor Contador (View)= $contadorNaView",
                                fontSize = 20.sp,
                                color = Color(0xFF673AB7),
                                fontWeight = FontWeight.Bold,
                                fontStyle = FontStyle.Italic,
                            )

                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }


                }

        },
        bottomBar = {
            BottomAppBar(
                contentColor = Color(0xFF116B94),
                content = {
                    Text(text ="Desenvolvido por Ana Beatriz Martins Batista | RA 22284",
                        textAlign = TextAlign.Center, color = Color(0xFFF845BE), fontWeight = FontWeight.Bold)
                }
            )

        },

    )//Scaffold
   }

