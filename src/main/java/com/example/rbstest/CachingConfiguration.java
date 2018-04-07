package com.example.rbstest;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;
import com.hazelcast.config.NetworkConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CachingConfiguration {

    //1 week
    public static final int DEFAULT_CACHE_TTL = 604800;

    @Bean
    public Config hazelCastConfig(){

        Config config = new Config();
        NetworkConfig networkConfig = config.setInstanceName("hazelcast-instance").getNetworkConfig();
        networkConfig.getJoin().getMulticastConfig().setEnabled(false);
        networkConfig.getJoin().getTcpIpConfig().setEnabled(false);
        config.addMapConfig(newMapConfig("primesCache", DEFAULT_CACHE_TTL));

        return config;
    }

    private MapConfig newMapConfig(final String name, int definitionCacheTTL) {
        return new MapConfig().setName(name)
                .setMaxSizeConfig(new MaxSizeConfig(200, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE))
                .setEvictionPolicy(EvictionPolicy.LRU)
                .setTimeToLiveSeconds(definitionCacheTTL);
    }

}