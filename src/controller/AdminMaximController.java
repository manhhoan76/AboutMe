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
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import constant.Defines;
import dao.MaximDAO;
import dao.UserDAO;
import entity.Maxim;
import entity.User;

@Controller
@RequestMapping(value="/admin/maxim")
public class AdminMaximController {
	public static final String DIR_FILES = "files";
	@Autowired 
	private MaximDAO maximDAO;
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
			model.addAttribute("title", "CAT INDEX");
			if (page == null) {
				page = 1;
			}
			int sumMaxim = maximDAO.countSumMaxim();
			int row_count = Defines.ROW_COUNT_PUBLIC_INDEX;
			int sumPage = (int) Math.ceil((float) sumMaxim / row_count);
			model.addAttribute("sumPage", sumPage);
			model.addAttribute("page", page);
			int offset = (page - 1) * row_count;
			model.addAttribute("listMaxim", maximDAO.getItems(offset, row_count));
			return "admin.maxim.index";
		}
	} 
	@RequestMapping(value = "/del/{id_maxim}", method = RequestMethod.GET)
	public String del(@PathVariable("id_maxim") int id_maxim, RedirectAttributes ra) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		if (username == "") {
			return "redirect:/login";
		} else {
			if (maximDAO.delItem(id_maxim) > 0) {
				ra.addFlashAttribute("msg", 3);
			} else {
				ra.addFlashAttribute("msg", 7);
			}
			return "redirect:/admin/maxim/index";
		}
	}
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "admin.maxim.add";
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("objMaxim") Maxim objMaxim, BindingResult rs, ModelMap model,
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
				return "admin.maxim.add";
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
			objMaxim.setPicture(CMF.getOriginalFilename());
			
			if (maximDAO.addItem(objMaxim) > 0) {
				ra.addFlashAttribute("msg", 1);
			} else {
				ra.addFlashAttribute("msg", 0);
			}
			return "redirect:/admin/maxim/index";
		}
	}
	@RequestMapping(value = "/edit/{id_maxim}", method = RequestMethod.GET)
	public String edit(@PathVariable("id_maxim") int id_maxim, ModelMap model) {
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
			model.addAttribute("objMaxim", maximDAO.getItem(id_maxim));
			return "admin.maxim.edit";
		}
	}

	@RequestMapping(value = "/edit/{id_maxim}", method = RequestMethod.POST)
	public String edit(@PathVariable("id_maxim") int id_maxim, RedirectAttributes ra,
			@Valid @ModelAttribute("objMaxim") Maxim objMaxim, BindingResult rs, HttpServletRequest request,
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
			model.addAttribute("title", "EDIT MAXIM");
			/*if (rs.hasErrors()) {
				return "admin.ads.edit";
			}*/
			Maxim objOld = maximDAO.getItem(id_maxim);
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
					objMaxim.setPicture(CMF.getOriginalFilename());
					System.out.println("thành công");
				} catch (IOException e) {
					System.out.println("có lỗi");
				}
			} else {
				objMaxim.setPicture(objOld.getPicture());
			}
			objMaxim.setDate_create(objOld.getDate_create());
			if (maximDAO.editItem(objMaxim) > 0) {
				ra.addFlashAttribute("msg", 2);
			} else {
				ra.addFlashAttribute("msg", 7);
			}
			return "redirect:/admin/maxim/index";
		}

	}
}
