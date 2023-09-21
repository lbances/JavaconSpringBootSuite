package edu.idat.pe;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProducto extends CrudRepository<CProducto, Long> {

}
