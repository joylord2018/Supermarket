package controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.apache.commons.io.FileUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import entity.User;
import service.UserService;
import util.PageUtil;

@Controller
@RequestMapping("/jsp")
public class UserController {
	ApplicationContext alc=new ClassPathXmlApplicationContext("applicationContext.xml");
	UserService us=(UserService) alc.getBean("UserService");
	List<String> allowedType=Arrays.asList("jpg","jpeg","gif","png");
	
	@RequestMapping("login.s")
	public String login(String userCode,String userPassword,Model model,HttpSession session){	
		User user=us.findByUserCodeAndPwd(userCode, userPassword);
		if(user!=null){
			session.setAttribute("user", user);
			return "jsp/frame";
		}
		else{
			session.setAttribute("errorMsg","用户名密码错误");
			return "redirect:../login.jsp";
		}
	}
	
	@RequestMapping("logout.s")
	public String logout(Model model,HttpSession session){
		session.removeAttribute("user");
		session.removeAttribute("pu");
		session.removeAttribute("biLi");
		session.removeAttribute("proLi");
		session.removeAttribute("pup");
		session.removeAttribute("pubi");
		session.removeAttribute("NameList");
		session.removeAttribute("errorMsg");
		return "redirect:../login.jsp";	
	}
	
	@RequestMapping("view/{id}")
	@ResponseBody
	public User view(@PathVariable int id){
		return us.findByUserId(id);
		
	}
	
	@RequestMapping("userlist.s")
	public String UserShow(String page_No,Model model,HttpSession session){
		int pageSize=2;//每页2条
		int pageNo=1;
		if(page_No!=null){
			pageNo=Integer.parseInt(page_No);
		}
		PageUtil<User>pu =us.checkAllByPage(pageNo, pageSize);
		session.setAttribute("pu", pu);
		return "jsp/userlist";
	}
	
	@RequestMapping("usersearch.s")
	public String UserSearch(String queryname,String queryUserRole,Model model,HttpSession session){
		User user=new User();
		if(queryname!=null&&!queryname.equals("")){
			user.setUserName(queryname);
		}
		if(queryUserRole!=null&&!queryUserRole.equals("")){
			user.setUserRole(Integer.parseInt(queryUserRole));
		}
		List<User> stLi=us.findByProperties(user);
		model.addAttribute("stLi", stLi);
		return "jsp/userlist";	
	}
	
	@RequestMapping("useradd.s")
	public String UserAdd(Model model,HttpSession session){
		User user=(User) session.getAttribute("user");
		if(user==null){
			session.removeAttribute("errorMsg");
			return "redirect:../error.jsp";	
		}
		else if(user.getUserRole()!=4){
			return "jsp/frame";
		}
		return "jsp/useradd";
	}
	
	@RequestMapping("useraddinfo.s")
	public String UserAddInfo(@ModelAttribute @Valid User user, BindingResult bindingResult,
			@RequestParam(value="pic")MultipartFile[] pic,Model model,HttpSession session){
		if(bindingResult.hasErrors()){
			return "jsp/useradd";
		}
		
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
					File uploadFile=new File(path+"/"+fileName[i]);
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
		}
		
		User created=(User) session.getAttribute("user");
		if(created!=null){
			user.setCreateBy(created.getUserId());
			user.setCreationDate(new Date());
			user.setIdPic(fileName[0]);
			int result=us.addUser(user);
			if(result==-1){
				/*model.addAttribute("msg","用户编码已存在！");*/
				return "jsp/useradd";
			}
			return "jsp/userlist";
		}
		else{
			session.removeAttribute("errorMsg");
			return "redirect:../error.jsp";	
		}
	}
	
	@RequestMapping("userCheck/{userId}")
	public String userCheck(@PathVariable int userId,Model model){	
		User user=us.findByUserId(userId);
		model.addAttribute("user",user);
		return "jsp/userview";
	}
	
	@RequestMapping("userGetId.s")
	public String userGetId(int userId,Model model){	
		User user=us.findByUserId(userId);
		model.addAttribute("user",user);
		return "jsp/usermodify";
	}
	
	@RequestMapping("userUpdate.s")
	public String userUpdate(int userId,User user,Model model){
		user.setUserId(userId);
		us.updateUser(user);	
		return "jsp/userlist";		
	}
	
	@RequestMapping("userDelete/{userId}")
	public String userDelete(@PathVariable int userId,Model model){
		us.deleteUser(userId);	
		return "redirect:../userlist.jsp";		
	}
	
	@RequestMapping("/download.s")
	public ResponseEntity<byte[]> download(String fileName,HttpSession session){
	/*	User user=(User) session.getAttribute("user");
		if(user.getUserRole()!=4){
			byte[] body="<h2>权限不足</h2><p><a href=''>返回</a></p>".getBytes();	
			return new ResponseEntity<byte[]>(body,HttpStatus.CREATED);
		}*/
		
		String path=session.getServletContext().getRealPath("/pic");
		File file=new File(path+"/"+fileName);
		HttpHeaders head=new HttpHeaders();
		head.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		head.setContentDispositionFormData("attachment", fileName);
		byte[] body=null;
		try {
			body = FileUtils.readFileToByteArray(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return new ResponseEntity<byte[]>(body,head,HttpStatus.CREATED);
	}
	
	@RequestMapping("updatePwd.s")
	public String updatePwd(HttpSession session){
		User user=(User) session.getAttribute("user");
		if(user==null){
			session.removeAttribute("errorMsg");
			return "redirect:../error.jsp";	
		}
		return "jsp/pwdmodify";
	}
	
	@RequestMapping("updatePwdInfo.s")
	public String updatePwdInfo(String oldpassword,String newpassword,String rnewpassword,Model model,HttpSession session){
		User user=(User) session.getAttribute("user");
		String password=user.getUserPassword();
		if(!oldpassword.equals("")&&!newpassword.equals("")&&!rnewpassword.equals("")){		
			if(password.equals(oldpassword)){
				if(newpassword.equals(rnewpassword)){
					us.updatePwdById(newpassword, user.getUserId());
					session.removeAttribute("errorMsg");
					return"redirect:error2.jsp";
				}
				else{
					model.addAttribute("msg2","新密码输入不一致!");
					return "jsp/pwdmodify";
				}
			}
			else{
				model.addAttribute("msg1","旧密码输入错误!");
				return "jsp/pwdmodify";
			}	
		}
		else{
			model.addAttribute("msg3","不能为空!");
			return "jsp/pwdmodify";
		}
	}
	
	@RequestMapping("checkUserCode.s")
	@ResponseBody
	public Map<String,Object> checkUserCode(String userCode){
		User u=us.findByUserCode(userCode);
		Map<String,Object>map=new HashMap<String,Object>();
		if(u==null){
			map.put("msg", "用户编码可用") ;
		}else{
			map.put("msg", "用户编码已存在") ;
		}
		return map;
	}
	

	@RequestMapping("userViewByAjax.s")
	@ResponseBody
	public User userViewByAjax(int userId,Model model){
		User user=us.findByUserId(userId);
		return user;
	}
}
