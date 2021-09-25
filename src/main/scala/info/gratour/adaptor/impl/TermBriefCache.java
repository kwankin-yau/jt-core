/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor.impl;

import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import info.gratour.jtmodel.TermBrief;

import java.util.concurrent.TimeUnit;

public class TermBriefCache {

    public interface TermBriefLoader {
        TermBrief load(String simNo);
    }

    private final TermBriefLoader loader;

    public TermBriefCache(TermBriefLoader loader) {
        this.loader = loader;
    }

    private final LoadingCache<String, TermBrief> cache = Caffeine.newBuilder()
            .expireAfterWrite(5, TimeUnit.MINUTES)
            .build(new CacheLoader<String, TermBrief>() {
                @Override
                public TermBrief load(String key) throws Exception {
                    return loader.load(key);
                }
            });

    public TermBrief get(String simNo) {
        return cache.get(simNo);
    }
}
