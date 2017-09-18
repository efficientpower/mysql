package org.wjh.mysql.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wjh.mysql.dao.UserDao;
import org.wjh.mysql.domain.User;
import org.wjh.mysql.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Integer insert(User user) {
        // TODO Auto-generated method stub
        userDao.insert(user);
        return user.getId();
    }

    @Override
    public Integer insertSelective(User user) {
        // TODO Auto-generated method stub
        userDao.insertSelective(user);
        return user.getId();
    }

    @Override
    public void batchInsert(List<User> users) {
        // TODO Auto-generated method stub
        userDao.batchInsert(users);
    }

    @Override
    public void update(User user) {
        // TODO Auto-generated method stub
        userDao.update(user);
    }

    @Override
    public void updateSelective(User user) {
        // TODO Auto-generated method stub
        userDao.updateSelective(user);
    }

    @Override
    public void batchUpdate(List<User> users) {
        // TODO Auto-generated method stub
        userDao.batchUpdate(users);
    }

    @Override
    public User getById(Integer id) {
        // TODO Auto-generated method stub
        return userDao.getById(id);
    }

    @Override
    public List<User> getByIds(List<Integer> ids) {
        // TODO Auto-generated method stub
        return userDao.getByIds(ids);
    }

    @Override
    public User getByUserId(String userId) {
        // TODO Auto-generated method stub
        return userDao.getByUserId(userId);
    }

    @Override
    public List<User> getByUserIds(List<String> userIds) {
        // TODO Auto-generated method stub
        return userDao.getByUserIds(userIds);
    }

    @Override
    public List<User> list(String orderBy, Integer offset, Integer size) {
        // TODO Auto-generated method stub
        return userDao.list(orderBy, offset, size);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateInTrans(String userId) {
        // TODO Auto-generated method stub
        User user = userDao.getByUserId(userId);
        user.setDbUpdateTime(new Date());
        userDao.updateSelective(user);
    }

}
