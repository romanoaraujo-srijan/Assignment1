import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController


import com.example.assignment.data.Data
import com.example.assignment.data.saveData
import com.example.assignment.ui.theme.readJsonData

//import com.example.assignment.data.readJsonData
//import com.example.assignment.data.saveData
import com.google.gson.Gson

class LoginViewModel : ViewModel() {

    private var incomingUser = Data("","")
    private var apiUser = Data("","")

    private val _openDialog: MutableState<Boolean> =  mutableStateOf(false)
    val openDialog: State<Boolean> = _openDialog

    private val _userNameState: MutableState<String> = mutableStateOf("")
    val userNameState: State<String> = _userNameState

    private val _password: MutableState<String> = mutableStateOf("")
    val password : State<String> = _password

    fun onUserNameValueChange(input: String){
        _userNameState.value = input
    }

    fun onPasswordValueChange(input: String){
        _password.value = input
    }

    fun onDialogResponseChange(input: Boolean){
        _openDialog.value = input
    }

    fun onClickButton(context: Context, navController: NavHostController){
        saveInputData() //STEP1: Save TextField data into incomingUser object

        val userJson = readJsonData(context)

        convertToObject(userJson)   //Convert it to Kotlin object and save it in apiUser variable

        val status =  validate() // compare incomingUser & apiUser object

        if(status) { //User is valid
            _openDialog.value = false
            saveData(context, incomingUser.userNameData, incomingUser.passwordData)
            navigate(navController)
        }
        else _openDialog.value = true
    }

    private fun saveInputData(){
        incomingUser.userNameData = _userNameState.value
        incomingUser.passwordData = _password.value
    }

    private fun convertToObject(userJson: String){
        val gson = Gson()
        apiUser = gson.fromJson(userJson, Data::class.java)
    }

    private fun validate(): Boolean{
        return (incomingUser.userNameData == apiUser.userNameData && incomingUser.passwordData == apiUser.passwordData)
    }

    private fun navigate(navController: NavHostController) {
        navController.navigate(Screens.welcome_screen.route){
            popUpTo(Screens.login_page.route) { inclusive = true }
        }
    }
}
