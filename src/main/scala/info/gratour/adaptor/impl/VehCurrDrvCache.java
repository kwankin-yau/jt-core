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
import info.gratour.adaptor.VehCurrDrvRepo;
import info.gratour.adaptor.types.VehCurrDrv;

import java.util.concurrent.TimeUnit;

public class VehCurrDrvCache implements VehCurrDrvRepo {

    private final VehCurrDrvRepo repo;

    public VehCurrDrvCache(VehCurrDrvRepo repo) {
        this.repo = repo;
    }

    private LoadingCache<Long, VehCurrDrv> cache = Caffeine.newBuilder()
            .expireAfterWrite(5, TimeUnit.MINUTES)
            .build(new CacheLoader<Long, VehCurrDrv>() {
                @Override
                public VehCurrDrv load(Long key) throws Exception {
                    return repo.load(key);
                }
            });

    @Override
    public VehCurrDrv load(long vehId) {
        return cache.get(vehId);
    }

    @Override
    public void put(VehCurrDrv currDrv) {
        cache.put(currDrv.getVehId(), currDrv);
        repo.put(currDrv);
    }
}
