package com.example.demo.config;

import java.time.Duration;
import java.util.Map;

import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import com.google.common.collect.ImmutableMap;

/**
 * 
 * 类 @code(CacheManagerConfiguration)
 *
 * <p>
 *  功能简介：
 * <p>
* 多缓存源配置类
 * <p>
 *  创建时间：2019年9月30日
 *
 * @author chenxj
 */
@Configuration
@EnableCaching
@EnableConfigurationProperties(CacheProperties.class)
public class CacheManagerConfiguration {
    private final CacheProperties cacheProperties;
    public CacheManagerConfiguration(CacheProperties cacheProperties)    {
        this.cacheProperties = cacheProperties;
    }
    public interface CacheManagerNames {
        String REDIS_CACHE_MANAGER = "redisCacheManager";
        String EHCACHE_CACHE_MANAGER = "ehCacheManager";
    }

    @Bean(name = CacheManagerNames.REDIS_CACHE_MANAGER)
    public RedisCacheManager redisCacheManager(RedisConnectionFactory factory) {
        Map<String, RedisCacheConfiguration> expires = ImmutableMap.<String, RedisCacheConfiguration>builder()
                .put("15", RedisCacheConfiguration.defaultCacheConfig().entryTtl(
                        Duration.ofMillis(15)
                ))
                .put("30", RedisCacheConfiguration.defaultCacheConfig().entryTtl(
                        Duration.ofMillis(30)
                ))
                .put("60", RedisCacheConfiguration.defaultCacheConfig().entryTtl(
                        Duration.ofMillis(60)
                ))
                .put("120", RedisCacheConfiguration.defaultCacheConfig().entryTtl(
                        Duration.ofMillis(120)
                ))
                .build();

        RedisCacheManager redisCacheManager = RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(factory)
                .withInitialCacheConfigurations(expires)
                .build();
        return redisCacheManager;
    }

    @Bean(name = CacheManagerNames.EHCACHE_CACHE_MANAGER)
    @Primary
    public EhCacheCacheManager ehCacheManager() {
        Resource resource = this.cacheProperties.getEhcache().getConfig();
        resource = this.cacheProperties.resolveConfigLocation(resource);
        EhCacheCacheManager ehCacheManager = new EhCacheCacheManager(
                EhCacheManagerUtils.buildCacheManager(resource)
        );
        ehCacheManager.afterPropertiesSet();
        return ehCacheManager;
    }
}


