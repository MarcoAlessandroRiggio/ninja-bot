package org.pubcoding.ninjacli.repository;

import org.pubcoding.ninjacli.model.Enchantment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnchantmentRepository extends JpaRepository<Enchantment, Integer> {
}