package org.andronitysolo.week3.ui.Museum

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_dashboard.view.*
import org.andronitysolo.week3.Adapter.MuseumAdapter
import org.andronitysolo.week3.R
import org.andronitysolo.week3.ViewModel.MueseumViewModel

class DashboardFragment : Fragment() {
    private lateinit var museumviewmodel : MueseumViewModel
    private lateinit var museumAdapter : MuseumAdapter
    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        museumviewmodel = ViewModelProviders.of(this).get(MueseumViewModel::class.java)
        museumviewmodel.getDataMu()
        root.rv_museum.apply {
            adapter = museumAdapter
            layoutManager = LinearLayoutManager(this.context)
            setHasFixedSize(true)
        }
        museumviewmodel.data.observe(viewLifecycleOwner, Observer {
            museumAdapter = activity?.let { it1 -> MuseumAdapter(it1) }!!
            museumAdapter.setData(it)
            root.rv_museum.adapter = museumAdapter
            museumAdapter.notifyDataSetChanged()
        })

        val pd = ProgressDialog(activity)
        pd.setMessage("loading")
        museumviewmodel.isLoading.observe(viewLifecycleOwner, Observer {
            if (it) pd.show()
            else pd.dismiss()
        })
        return root
    }
}