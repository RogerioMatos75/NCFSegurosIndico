class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupNavigation() // Método extraído
        setupUI() // Método extraído
    }

    private fun setupNavigation() {
        // Lógica de navegação
    }

    private fun setupUI() {
        setContent {
            MainScreen() // Mover para uma classe separada
        }
    }
} 