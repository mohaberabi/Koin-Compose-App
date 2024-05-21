package com.mohaberabi.koindiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mohaberabi.koindiapp.features.user.model.User
import com.mohaberabi.koindiapp.features.user.presentation.UserPresenter
import com.mohaberabi.koindiapp.features.user.presentation.UserViewModel
import com.mohaberabi.koindiapp.ui.theme.KoinDiAppTheme
import org.koin.android.ext.android.inject
import org.koin.androidx.compose.koinViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val presenter: UserPresenter by inject<UserPresenter>()
    private val viewModel: UserViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val userViewModelCompose: UserViewModel = koinViewModel()
            KoinDiAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Column(
                        modifier = Modifier.padding(innerPadding),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {


                        Text(text = presenter.sayHello("loser"))
                        Text(text = viewModel.sayHello("loser"))
                        Text(text = userViewModelCompose.sayHello("loser"))

                    }
                }
            }
        }
    }
}

