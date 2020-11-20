package org.andronitysolo.week3.ui.Covid

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.blank_fragment.*
import org.andronitysolo.week3.Adapter.CovidAdapter
import org.andronitysolo.week3.R
import org.andronitysolo.week3.ViewModel.CovidViewModel

class BlankFragment : Fragment() {


    private lateinit var viewModel: BlankViewModel
    private lateinit var mAdapter : CovidAdapter
    private lateinit var covidViewModel: CovidViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.blank_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        covidViewModel = ViewModelProvider(this).get(CovidViewModel::class.java)
        covidViewModel.getCovid()
        rv_cofid.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(this.context)
            setHasFixedSize(true)
        }
        covidViewModel.data.observe(viewLifecycleOwner, Observer {
            mAdapter = activity?.let { it1 -> CovidAdapter(it1) }!!
            mAdapter.setData(it)
            rv_cofid.adapter = mAdapter
            mAdapter.notifyDataSetChanged()
        })

        val pd = ProgressDialog(activity)
        pd.setMessage("loading")
        covidViewModel.isLoading.observe(viewLifecycleOwner, Observer {
            if (it) pd.show()
            else pd.dismiss()
        })

    }

}