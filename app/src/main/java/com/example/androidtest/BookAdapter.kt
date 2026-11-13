package com.example.androidtest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

/**
 * 书籍列表适配器：把 [Book] 数组渲染成 item_book 布局。
 */
class BookAdapter(context: Context, private val books: Array<Book>) :
    ArrayAdapter<Book>(context, R.layout.item_book, books) {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: inflater.inflate(R.layout.item_book, parent, false)
        val book = books[position]

        view.findViewById<TextView>(R.id.tv_book_title).text = book.title
        view.findViewById<TextView>(R.id.tv_book_author).text =
            view.context.getString(R.string.book_author_publisher, book.author, book.publisher)
        view.findViewById<TextView>(R.id.tv_book_price).text =
            view.context.getString(R.string.price_format, book.price)
        return view
    }
}