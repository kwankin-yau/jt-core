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
import info.gratour.jtmodel.alm.AlmParam;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class AlmParamLocalCache {

    public interface AlmParamLoader {

        AlmParam load(long corpId, String almTyp);
    }

    public static class Key {
        private long corpId;
        private String almTyp;

        public Key() {
        }

        public Key(long corpId, String almTyp) {
            this.corpId = corpId;
            this.almTyp = almTyp;
        }

        public long getCorpId() {
            return corpId;
        }

        public String getAlmTyp() {
            return almTyp;
        }

        static String toKey(long corpId, String almTyp) {
            return corpId + ":" + almTyp;
        }

        public static Key parse(String key) {
            int p = key.indexOf(':');
            if (p <= 0)
                return null;

            Key k = new Key();
            k.corpId = Long.parseLong(key.substring(0, p));
            k.almTyp = key.substring(p + 1);

            return k;
        }

        public String key() {
            return toKey(corpId, almTyp);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return corpId == key.corpId &&
                    almTyp.equals(key.almTyp);
        }

        @Override
        public int hashCode() {
            return Objects.hash(corpId, almTyp);
        }
    }

    private LoadingCache<Key, AlmParam> cache;

    public AlmParamLocalCache(AlmParamLoader loader) {
        cache = Caffeine.newBuilder()
                .refreshAfterWrite(30, TimeUnit.MINUTES)
                .build(new CacheLoader<Key, AlmParam>() {
                    @Override
                    public AlmParam load(Key key) throws Exception {
                        return loader.load(key.corpId, key.almTyp);
                    }
                });
    }

    public AlmParam find(long corpId, String almTyp) {
        if (almTyp == null)
            throw new NullPointerException("almTyp is null.");

        return cache.get(new Key(corpId, almTyp));
    }

    public void invalid(Key key) {
        cache.invalidate(key);
    }

    public void invalid(long corpId, String almTyp) {
        cache.invalidate(new Key(corpId, almTyp));
    }

}
