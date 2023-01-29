package io.maxiplux.spa.repositories;


import io.maxiplux.spa.models.Role;
import io.maxiplux.spa.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {


}
