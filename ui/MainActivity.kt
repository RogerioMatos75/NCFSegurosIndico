@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject lateinit var myDependency: MyDependency

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "loginFragment") {
                composable("loginFragment") { LoginScreen(navController) }
                composable("dashboardFragment") { DashboardScreen(navController) }
            }
        }
    }
} 