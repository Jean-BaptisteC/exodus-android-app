package org.eu.exodusprivacy.exodus.fragments.apps

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.eu.exodusprivacy.exodus.manager.database.ExodusDatabaseRepository
import org.eu.exodusprivacy.exodus.manager.database.app.ExodusApplication
import javax.inject.Inject

@HiltViewModel
class AppsViewModel @Inject constructor(
    exodusDatabaseRepository: ExodusDatabaseRepository
) : ViewModel() {

    val appList: LiveData<List<ExodusApplication>> = exodusDatabaseRepository.getAllApps()
}
