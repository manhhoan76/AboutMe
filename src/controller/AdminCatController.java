package controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import constant.Defines;
import dao.CatDAO;
import dao.UserDAO;
import entity.Cat;
import entity.Network;
import entity.User;

@Controller
@RequestMapping(value = "/admin/cat")
public class AdminCatController {
	@Autowired
	private CatDAO catDAO;
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
			int sumCat = catDAO.countSumCat();
			int row_count = Defines.ROW_COUNT_PUBLIC_INDEX;
			int sumPage = (int) Math.ceil((float) sumCat / row_count);
			System.out.println(sumCat);
			model.addAttribute("sumPage", sumPage);
			model.addAttribute("page", page);
			int offset = (page - 1) * row_count;
			model.addAttribute("listCat", catDAO.getItems(offset, row_count));
			return "admin.category.index";
		}
	}

	@RequestMapping(value = "/del/{id_cat}", method = RequestMethod.GET)
	public String del(@PathVariable("id_cat") int id_cat, RedirectAttributes ra) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		if (username == "") {
			return "redirect:/login";
		} else {
			if (catDAO.delItem(id_cat) > 0) {
				ra.addFlashAttribute("msg", 3);
			} else {
				ra.addFlashAttribute("msg", 7);
			}
			return "redirect:/admin/cat/index";
		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "admin.cat.add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("objCat") Cat objCat, BindingResult rs, ModelMap model,
			RedirectAttributes ra, HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		if (username == "") {
			return "redirect:/login";
		} else {
			model.addAttribute("title", "ADD Cat");
			/*
			 * if (rs.hasErrors()) { return "admin.cat.add"; }
			 */
			System.out.println(objCat.getName());
			/*Cat objCatCheck = catDAO.getItem(objCat.getName());
			System.out.println(objCatCheck.getName());
			if (objCatCheck != null) {
				ra.addFlashAttribute("msg", 8);
				return "redirect:/admin/cat/index";
			} else {*/
				if (catDAO.addItem(objCat) > 0) {
					ra.addFlashAttribute("msg", 1);
				} else {
					ra.addFlashAttribute("msg", 0);
				}
				return "redirect:/admin/cat/index";
			/*}*/
		}
	}

	@RequestMapping(value = "/edit/{id_cat}", method = RequestMethod.GET)
	public String edit(@PathVariable("id_cat") int id_cat, ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		if (username == "") {
			return "redirect:/login";
		} else {
			model.addAttribute("title", "EDIT CAT");
			model.addAttribute("objCat", catDAO.getItem(id_cat));
			return "admin.cat.edit";
		}
	}

	@RequestMapping(value = "/edit/{id_cat}", method = RequestMethod.POST)
	public String edit(@PathVariable("id_cat") int id_cat, RedirectAttributes ra,
			@Valid @ModelAttribute("objCat") Cat objCat, BindingResult rs, HttpServletRequest request, ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		if (username == "") {
			return "redirect:/login";
		} else {
			model.addAttribute("title", "EDIT CAT");
			/*
			 * if (rs.hasErrors()) { return "admin.network.edit"; }
			 */
			Cat objOld = catDAO.getItem(id_cat);
			objCat.setDate_create(objOld.getDate_create());
			/*Cat objCheck = catDAO.getItem(objCat.getName());*/
			/*if (objCheck.getName() == "" || objOld.getName().equals(objCat.getName())
					|| objCheck.getName().equals(objOld.getName())) {*/
				if (catDAO.editItem(objCat) > 0) {
					ra.addFlashAttribute("msg", 2);
				} else {
					ra.addFlashAttribute("msg", 7);
				}
				return "redirect:/admin/cat/index";
			/*} else {
				ra.addFlashAttribute("msg", 8);
				return "redirect:/admin/cat/index";
			}*/
		}

	}

}
