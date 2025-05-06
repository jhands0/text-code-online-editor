package com.example.backend.collection;

import com.example.backend.models.User;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepositoryImpl implements UserRepository {
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

    @Override
    public User save(User user) {
        userCol.insert(user.getEmail(), user);
        return user;
    }

    @Override
    public User update(String id, User user) {
        userCol.replace(id, user);
        return user;
    }
}
