package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import constant.Defines;
import dao.CatDAO;
import dao.NewsDAO;
import dao.UserDAO;
import entity.News;
import entity.User;

@Controller
@RequestMapping(value = "/admin/new")
public class AdminNewsController {
	public static final String DIR_FILES = "files";
	@Autowired
	private NewsDAO newDAO;
	@Autowired
	private CatDAO catDAO;
	@Autowired
	private UserDAO userDAO;

	@ModelAttribute
	public void addCommon(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		User objUserInfro = userDAO.getItem(username);
		model.addAttribute("objUserInfor", objUserInfro);
	}
	@RequestMapping(value = "/active", method = RequestMethod.POST)
	public @ResponseBody String active(@RequestParam("nid") int id, @RequestParam("nactive") int active, ModelMap model,
			RedirectAttributes ra) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		if (username == "") {
			return "redirect:/login";
		} else {
			
			if (active == 1) {
				newDAO.block(newDAO.getItem(id).getDate_create(),id);
				return "<a onclick=\"active(" + id
						+ ",0)\"  class=\"btn btn-warning\" href=\"javascript:void(0)\" ><i class=\"icon_check_alt2\"></i></a>";
			} else {
				newDAO.active(newDAO.getItem(id).getDate_create(),id);
				return "<a onclick='active(" + id
						+ ",1)'  class='btn btn-success' href='javascript:void(0)' ><i class='icon_check_alt2'></i></a>";
			}

		}
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

			model.addAttribute("title", "INDEX LAND");
			model.addAttribute("listCat", catDAO.getItems());
			if (page == null) {
				page = 1;
			}
			int sumNews = newDAO.countSumNews();
			int row_count = Defines.ROW_COUNT_PUBLIC_INDEX;
			int sumPage = (int) Math.ceil((float) sumNews / row_count);
			model.addAttribute("sumPage", sumPage);
			model.addAttribute("page", page);
			int offset = (page - 1) * row_count;
			model.addAttribute("listNews", newDAO.getItems(offset, row_count));
			return "admin.new.index";
		}

	}
	@RequestMapping(value = "/del/{id_news}", method = RequestMethod.GET)
	public String del(@PathVariable("id_news") int id_news, RedirectAttributes ra) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		if (username == "") {
			return "redirect:/login";
		} else {
			if (newDAO.delItem(id_news) > 0) {
				ra.addFlashAttribute("msg", 3);
			} else {
				ra.addFlashAttribute("msg", 7);
			}
			return "redirect:/admin/new/index";
		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap model) {
		model.addAttribute("listCat", catDAO.getItems());
		return "admin.new.add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("objNew") News objNew, BindingResult rs, ModelMap model,
			RedirectAttributes ra, HttpServletRequest request, @RequestParam("Picture") CommonsMultipartFile CMF) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		if (username == "") {
			return "redirect:/login";
		} else {
			System.out.println(objNew.getId_cat() +"--" +objNew.getHiden()+"--" +objNew.getId_user());
			User objUser = userDAO.getItem(username);
			model.addAttribute("title", "ADD NEW");
			/*if (rs.hasErrors()) {
				return "admin.new.add";
			}*/
			objNew.setCount_number(0);
			objNew.setHiden(0);
			objNew.setId_user(objUser.getId_user());
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
			objNew.setPicture(CMF.getOriginalFilename());
			
			if (newDAO.addItem(objNew) > 0) {
				ra.addFlashAttribute("msg", 1);
			} else {
				ra.addFlashAttribute("msg", 0);
			}
			return "redirect:/admin/new/index";
		}
	}
	@RequestMapping(value = "/edit/{id_news}", method = RequestMethod.GET)
	public String edit(@PathVariable("id_news") int id_news, ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		if (username == "") {
			return "redirect:/login";
		} else {
			model.addAttribute("title", "EDIT News");
			model.addAttribute("objNew", newDAO.getItem(id_news));
			model.addAttribute("listCat", catDAO.getItems());
			return "admin.new.edit";
		}
	}

	@RequestMapping(value = "/edit/{id_news}", method = RequestMethod.POST)
	public String edit(@PathVariable("id_news") int id_news, RedirectAttributes ra,
			@Valid @ModelAttribute("objNew") News objNew, BindingResult rs, HttpServletRequest request,
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
			model.addAttribute("title", "EDIT ADS");
			/*if (rs.hasErrors()) {
				return "admin.new.edit";
			}*/
			News objOld = newDAO.getItem(id_news);
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
					objNew.setPicture(CMF.getOriginalFilename());
					System.out.println("thành công");
				} catch (IOException e) {
					System.out.println("có lỗi");
				}
			} else {
				objNew.setPicture(objOld.getPicture());
			}
			objNew.setDate_create(objOld.getDate_create());
			if (newDAO.editItem(objNew) > 0) {
				ra.addFlashAttribute("msg", 2);
			} else {
				ra.addFlashAttribute("msg", 7);
			}
			return "redirect:/admin/new/index";
		}

	}


}
