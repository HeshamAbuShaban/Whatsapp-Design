package dev.training.whatsapp_design.di

import android.content.Context
import android.content.SharedPreferences
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.training.whatsapp_design.R
import dev.training.whatsapp_design.adapters.ChatAdapter
import dev.training.whatsapp_design.app_system.AppConstants
import dev.training.whatsapp_design.ui.fragments.ChatFragment
import dev.training.whatsapp_design.ui.fragments.ContactsFragment
import dev.training.whatsapp_design.ui.fragments.GroupFragment
import dev.training.whatsapp_design.ui.fragments.StatusFragment
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // will live as long as the <?> dose
object AppModule {

    @Singleton
    @Provides
    fun provideAny(): String = "MusicServiceConnection"

    @Singleton
    @Provides
    fun provideGlide(
        @ApplicationContext context: Context,
    ): RequestManager = Glide.with(context)
        .applyDefaultRequestOptions(
            RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .error(R.drawable.ic_placeholder_person)
                .placeholder(R.drawable.ic_placeholder_person)
        )

    @Singleton
    @Provides
    fun provideChatAdapter(
        glide: RequestManager,
    ): ChatAdapter = ChatAdapter(glide)

    @Singleton
    @Provides
    fun provideSharedPreferences(
        @ApplicationContext context: Context,
    ): SharedPreferences =
        context.getSharedPreferences(
            AppConstants.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE
        )

    @Singleton
    @Provides
    fun provideFragmentsList(): ArrayList<Fragment> = arrayListOf(
        GroupFragment(),
        ChatFragment(),
        StatusFragment(),
        ContactsFragment()
    )

    /*@Singleton
    @Provides
    fun provideVPAdapter(
        context: Context,
        fragmentsList: ArrayList<Fragment>,
    ): ViewPagerAdapter =
        ViewPagerAdapter(
            context as FragmentActivity,
            fragmentsList
        )*/

}