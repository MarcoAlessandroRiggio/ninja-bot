package org.pubcoding.ninjacli.repository;

import org.pubcoding.ninjacli.model.Enchantment;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EnchantmentRepository extends CrudRepository<Enchantment, Integer> {

    public Optional<Enchantment> findByName(final String name);

}