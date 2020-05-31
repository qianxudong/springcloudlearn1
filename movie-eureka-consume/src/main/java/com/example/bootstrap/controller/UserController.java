package com.example.bootstrap.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.bootstrap.entity.User;

@RestController
@RequestMapping("/users")
public class UserController {
	/**
	 * 查询所用用户
	 */
	@GetMapping
	public ModelAndView list(Model model) {
		model.addAttribute("userList", getUserlist());
		model.addAttribute("title", "用户管理");
		return new ModelAndView("users/list", "userModel", model);
	}

	/**
	 * 从 用户存储库 获取用户列表
	 * @return
	 */
	private List<User> getUserlist() {
		List<User> users = new ArrayList<>();
		users.add(new User(1L,"Kim"));
		users.add(new User(2L,"Wendy"));
		users.add(new User(3L,"Peanut"));
		return users;
	}
	
	/**
	 * 获取 form 表单页面
	 * @param user
	 * @return
	 */
	@GetMapping("/form")
	public ModelAndView createForm(Model model) {
		model.addAttribute("user", new User(null, null));
		model.addAttribute("title", "创建用户");
		return new ModelAndView("users/form", "userModel", model);
	}
	@PostMapping("/create")
	public ModelAndView createForm(User user) {
		// 保存user
		return new ModelAndView("redirect:/users");
	}
	/**
	 * 根据id查询用户
	 * @param message
	 * @return
	 */
	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id") Long id, Model model) {
		User user = new User(3L,"defaultForTest");
		model.addAttribute("user", user);
		model.addAttribute("title", "查看用户");
		return new ModelAndView("users/view", "userModel", model);
	}
}
