import org.junit.Assert.assertEquals
import org.junit.Test

class LoginViewModelTest {

    private val viewModel = LoginViewModel()

    @Test
    fun testLoginSuccess() {
        viewModel.login("user", "password")
        assertEquals(true, viewModel.loginState.value)
    }

    @Test
    fun testLoginFailure() {
        viewModel.login("wrongUser", "wrongPassword")
        assertEquals(false, viewModel.loginState.value)
    }
} 