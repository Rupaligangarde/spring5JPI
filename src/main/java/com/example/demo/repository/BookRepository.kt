package com.example.demo.repository

import com.example.demo.model.Book
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<Book, Long>