package com.borqs.server.impl.migration.friend;

class MigrationFriend {
    private long user;
    private long friend;
    private int cricle;
    private int type;
    private long updated_time;
    private int reason;

    public MigrationFriend(){
        
    }
    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }

    public long getFriend() {
        return friend;
    }

    public void setFriend(long friend) {
        this.friend = friend;
    }

    public int getCricle() {
        return cricle;
    }

    public void setCricle(int cricle) {
        this.cricle = cricle;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getUpdated_time() {
        return updated_time;
    }

    public void setUpdated_time(long updated_time) {
        this.updated_time = updated_time;
    }

    public int getReason() {
        return reason;
    }

    public void setReason(int reason) {
        this.reason = reason;
    }
}
