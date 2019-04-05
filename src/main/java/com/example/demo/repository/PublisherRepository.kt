package com.example.demo.repository

import com.example.demo.model.Publisher
import org.springframework.data.repository.CrudRepository


interface PublisherRepository: CrudRepository<Publisher, Long>{

}