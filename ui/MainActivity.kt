@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject lateinit var myDependency: MyDependency

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupNavigation()
        setupUI()
    }

    private fun setupNavigation() {
        // Lógica de navegação pode ser movida para uma classe separada
    }

    private fun setupUI() {
        setContent {
            NavGraph(navController = rememberNavController()) // Usando o NavGraph
        }
    }
} 