package com.techyourchance.dagger2course.screens.questiondetails

import android.content.Context
import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.techyourchance.dagger2course.R
import com.techyourchance.dagger2course.screens.common.toolbar.MyToolbar
import com.techyourchance.dagger2course.screens.common.viewsmvc.BaseViewMvc

class QuestionDetailsViewMvc(
    private val layoutInflater: LayoutInflater,
    private val parent: ViewGroup?
): BaseViewMvc<QuestionDetailsViewMvc.Listener>(layoutInflater, parent, R.layout.layout_question_details) {

    interface Listener {
        fun onListenerBackPressed()
    }

    private var toolbar: MyToolbar
    private var swipeRefresh: SwipeRefreshLayout
    private var txtQuestionBody: TextView

    init {

        rootView = layoutInflater.inflate(R.layout.layout_question_details, parent, false)
        txtQuestionBody = findViewById(R.id.txt_question_body)

        // init toolbar
        toolbar = findViewById(R.id.toolbar)
        toolbar.setNavigateUpListener {
            for (listener in listeners) {
                listener.onListenerBackPressed()
            }
        }

        // init pull-down-to-refresh (used as a progress indicator)
        swipeRefresh = findViewById(R.id.swipeRefresh)
        swipeRefresh.isEnabled = false

    }

    fun bindQuestionBody(questionBody: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            txtQuestionBody.text = Html.fromHtml(questionBody, Html.FROM_HTML_MODE_LEGACY)
        } else {
            @Suppress("DEPRECATION")
            txtQuestionBody.text = Html.fromHtml(questionBody)
        }
    }


    fun showProgressIndication() {
        swipeRefresh.isRefreshing = true
    }

    fun hideProgressIndication() {
        swipeRefresh.isRefreshing = false
    }

}