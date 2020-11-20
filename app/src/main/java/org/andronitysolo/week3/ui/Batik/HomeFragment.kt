package org.andronitysolo.week3.ui.Batik

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_home.view.*
import org.andronitysolo.week3.Adapter.BatikAdapter
import org.andronitysolo.week3.Model.Batik.HasilItem
import org.andronitysolo.week3.Model.Batik.ResponseBatik
import org.andronitysolo.week3.R
import org.andronitysolo.week3.ViewModel.BatikMV

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var mAdapter: BatikAdapter
    private lateinit var batikViewmodel: BatikMV

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        mAdapter = BatikAdapter(activity)
        root.rv_movies.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(this.context)
            setHasFixedSize(true)
        }

        batikViewmodel = ViewModelProviders.of(this).get(BatikMV::class.java)
        batikViewmodel.getDataBundle?.observe(viewLifecycleOwner, Observer { b ->
            batikViewmodel.getData()
            Log.d("umar sebelum masuk", Gson().toJson(b))
            val data: ResponseBatik? = b.getParcelable("dataUmar")
            if (data != null) {
                data.let { dataa -> dataa.hasil.let { it1 -> mAdapter.swapData(it1 as List<HasilItem>) } }
            } else {
                val pd = ProgressDialog(activity)
                pd.setMessage("Loading")
                batikViewmodel.isLoading.observe(viewLifecycleOwner, Observer {
                    if (it) pd.show()
                    else pd.dismiss()
                })
            }
        })


//        batikViewmodel.data.observe(
//                viewLifecycleOwner,
//                Observer {
//                    val bundle = Bundle()
//                    batikViewmodel.getDataBundle?.observe(
//                            viewLifecycleOwner,
//                            Observer { b ->
//
//                            },
//                    )
//                    batikViewmodel.saveBundle(bundle)
//                    batikViewmodel.getDataBundle?.observe(
//                            viewLifecycleOwner,
//                            Observer { b ->
//                                if (b != null) {
//                                    val data: ResponseBatik? = b.getParcelable("dataUmar")
//                                    data?.let { dataa -> dataa.hasil?.let { it1 -> mAdapter.swapData(it1 as List<HasilItem>) } }
//                                } else {
//
//                                }
//                            },
//                    )
//                    it.hasil {
//                        mAdapter.swapData(it1)
//                    }
//
//                },
//        )
                    mAdapter.notifyDataSetChanged()



                    return root
                }

}




