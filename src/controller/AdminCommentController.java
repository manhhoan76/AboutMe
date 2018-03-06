package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import constant.Defines;
import dao.CommentDAO;
import dao.UserDAO;
import entity.User;

@Controller
@RequestMapping(value="/admin/comment")
public class AdminCommentController {
	@Autowired 
	private CommentDAO commentDAO;
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
	@RequestMapping(value = "/active", method = RequestMethod.POST)
	public @ResponseBody String active(@RequestParam("coid") int id, @RequestParam("coactive") int active, ModelMap model,
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
				commentDAO.block(commentDAO.getItem(id).getDate_create(),id);
				return "<a onclick=\"active(" + id
						+ ",0)\"  class=\"btn btn-warning\" href=\"javascript:void(0)\" ><i class=\"icon_check_alt2\"></i></a>";
			} else {
				commentDAO.active(commentDAO.getItem(id).getDate_create(),id);
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
			model.addAttribute("title", "CAT INDEX");
			if (page == null) {
				page = 1;
			}
			int sumComment = commentDAO.countSumComment();
			int row_count = Defines.ROW_COUNT_PUBLIC_INDEX;
			int sumPage = (int) Math.ceil((float) sumComment / row_count);
			model.addAttribute("sumPage", sumPage);
			model.addAttribute("page", page);
			int offset = (page - 1) * row_count;
			model.addAttribute("listComment", commentDAO.getItems(offset, row_count));
			return "admin.comment.index";
		}
	 } 
	@RequestMapping(value = "/del/{id_comment}", method = RequestMethod.GET)
	public String del(@PathVariable("id_comment") int id_comment, RedirectAttributes ra) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}
		if (username == "") {
			return "redirect:/login";
		} else {
			if (commentDAO.delItem(id_comment) > 0) {
				ra.addFlashAttribute("msg", 3);
			} else {
				ra.addFlashAttribute("msg", 7);
			}
			return "redirect:/admin/comment/index";
		}
	}
}
