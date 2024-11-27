package vn.iotstar.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLMutationResolver;
import vn.iotstar.entity.User;
import vn.iotstar.repository.UserRepository;

@Component
public class MutationResolver implements GraphQLMutationResolver {
	@Autowired
	private UserRepository userRepository;

	public User createUser(String fullname, String email, String password, String phone) {
		User user = new User();
		user.setFullname(fullname);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhone(phone);
		return userRepository.save(user);
	}

	public User updateUser(Long id, String fullname, String email, String password, String phone) {
		User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
		if (fullname != null)
			user.setFullname(fullname);
		if (email != null)
			user.setEmail(email);
		if (password != null)
			user.setPassword(password);
		if (phone != null)
			user.setPhone(phone);
		return userRepository.save(user);
	}

	public boolean deleteUser(Long id) {
		userRepository.deleteById(id);
		return true;
	}
}
