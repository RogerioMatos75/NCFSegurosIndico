import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.assertIsDisplayed
import org.junit.Rule
import org.junit.Test

class LoginScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testLoginButtonDisplayed() {
        composeTestRule.setContent {
            LoginScreen(navController = /* Mock NavController */)
        }

        composeTestRule.onNodeWithText("Ir para Dashboard").assertIsDisplayed()
    }

    @Test
    fun testLoginButtonClick() {
        composeTestRule.setContent {
            LoginScreen(navController = /* Mock NavController */)
        }

        composeTestRule.onNodeWithText("Ir para Dashboard").performClick()
        // Adicione asserções para verificar a navegação
    }
} 