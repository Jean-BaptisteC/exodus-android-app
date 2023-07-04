package org.eu.exodusprivacy.exodus.fragments.trackerdetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.eu.exodusprivacy.exodus.manager.database.ExodusDatabaseRepository
import org.eu.exodusprivacy.exodus.manager.database.app.ExodusApplication
import org.eu.exodusprivacy.exodus.manager.database.tracker.TrackerData
import javax.inject.Inject

@HiltViewModel
class TrackerDetailViewModel @Inject constructor(
    private val exodusDatabaseRepository: ExodusDatabaseRepository
) : ViewModel() {

    val tracker: MutableLiveData<TrackerData> = MutableLiveData()
    val appsList: MutableLiveData<List<ExodusApplication>> = MutableLiveData()

    fun getTracker(trackerID: Int) {
        viewModelScope.launch {
            tracker.value = exodusDatabaseRepository.getTracker(trackerID)
        }
    }

    fun getApps(packageNameList: List<String>) {
        viewModelScope.launch {
            appsList.value = exodusDatabaseRepository.getApps(packageNameList)
        }
    }
}
