package com.liheng.bootdemo.com.liheng.bootdemo.cacheProxy;

import com.liheng.bootdemo.com.liheng.bootdemo.cacheProxy.downLoader.YouTubeDownloader;
import com.liheng.bootdemo.com.liheng.bootdemo.cacheProxy.mediaLib.ThirdPartyYouTubeClass;
import com.liheng.bootdemo.com.liheng.bootdemo.cacheProxy.proxy.YouTubeCacheProxy;

public class Demo {
    public static void main(String[] args) {
        YouTubeDownloader naiveDownloader = new YouTubeDownloader(new ThirdPartyYouTubeClass());
        YouTubeDownloader smartDownloader = new YouTubeDownloader(new YouTubeCacheProxy());

        long naive = test(naiveDownloader);
        long smart = test(smartDownloader);
        System.out.print("Time saved by caching proxy: " + (naive - smart) + "ms");

    }

    private static long test(YouTubeDownloader downloader) {
        long startTime = System.currentTimeMillis();

        // User behavior in our app:
        downloader.renderPopularVideos();
        downloader.renderVideoPage("catzzz1111");
        downloader.renderPopularVideos();
        downloader.renderVideoPage("dancez3333");
        // Users might visit the same page quite often.
        downloader.renderVideoPage("catzzz1111");
        downloader.renderVideoPage("someothervid");

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("Time elapsed: " + estimatedTime + "ms\n");
        System.out.println("-------------------下载完成---------------------------");
        return estimatedTime;
    }
}
