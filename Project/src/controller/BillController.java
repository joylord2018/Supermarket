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
import service.BillService;
import util.PageUtil;
import entity.Bill;
import entity.User;

@Controller
@RequestMapping("/jsp")
public class BillController {
	
		ApplicationContext alc=new ClassPathXmlApplicationContext("applicationContext.xml");
		BillService bs=(BillService) alc.getBean("BillService");
	/*	List<String> allowedType=Arrays.asList("jpg","jpeg","gif","png");*/
		
		@RequestMapping("billlist.s")
		public String BillShow(String page_No,Model model,HttpSession session){
			int pageSize=2;//每页2条
			int pageNo=1;
			if(page_No!=null){
				pageNo=Integer.parseInt(page_No);
			}
			PageUtil<Bill>pubi =bs.checkAllByPage(pageNo, pageSize);
			List<Bill> NameList=bs.checkProName();
			session.setAttribute("pubi", pubi);
			session.setAttribute("NameList", NameList);
			return "jsp/billlist";
		}
		
		@RequestMapping("billsearch.s")
		public String UserSearch(String queryProductName,String queryProviderId,String queryIsPayment,Model model,HttpSession session){
			Bill bill=new Bill();
			if(queryProviderId!=null&&!queryProviderId.equals("")){
				bill.setProName(queryProviderId);
			}
			if(queryProductName!=null&&!queryProductName.equals("")){
				bill.setProductName(queryProductName);
			}
			if(queryIsPayment!=null&&!queryIsPayment.equals("")){
				bill.setIsPayment(Integer.parseInt(queryIsPayment));
			}
			List<Bill> biLi=bs.findByProperties(bill);
			model.addAttribute("biLi", biLi);
			return "jsp/billlist";	
		}
		
		@RequestMapping("billCheck/{bid}")
		public String billCheck(@PathVariable int bid,Model model){	
			Bill bill=bs.findByBId(bid);
			model.addAttribute("bill",bill);
			return "jsp/billview";
		}
		
		@RequestMapping("billadd.s")
		public String billAdd(Model model,HttpSession session){
			User user=(User) session.getAttribute("user");
			if(user==null){
				session.removeAttribute("errorMsg");
				return "redirect:../error.jsp";	
			}
			else if(user.getUserRole()!=4){
				return "jsp/frame";
			}
			return "jsp/billadd";
		}
		
		@RequestMapping("billaddinfo.s")
		public String UserAddInfo(@Valid Bill bill, BindingResult bindingResult,
				/*@RequestParam(value="pic")MultipartFile[] pic,*/Model model,HttpSession session){
			if(bindingResult.hasErrors()){
				List<FieldError>eli=bindingResult.getFieldErrors();
				for(FieldError error:eli){
					model.addAttribute(error.getField(),error.getDefaultMessage());
				}
				return "jsp/billadd";
			}
			
			/*
			String path=session.getServletContext().getRealPath("/pic");
			String fileName[]=new String[pic.length];
			File fpath=new File(path);
			if(!fpath.exists()){
				fpath.mkdir();
			}
			
			boolean isRight=true;
			int i=0;
			for(MultipartFile p:pic){
				if(!p.isEmpty()){
					if(p.getSize()>(1024*500)){
						model.addAttribute("msg","文件不能超过500kb");
						isRight=false;
					}
					
					fileName[i]=p.getOriginalFilename();//获得文件名
					String type=fileName[i].substring(fileName[i].lastIndexOf(".")+1).toLowerCase();
					
					if(!allowedType.contains(type)){
						model.addAttribute("msg","文件只能是JPG,PNG,GIF格式的图片");
						isRight=false;
					}
					if(isRight){
						fileName[i]=UUID.randomUUID().toString().replace("-", "")+"."+type;
						File uploadFile=new File(path+"/"+fileName);
						try {
							p.transferTo(uploadFile);
						} catch (IllegalStateException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				i++;
			}*/
			
			User created=(User) session.getAttribute("user");
			if(created!=null){
				bill.setCreateBy(created.getUserId());
				bill.setCreatetion(new Date());
              /*user.setIdPic(fileName[0]);*/
				int result=bs.addBill(bill);
				if(result==-1){
					model.addAttribute("msg","用户编码已存在！");
					return "jsp/billadd";
				}
				return "jsp/billlist";
			}
			else{
				session.removeAttribute("errorMsg");
				return "redirect:../error.jsp";	
			}
		}
		

		
		@RequestMapping("billGetId.s")
		public String userGetId(int bid,Model model){	
			Bill bill=bs.findByBId(bid);
			model.addAttribute("bill",bill);
			return "jsp/billmodify";
		}
		
		@RequestMapping("billUpdate.s")
		public String userUpdate(int bid,Bill bill,Model model){
			bill.setBid(bid);
			bs.updateBill(bill);	
			return "jsp/billlist";		
		}
		
		@RequestMapping("billDelete/{bid}")
		public String userDelete(@PathVariable int bid,Model model){
			bs.deleteBill(bid);
			return "redirect:../billlist.jsp";		
		}
}
