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
import dao.NetworkDAO;
import dao.UserDAO;
import entity.Maxim;
import entity.Network;
import entity.User;

@Controller
@RequestMapping(value="/admin/network")
public class AdminNetworkController {
	@Autowired 
	private NetworkDAO networkDAO;
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
			int sumNet = networkDAO.countSumNetwork();
			int row_count = Defines.ROW_COUNT_PUBLIC_INDEX;
			int sumPage = (int) Math.ceil((float) sumNet / row_count);
			model.addAttribute("sumPage", sumPage);
			model.addAttribute("page", page);
			int offset = (page - 1) * row_count;
			model.addAttribute("listNetwork", networkDAO.getItems(offset, row_count));
			return "admin.network.index";
		}
	 } 
	@RequestMapping(value = "/del/{id_network}", method = RequestMethod.GET)
	public String del(@PathVariable("id_network") int id_network, RedirectAttributes ra) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		if (username == "") {
			return "redirect:/login";
		} else {
			if (networkDAO.delItem(id_network) > 0) {
				ra.addFlashAttribute("msg", 2);
			} else {
				ra.addFlashAttribute("msg", 7);
			}
			return "redirect:/admin/network/index";
		}
	}
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "admin.network.add";
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("objNetwork") Network objNetwork, BindingResult rs, ModelMap model,
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
			model.addAttribute("title", "ADD NEW");
			/*if (rs.hasErrors()) {
				return "admin.network.add";
			}*/
			if (networkDAO.addItem(objNetwork) > 0) {
				ra.addFlashAttribute("msg", 1);
			} else {
				ra.addFlashAttribute("msg", 0);
			}
			return "redirect:/admin/network/index";
		}
	}
	@RequestMapping(value = "/edit/{id_network}", method = RequestMethod.GET)
	public String edit(@PathVariable("id_network") int id_network, ModelMap model) {
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
			model.addAttribute("objNetwork", networkDAO.getItem(id_network));
			return "admin.network.edit";
		}
	}

	@RequestMapping(value = "/edit/{id_network}", method = RequestMethod.POST)
	public String edit(@PathVariable("id_network") int id_network, RedirectAttributes ra,
			@Valid @ModelAttribute("objNetwork") Network objNetwork, BindingResult rs, HttpServletRequest request,
			ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		if (username == "") {
			return "redirect:/login";
		} else {
			model.addAttribute("title", "EDIT Net");
			/*if (rs.hasErrors()) {
				return "admin.network.edit";
			}*/
			Network objOld = networkDAO.getItem(id_network);
			objNetwork.setDate_create(objOld.getDate_create());
			if (networkDAO.editItem(objNetwork) > 0) {
				ra.addFlashAttribute("msg", 2);
			} else {
				ra.addFlashAttribute("msg", 7);
			}
			return "redirect:/admin/network/index";
		}

	}
}
