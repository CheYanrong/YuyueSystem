// 引入mockjs
import Mock from "mockjs";

// 获取 mock.Random 对象
const Random = Mock.Random;
console.log(11111)
Mock.mock("/login", "post", (params) => {
	console.log(2222222)
	let newData = JSON.parse(params.body);
	let obj = {
		"code": 200,
		"message": "登录成功",
		"data": {
		    "id": 28,
		    "name": "杜甫",
		    "password": "b92e2dff9a9a043b8e304b4c9e1361d3",
		    "phone": "15120555200",
		    "mail": "1234@qq.com",
		    "roles": []
		    }
	}
	obj.data.id = Random.guid();
	return obj;

});
