package uz.pdp.appjwtrealemailauditing.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private UUID id;//userning takrorlanmas raqami

    @Column(nullable = false,length = 50)
    private String firstName;//Ismi

    @Column(nullable = false)
    private String lastName;//familiyasi

    @Email
    @Column(unique = true,nullable = false)
    private String email;// userning emaili (Username sifatida)

    @Column(nullable = false)
    private String password;// kalit sozi

    @Column(nullable = false,updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;//qachon ro'yxatdan o'tganligi

    @UpdateTimestamp
    private Timestamp updatedAt;//ohirgi marta qachon tahrirdan o'tganlii

    @ManyToMany
    private Set<Role> roles;

    private boolean accountNonExpired=true;//bu userning amal qilish muddati utmaganligi

    private boolean accountNonLocked=true;// bu User blocklanmaganligi

    private boolean credentialsNonExpired=true;//
    private boolean enabled;//

    private String emailCode;

    //---------------- Bu userDetails ning metodlari-------//

    //Bu Userning Huquqlari ro'yxati
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    //userning usernameni qaytaruvchi method
    @Override
    public String getUsername() {
        return this.email;
    }

    //Bu accountni amal qilish muddati
    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    // Bu account bloklanganligi xolatini qaytaradi
    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    //  Accountning ishonchlilik muddati tugagan yoki tugamaganligini  qaytaradi
    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    // accountning yoniq yoki ochiqligini qaytaradi
    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
