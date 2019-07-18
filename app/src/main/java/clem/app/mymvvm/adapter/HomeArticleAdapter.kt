package clem.app.mymvvm.adapter

import android.text.Html
import clem.app.core.ext.fromN
import clem.app.mymvvm.R
import clem.app.mymvvm.model.bean.Article
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by luyao
 * on 2018/3/14 15:52
 */
@Suppress("DEPRECATION")
class HomeArticleAdapter(layoutResId: Int = R.layout.item_article) :
    BaseQuickAdapter<Article, BaseViewHolder>(layoutResId) {

    private var showStar = true

    fun showStar(showStar: Boolean) {
        this.showStar = showStar
    }

    override fun convert(helper: BaseViewHolder, item: Article) {
        helper.setText(
            R.id.articleTitle,
            if (fromN()) Html.fromHtml(item.title, Html.FROM_HTML_MODE_LEGACY) else Html.fromHtml(item.title)
        )
    }
}