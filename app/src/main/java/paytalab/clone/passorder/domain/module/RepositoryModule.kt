package paytalab.clone.passorder.domain.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import paytalab.clone.passorder.data.repository.LoginRepository
import paytalab.clone.passorder.data.repository.LoginRepositoryImpl
import paytalab.clone.passorder.data.repository.SignUpRepository
import paytalab.clone.passorder.data.repository.SignUpRepositoryImpl
import javax.inject.Named
import javax.inject.Singleton

// repository 생성 모듈
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    @Named("Login")
    abstract fun bindLoginRepository(repository : LoginRepositoryImpl) : LoginRepository

    @Binds
    @Singleton
    @Named("SignUp")
    abstract fun bindSignUpRepository(repository : SignUpRepositoryImpl) : SignUpRepository
}