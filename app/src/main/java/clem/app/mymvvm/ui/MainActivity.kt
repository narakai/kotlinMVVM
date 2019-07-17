package clem.app.mymvvm.ui

import com.google.android.material.snackbar.Snackbar
import clem.app.core.base.BaseActivity
import clem.app.core.ext.screenWidth
import clem.app.mymvvm.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun getLayoutResId() = R.layout.activity_main

    override fun initView() {
        fab.setOnClickListener { view ->
            Snackbar.make(view, screenWidth.toString(), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun initData() {
    }
}