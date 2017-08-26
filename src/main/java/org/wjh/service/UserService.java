package org.wjh.service;

import java.util.List;

import org.wjh.domain.User;

public interface UserService {

    public Integer insert(User user);

    public Integer insertSelective(User user);

    public void batchInsert(List<User> users);

    public void update(User user);

    public void updateSelective(User user);

    public void batchUpdate(List<User> users);

    public User getById(Integer id);

    public List<User> getByIds(List<Integer> ids);

    public User getByUserId(String userId);

    public List<User> getByUserIds(List<String> userIds);

    public List<User> list(String orderBy, Integer offset, Integer size);

    public void updateInTrans(String userId);
}
