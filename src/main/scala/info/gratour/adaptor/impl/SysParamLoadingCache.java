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
import info.gratour.jtmodel.SysParam;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class SysParamLoadingCache {

    public interface Loader {

        SysParam load(String scope, String name);
    }

    class Key {
        String scope;
        String name;

        public Key(String scope, String name) {
            this.scope = scope;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return Objects.equals(scope, key.scope) &&
                    Objects.equals(name, key.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(scope, name);
        }
    }

    private final Loader loader;
    private final LoadingCache<Key, SysParam> cache;

    public SysParamLoadingCache(Loader loader) {
        this.loader = loader;
        cache = Caffeine.newBuilder()
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .build(new CacheLoader<Key, SysParam>() {
                    @Override
                    public SysParam load(Key key) throws Exception {
                        SysParam r = loader.load(key.scope, key.name);
                        if (r == null) {
                            r = new SysParam();
                            r.setScope(key.scope);
                            r.setName(key.name);
                        }

                        return r;
                    }
                });
    }

    public String get(String scope, String name) {
        Key key = new Key(scope, name);
        SysParam sp = cache.get(key);
        if (sp != null)
            return sp.getValue();
        else
            return null;
    }

    public void invalidateAll() {
        cache.invalidateAll();
    }
}
