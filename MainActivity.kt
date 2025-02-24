@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject lateinit var myDependency: MyDependency

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupNavigation() // Método em camelCase
        setupUI() // Método em camelCase
    }

    private fun setupNavigation() {
        // Lógica de navegação
    }

    private fun setupUI() {
        setContent {
            MainScreen() // Composable em PascalCase
        }
    }
} 