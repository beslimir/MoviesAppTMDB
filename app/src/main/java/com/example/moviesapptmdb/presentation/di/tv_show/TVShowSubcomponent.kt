package com.example.moviesapptmdb.presentation.di.tv_show

import com.example.moviesapptmdb.presentation.tv_show.TVShowActivity
import dagger.Subcomponent

@TVShowScope
@Subcomponent(modules = [TVShowModule::class])
interface TVShowSubcomponent {

    fun inject(tvShowActivity: TVShowActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TVShowSubcomponent
    }

}