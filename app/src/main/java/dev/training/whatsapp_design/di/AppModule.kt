package dev.training.whatsapp_design.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // will live as long as the <?> dose
object AppModule {

    @Singleton
    @Provides
    fun provideAny(
        @ApplicationContext context: Context,
    ): String = "MusicServiceConnection"

}