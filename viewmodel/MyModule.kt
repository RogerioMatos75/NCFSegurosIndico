import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MyModule {
    @Provides
    fun provideMyDependency(): MyDependency {
        return MyDependency() // Retorne a instância do seu objeto
    }
} 