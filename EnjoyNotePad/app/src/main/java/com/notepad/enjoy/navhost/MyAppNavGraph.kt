package com.notepad.enjoy.navhost

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.notepad.enjoy.api.ApiService
import com.notepad.enjoy.db.UserDao
import com.notepad.enjoy.db.UserDatabase
import com.notepad.enjoy.repo.UserRepository
import com.notepad.enjoy.viewmodel.UserViewModel
import com.notepad.enjoy.widget.LoginScreen
import com.notepad.enjoy.widget.RegisterScreen
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @Description: 导航图$
 * @Author: ChrisYe
 * @Date: 2025-11-30-14:39
 */
@Composable
fun MyAppNavGraph(
    startDestination: String = "login_page"
) {
    val context = LocalContext.current // ✅ 获取 Context
    val navController = rememberNavController()

    // 1. 创建 Retrofit 实例
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.example.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // 2. 用 Retrofit 创建 ApiService 的实现
    val apiService: ApiService = retrofit.create(ApiService::class.java)
    val database = UserDatabase.getDatabase(context = context)
    val userDao = database.userDao()
    val userRepository = UserRepository(apiService, userDao)
    val userViewModel =  remember { UserViewModel(userRepository) }

    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        composable("login_page") {
            LoginScreen(
                onNavigateToDetail = { title -> navController.navigate("register_page/$title") }
            )
        }

        composable(
            route = "register_page/{title}",
            arguments = listOf(navArgument("title") { type = NavType.StringType })
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            RegisterScreen(title = title, viewModel = userViewModel)
        }
    }
}