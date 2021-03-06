package com.asofdate.hauth.dao.impl;

import com.asofdate.hauth.dao.UserThemeDao;
import com.asofdate.hauth.sql.SqlText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by hzwy23 on 2017/5/17.
 */
@Repository
public class UserThemeDaoImpl implements UserThemeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private SqlText sqlText;

    @Override
    public String findById(String userId) {
        String themeId = jdbcTemplate.queryForObject(sqlText.getSql("sys103"), String.class, userId);
        return themeId;
    }

    @Override
    public int changeTheme(String themeId, String username) {
        return jdbcTemplate.update(sqlText.getSql("sys024"), themeId, username);
    }
}
