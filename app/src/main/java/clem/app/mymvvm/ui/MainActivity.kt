package clem.app.mymvvm.ui

import android.os.Handler
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import clem.app.core.base.BaseActivity
import clem.app.core.base.BaseVMActivity
import clem.app.core.ext.dp2px
import clem.app.core.ext.screenWidth
import clem.app.mymvvm.R
import clem.app.mymvvm.adapter.HomeArticleAdapter
import clem.app.mymvvm.model.bean.ArticleList
import clem.app.mymvvm.view.SpaceItemDecoration
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseVMActivity<HomeViewModel>() {

    companion object {
        const val TEST_INDEX = 1
    }

    override fun providerVMClass(): Class<HomeViewModel>? = HomeViewModel::class.java

    private val homeArticleAdapter by lazy { HomeArticleAdapter() }
    private val handler by lazy { Handler() }

    override fun getLayoutResId() = R.layout.activity_main

    override fun initView() {
        homeRecycleView.run {
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(SpaceItemDecoration(homeRecycleView.dp2px(10f)))
            homeRecycleView.adapter = homeArticleAdapter
        }
    }

    override fun initData() {
        mViewModel.getArticleList(TEST_INDEX)
        //sim data refresh
        handler.postDelayed({mViewModel.getArticleList(TEST_INDEX + 1)}, 5000)
    }

    override fun startObserve() {
        mViewModel.apply {
            //may many data
            mArticleList.observe(this@MainActivity, Observer { it ->
                //call when data changes
                Log.d("data refresh", it.datas[0].title)
                it?.let { setArticles(it) }
            })
        }
    }

    private fun setArticles(articleList: ArticleList) {
        homeArticleAdapter.run {
            replaceData(articleList.datas)
        }
    }
}