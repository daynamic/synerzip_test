package com.akshat.synerzip.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.akshat.synerzip.R
import com.akshat.synerzip.presenter.Callbacks
import com.akshat.synerzip.repo.FeedRepo
import com.akshat.synerzip.utils.alertDialog
import com.akshat.synerzip.utils.dismissprogressDialog
import com.akshat.synerzip.utils.showprogressDialog
import com.akshat.synerzip.viewmodel.GridAdapter
import com.akshat.synerzip.viewmodel.GridViewModel
import com.akshat.synerzip.viewmodel.GridViewModelFactory
import kotlinx.android.synthetic.main.activity_grid.*


class GridActivity : AppCompatActivity(), Callbacks {
    override fun onstarted() {
        showprogressDialog(
            this,
            "Getting Data...",
            "",
            false
        )
    }

    override fun onSuccess() {
        dismissprogressDialog(this)
    }

    override fun onFailure(message: String) {
        dismissprogressDialog(this)
        alertDialog(message)

    }

    private lateinit var viewModel: GridViewModel
    private lateinit var factory: GridViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_grid)

        val repository = FeedRepo()
        factory = GridViewModelFactory(repository)
        viewModel= ViewModelProviders.of(this,factory).get(GridViewModel::class.java)
        viewModel.authListener=this
        viewModel.getList()
        viewModel.providedList.observe(this, Observer {providedList ->

            System.out.print("lsit data "+ providedList.size)


            recycler_view.also {
                it.layoutManager= GridLayoutManager(this,2)
                it.setHasFixedSize(true)
                it.adapter = GridAdapter(providedList)

            }


        })






    }

}
