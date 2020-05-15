package com.maodun;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maodunWorld
 * @version 1.0
 * @date 2020/5/15 14:47
 */
@ConfigurationProperties("my")
public class ServersConf {
    private List<String> servers = new ArrayList<String>();

    public List<String> getServers() {
        return servers;
    }
}
