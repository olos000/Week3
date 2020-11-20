package org.andronitysolo.week3.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.andronitysolo.week3.Model.Batik.Covid.ListDataItem
import org.andronitysolo.week3.Networking.Covid.CovidApi

class CovidViewModel : ViewModel() {
    val data = MutableLiveData<List<ListDataItem>>()
    val isLoading = MutableLiveData<Boolean>()

    fun getCovid() {
        isLoading.value = true
        CovidApi().run {
           instance().GetCovid()
               .observeOn(AndroidSchedulers.mainThread())
               .subscribeOn(Schedulers.io())
               .subscribe({
                   isLoading.value=false
                   if (it.isSuccessful){
                       data.value = it.body()?.listData as List<ListDataItem>?
                   }
               },{
                   isLoading.value=false

               })

        }
    }
}