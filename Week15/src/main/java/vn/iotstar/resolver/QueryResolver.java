package vn.iotstar.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLQueryResolver;
import vn.iotstar.entity.Category;
import vn.iotstar.entity.User;
import vn.iotstar.repository.CategoryRepository;
import vn.iotstar.repository.UserRepository;

@Component
public class QueryResolver implements GraphQLQueryResolver {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	// Truy vấn lấy tất cả người dùng
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	// Truy vấn lấy tất cả danh mục
	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}
}
