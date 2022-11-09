package edu.ucne.parcticaparcial2hoy.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.ucne.parcticaparcial2hoy.data.remote.verbosApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi
            .Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Singleton
    @Provides
    fun providesApi(moshi: Moshi): verbosApi {
        return Retrofit.Builder()
            .baseUrl("https://private-a127e-verbos.apiary-mock.com")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(verbosApi::class.java)
    }
}