package com.example.openfeign.utils;

import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * IpUtil
 *
 * Description: IP地址相关工具
 *
 * @author Mr.Cui
 * @date 2020-08-26
 */
@Slf4j
public class IpUtil {

    private static final String ipPattern = "^(?:(?:[01]?\\d{1,2}|2[0-4]\\d|25[0-5])\\.){3}(?:[01]?\\d{1,2}|2[0-4]\\d|25[0-5])\\b";

    /**
     * 获取服务器本地IP
     *
     * @return
     */
    public static String getLocalIp(){
        String ipsStr = "";
        try {
            Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
            while (netInterfaces.hasMoreElements()) {
                NetworkInterface ni = netInterfaces.nextElement();
                Enumeration<InetAddress> ips = ni.getInetAddresses();
                Pattern pattern = Pattern.compile(ipPattern);
                while (ips.hasMoreElements()) {
                    String ip = ips.nextElement().getHostAddress();
                    Matcher matcher = pattern.matcher(ip);
                    if (matcher.matches() && !ip.equals("127.0.0.1")) {
                        ipsStr = ip;
                    }
                }
            }
        }
        catch (Exception e){
            log.error("getLocalIp error", e);
        }
        return ipsStr;
    }
}
