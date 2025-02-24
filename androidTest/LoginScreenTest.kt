import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

@RunWith(AndroidJUnit4::class)
class LoginScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @Mock
    private lateinit var viewModel: LoginViewModel

    @Before
    fun setup() {
        viewModel = mock(LoginViewModel::class.java)
    }

    @Test
    fun loginScreen_displaysAllUIElements() {
        composeTestRule.setContent {
            val navController = rememberNavController()
            LoginScreen(navController = navController, viewModel = viewModel)
        }

        composeTestRule.onNodeWithText("Login").assertIsDisplayed()
        composeTestRule.onNodeWithText("Email").assertIsDisplayed()
        composeTestRule.onNodeWithText("Senha").assertIsDisplayed()
        composeTestRule.onNodeWithText("Entrar").assertIsDisplayed()
    }

    @Test
    fun loginScreen_enterCredentials_callsLoginFunction() {
        composeTestRule.setContent {
            val navController = rememberNavController()
            LoginScreen(navController = navController, viewModel = viewModel)
        }

        // Enter credentials
        composeTestRule.onNodeWithTag("email_field")
            .performTextInput("test@example.com")
        composeTestRule.onNodeWithTag("password_field")
            .performTextInput("password123")

        // Click login button
        composeTestRule.onNodeWithText("Entrar").performClick()

        // Verify viewModel.login was called with correct parameters
        verify(viewModel).login("test@example.com", "password123")
    }

    @Test
    fun loginScreen_showsLoadingIndicator_whenLoading() {
        `when`(viewModel.uiState.value).thenReturn(LoginUiState(isLoading = true))

        composeTestRule.setContent {
            val navController = rememberNavController()
            LoginScreen(navController = navController, viewModel = viewModel)
        }

        composeTestRule.onNodeWithTag("loading_indicator").assertIsDisplayed()
    }

    @Test
    fun loginScreen_showsErrorMessage_whenError() {
        val errorMessage = "Invalid credentials"
        `when`(viewModel.uiState.value).thenReturn(LoginUiState(isError = true, errorMessage = errorMessage))

        composeTestRule.setContent {
            val navController = rememberNavController()
            LoginScreen(navController = navController, viewModel = viewModel)
        }

        composeTestRule.onNodeWithText(errorMessage).assertIsDisplayed()
    }

    @Test
    fun loginScreen_navigatesToDashboard_onSuccessfulLogin() {
        `when`(viewModel.uiState.value).thenReturn(LoginUiState(isSuccess = true))

        composeTestRule.setContent {
            val navController = rememberNavController()
            LoginScreen(navController = navController, viewModel = viewModel)
        }

        // Verify navigation to dashboard
        composeTestRule.onNodeWithTag("dashboard_screen").assertExists()
    }
}