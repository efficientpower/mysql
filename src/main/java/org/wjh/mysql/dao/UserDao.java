package org.wjh.mysql.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.wjh.mysql.common.datasource.DataSource;
import org.wjh.mysql.common.datasource.DataSourceConstant;
import org.wjh.mysql.domain.User;

public interface UserDao {

    @DataSource(DataSourceConstant.MASTER)
    public Integer insert(User user);

    @DataSource(DataSourceConstant.MASTER)
    public Integer insertSelective(User user);

    @DataSource(DataSourceConstant.MASTER)
    public void batchInsert(List<User> users);

    @DataSource(DataSourceConstant.MASTER)
    public void update(User user);

    @DataSource(DataSourceConstant.MASTER)
    public void updateSelective(User user);

    @DataSource(DataSourceConstant.MASTER)
    public void batchUpdate(List<User> users);

    @DataSource(DataSourceConstant.SLAVE)
    public User getById(Integer id);

    @DataSource(DataSourceConstant.SLAVE)
    public List<User> getByIds(List<Integer> id);

    @DataSource(DataSourceConstant.SLAVE)
    public User getByUserId(String userId);

    @DataSource(DataSourceConstant.SLAVE)
    public List<User> getByUserIds(List<String> userId);

    @DataSource(DataSourceConstant.SLAVE)
    public List<User> list(@Param("orderBy") String orderBy, @Param("offset") Integer offset, @Param("size") Integer size);
}
