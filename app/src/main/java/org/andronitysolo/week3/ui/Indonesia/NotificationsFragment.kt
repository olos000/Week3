package org.andronitysolo.week3.ui.Indonesia

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
import kotlinx.android.synthetic.main.fragment_notifications.view.*
import org.andronitysolo.week3.Adapter.DaerahAdapter
import org.andronitysolo.week3.R
import org.andronitysolo.week3.ViewModel.IndoViewModel

class NotificationsFragment : Fragment() {
    private lateinit var tAdapter : DaerahAdapter
    private lateinit var indoViewModel: IndoViewModel
    private lateinit var notificationsViewModel: NotificationsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
                ViewModelProvider(this).get(NotificationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        indoViewModel = ViewModelProviders.of(this).get(IndoViewModel::class.java)
        indoViewModel.getDaerah()
        root.rv_indo.apply {
            adapter = tAdapter
            layoutManager = LinearLayoutManager(this.context)
            setHasFixedSize(true)
        }
        indoViewModel.dataDe.observe(viewLifecycleOwner, Observer {
            tAdapter = DaerahAdapter()
            tAdapter.setData(it)
            root.rv_indo.adapter = tAdapter
            tAdapter.notifyDataSetChanged()
        })

        val pd = ProgressDialog(activity)
        pd.setMessage("loading")
        indoViewModel.isLoading.observe(viewLifecycleOwner, Observer {
            if (it) pd.show()
            else pd.dismiss()
        })
        return root
    }
}