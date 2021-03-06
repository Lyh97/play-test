package com.user.function.modules;

import com.google.inject.AbstractModule;
import com.user.function.dao.UserProfileDao;
import com.user.function.dao.daoimpl.UserProfileDaoImpl;
import com.user.function.dbpool.DbcpDataSourceFactory;
import com.user.function.redis.RedisConnector;
import com.user.function.redis.RedisUtil;
import com.user.function.service.UserProfileService;
import com.user.function.service.UserProfileServiceImpl;
import org.apache.ibatis.datasource.DataSourceFactory;
import play.libs.akka.AkkaGuiceSupport;

/**
 * The type Module.
 */
public final class Module extends AbstractModule implements AkkaGuiceSupport {
    /**
     * Instantiates a new Module.
     */
    public Module() {
    }

    @Override
    public void configure() {
        bind(RedisConnector.class).to(RedisUtil.class);
        bind(DataSourceFactory.class).to(DbcpDataSourceFactory.class);
        bind(UserProfileService.class).to(UserProfileServiceImpl.class);
        bind(UserProfileDao.class).to(UserProfileDaoImpl.class);
    }
}
