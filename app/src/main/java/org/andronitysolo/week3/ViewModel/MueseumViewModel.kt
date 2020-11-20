package org.andronitysolo.week3.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.andronitysolo.week3.Model.Batik.Museum.DataItem
import org.andronitysolo.week3.Networking.Museum.MuseumApi

class MueseumViewModel : ViewModel() {
    val data = MutableLiveData<List<DataItem>>()
    val isLoading = MutableLiveData<Boolean>()

    fun getDataMu(){
        isLoading.value = true
        MuseumApi().run {
            instance().GetMuseum()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    isLoading.value = false
                    if (it.isSuccessful){
                        data.value = it.body()?.data as List<DataItem>?
                    }
                },{
                    isLoading.value=false
                }

                )
        }
    }

}