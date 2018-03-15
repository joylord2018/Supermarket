package controller;


import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import service.ProviderService;
import util.PageUtil;
import entity.Provider;
import entity.User;

@Controller
@RequestMapping("/jsp")
public class ProviderController {
	ApplicationContext alc=new ClassPathXmlApplicationContext("applicationContext.xml");
	ProviderService ps=(ProviderService) alc.getBean("ProviderService");
	
	@RequestMapping("providerlist.s")
	public String ProviderShow(String page_No,Model model,HttpSession session){
		int pageSize=3;//每页2条
		int pageNo=1;
		if(page_No!=null){
			pageNo=Integer.parseInt(page_No);
		}

		PageUtil<Provider>pup =ps.checkAllByPage(pageNo, pageSize);
		session.setAttribute("pup", pup);
		return "jsp/providerlist";
	}
	
	@RequestMapping("providersearch.s")
	public String ProviderSearch(String queryProCode,String queryProName,Model model,HttpSession session){
		Provider prov=new Provider();
		if(queryProCode!=null&&!queryProCode.equals("")){
			prov.setProcode(queryProCode);
		}
		if(queryProName!=null&&!queryProName.equals("")){
			prov.setProname(queryProName);
		}
		List<Provider> stProv=ps.findByProperties(prov);
		model.addAttribute("stProv", stProv);
		return "jsp/providerlist";	
	}
	
	@RequestMapping("provideradd.s")
	public String ProviderrAdd(Model model,HttpSession session){
		User user=(User) session.getAttribute("user");
		if(user==null){
			session.removeAttribute("errorMsg");
			return "redirect:../error.jsp";	
		}
		else if(user.getUserRole()!=4){
			return "jsp/frame";
		}		
		return "jsp/provideradd";
	}
		
	@RequestMapping("provideraddinfo.s")
	public String UserAddInfo(@Valid Provider prov, BindingResult bindingResult,Model model,HttpSession session){
		if(bindingResult.hasErrors()){
			List<FieldError>eli=bindingResult.getFieldErrors();
			for(FieldError error:eli){
				model.addAttribute(error.getField(),error.getDefaultMessage());
			}
			return "jsp/provideradd";
		}
		
		User created=(User) session.getAttribute("user");
		if(created!=null){
			prov.setCreateBy(created.getUserId());
			prov.setCreatetionDate(new Date());
			int result=ps.addProvider(prov);
			if(result==-1){
				model.addAttribute("msg","供应商编码已存在！");
				return "jsp/provideradd";
			}
			return "jsp/providerlist";
		}
		else{
			session.removeAttribute("errorMsg");
			return "redirect:../error.jsp";	
		}
	}
	
	@RequestMapping("providerCheck/{pid}")
	public String userCheck(@PathVariable int pid,Model model){	
		Provider prov=ps.findByPid(pid);
		model.addAttribute("prov",prov);
		return "jsp/providerview";
	}
	
	@RequestMapping("providerGetId.s")
	public String userGetId(int pid,Model model){	
		Provider prov=ps.findByPid(pid);
		model.addAttribute("prov",prov);
		return "jsp/providermodify";
	}
	
	@RequestMapping("providerUpdate.s")
	public String userUpdate(Provider prov,int pid,Model model){
		prov.setPid(pid);
		ps.updateProvider(prov)	;
		return "redirect:providerlist.jsp";		
	}
	
	@RequestMapping("providerDelete/{pid}")
	public String userDelete(@PathVariable int pid,Model model){
		ps.deleteProvider(pid);	
		return "redirect:../providerlist.jsp";		
	}
}
