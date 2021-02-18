package paytalab.clone.passorder.domain.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import paytalab.clone.passorder.data.repository.SignUpRepository
import paytalab.clone.passorder.domain.usecase.SignUpUseCase
import javax.inject.Named
import javax.inject.Singleton


// UseCase 생성 모듈
@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideSignUpUseCase(@Named("SignUp") repo : SignUpRepository) : SignUpUseCase
        = SignUpUseCase(repo)
}