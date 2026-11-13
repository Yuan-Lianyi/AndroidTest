package com.example.androidtest

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * 第 1 个 Activity：显示按价格升序排列的书籍列表，点击某一本启动 [BookDetailActivity]。
 */
class MainActivity : AppCompatActivity() {

    /** 在代码中新建的书籍对象数组，初始顺序与价格无关。 */
    private val books: Array<Book> = arrayOf(
        Book(
            title = "深入理解计算机系统（第3版）",
            author = "Randal E. Bryant",
            publisher = "机械工业出版社",
            price = 139.00,
            isbn = "9787111544937",
            publishDate = "2016-11",
            category = "计算机基础",
            description = "从程序员视角讲解计算机系统，涵盖程序表示、处理器体系结构、存储器层次结构与链接等内容。"
        ),
        Book(
            title = "代码整洁之道",
            author = "Robert C. Martin",
            publisher = "人民邮电出版社",
            price = 59.00,
            isbn = "9787115216878",
            publishDate = "2010-01",
            category = "编程实践",
            description = "讲述命名、函数、格式、错误处理与单元测试等编写整洁代码的原则与实践。"
        ),
        Book(
            title = "Java 核心技术 卷I（第11版）",
            author = "Cay S. Horstmann",
            publisher = "机械工业出版社",
            price = 149.00,
            isbn = "9787111611118",
            publishDate = "2019-01",
            category = "程序设计",
            description = "Java 语言基础知识与核心技术详解，包含面向对象、集合、并发等主题。"
        ),
        Book(
            title = "Kotlin 实战",
            author = "Dmitry Jemerov, Svetlana Isakova",
            publisher = "电子工业出版社",
            price = 79.00,
            isbn = "9787121302957",
            publishDate = "2017-01",
            category = "移动开发",
            description = "系统介绍 Kotlin 语言特性及其在 Android 开发中的实际应用。"
        ),
        Book(
            title = "算法导论（原书第3版）",
            author = "Thomas H. Cormen",
            publisher = "机械工业出版社",
            price = 128.00,
            isbn = "9787111407010",
            publishDate = "2013-01",
            category = "算法与数据结构",
            description = "全面讲解算法的设计与分析方法，覆盖排序、图算法、动态规划等经典内容。"
        ),
        Book(
            title = "第一行代码：Android（第3版）",
            author = "郭霖",
            publisher = "人民邮电出版社",
            price = 99.00,
            isbn = "9787115544321",
            publishDate = "2020-07",
            category = "移动开发",
            description = "从零开始讲解 Android 应用开发，包含四大组件、UI 布局与数据存储等。"
        ),
        Book(
            title = "重构：改善既有代码的设计（第2版）",
            author = "Martin Fowler",
            publisher = "人民邮电出版社",
            price = 118.00,
            isbn = "9787115228313",
            publishDate = "2019-04",
            category = "编程实践",
            description = "通过一系列重构手法改善既有代码的结构，提高可读性与可维护性。"
        ),
        Book(
            title = "计算机网络：自顶向下方法（第7版）",
            author = "James F. Kurose",
            publisher = "机械工业出版社",
            price = 89.00,
            isbn = "9787111593582",
            publishDate = "2018-06",
            category = "计算机网络",
            description = "以自顶向下的方式讲解网络协议与应用层、传输层、网络层等核心概念。"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 第 1 个 Activity 的标题：姓名 + 学号
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.title_main)

        // 对数组里的书籍按价格从低到高排序
        books.sortBy { it.price }

        findViewById<TextView>(R.id.tv_list_header).text =
            getString(R.string.list_header_format, books.size)

        val listView = findViewById<ListView>(R.id.lv_books)
        listView.adapter = BookAdapter(this, books)
        listView.setOnItemClickListener { _, _, position, _ ->
            openBookDetail(books[position])
        }
    }

    /** 启动第 2 个 Activity，并把被选中书籍的完整信息传过去。 */
    private fun openBookDetail(book: Book) {
        val intent = Intent(this, BookDetailActivity::class.java).apply {
            putExtra(BookDetailActivity.EXTRA_TITLE, book.title)
            putExtra(BookDetailActivity.EXTRA_AUTHOR, book.author)
            putExtra(BookDetailActivity.EXTRA_PUBLISHER, book.publisher)
            putExtra(BookDetailActivity.EXTRA_PRICE, book.price)
            putExtra(BookDetailActivity.EXTRA_ISBN, book.isbn)
            putExtra(BookDetailActivity.EXTRA_PUBLISH_DATE, book.publishDate)
            putExtra(BookDetailActivity.EXTRA_CATEGORY, book.category)
            putExtra(BookDetailActivity.EXTRA_DESCRIPTION, book.description)
        }
        startActivity(intent)
    }
}