package com.example.androidtest

/**
 * 书籍实体类，保存一本书的完整信息。
 *
 * @param title 书名
 * @param author 作者
 * @param publisher 出版社
 * @param price 价格（元）
 * @param isbn ISBN 编号
 * @param publishDate 出版日期
 * @param category 分类
 * @param description 内容简介
 */
data class Book(
    val title: String,
    val author: String,
    val publisher: String,
    val price: Double,
    val isbn: String,
    val publishDate: String,
    val category: String,
    val description: String
)