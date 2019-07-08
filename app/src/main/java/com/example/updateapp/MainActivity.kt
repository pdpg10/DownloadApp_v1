package com.example.updateapp

import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        button.setOnClickListener { showProgress() }

    }

    private fun showProgress() {
        button.visibility = View.INVISIBLE
        pb.visibility = View.VISIBLE
        MyTask().execute()
    }

    inner class MyThread : Thread() {
        private val downloadManager = DownloadManager()

        override fun run() {
            super.run()
            downloadManager.downloadWithOutProgress()
            button.visibility = View.VISIBLE
            pb.visibility = View.INVISIBLE
        }
    }


    inner class MyTask() : AsyncTask<Any, Any, Any>() {
        private val downloadManager = DownloadManager()

        override fun doInBackground(vararg params: Any?): Any {
            downloadManager.downloadWithOutProgress()
            return Any()
        }

        override fun onPostExecute(result: Any?) {
            super.onPostExecute(result)
            button.visibility = View.VISIBLE
            pb.visibility = View.INVISIBLE
        }

    }
}
