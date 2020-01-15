package com.example.handnew04.ui.movie

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.handnew04.R

class MovieDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        supportActionBar?.hide()
        initWebView()
    }

    fun getMovieLink(): String? = intent.getStringExtra(getString(R.string.movieLink))

    @SuppressLint("ObsoleteSdkInt", "SetJavaScriptEnabled")
    private fun initWebView() {
        val movieWebView = findViewById<View>(R.id.wb_movieDetail) as WebView

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true)
        }

        movieWebView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }

        val settings = movieWebView.settings
        settings.javaScriptEnabled = true

        movieWebView.loadUrl(getMovieLink())
    }
}