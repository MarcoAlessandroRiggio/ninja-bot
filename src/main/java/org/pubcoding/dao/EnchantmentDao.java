package org.pubcoding.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import org.pubcoding.model.Enchantment;

import java.sql.SQLException;
import java.util.List;

public class EnchantmentDao extends BaseDaoImpl<Enchantment, Integer> {
    protected EnchantmentDao(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, Enchantment.class);
    }

    public List<Enchantment> findByName(String name) throws SQLException {
        return super.queryForEq("name", name);
    }

}
