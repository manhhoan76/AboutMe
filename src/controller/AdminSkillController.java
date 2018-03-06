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
import dao.CatDAO;
import dao.MaximDAO;
import dao.SkillDAO;
import dao.UserDAO;
import entity.Job;
import entity.Skill;
import entity.User;

@Controller
@RequestMapping(value="/admin/skill")
public class AdminSkillController {
	@Autowired 
	private SkillDAO skillDAO;
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
			int sumSkill = skillDAO.countSumSkill();
			int row_count = Defines.ROW_COUNT_PUBLIC_INDEX;
			int sumPage = (int) Math.ceil((float) sumSkill / row_count);
			model.addAttribute("sumPage", sumPage);
			model.addAttribute("page", page);
			int offset = (page - 1) * row_count;
			model.addAttribute("listSkill", skillDAO.getItems(offset, row_count));
			return "admin.skill.index";
		}
	} 
	@RequestMapping(value = "/del/{id_skill}", method = RequestMethod.GET)
	public String del(@PathVariable("id_skill") int id_skill, RedirectAttributes ra) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		if (username == "") {
			return "redirect:/login";
		} else {
			if (skillDAO.delItem(id_skill) > 0) {
				ra.addFlashAttribute("msg", 3);
			} else {
				ra.addFlashAttribute("msg", 7);
			}
			return "redirect:/admin/skill/index";
		}
	}
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "admin.skill.add";
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("objSkill") Skill objSkill, BindingResult rs, ModelMap model,
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
			model.addAttribute("title", "ADD SKILL");
			/*if (rs.hasErrors()) {
				return "admin.skill.add";
			}*/
			System.out.println(objSkill.getPercent());
			if (skillDAO.addItem(objSkill) > 0) {
				ra.addFlashAttribute("msg", 1);
			} else {
				ra.addFlashAttribute("msg", 0);
			}
			return "redirect:/admin/skill/index";
		}
	}

}
