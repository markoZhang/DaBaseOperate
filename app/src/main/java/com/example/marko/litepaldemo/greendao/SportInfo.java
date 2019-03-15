package com.example.marko.litepaldemo.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * @author Marko
 * @date 2019/3/15
 */

@Entity(nameInDb ="SportInfo" )
public class SportInfo {

    @Id
    private Long sportId;
    private String date = "";
    private Long userId;
    @ToOne(joinProperty = "userId")
    private UserInfo userInfo;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 294877999)
    private transient SportInfoDao myDao;
    @Generated(hash = 463731598)
    public SportInfo(Long sportId, String date, Long userId) {
        this.sportId = sportId;
        this.date = date;
        this.userId = userId;
    }
    @Generated(hash = 1254911132)
    public SportInfo() {
    }
    public Long getSportId() {
        return this.sportId;
    }
    public void setSportId(Long sportId) {
        this.sportId = sportId;
    }
    public String getDate() {
        return this.date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public Long getUserId() {
        return this.userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    @Generated(hash = 2066097151)
    private transient Long userInfo__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1827626095)
    public UserInfo getUserInfo() {
        Long __key = this.userId;
        if (userInfo__resolvedKey == null || !userInfo__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UserInfoDao targetDao = daoSession.getUserInfoDao();
            UserInfo userInfoNew = targetDao.load(__key);
            synchronized (this) {
                userInfo = userInfoNew;
                userInfo__resolvedKey = __key;
            }
        }
        return userInfo;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 452425861)
    public void setUserInfo(UserInfo userInfo) {
        synchronized (this) {
            this.userInfo = userInfo;
            userId = userInfo == null ? null : userInfo.getUserId();
            userInfo__resolvedKey = userId;
        }
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 570744676)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getSportInfoDao() : null;
    }
}
