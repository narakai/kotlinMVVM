package clem.app.mymvvm.ui

import androidx.lifecycle.MutableLiveData
import clem.app.core.base.BaseViewModel
import clem.app.mymvvm.executeResponse
import clem.app.mymvvm.model.bean.ArticleList
import clem.app.mymvvm.model.repository.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by luyao
 * on 2019/1/29 10:27
 */
class HomeViewModel : BaseViewModel() {

    private val repository by lazy { HomeRepository() }
    val mArticleList: MutableLiveData<ArticleList> = MutableLiveData()

    fun getArticleList(page: Int) {
        launch {
            val result = withContext(Dispatchers.IO) { repository.getArticleList(page) }
            executeResponse(result, { mArticleList.value = result.data }, {})
        }
    }

    //may many func
}