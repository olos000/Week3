package org.andronitysolo.week3.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.andronitysolo.week3.Model.Batik.Indo.ProvinsiItem
import org.andronitysolo.week3.Networking.Indonesia.DaerahApi

class IndoViewModel : ViewModel() {
    val dataDe = MutableLiveData<List<ProvinsiItem>>()
    val isLoading = MutableLiveData<Boolean>()

    fun getDaerah(){
        isLoading.value = true
        DaerahApi().run {
            instance().getDaerah()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    isLoading.value = false
                    if (it.isSuccessful){
                        dataDe.value = it.body()?.provinsi as List<ProvinsiItem>?
                    }
                },{
                    isLoading.value=false
                }

                )
        }
    }


}