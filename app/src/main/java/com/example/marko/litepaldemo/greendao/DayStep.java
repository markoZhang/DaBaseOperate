package com.example.marko.litepaldemo.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * @author Marko
 * @date 2019/3/15
 */

@Entity(nameInDb = "DayStep")
public class DayStep {

    @Id
    private long id;
    private String date;
    private int step;
    private long sportId;
    @ToOne(joinProperty = "sportId")
    private SportInfo sportInfo;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 689458881)
    private transient DayStepDao myDao;
    @Generated(hash = 349734887)
    public DayStep(long id, String date, int step, long sportId) {
        this.id = id;
        this.date = date;
        this.step = step;
        this.sportId = sportId;
    }
    @Generated(hash = 121003456)
    public DayStep() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getDate() {
        return this.date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public int getStep() {
        return this.step;
    }
    public void setStep(int step) {
        this.step = step;
    }
    public long getSportId() {
        return this.sportId;
    }
    public void setSportId(long sportId) {
        this.sportId = sportId;
    }
    @Generated(hash = 449419486)
    private transient Long sportInfo__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 5621631)
    public SportInfo getSportInfo() {
        long __key = this.sportId;
        if (sportInfo__resolvedKey == null
                || !sportInfo__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SportInfoDao targetDao = daoSession.getSportInfoDao();
            SportInfo sportInfoNew = targetDao.load(__key);
            synchronized (this) {
                sportInfo = sportInfoNew;
                sportInfo__resolvedKey = __key;
            }
        }
        return sportInfo;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 586480698)
    public void setSportInfo(@NotNull SportInfo sportInfo) {
        if (sportInfo == null) {
            throw new DaoException(
                    "To-one property 'sportId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.sportInfo = sportInfo;
            sportId = sportInfo.getSportId();
            sportInfo__resolvedKey = sportId;
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
    @Generated(hash = 1246360032)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getDayStepDao() : null;
    }
}
