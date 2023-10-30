package com.tofattobat.tinyurl;

import org.springframework.data.repository.CrudRepository;

interface LinkRepository extends CrudRepository <Link, String>{
}
