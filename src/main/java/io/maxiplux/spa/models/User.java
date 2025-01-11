package io.maxiplux.spa.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


public class User implements Serializable {


	private static final long serialVersionUID = 1L;



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 30, unique = true)
	private String username;

	private String password;
	private boolean enabled;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<Role> roles;

//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//
//		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//
//		this.roles.forEach(role -> {
//			authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
//		});
//
//
//
//		return authorities;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		return this.enabled;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return this.enabled;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		//put a expiere time ot TTL
//		return this.enabled;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return this.enabled;
//	}
}
