import http from "./http.js";
export default{    //整体要导出
	login(loginForm){
		return http({
		  url: `/loginController`,
		  method: "post",
		  data: loginForm,
		});
	}
}
