package com.sysu.workflow.service.identityservice.sessionfactory;

import com.sysu.workflow.entity.GroupEntity;
import com.sysu.workflow.service.identityservice.GroupDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA
 * Date: 2015/12/16
 * Time: 13:17
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://blog.csdn.net/c601097836</a>
 * Email: 601097836@qq.com
 */
public class GroupDaoImpl implements GroupDao {
    @Resource(name = "sessionFactory")
    SessionFactory sessionFactory;

    @Transactional
    public boolean addGroup(GroupEntity groupEntity) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();

            session.save(groupEntity);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return true;
    }

    @Transactional
    public ArrayList<GroupEntity> findGroup(GroupEntity groupEntity) {
        Session session = null;

        try {
            session = sessionFactory.getCurrentSession();

            if (groupEntity.getGroupId() != 0) {
                return findGroupByGroupId(String.valueOf(groupEntity.getGroupId()));
            } else if (groupEntity.getGroupName() != null) {
                return findGroupByGroupName(groupEntity.getGroupName());
            } else {
                //TODO:其他各种访问方式
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return null;
    }

    @Transactional
    public ArrayList<GroupEntity> findGroupByGroupName(String groupName) {

        Session session = null;
        ArrayList<GroupEntity> groupEntityArrayList = new ArrayList<GroupEntity>();
        try {
            session = sessionFactory.getCurrentSession();

            Criteria criteria = session.createCriteria(GroupEntity.class);

            Criterion groupNameCriterion = Restrictions.eq("groupName", groupName);
            criteria.add(groupNameCriterion);

            groupEntityArrayList = (ArrayList<GroupEntity>) criteria.list();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return groupEntityArrayList;

    }

    @Transactional
    public ArrayList<GroupEntity> findGroupByGroupId(String groupId) {
        Session session = null;
        ArrayList<GroupEntity> groupEntityArrayList = new ArrayList<GroupEntity>();
        try {
            session = sessionFactory.getCurrentSession();

            Criteria criteria = session.createCriteria(GroupEntity.class);

            Criterion groupIdCriterion = Restrictions.eq("groupId", groupId);
            criteria.add(groupIdCriterion);

            groupEntityArrayList = (ArrayList<GroupEntity>) criteria.list();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return groupEntityArrayList;
    }

    @Transactional
    public boolean updateGroup(GroupEntity groupEntity) {
        return false;
    }

    @Transactional
    public boolean deleteGroup(GroupEntity groupEntity) {
        return false;
    }

    @Transactional
    public boolean deleteGroupById(String groupId) {
        return false;
    }


}
