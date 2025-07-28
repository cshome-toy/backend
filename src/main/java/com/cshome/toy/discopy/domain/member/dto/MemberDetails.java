    package com.cshome.toy.discopy.domain.member.dto;

    import com.cshome.toy.discopy.domain.member.entity.Member;
    import lombok.Getter;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.security.core.GrantedAuthority;
    import org.springframework.security.core.userdetails.UserDetails;

    import java.time.LocalDate;
    import java.util.Collection;
    import java.util.List;

    @Slf4j
    @Getter
    public class MemberDetails implements UserDetails {
        private final Long id;
        private final String email;
        private final String password;
        private final String nickname;
        private final LocalDate birthday;
        private final String name;
        private final List<? extends GrantedAuthority> authorities;

        public MemberDetails(Member member) {
            this.id = member.getId();
            this.email = member.getEmail();
            this.password = member.getPassword();
            this.nickname = member.getNickname();
            this.birthday = member.getBirthday();
            this.name = member.getUsername();
            this.authorities = List.of(() -> "ROLE_USER");
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return authorities;
        }

        @Override
        public String getUsername() {
            return email;
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
    }
