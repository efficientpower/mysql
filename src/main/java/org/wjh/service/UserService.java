package org.wjh.service;

import java.util.List;

import org.wjh.domain.User;

public interface UserService {

    public Integer insert(User user);

    public Integer insertSelective(User user);

    public void update(User user);

    public void updateSelective(User user);

    public User getById(Integer id);

    public User getByUserId(String userId);

    public List<User> list(String orderBy, Integer offset, Integer size);
    
    public void updateInTrans(String userId);
}
