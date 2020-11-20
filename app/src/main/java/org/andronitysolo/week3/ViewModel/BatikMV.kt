package org.andronitysolo.week3.ViewModel

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.andronitysolo.week3.Model.Batik.ResponseBatik
import org.andronitysolo.week3.Networking.Batik.BatikApi


class BatikMV(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    val data = MutableLiveData<List<ResponseBatik>>()
    val isLoading = MutableLiveData<Boolean>()
    val REGULAR_KEY = "regular_key"
    val LIVE_DATE_KEY = "live_data_key"

    fun getData() {
        isLoading.value = true
        BatikApi().run {
            instance().getBatik()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe({
                        isLoading.value = false
                        if (it.isSuccessful) {
                            data.value = it.body()
                        }
                    }, {
                        isLoading.value = false

                    })

        }
    }

    val regularText: String
        get() = savedStateHandle.get<String>(REGULAR_KEY).orEmpty()

    val dataBundle = MutableLiveData<Bundle>()
    val getDataBundle: LiveData<Bundle>? = savedStateHandle.getLiveData(LIVE_DATE_KEY)

    fun saveRegularText(text: String) {
        savedStateHandle.set(REGULAR_KEY, text)
    }

    fun saveBundle(b: Bundle) {
        savedStateHandle.set(LIVE_DATE_KEY, b)
    }
}


