package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import constant.Defines;
import dao.RoleDAO;
import dao.UserDAO;
import entity.Maxim;
import entity.User;
import entity.UserEdit;

@Controller
@RequestMapping(value="/admin/user")
public class AdminUserController {
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	public static final String DIR_FILES = "files";
	@Autowired 
	private UserDAO userDAO;
	@Autowired
	private RoleDAO roleDAO;
	@Autowired
	private UserDAO uerDAO;
	@ModelAttribute
	public void addCommon(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		User objUserInfro = uerDAO.getItem(username);
		model.addAttribute("objUserInfor", objUserInfro);
	}
	@RequestMapping({ "/index/{page}", "/index" })
	public String index(ModelMap model, @PathVariable(value = "page", required = false) Integer page) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		if (username == "") {
			return "redirect:/login";
		} else {
			model.addAttribute("title", "USER INDEX");
			if (page == null) {
				page = 1;
			}
			int sumUser = userDAO.countSumUser();
			int row_count = Defines.ROW_COUNT_PUBLIC_INDEX;
			int sumPage = (int) Math.ceil((float) sumUser / row_count);
			model.addAttribute("sumPage", sumPage);
			model.addAttribute("page", page);
			int offset = (page - 1) * row_count;
			model.addAttribute("listUser", userDAO.getItems(offset, row_count));
			return "admin.user.index";
		}
	 } 
	@RequestMapping(value = "/del/{id_user}", method = RequestMethod.GET)
	public String del(@PathVariable("id_user") int id_user, RedirectAttributes ra) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		if (username == "") {
			return "redirect:/login";
		} else {
			if (userDAO.delItem(id_user) > 0) {
				ra.addFlashAttribute("msg", 3);
			} else {
				ra.addFlashAttribute("msg", 7);
			}
			return "redirect:/admin/user/index";
		}
	}
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap model) {
		model.addAttribute("listRole", roleDAO.getItems());
		return "admin.user.add";
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("objUser") User objUser, BindingResult rs, ModelMap model,
			RedirectAttributes ra, HttpServletRequest request, @RequestParam("picture") CommonsMultipartFile CMF) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		if (username == "") {
			return "redirect:/login";
		} else {
			model.addAttribute("title", "ADD NEW");
			/*if (rs.hasErrors()) {
				return "admin.user.add";
			}*/
			/*if (userDAO.checkUsername(objUser.getUsername()) != null) {
				ra.addFlashAttribute("msg", 0);
				return "redirect:/admin/user/add";
			}*/
			String appPath = request.getServletContext().getRealPath("");
			String dirPath = appPath + DIR_FILES;
			System.out.println(dirPath);
			File dirFile = new File(dirPath);
			if (!dirFile.exists()) {
				dirFile.mkdir();
			}
			try {
				CMF.transferTo(new File(dirPath + File.separator + CMF.getOriginalFilename()));
				System.out.println("thành công");
			} catch (IOException e) {
				System.out.println("có lỗi");
			}
			objUser.setPicture(CMF.getOriginalFilename());
			objUser.setPassword(bCryptPasswordEncoder.encode(objUser.getPassword()));
			if (userDAO.addItem(objUser) > 0) {
				ra.addFlashAttribute("msg", 1);
			} else {
				ra.addFlashAttribute("msg", 0);
			}
			return "redirect:/admin/user/index";
		}
	}
	@RequestMapping(value = "/edit/{id_user}", method = RequestMethod.GET)
	public String edit(@PathVariable("id_user") int id_user, ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		if (username == "") {
			return "redirect:/login";
		} else {
			model.addAttribute("title", "EDIT USER");
			model.addAttribute("objUser", userDAO.getItem(id_user));
			model.addAttribute("listRole", roleDAO.getItems());
			return "admin.user.edit";
		}
	}

	@RequestMapping(value = "/edit/{id_user}", method = RequestMethod.POST)
	public String edit(@PathVariable("id_user") int id_user, RedirectAttributes ra,
			@Valid @ModelAttribute("objUser") UserEdit objUser, BindingResult rs, HttpServletRequest request,
			@RequestParam("picture") CommonsMultipartFile CMF, ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		if (username == "") {
			return "redirect:/login";
		} else {
			model.addAttribute("title", "EDIT USER");
			/*if (rs.hasErrors()) {
				return "admin.ads.edit";
			}*/
			User objOld = userDAO.getItem(id_user);
			String appPath = request.getServletContext().getRealPath("");
			String dirPath = appPath + DIR_FILES;
			System.out.println(dirPath);
			File dirFile = new File(dirPath);
			if (!dirFile.exists()) {
				dirFile.mkdir();
			}
			if (!CMF.getOriginalFilename().isEmpty()) {
				if (!"".equals(objOld.getPicture())) {
					String urlFileDel = dirPath + File.separator + objOld.getPicture();
					File delFile = new File(urlFileDel);
					delFile.delete();
				}
				try {
					CMF.transferTo(new File(dirPath + File.separator + CMF.getOriginalFilename()));
					objUser.setPicture(CMF.getOriginalFilename());
					System.out.println("thành công");
				} catch (IOException e) {
					System.out.println("có lỗi");
				}
			} else {
				objUser.setPicture(objOld.getPicture());
			}
			if(objUser.getPassword() == "") {
				objUser.setPassword(objOld.getPassword());
			} else {
				objUser.setPassword(bCryptPasswordEncoder.encode(objUser.getPassword()));
			}
			objUser.setDate_create(objOld.getDate_create());
			if (userDAO.editItem(objUser) > 0) {
				ra.addFlashAttribute("msg", 2);
			} else {
				ra.addFlashAttribute("msg", 7);
			}
			return "redirect:/admin/user/index";
		}

	}
}
