package senai.org.prjjava.repository;

import org.springframework.data.repository.CrudRepository;

import senai.org.prjjava.entity.Usuario;

public interface  UsuarioRepository extends CrudRepository<Usuario, Integer>{
    
}
