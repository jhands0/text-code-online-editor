package com.example.backend.collection;

import com.example.backend.models.User;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.stereotype.Repository;

public interface UserRespository {
    User findById(String id);
}
@Repository
public class UserRepositoryImpl implements UserRespository {
    private final Cluster cluster;
    private final Collection userCol;

    public UserRepositoryImpl(Cluster cluster, Bucket bucket) {
        this.cluster = cluster;
        this.userCol = bucket.scope("records").collection("user");
    }

    @Override
    public User findById(String id) {
        return userCol.get(id).contentAs(User.class);
    }
}
