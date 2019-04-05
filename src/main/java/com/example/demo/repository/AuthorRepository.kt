package com.example.demo.repository

import com.example.demo.model.Author
import org.springframework.data.repository.CrudRepository

interface AuthorRepository : CrudRepository<Author, Long>