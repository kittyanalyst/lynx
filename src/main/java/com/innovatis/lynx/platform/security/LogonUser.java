package com.innovatis.lynx.platform.security;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by Ramakrishna Chalasani 02/01/2017..
 */
public class LogonUser implements UserDetails {

    private Long userId;

    private String logonId;

    private String userTypeCode;

    private String fcoCode;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLogonId() {
        return logonId;
    }

    public void setLogonId(String logonId) {
        this.logonId = logonId;
    }

    public String getUserTypeCode() {
        return userTypeCode;
    }

    public void setUserTypeCode(String userTypeCode) {
        this.userTypeCode = userTypeCode;
    }

    public String getFcoCode() {
        return fcoCode;
    }

    public void setFcoCode(String fcoCode) {
        this.fcoCode = fcoCode;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.logonId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        LogonUser rhs = (LogonUser) obj;
        return new EqualsBuilder()
                .append(this.userId, rhs.userId)
                .append(this.logonId, rhs.logonId)
                .append(this.userTypeCode, rhs.userTypeCode)
                .append(this.fcoCode, rhs.fcoCode)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(userId)
                .append(logonId)
                .append(userTypeCode)
                .append(fcoCode)
                .toHashCode();
    }

    public static final class Builder {
        private Long userId;
        private String logonId;
        private String userTypeCode;
        private String fcoCode;

        public Builder() {
        }

        public static Builder aLogonUser() {
            return new Builder();
        }

        public Builder withUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder withLogonId(String logonId) {
            this.logonId = logonId;
            return this;
        }

        public Builder withUserTypeCode(String userTypeCode) {
            this.userTypeCode = userTypeCode;
            return this;
        }

        public Builder withFcoCode(String fcoCode) {
            this.fcoCode = fcoCode;
            return this;
        }

        public LogonUser build() {
            LogonUser logonUser = new LogonUser();
            logonUser.setUserId(userId);
            logonUser.setLogonId(logonId);
            logonUser.setUserTypeCode(userTypeCode);
            logonUser.setFcoCode(fcoCode);
            return logonUser;
        }
    }
}
