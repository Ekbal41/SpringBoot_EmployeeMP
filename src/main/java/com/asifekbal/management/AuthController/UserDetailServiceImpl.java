package com.asifekbal.management.AuthController;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.asifekbal.management.Repo.UserRepository;
import com.asifekbal.management.Shema.User;




public class UserDetailServiceImpl implements UserDetailsService{
   
    @Autowired
    private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=repository.getUserByUsername(username);
        
        if(user==null){
            throw new UsernameNotFoundException("username not found");
        }
		return new MyUserDetail(user);
	}
    
}