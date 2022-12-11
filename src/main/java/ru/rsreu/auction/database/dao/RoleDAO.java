package ru.rsreu.auction.database.dao;

import ru.rsreu.auction.data.Role;
import java.util.List;
import java.util.Optional;

public interface RoleDAO {
	Optional<Role> findById(Long userId);
	Optional<Role> findByName(String roleName);
}
