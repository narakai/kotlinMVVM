package clem.app.mymvvm.model.api

import clem.app.mymvvm.model.bean.ArticleList
import clem.app.mymvvm.model.bean.WanResponse
import retrofit2.http.*


/**
 * Created by luyao
 * on 2018/3/13 14:33
 */
interface WanService {

    companion object {
        const val BASE_URL = "https://www.wanandroid.com"
    }

    @GET("/article/list/{page}/json")
    suspend fun getHomeArticles(@Path("page") page: Int): WanResponse<ArticleList>

}