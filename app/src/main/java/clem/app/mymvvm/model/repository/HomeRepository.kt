package clem.app.mymvvm.model.repository

import clem.app.mymvvm.model.api.BaseRepository
import clem.app.mymvvm.model.api.WanRetrofitClient
import clem.app.mymvvm.model.bean.ArticleList
import clem.app.mymvvm.model.bean.WanResponse


/**
 * Created by luyao
 * on 2019/4/10 14:09
 */
class HomeRepository : BaseRepository() {

    suspend fun getArticleList(page: Int): WanResponse<ArticleList> {
        return apiCall { WanRetrofitClient.service.getHomeArticles(page) }
    }
}