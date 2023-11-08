package br.edu.up.app

import android.app.Application
import android.content.Context
import br.edu.up.app.data.BancoSQLite
import br.edu.up.app.data.DestinoDAO
import br.edu.up.app.data.DestinoRepository
import br.edu.up.app.data.DestinoRepositoryFirebase
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
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
    fun provideDestinosRef() : CollectionReference {
        return Firebase.firestore.collection("destinos")
    }

    @Provides
    fun provideDestinoRepositoryFirebase(destinosRef: CollectionReference)
            : DestinoRepository{
        return DestinoRepositoryFirebase(destinosRef)
    }




//    @Provides
//    fun provideDestinoRepository(destinoDAO: DestinoDAO) : DestinoRepository {
//        return DestinoRepository(destinoDAO)
//    }
//
//
//    @Provides
//    fun provideDestinoDAO(bancoSQLite: BancoSQLite): DestinoDAO {
//        return bancoSQLite.destinoDAO()
//    }
//
//    @Provides
//    @Singleton
//    fun provideBanco(@ApplicationContext ctx: Context): BancoSQLite {
//        return BancoSQLite.get(ctx)
//    }
}