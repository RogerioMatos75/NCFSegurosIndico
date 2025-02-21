import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import com.example.indica.data.auth.AuthService
import com.example.indica.domain.usecase.AuthUseCase
import com.example.indica.domain.models.User

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class LoginViewModelTest {

    @Mock
    private lateinit var authService: AuthService

    @Mock
    private lateinit var authUseCase: AuthUseCase

    private lateinit var viewModel: LoginViewModel
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        viewModel = LoginViewModel(authUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `login with valid credentials should update state to success`() = runTest {
        // Arrange
        val email = "test@example.com"
        val password = "password123"
        val user = User(id = "1", email = email)
        
        `when`(authUseCase.login(email, password)).thenReturn(Result.success(user))

        // Act
        viewModel.login(email, password)
        testDispatcher.scheduler.advanceUntilIdle()

        // Assert
        assert(viewModel.uiState.value.isSuccess)
        assert(viewModel.uiState.value.user != null)
        verify(authUseCase).login(email, password)
    }

    @Test
    fun `login with invalid credentials should update state to error`() = runTest {
        // Arrange
        val email = "test@example.com"
        val password = "wrongpassword"
        
        `when`(authUseCase.login(email, password))
            .thenReturn(Result.failure(Exception("Invalid credentials")))

        // Act
        viewModel.login(email, password)
        testDispatcher.scheduler.advanceUntilIdle()

        // Assert
        assert(viewModel.uiState.value.isError)
        assert(viewModel.uiState.value.errorMessage == "Invalid credentials")
        verify(authUseCase).login(email, password)
    }
}