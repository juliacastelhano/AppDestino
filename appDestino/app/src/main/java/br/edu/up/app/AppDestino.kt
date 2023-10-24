package br.edu.up.app

import android.app.Application
import android.content.Context
import br.edu.up.app.data.BancoSQLite
import br.edu.up.app.data.DestinoDAO
import br.edu.up.app.data.DestinoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@HiltAndroidApp
@InstallIn(SingletonComponent::class)
class AppDestino : Application() {

    @Provides
    fun provideDestinoRepository(destinoDAO: DestinoDAO) : DestinoRepository {
        return DestinoRepository(destinoDAO)
    }


    @Provides
    fun provideDestinoDAO(bancoSQLite: BancoSQLite): DestinoDAO {
        return bancoSQLite.destinoDAO()
    }

    @Provides
    @Singleton
    fun provideBanco(@ApplicationContext ctx: Context): BancoSQLite {
        return BancoSQLite.get(ctx)
    }
}