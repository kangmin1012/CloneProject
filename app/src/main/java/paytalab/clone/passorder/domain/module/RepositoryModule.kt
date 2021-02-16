package paytalab.clone.passorder.domain.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import paytalab.clone.passorder.data.repository.LoginRepository
import paytalab.clone.passorder.data.repository.LoginRepositoryImpl
import javax.inject.Singleton

// repository 생성 모듈
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindLoginRepository(repository : LoginRepositoryImpl) : LoginRepository
}