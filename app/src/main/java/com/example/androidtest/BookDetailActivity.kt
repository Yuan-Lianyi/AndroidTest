package com.example.androidtest

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * 第 2 个 Activity：显示被选中书籍的完整信息。
 */
class BookDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_AUTHOR = "extra_author"
        const val EXTRA_PUBLISHER = "extra_publisher"
        const val EXTRA_PRICE = "extra_price"
        const val EXTRA_ISBN = "extra_isbn"
        const val EXTRA_PUBLISH_DATE = "extra_publish_date"
        const val EXTRA_CATEGORY = "extra_category"
        const val EXTRA_DESCRIPTION = "extra_description"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_book_detail)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.detail_root)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.title_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.navigationIcon?.setTint(ContextCompat.getColor(this, R.color.book_text_primary))
        toolbar.setNavigationOnClickListener { onBackPressedDispatcher.onBackPressed() }

        findViewById<TextView>(R.id.tv_detail_book_title).text = intent.getStringExtra(EXTRA_TITLE)
        findViewById<TextView>(R.id.tv_detail_author).text = intent.getStringExtra(EXTRA_AUTHOR)
        findViewById<TextView>(R.id.tv_detail_publisher).text = intent.getStringExtra(EXTRA_PUBLISHER)
        findViewById<TextView>(R.id.tv_detail_price).text = getString(
            R.string.price_format,
            intent.getDoubleExtra(EXTRA_PRICE, 0.0)
        )
        findViewById<TextView>(R.id.tv_detail_isbn).text = intent.getStringExtra(EXTRA_ISBN)
        findViewById<TextView>(R.id.tv_detail_publish_date).text =
            intent.getStringExtra(EXTRA_PUBLISH_DATE)
        findViewById<TextView>(R.id.tv_detail_category).text = intent.getStringExtra(EXTRA_CATEGORY)
        findViewById<TextView>(R.id.tv_detail_description).text =
            intent.getStringExtra(EXTRA_DESCRIPTION)
    }
}