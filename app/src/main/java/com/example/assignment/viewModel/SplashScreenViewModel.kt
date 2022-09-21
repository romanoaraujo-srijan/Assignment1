import android.content.Context
import androidx.annotation.RestrictTo
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.assignment.data.loadData
import com.example.assignment.ui.theme.getApiData


import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenViewModel : ViewModel() {

    fun execute(scope: CoroutineScope, context: Context, navController: NavHostController) {
        getApiData()
        scope.launch {

            //Load user date from shared pref
            val user = loadData(context)


            delay(1000)


            if (user.userNameData.isEmpty() && user.passwordData.isEmpty()) {
                navController.navigate(Screens.login_page.route) {
                    popUpTo(Screens.Start_Screen.route) { inclusive = true }
                }
            } else {
                navController.navigate(Screens.welcome_screen.route) {
                    popUpTo(Screens.Start_Screen.route) { inclusive = true }
                }
            }
        }


    }
}