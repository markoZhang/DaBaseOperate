package com.example.marko.litepaldemo.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * @author Marko
 * @date 2019/3/15
 */

@Entity(nameInDb = "UserInfo")
public class UserInfo {
    @Id
    private Long userId;
    //账号
    private String number;
    //密码
    private String password;
    //昵称
    private String nick_name;
    //一对多关联
    @ToMany(referencedJoinProperty = "sportId")
    private List<SportInfo> sportInfo;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 437952339)
    private transient UserInfoDao myDao;
    @Generated(hash = 1445688962)
    public UserInfo(Long userId, String number, String password, String nick_name) {
        this.userId = userId;
        this.number = number;
        this.password = password;
        this.nick_name = nick_name;
    }
    @Generated(hash = 1279772520)
    public UserInfo() {
    }
    public Long getUserId() {
        return this.userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getNumber() {
        return this.number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNick_name() {
        return this.nick_name;
    }
    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 340723967)
    public List<SportInfo> getSportInfo() {
        if (sportInfo == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SportInfoDao targetDao = daoSession.getSportInfoDao();
            List<SportInfo> sportInfoNew = targetDao
                    ._queryUserInfo_SportInfo(userId);
            synchronized (this) {
                if (sportInfo == null) {
                    sportInfo = sportInfoNew;
                }
            }
        }
        return sportInfo;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 683486721)
    public synchronized void resetSportInfo() {
        sportInfo = null;
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
    @Generated(hash = 821180768)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserInfoDao() : null;
    }
}
