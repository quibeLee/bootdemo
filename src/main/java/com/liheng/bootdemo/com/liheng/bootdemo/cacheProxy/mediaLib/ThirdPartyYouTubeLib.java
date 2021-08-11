package com.liheng.bootdemo.com.liheng.bootdemo.cacheProxy.mediaLib;

import java.util.HashMap;

/**
 * 视频库
 */
public interface ThirdPartyYouTubeLib {
    HashMap<String, Video> popularVideos();

    Video getVideo(String videoId);
}
