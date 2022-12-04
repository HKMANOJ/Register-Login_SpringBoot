package com.example.manoj;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImp implements InterfacUserService {

	
	@Autowired
	private Repository repo;

	
	public UserServiceImp(Repository repo) {
		super();
		this.repo = repo;
}
	@Override
	@Transactional
	public User saveData(User user) {
		User us=new User();
		us.setEmail(user.getEmail());
		us.setId(user.getId());
		us.setUsername(user.getUsername());
		us.setPassword(user.getPassword());
	//	us.setPlace(user.getPlace());
		
		return repo.save(us);
	}
//	@Override
//	public User saveData(User user) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
